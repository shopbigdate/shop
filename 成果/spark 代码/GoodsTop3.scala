package com.spark_sql_task

import java.util.Calendar

import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

object GoodsTop3 {
	def main(args: Array[String]): Unit = {
		val conf = new SparkConf().setAppName("GoodsTop3")
		val sc = new SparkContext(conf)
		val hiveContext = new HiveContext(sc)

		val cal = Calendar.getInstance
		val year = cal.get(Calendar.YEAR)
		val month = cal.get(Calendar.MONTH) + 1
		val Day = cal.get(Calendar.DAY_OF_MONTH)

		//创建数据库
		hiveContext.sql("create database if not exists shopping")
		hiveContext.sql("use shopping")

		//创建商品下单记录表 goods_order_record
		hiveContext.sql(
			"create table if not exists goods_order_record" +
					"(goods_id int,goods_name String,goods_category String, one int) " +
					"partitioned by (day string) row format delimited fields terminated by ','"
		)

		//从临时表加载数据
		hiveContext.sql("insert into goods_order_record partition(day='" + year + "-" + month + "-" + Day + "') " +
				"select id,goods_name,goods_category,one from goods_order_all where logid = 'hot_goods' and day='" + year + "-" + month + "-" + Day + "'")

		//查询生成DataFrame
		val goods = hiveContext.sql(
			"select goods_id,goods_name,goods_category,sum(one) sum,day " +
					"from goods_order_record " +
					"where day='" + year + "-" + month + "-" + Day + "'" +
					"group by goods_id,goods_name,goods_category,day"
		)

		//生成商品下单次数表 goods_order_count
		hiveContext.sql("drop table if exists goods_order_count")
		goods.write.mode(SaveMode.Append).saveAsTable("goods_order_count")

		val hotgoods = hiveContext.sql(
			"select goods_id,goods_name,goods_category,sum,day from " +
					"(select goods_id,goods_name,goods_category,sum,day," +
					"row_number() over (partition by goods_category order by sum desc) rank from goods_order_count " +
					"where day='" + year + "-" + month + "-" + Day + "')t " +
					"where t.rank<=3"
		)

		//将查询结果追加写入到Mysql报表：goods_order_count
		hotgoods.write.mode("append")
				.format("jdbc")
				.option("driver", "com.mysql.jdbc.Driver")
				.option("url", "jdbc:mysql://virhost01:3306/shop_platform_analyse?useUnicode=true&characterEncoding=UTF-8")
				.option("dbtable", "goods_order_count")
				.option("user", "root")
				.option("password", "123456")
				.option("truncate", "false")
				.save()

		sc.stop()
	}
}
