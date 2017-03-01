package com.github.braindump.hackerrank.greedy

import java.util.Scanner

/**
  * Created by samez on 2/28/2017.
  */
object GreedyChallenge extends App {


  val in = new Scanner(System.in)
  val testCase = in.nextInt()

  for (c <- 0 until testCase) {
    val arrayDim = in.nextInt()
    val inputArray = Array.ofDim[Char](arrayDim, arrayDim)
    for (dim <- 0 until arrayDim) {
      inputArray(dim) = in.next().toCharArray.sortWith(_ > _)
    }
    val soln = solution(inputArray)
    if (soln)
      println("YES")
    else
      println("NO")

  }


  /**
    * Is it possible to rearrange the grid such that every row and every column is lexicographically sorted?
    *
    * @param arr The array that needs to be validated
    * @return True if its sortable else false
    */
  def solution(arr: Array[Array[Char]]): Boolean = {
    var sorted = true
    for (i <- 0 until (arr.length - 1)
         if sorted) {

      for (j <- arr(i).indices) {
        if (arr(i)(j) > arr(i + 1)(j))
          sorted = false
      }

    }
    sorted
  }


}
