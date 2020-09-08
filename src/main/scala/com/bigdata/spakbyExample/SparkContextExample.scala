package com.bigdata.spakbyExample

import org.apache.spark.sql._
import org.apache.spark.sql.functions._

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


object SparkContextExample {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SC_PGM").setMaster("local[1]")
    val SparkContext = new SparkContext(conf)
    val rdd = SparkContext.parallelize(Array(1,2,3,4,5,6,7,8,9))

    SparkContext.setLogLevel("Error")

    println("First SparkContext:")
    println("App name:"+ SparkContext.appName)
    println("Deploy mode:"+SparkContext.deployMode)
    println("Master:"+ SparkContext.master)

    SparkContext.stop()
  }
}