package com.kofislaper.day2

import org.scalatest.{FunSuite, Matchers}

class ChecksumTest extends FunSuite with Matchers {

  test("Example data") {
    Checksum.calculateChecksum(List("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")) shouldEqual 12
  }
}
