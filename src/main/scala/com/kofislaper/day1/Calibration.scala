package com.kofislaper.day1

import java.nio.file.{Files, Paths}

import scala.annotation.tailrec

object Calibration {

  def calculateFrequency(startingFrequency: Int, changes: Seq[Int]): Int = {
    changes.fold(startingFrequency)(_ + _)
  }

  def findFirstRepeatedFrequency(currentFrequency: Int, changes: Seq[Int]): Int = {
    @tailrec def iterate(currentFrequency: Int, changes: Seq[Int], previousFrequencies: Set[Int], index: Int): Int = {
      val changedFrequency = currentFrequency + changes(index)
      if (previousFrequencies.contains(changedFrequency)) {
        return changedFrequency
      }
      iterate(changedFrequency, changes, previousFrequencies + changedFrequency, (index + 1) % changes.size)
    }

    iterate(currentFrequency, changes, Set(currentFrequency), 0)
  }

  def main(args: Array[String]): Unit = {
    import collection.JavaConverters._
    val lines = Files.readAllLines(Paths.get(Calibration.getClass.getResource("/day1.txt").toURI)).asScala
    val changes = lines.map(_.toInt)
    println(changes)
    val result = calculateFrequency(0, changes)
    println(result)
    println(findFirstRepeatedFrequency(0, changes))
  }
}
