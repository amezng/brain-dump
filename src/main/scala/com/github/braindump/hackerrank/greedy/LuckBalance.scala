package com.github.braindump.hackerrank.greedy

import java.util.Scanner

/**
  * Created by samez on 2/28/2017.
  */
object LuckBalance extends App {

  val in = new Scanner(System.in)
  val nk = in.nextLine()
  val _contests = nk.split(" ")(0).toInt
  val _maxLoose = nk.split(" ")(1).toInt

  val inputArray = Array.ofDim[Int](_contests, 2)
  for (c <- 0 until _contests) {
    val contestInput = in.nextLine()
    inputArray(c)(0) = contestInput.split(" ")(0).toInt
    inputArray(c)(1) = contestInput.split(" ")(1).toInt
  }

  println(solution(inputArray,_maxLoose))

  def solution(arr: Array[Array[Int]], maxLoses: Int): Int = {
    val loosableContests = arr.count(x => x(1) == 1) - maxLoses
    val impContestsSorted = arr.filter(x => x(1) == 1).sortWith((x,y) => x(0) < y(0))
    val nonImpGainedConfidence = arr.filter(x => x(1) == 0).foldLeft(0)((x,y) => x + y(0))

    if(loosableContests > 0){
      val impGainedConfidence = impContestsSorted.drop(loosableContests).foldLeft(0)((x,y) => x + y(0))
      val impLostConfidence = impContestsSorted.take(loosableContests).foldLeft(0)((x,y) => x + y(0))

      impGainedConfidence + nonImpGainedConfidence - impLostConfidence
    }
    else{
      arr.foldLeft(0)((x,y) => x + y(0))
    }
  }

}
