package com.github.braindump.codility

import scala.collection.mutable.HashSet

/**
  * @author Shad
  */
object FrogRiverOne extends App{

  def solution(x: Int, a: Array[Int]): Int = {
    val store = new HashSet[Int]()
    var sum = 0
    var minTime = -1
    var found = false
    for(i <- a.indices
        if !found){
      if(a(i) <= x && !store.contains(a(i))){
        store.add(a(i))
        sum += a(i)
      }
      if(sum == (x + (x * x)) / 2){
        minTime = i
        found = true
      }
    }
    minTime
  }


 println(solution(7, Array(1,3,1,4,2,3,5,4,7,2,4,8,9,6,12,3)))
}
