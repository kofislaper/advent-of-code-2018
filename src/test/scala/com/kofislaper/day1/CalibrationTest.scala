package com.kofislaper.day1

import org.scalatest.{FunSuite, Matchers}

class CalibrationTest extends FunSuite with Matchers {

  test("Calculate frequency: Example inputs") {
    Calibration.calculateFrequency(0, List(1, 1, 1)) shouldEqual 3
    Calibration.calculateFrequency(0, List(1, 1, -2)) shouldEqual 0
    Calibration.calculateFrequency(0, List(-1, -2, -3)) shouldEqual -6
    Calibration.calculateFrequency(0, List(1, -2, 3, 1)) shouldEqual 3
  }

  test("Find first repeated frequency: Example inputs") {
    Calibration.findFirstRepeatedFrequency(0, List(1, -1)) shouldEqual 0
    Calibration.findFirstRepeatedFrequency(0, List(3, 3, 4, -2, -4)) shouldEqual 10
    Calibration.findFirstRepeatedFrequency(0, List(-6, 3, 8, 5, -6)) shouldEqual 5
    Calibration.findFirstRepeatedFrequency(0, List(7, 7, -2, -7, -4)) shouldEqual 14
    Calibration.findFirstRepeatedFrequency(0, List(1, -2, 3, 1)) shouldEqual 2
  }
}
