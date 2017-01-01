package KnightsDialer

import Array.ofDim
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
                                      List(3,9),
                                      List(),
                                      List(1,7),
                                      List(2,6),
                                      List(1,3),
                                      List(2,4))

    val count = Array.ofDim[Int](nums,nums,length)



    fillArray(count,nums,moves)
    println(count(0)(3)(1))
  }

  def fillArray (count: Array[Array[Array[Int]]], nums: Int, moves: List[List[Int]]): Unit = {
    for (i <- 0 until nums) {
      for (j <- 0 until nums) {
        count(i)(j)(1) = 0
      }
      for (l <- moves(i)) {
        count(i)(l)(1) = 1
      }
    }

  }
}
