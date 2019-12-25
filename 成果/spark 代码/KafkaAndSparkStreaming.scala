package com.qrsx


import java.util.Properties

import kafka.serializer.StringDecoder
import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}
import org.apache.spark.streaming.kafka._
import org.apache.spark.streaming.{Durations, Seconds, StreamingContext}

object KafkaAndSparkStreaming {
	def main(args: Array[String]): Unit = {
		//判断args的配置是否符合标准
		if (args.length != 2) {
			System.err.println("Usage: KafkaDirect <ip:port> <topics>")
			System.exit(1)
		}

		//将参数args读入到数组中
		val Array(brokers, topics) = args

		val sparkConf = new SparkConf().setMaster("local[2]").setAppName("KafkaAndSparkStreaming")
		// 用n秒批间隔创建上下文
		val ssc = new StreamingContext(sparkConf, Seconds(2))

		//设置日志级别
		ssc.sparkContext.setLogLevel("WARN")
		ssc.checkpoint("./sscheckpoint")

		// 创建kafka流与brokers和topic
		val topicsSet = topics.split(" ").toSet
		val kafkaParams = Map[String, String]("metadata.broker.list" -> brokers)
		val messages = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](
			ssc, kafkaParams, topicsSet)

		//打印获取到的数据：messages.map(_._2)
		val mapDStream = messages.map(_._2).map((_, 1)).map(_._2).map(("人数", _))

		//优化的窗口函数
		val result = mapDStream.reduceByKeyAndWindow((v1: Int, v2: Int) => {
			v1 + v2
		}, (v1: Int, v2: Int) => {
			v1 - v2
		}, Durations.seconds(60), Durations.seconds(60))

		result.print()

		result.foreachRDD(
			rdd => {
				//创建一个spark Session对象
				val sparkSession = SparkSession.builder().config(rdd.sparkContext.getConf).getOrCreate()
				//将RDD转换为DataFrame，并且过滤掉了人数为0的时间段
				import sparkSession.implicits._
				//rdd:(人数，n)
				//toDF("active_count")：将rdd中的代表活跃人数的映射为表的active_count列
				val frame: DataFrame = rdd.filter(_._2 > 0).map(_._2).toDF("active_count")
				//封装用户名和口令
				val properties = new Properties
				properties.setProperty("user", "root")
				properties.setProperty("password", "123456")
				//数据库和表会自动创建
				frame.write.mode(SaveMode.Append).jdbc("jdbc:mysql://virhost01:3306/shop_platform_analyse?characterEncoding=UTF-8", "active_count", properties)
			}
		)

		// 开始计算
		ssc.start()
		ssc.awaitTermination()
	}
}
