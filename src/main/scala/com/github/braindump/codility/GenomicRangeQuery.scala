package com.github.braindump.codility

/**
  * @author Shad
  */
object GenomicRangeQuery extends App {

 implicit val impFactor = Map('A' -> 1, 'C' -> 2, 'G' -> 3, 'T' -> 4)

  def solution(s: String, p: Array[Int], q: Array[Int])(implicit impFactor : Map[Char,Int]): Array[Int] = {
    val result = new Array[Int](p.length)
    val prefixSum = buildPrefixSum(s)

    for (i <- p.indices) {
      val minFactor = if (p(i) != q(i)){
        getMinFactor(p(i), q(i), prefixSum)
      }

      else
        impFactor(s.charAt(p(i)))

      result(i) = minFactor
    }
    result
  }

  def getMinFactor(startPos: Int, endPos: Int, prefixSum: Map[Char, Array[Int]])(implicit impFactor : Map[Char,Int]): Int = {

    if (startPos > 0){
      if(prefixSum('A').apply(endPos) - prefixSum('A').apply(startPos-1) > 0)
        impFactor('A')
      else if(prefixSum('C').apply(endPos) - prefixSum('C').apply(startPos-1) > 0)
        impFactor('C')
      else if(prefixSum('G').apply(endPos) - prefixSum('G').apply(startPos-1) > 0)
        impFactor('G')
      else
      impFactor('T')
    }
    else if(prefixSum('A').apply(startPos) == 1 || (prefixSum('A').apply(endPos) - prefixSum('A').apply(startPos) > 0))
      impFactor('A')
    else if(prefixSum('C').apply(startPos) == 1 || (prefixSum('C').apply(endPos) - prefixSum('C').apply(startPos) > 0))
      impFactor('C')
    else if(prefixSum('G').apply(startPos) == 1 || (prefixSum('G').apply(endPos) - prefixSum('G').apply(startPos) > 0))
      impFactor('G')
    else
      impFactor('T')

  }

  def buildPrefixSum(s: String): Map[Char, Array[Int]] = {
    val aPrefixSum = new Array[Int](s.length)
    val cPrefixSum = new Array[Int](s.length)
    val gPrefixSum = new Array[Int](s.length)
    val chrArray = s.toCharArray
    for (i <- chrArray.indices) {
      if (i > 0) {
        aPrefixSum(i) = aPrefixSum(i - 1)
        cPrefixSum(i) = cPrefixSum(i - 1)
        gPrefixSum(i) = gPrefixSum(i - 1)
      }
      if (chrArray(i) == 'A') {
        if (i > 0)
          aPrefixSum(i) = aPrefixSum(i - 1) + 1
        else
          aPrefixSum(i) = 1
      } else if (chrArray(i) == 'C') {
        if (i > 0)
          cPrefixSum(i) = cPrefixSum(i - 1) + 1
        else
          cPrefixSum(i) = 1
      } else if (chrArray(i) == 'G') {
        if (i > 0)
          gPrefixSum(i) = gPrefixSum(i - 1) + 1

        else
          gPrefixSum(i) = 1
      }
    }
    Map('A' -> aPrefixSum, 'C' -> cPrefixSum, 'G' -> gPrefixSum)
  }

  println(solution("CAGCCTA", Array(2, 5, 0), Array(4,5,6)))

}
