package com.github.brain.sample

/**
  * Created by samez on 2/28/2017.
  */
object EqSolution extends App {

  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    var balancedIndex = 0

    var net = a.sum
    var lsum = 0
    var found = false
    for( i <- a.indices
       if !found){
      net -= a(i)
      if(lsum == net){
        balancedIndex = i
        found = true
      }

      else{
        lsum+=a(i)
      }
    }

    if(!found)
      -1
    else
      balancedIndex

  }


  val ar = Array(-1,3,-4,5,1,-6,2,1)
  println(solution(ar))
  val ar2 = Array(-1,0)
  println(solution(ar2))

  def solution2(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    var balancedIndex = 0

    var net = a.sum
    var lsum = 0
    var found = false
    for( i <- a.indices
         if !found){
      net -= a(i)
      if(lsum == net){
        balancedIndex = i
        found = true
      }

      else{
        lsum+=a(i)
      }
    }

    if(!found)
      -1
    else
      balancedIndex

  }

}
