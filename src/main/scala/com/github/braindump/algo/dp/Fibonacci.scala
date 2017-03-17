package com.github.braindump.algo.dp

/**
  * Created by samez on 3/2/2017.
  */
object Fibonacci extends App {

  def memoizedSolution(n : Int,n0 : Int, n1 : Int) : Int = {
    val mem = new Array[Int](n)
    mem(0) = n0
    mem(1) = n1
    for(i <- 2 until n ) {
      mem(i) = mem(i-1) + mem(i-2)
    }
    mem(n-1)
  }

  println(memoizedSolution(6,1,1))

}
