package KnightsDialer

import Array.ofDim
import scala.collection.mutable.MutableList

/**
  * Created by Eddie on 12/31/16.
  */

object KnightsDialer {
  def main(args: Array[String]): Unit = {
    val start: Int = 1
    val end: Int = 4
    val length: Int = 9
    val nums: Int = 10

    val moves: List[List[Int]] = List(List(4,6),
                                      List(6,8),
                                      List(7,9),
                                      List(4,8),
                                      List(0,3,9),
                                      List(),
                                      List(0,1,7),
                                      List(2,6),
                                      List(1,3),
                                      List(2,4))

    val count = Array.ofDim[Int](nums,nums,length+1)



    initializeArray(count,nums,moves)
    fillArray(count,nums,moves,length)
    println(countNumbers(count,nums,length))
  }

  def initializeArray (count: Array[Array[Array[Int]]], nums: Int, moves: List[List[Int]]): Unit = {
    for (i <- 0 until nums) {
      for (j <- 0 until nums) {
        count(i)(j)(0) = 0
        count(i)(j)(1) = 0
      }
      for (j <- moves(i)) {
        count(i)(j)(1) = 1
      }
    }

  }

  def fillArray(count: Array[Array[Array[Int]]], nums: Int, moves: List[List[Int]], length: Int): Unit = {
    for (i <- 2 to length) {
      for (j <- 0 until nums) {
        for (k <- 0 until nums) {
          val c: Int = count(j)(k)(i)
          println(s"i: $j, j: $k, k: $i, count: $c")
          if (count(j)(k)(i-1) != 0) {
            for(l <- moves(k)) {
              count(j)(l)(i) = count(j)(k)(i-1) + 1
            }
          }
        }
      }
    }
  }

  def countNumbers(count: Array[Array[Array[Int]]], nums: Int, length: Int): MutableList[Int] = {
    var sumList: MutableList[Int] = MutableList()
    for (i <- 0 to length) {
      var sum: Int = 0
      for (j <- 0 until nums) {
        for (k <- 0 until nums) {
          sum += count(j)(k)(i)
        }
      }
      sumList += sum
    }
    sumList
  }

}
