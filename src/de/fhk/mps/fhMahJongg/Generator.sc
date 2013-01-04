package de.fhk.mps.fhMahJongg

import scala.util.Random

object Generator
{
  println("Worksheet for the Generator")          //> Worksheet for the Generator
  
  var r = new Random(144)                         //> r  : scala.util.Random = scala.util.Random@25648263
  r.nextInt(144)                                  //> res0: Int = 16
  r.nextInt(95)                                   //> res1: Int = 3
}