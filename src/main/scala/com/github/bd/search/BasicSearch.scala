package com.github.bd.search

/**
  * Created by samez on 2/15/2017.
  */
object BasicSearch extends App {

  def binarySearch(arr: Array[Int], elem: Int): Boolean = {

    if (arr.length == 0)
      false
    else if (arr(arr.length / 2) == elem)
      true
    else if (arr(arr.length / 2) > elem)
      binarySearch(arr.take(arr.length / 2), elem)
    else
      binarySearch(arr.drop(arr.length / 2 + 1), elem)

  }

  println(binarySearch(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 7))

}
