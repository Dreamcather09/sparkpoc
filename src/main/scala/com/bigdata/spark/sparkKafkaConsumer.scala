package com.bigdata.spark

import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.streaming._
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql._
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}
object sparkKafkaConsumer {
  def main(args: Array[String]) {
    val spark = SparkSession.builder.master("local[*]").appName("kafkaConsumer").getOrCreate()
    val ssc = new StreamingContext(spark.sparkContext, Seconds(10))
    // val sc = spark.sparkContext



    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "localhost:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "use_a_separate_group_id_for_each_stream",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (false: java.lang.Boolean)
    )

    val topics = Array("dasari", "indpak")
    val stream = KafkaUtils.createDirectStream[String, String](
      ssc,
      PreferConsistent,
      Subscribe[String, String](topics, kafkaParams)
    )

    val lines = stream.map(record =>  record.value)

    lines.foreachRDD { x =>

      // Get the singleton instance of SparkSession
      val spark = SparkSession.builder.config(x.sparkContext.getConf).getOrCreate()
      import spark.implicits._

      // Convert RDD[String] to DataFrame
      val df = x.map(x=>x.split(",")).map(x=>(x(0),x(1),x(2))).toDF("name","age","city")
      df.show()
      // Create a temporary view
      /*df.createOrReplaceTempView("tab")
      val ourl = "jdbc:oracle:thin:@//paritoshoracle.czhyzqz8vleo.ap-south-1.rds.amazonaws.com:1521/orcl"
      val oprop = new java.util.Properties()
      oprop.setProperty("user","ousername")
      oprop.setProperty("password","opassword")
      oprop.setProperty("driver","oracle.jdbc.OracleDriver")

      // Do word count on DataFrame using SQL and print it
      val deldf =
        spark.sql("select * from tab where city ='del'")
      deldf.write.mode(SaveMode.Append).jdbc(ourl,"delhiinfo",oprop)
      //res.show()
      val masdf= spark.sql("select * from tab where city ='mas'")
      masdf.write.mode(SaveMode.Append).jdbc(ourl,"chennaiinfo",oprop)
      val otherdf= spark.sql("select * from tab where city <>'del' and city <>'mas'")
      otherdf.write.mode(SaveMode.Append).jdbc(ourl,"othercity",oprop)*/

    }

    import spark.implicits._
    import spark.sql

    ssc.start()             // Start the computation
    ssc.awaitTermination()  // Wait for the computation to terminate


    import spark.implicits._
    import spark.sql


  }
}
