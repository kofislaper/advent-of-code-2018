package com.kofislaper.day2


import scala.io.Source

object Checksum {

  def calculateChecksum(strings: List[String]): Int = {
    def containsLetter(word: String, expectedCount: Int): Boolean = {
      val letterToOccurrences: Map[Char, Array[Char]] = word.toCharArray.groupBy(e => e)
      letterToOccurrences.values.exists(_.length == expectedCount)
    }

    val wordsWith2OfAnyLetters = strings.count(containsLetter(_, 2))
    val wordsWith3OfAnyLetters = strings.count(containsLetter(_, 3))
    wordsWith2OfAnyLetters * wordsWith3OfAnyLetters
  }


  def findCommonPart(strings: List[String]): String = {
    def areWrodsSimilar(w1: String, w2: String): Boolean = {
      Stream.from(0).takeWhile(e => e < w1.length)
        .count(i => w1.charAt(i) == w2.charAt(i)) == w1.length - 1
    }

    strings.foreach(w1 => {
      strings.foreach(w2 => {
        if (w1 != w2 && areWrodsSimilar(w1, w2)) {
          val common = Stream.from(0).takeWhile(e => e < w1.length)
            .filter(i => w1.charAt(i).equals( w2.charAt(i)))
            .map(i => w1.charAt(i)).toArray
         return String.copyValueOf(common)
        }
      })
    })
    null
  }


  def main(args: Array[String]): Unit = {
    val lines = Source.fromResource("day2.txt").getLines().toList
    println(calculateChecksum(lines))
    println(findCommonPart(lines))
  }
}
