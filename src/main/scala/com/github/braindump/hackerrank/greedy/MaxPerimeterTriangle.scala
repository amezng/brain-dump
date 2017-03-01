package com.github.braindump.hackerrank.greedy

import java.util.Scanner

/**
  * Created by samez on 3/1/2017.
  */
object MaxPerimeterTriangle extends App {

  val in = new Scanner(System.in)
  val _sticks = in.nextLine().toInt
  val sticks = new Array[Int](_sticks)
  val strStickLengths = in.nextLine()

  for (c <- 0 until _sticks) {
    sticks(c) = strStickLengths.split(" ")(c).toInt
  }

  solution(sticks.sortWith(_ > _)) match {
    case Some(resArr) => resArr.foreach(x => print(x + " "))
    case None => println(-1)
  }

  def solution(arr: Array[Int]): Option[Array[Int]] = {

    def isNonDegenerate(h: Int, tl: Array[Int]): Boolean = h < tl.sum

    arr match {
      case a if a.length >= 3 => if (isNonDegenerate(a.head, a.tail.take(2))) {
        Some(a.take(3).reverse)
      }
      else
        solution(a.tail)
      case _ => None
    }


  }


}
