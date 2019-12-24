package com.qrsx.shop

import java.util.Calendar

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext

object dataCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("orderCount")
    val sc = new SparkContext(conf)
    val hiveContext = new HiveContext(sc)
    hiveContext.sql("use shopping")
    /**
     * 查询生成DataFrame
     */
    val cal = Calendar.getInstance
    val year = cal.get(Calendar.YEAR)
    val month = cal.get(Calendar.MONTH)
    val Day = cal.get(Calendar.DAY_OF_MONTH)
    hiveContext.sql("create table if not exists goods_order_all"+
      "(logid String,id String,goods_name String,Goods_category String, one int, orders_sum double,order_status char(1),order_time timestamp,user_name string) "+
      "partitioned by (day string) row format delimited fields terminated by ','")
    hiveContext.sql("load data inpath 'hdfs://virhost01:9000/test/shop/"+year+"-"+(month+1)+"-"+Day+"/*' into table goods_order_all partition(day='"+year+"-"+(month+1)+"-"+Day+"')")
    hiveContext.sql(
      "create table if not exists order_info(order_id string, orders_sum double,order_status char(1),order_time timestamp,user_name string) partitioned by (day string) row format delimited fields terminated by ','"
    )
    hiveContext.sql("insert into order_info partition(day='"+year+"-"+(month+1)+"-"+Day+"') "+
      "select id,orders_sum,order_status,order_time,user_name from goods_order_all where logid = 'order' and day='"+year+"-"+(month+1)+"-"+Day+"'")
    val goods = hiveContext.sql(
      "select (success.success_num+fail.fail_num) order_sum_count,success.success_num order_pay_count,success.success_sum order_trade_sum,fail.fail_num order_refund_count,fail.fail_sum order_refund_sum,success.day order_count_date from " +
        "(select day,count(1) success_num,sum(orders_sum) success_sum from order_info where order_status='2' group by order_status,day) success" +
        ",(select day,count(1) fail_num,sum(orders_sum) fail_sum from order_info where order_status='3' group by order_status,day) fail " +
        "where success.day = fail.day"
    )
    goods.write.mode("append")
      .format("jdbc")
      .option("driver","com.mysql.jdbc.Driver")
      .option("url","jdbc:mysql://192.168.14.33:3306/shop_platform_analyse?useUnicode=true&characterEncoding=UTF-8")
      .option("dbtable","order_count")
      .option("user","root")
      .option("password","123456")
      .option("truncate","false").save()
    sc.stop()
  }
}
