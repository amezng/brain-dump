package com.github.braindump.codility

/**
  * @author Shad
  */
object CyclicRotation extends App {

  def solution(a: Array[Int], k: Int): Array[Int] = {
    val narr = new Array[Int](a.length)

    for (i <- a.indices) {
      if (i + k < a.length) {
        narr(i + k) = a(i)
      } else if( k > a.length){
        narr( (i + k % a.length) % a.length) = a(i)
      }
      else{
        narr((i + k) - a.length ) = a(i)
      }


    }
    narr
  }

  println(solution(Array(3, 8, 9, 7, 6), 3).toString)
}
