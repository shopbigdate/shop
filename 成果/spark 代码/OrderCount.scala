package com.spark_sql_task

import java.util.Calendar

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

object OrderCount {
	def main(args: Array[String]): Unit = {
		val conf = new SparkConf().setAppName("orderCount")
		val sc = new SparkContext(conf)
		val hiveContext = new HiveContext(sc)

		val cal = Calendar.getInstance
		val year = cal.get(Calendar.YEAR)
		val month = cal.get(Calendar.MONTH) + 1
		val Day = cal.get(Calendar.DAY_OF_MONTH)

		//创建数据库
		hiveContext.sql("create database if not exists shopping")
		hiveContext.sql("use shopping")

		//生成临时的日志汇总表goods_order_all
		hiveContext.sql("create table if not exists goods_order_all" +
				"(logid String,id String,goods_name String,goods_category String, one int, order_sum double,order_status char(1),update_time timestamp,consignee_name string) " +
				"partitioned by (day string) row format delimited fields terminated by ','")
		hiveContext.sql("load data inpath 'hdfs://virhost01:9000/project/shop/" + year + "-" + month + "-" + Day + "/*' into table goods_order_all partition(day='" + year + "-" + month + "-" + Day + "')")

		//创建order_info订单表
		hiveContext.sql(
			"create table if not exists order_info(order_id string, order_sum double,order_status char(1),update_time timestamp,consignee_name string) partitioned by (day string) row format delimited fields terminated by ','"
		)

		//从临时表加载数据
		hiveContext.sql("insert into order_info partition(day='" + year + "-" + month + "-" + Day + "') " +
				"select id,order_sum,order_status,update_time,consignee_name from goods_order_all where logid = 'order' and day='" + year + "-" + month + "-" + Day + "'")

		//查询生成DataFrame
		val order = hiveContext.sql(
			"select (success.success_num+fail.fail_num) order_sum_count," +
					"success.success_num order_pay_count," +
					"success.success_sum order_trade_sum," +
					"fail.fail_num order_refund_count," +
					"fail.fail_sum order_refund_sum," +
					"success.day order_count_date from " +
					"(select day,count(1) success_num,sum(order_sum) success_sum from order_info where day='" + year + "-" + month + "-" + Day + "' and order_status='2' group by order_status,day) success," +
					"(select day,count(1) fail_num,sum(order_sum) fail_sum from order_info where day='" + year + "-" + month + "-" + Day + "' and order_status='3' group by order_status,day) fail " +
					"where success.day = fail.day"
		)

		//将查询结果追加写入到Mysql报表：订单统计表order_count
		order.write.mode("append")
				.format("jdbc")
				.option("driver", "com.mysql.jdbc.Driver")
				.option("url", "jdbc:mysql://virhost01:3306/shop_platform_analyse?useUnicode=true&characterEncoding=UTF-8")
				.option("dbtable", "order_count")
				.option("user", "root")
				.option("password", "123456")
				.option("truncate", "false")
				.save()

		sc.stop()
	}
}
