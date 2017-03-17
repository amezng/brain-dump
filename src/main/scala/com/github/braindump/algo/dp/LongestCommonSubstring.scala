package com.github.braindump.algo.dp

/**
  * Created by samez on 3/3/2017.
  */
object LongestCommonSubstring extends App {

  def solution(fa: Array[Char], sa: Array[Char]): Int = {
    val lcs = Array.ofDim[Int](fa.length + 1, sa.length + 1)

    for (i <- 1 to fa.length) {
      for (j <- 1 to sa.length) {
        if (fa(i - 1) == sa(j - 1))
          lcs(i)(j) = 1 + lcs(i - 1)(j - 1)
      }
    }
    getMax(lcs)

  }

  def getMax(arr: Array[Array[Int]]): Int = {
    var max = arr(0)(0)
    for (i <- arr.indices) {
      for (j <- arr(i).indices) {
        if (arr(i)(j) > max) {
          max = arr(i)(j)
        }
      }
    }
    max
  }

  println(solution("GeeksForGeek".toCharArray, "IAMGeekshadGeeksFor".toCharArray))
}
