package com.bigdata.spark

import org.apache.spark.sql._
import org.apache.spark.sql.functions._

object sparktest {
  def main(args: Array[String]) {
    val spark = SparkSession.builder.master("local[*]").appName("sparktest").getOrCreate()
    //    val ssc = new StreamingContext(spark.sparkContext, Seconds(10))
    val sc = spark.sparkContext

    import spark.implicits._
    import spark.sql

    val data="C:\\BigData\\datassets\\departuredelays.csv"
    val data1="C:\\BigData\\datassets\\airport-codes-na.txt"
    val df=spark.read.format("csv").option("header","true").option("inferSchema","true").load(data)
    df.show(5)
    df.createOrReplaceTempView("FlightPerformance")
    val df1=spark.read.format("csv").option("header","true").option("delimiter","\t").option("inferSchema","true").load(data1)
    df1.show(5)
    df1.createOrReplaceTempView("airports")

    // Query Sum of Flight Delays by State (for the US)
    val res2=spark.sql("select a.State, sum(f.delay) as Delays from FlightPerformance f join airports a on a.IATA = f.origin where a.Country = 'USA' group by a.State ")
    res2.show()
    // Query Sum of Flight Delays by City and Origin Code (for Washington State)
    val  res=spark.sql("select a.City, f.origin, sum(f.delay) as Delays from FlightPerformance f join airports a on a.IATA = f.origin where a.State = 'WA' group by a.City, f.origin order by sum(f.delay) desc")
    res.show()

    spark.stop()
  }
}