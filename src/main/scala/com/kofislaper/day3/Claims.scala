package com.kofislaper.day3


import scala.io.Source

object Claims {


  def coutOverlaps(lines: List[String]): Int = {
    lines.map("[0-9]+".r.findAllIn(_))
      .map(_.toList)
      .flatMap(toPoints)
      .groupBy(e => (e.x, e.y)).values.count(_.size >= 2)
  }

  def findNonOverlappingId(lines: List[String]): Int = {
    val points = lines.map("[0-9]+".r.findAllIn(_))
      .map(_.toList)
      .flatMap(toPoints)

    val nonOverlappingPoints = points
      .groupBy(e => (e.x, e.y))
      .filter(_._2.size == 1)

    val nonOverlappingPointsByRectangle = nonOverlappingPoints.values.map(_.head)
      .groupBy(_.rectangleId)

    val pointsByRectangle = points.groupBy(_.rectangleId)

    nonOverlappingPointsByRectangle
      .find(e => pointsByRectangle(e._1).size == e._2.size)
      .map(_._1)
      .getOrElse(-1)
  }

  def toPoints(ints: List[String]): Seq[Point] = {
    Stream.from(ints(1).toInt).take(ints(3).toInt)
      .flatMap(i => Stream.from(ints(2).toInt).take(ints(4).toInt).map(j => Point(i, j, ints.head.toInt)))
      .toList
  }


  def main(args: Array[String]): Unit = {
    val lines = Source.fromResource("day3.txt").getLines().toList
    println(coutOverlaps(lines))
    println(findNonOverlappingId(lines))
  }

  case class Point(x: Int, y: Int, rectangleId: Int)

}
