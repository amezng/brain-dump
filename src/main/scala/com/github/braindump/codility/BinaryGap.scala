package com.github.braindump.codility

/**
  * Created by samez on 2/28/2017.
  */
object BinaryGap extends App{

  def solution(n: Int): Int = {
    val splitted = n.toBinaryString.split("1+")
    val max = {
        if(splitted.last.startsWith("0"))
          splitted.dropRight(1)
      else
          splitted
    }
        if(max.nonEmpty)
          max.map(_.length).sortWith(_ > _).head
        else
          0


  }

  println(solution(529))
  println(solution(999999))
  println(solution(6))

}
