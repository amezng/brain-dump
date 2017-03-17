package com.github.braindump.codility

import scala.util.Sorting

/**
  * @author Shad
  */
object MissingInteger extends App {

  def solution(a: Array[Int]): Int = {
    var min = 1
    Sorting.quickSort(a)
    for (i <- a.indices) {
      if (a(i) == min) {
        min += 1
      }
    }
    min
  }

  println(solution(Array(1,3,6,4,1,2)))

}
