package com.github.braindump.codility

import scala.collection.mutable.HashSet

/**
  * @author Shad
  */
object PermCheck extends App {

  def solution(a: Array[Int]): Int = {

    val store = new HashSet[Int]()
    var isUnique = true
    for {i <- a.indices
         if isUnique} {
      if (store.contains(a(i)))
        isUnique = false
      else
        store.add(a(i))
    }
    if (isUnique && a.sum == ((a.length + (a.length * a.length)) / 2) )
      1
    else
      0
  }

  println(solution(Array(4, 1, 1)))

}
