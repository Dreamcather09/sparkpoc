package com.bigdata.spark

import org.apache.spark.sql._
import org.apache.spark.sql.functions._

object ScalaFunction {
  def main(args: Array[String]) {
    val spark = SparkSession.builder.master("local[*]").appName("ScalaFunction").getOrCreate()
    //    val ssc = new StreamingContext(spark.sparkContext, Seconds(10))
    val sc = spark.sparkContext

    import spark.implicits._
    import spark.sql

    val data = "C:\\BigData\\datassets\\us-500.csv"
    val df = spark.read.format("csv").option("header", "true").load(data)
    df.createOrReplaceTempView("tab")

    spark.udf.register("myoffer", "offer")
    spark.udf.register("comb", "full")

    val res = spark.sql("select comb(first_name, last_name)full_name,*,myoffer(state)todayoffer from tab")

    res.show(false)
    spark.stop()
  }
  def full(fname:String, lname:String) = fname + " "+ lname
  def offer(state:String) = state match {
    case s if(s=="OH") => s"Hi  you will get 10% off"
    case s if(s=="NJ") => s" hi  you will get 30 % off"
    case _ => s"  no offer"
  }
}