package com.tgzhao

import java.io.PrintWriter
import java.util.Date

import scala.io.Source

/**
 * Created by tgzhao on 2016/7/26.
 */
object ScalaApp02 {

  def main(args: Array[String]) {

    //匹配元组
    val tuple=(1,2)
    tuple match{
      case (1,_)=>println("start 1")//匹配以1开头的元组
      case (_,2)=>println("end2")//匹配以2结尾的元组

      case _=>println("nothing")
    }


    val array2=Array("Mary","had","a","little","cat") //直接按内容进行初始化
    println(array2.mkString("#"))//
    println("the index is 2="+array2(3))//取索引为3的值
    val array3:Array[(String,Int)]=Array(("xiaoming",23),("xiaohong",22))//使用元祖作为数组内容
    array3.foreach(println)


    //Scala Application
    val str="Hello,wrold"
    println(Array("dfdf", "fasdf"))
    println(str.split(Array(',', ' ')))

    val data=str
              .split(Array(',',' '))
              .flatMap(for(c<-_) yield (c,1))  //好Api
              .groupBy(_._1)
              .mapValues(_.size)

    println(data)


/*
    tupleDemo
    println
    mapDemo
    println
    arrayDemo
    println
    fileWriteAndRead
    println(getUrlContent("http://www.cnblogs.com/yjmyzz/"))
*/

  }

  /**
   * 元组示例
   */
  def tupleDemo = {
    //val表示常量（相当于JAVA中的final），var表示变量
    val tuple = ("jimmy", 100, new Date()) //这写法比c#里的Tuple<T>还简洁
    //打印第1，2，3个元素，注意元组下标是从1开始的
    println(tuple._1)
    println(tuple._2)
    println(tuple._3)
  }

  /**
   * 数组示例
   */
  def arrayDemo = {
    var myArr = Array(5, 4, 3, 2, 1) //注意：这里不需要new关键字
    for (i <- myArr) println(i)
    println
    //找出myArr中的偶数
    var even = myArr.filter(i => i % 2 == 0) //这语法的简洁性，快赶上C#的LINQ了
    for (i <- even) println(i)
    println
    scala.util.Sorting.quickSort(even) //排序
    for (i <- even) println(i)
  }

  //Map示例
  def mapDemo = {
    var myMap = Map(("jimmy", 1), ("Mike", 2), ("John", 3));
    //遍历
    for ((k, v) <- myMap) {
      println("key:" + k + "\t,value=" + v);
    }
    println
    println("all keys => ")
    //遍历key
    for (k <- myMap.keys) {
      println(k)
    }
    println
    //遍历value
    println("all values => ")
    for (v <- myMap.values) {
      println(v)
    }
    println
    //遍历key和value，还有一种写法（利用占位符号"_"）
    println("all keys => ")
    for ((k, _) <- myMap) println(k)
    println
    println("all values => ")
    for ((_, v) <- myMap) println(v)
  }


  /**
   * 文件读写示例
   */
  def fileWriteAndRead = {
    val fileName = "scalaTest.txt"

    //写文件
    var writer = new PrintWriter(fileName)
    writer.write("hello scala\n")
    writer.write("hello spark")
    writer.close()

    //读文件
    var fileContent = Source.fromFile(fileName);
    println(fileContent.mkString)

  }

  /**
   * 获取网页内容
   * @param url
   * @return
   */
  def getUrlContent(url: String): String = {
    Source.fromURL(url).mkString
  }


}