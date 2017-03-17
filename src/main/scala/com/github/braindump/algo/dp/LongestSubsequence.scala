package com.github.braindump.algo.dp

/**
  * Created by samez on 3/3/2017.
  */
object LongestSubsequence extends App {


  val result = solution("AAA".toCharArray, "AAA".toCharArray)
  println(result)

  def solution(s: Array[Char], t: Array[Char]): Int = {
    val mem = Array.ofDim[Int](s.length + 1, t.length + 1)
    for (i <- s.indices) {
      for (j <- t.indices)
        mem(i)(j) = -1
    }

    def lcs(a: Array[Char], n: Int, b: Array[Char], m: Int): Int = {
      if (mem(n)(m) != -1)
        mem(n)(m)

      if ((n == 0) || (m == 0)) {
        //mem(n)(m) = 0
        0
      }

      else if (a(n - 1) == b(m - 1)) {
        1 + lcs(a, n - 1, b, m - 1)

      }
      else {
        val tmp1 = lcs(a, n - 1, b, m)
        val tmp2 = lcs(a, n, b, m - 1)
        val maxValue = if (tmp1 > tmp2) tmp1 else tmp2
        mem(n)(m) = maxValue
        maxValue
      }
    }

    lcs(s, s.length, t, t.length)

  }


}


