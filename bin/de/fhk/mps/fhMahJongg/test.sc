package de.fhk.mps.fhMahJongg

/*import org.specs2.mutable._

class TileTest extends SpecificationWithJUnit {
   	"A new Tile with X = 1, Y = 2, Z = 3" should	{
   			val t = new Tile("test", 0, 1, 2, 3)
  	 	"return its position as vector" in	{
  	 	t.position must be(Vector(1,2,3))
  		 }
  	 }
   }*/
   
   
   
   

import Array._
object test {

	var m = new map(30, 45)                   //> m  : de.fhk.mps.fhMahJongg.map = de.fhk.mps.fhMahJongg.map@1c87031
	m.field(1)(2) = 5
	//m.field

	var i = 1                                 //> i  : Int = 1
  var t1 = new Tile("dragon", i, 1, 1, 1)         //> t1  : de.fhk.mps.fhMahJongg.Tile = de.fhk.mps.fhMahJongg.Tile@1724852
  i += 1
  var t2 = new Tile("dragon", i, 1, 1, 2)         //> t2  : de.fhk.mps.fhMahJongg.Tile = de.fhk.mps.fhMahJongg.Tile@1ea0c8b
  i += 1
  var t3 = new Tile("dragon", i, 1, 2, 2)         //> t3  : de.fhk.mps.fhMahJongg.Tile = de.fhk.mps.fhMahJongg.Tile@dd8904
  t1.pushUpper(t2.id)
  t1.pushUpper(t3.id)
  t1.UpperTile                                    //> res0: List[Int] = List(2, 3)
  t1.blocked                                      //> res1: Boolean = true
  t1.popUpper(t3.id)
  t1.UpperTile                                    //> res2: List[Int] = List(2)
  t1.blocked                                      //> res3: Boolean = true
  t1.popUpper(t2.id)
  t1.UpperTile                                    //> res4: List[Int] = List()
  t1.blocked                                      //> res5: Boolean = false
  t1.check                                        //> res6: Boolean = true
  t1.checked                                      //> res7: Boolean = true
  t1.check                                        //> res8: Boolean = true
  t1.checked                                      //> res9: Boolean = false
  t1.pushUpper(t2.id)
  t1.UpperTile                                    //> res10: List[Int] = List(2)
  t1.popUpper(t2.id)
  t1.UpperTile                                    //> res11: List[Int] = List()
  var liste = List[Tile]()                        //> liste  : List[de.fhk.mps.fhMahJongg.Tile] = List()
  for (i <- 1 to 100) {
  	liste ++= List(new Tile("test", i, i, 1, 1))
  }
  for (i <- 0 to 99)	println(liste(i).position.toString)
                                                  //> Vector(1, 1, 1)
                                                  //| Vector(2, 1, 1)
                                                  //| Vector(3, 1, 1)
                                                  //| Vector(4, 1, 1)
                                                  //| Vector(5, 1, 1)
                                                  //| Vector(6, 1, 1)
                                                  //| Vector(7, 1, 1)
                                                  //| Vector(8, 1, 1)
                                                  //| Vector(9, 1, 1)
                                                  //| Vector(10, 1, 1)
                                                  //| Vector(11, 1, 1)
                                                  //| Vector(12, 1, 1)
                                                  //| Vector(13, 1, 1)
                                                  //| Vector(14, 1, 1)
                                                  //| Vector(15, 1, 1)
                                                  //| Vector(16, 1, 1)
                                                  //| Vector(17, 1, 1)
                                                  //| Vector(18, 1, 1)
                                                  //| Vector(19, 1, 1)
                                                  //| Vector(20, 1, 1)
                                                  //| Vector(21, 1, 1)
                                                  //| Vector(22, 1, 1)
                                                  //| Vector(23, 1, 1)
                                                  //| Vector(24, 1, 1)
                                                  //| Vector(25, 1, 1)
                                                  //| Vector(26, 1, 1)
                                                  //| Vector(27, 1, 1)
                                                  //| Vector(28, 1, 1)
                                                  //| Vector(29, 1, 1)
                                                  //| Vector(30, 1, 1)
                                                  //| Vector(31, 1, 1)
                                                  //| Vector(32, 1, 1)
                                                  //| Vector(33, 1, 1)
                                                  //| Vector(34, 1, 1)
                                                  //| Vector(35, 1, 1)
                                                  //| Vector(36, 1, 1)
                                                  //| Vector(37, 1, 1)
                                                  //| Vector(38, 1, 1)
                                                  //| Vector(39, 1, 1)
                                                  //| Vector(40, 1, 1)
                                                  //| Vector(41, 1, 1)
                                                  //| Vector(42, 1, 1)
                                                  //| Vector(43, 1, 1)
                                                  //| Vector(44, 1, 1
                                                  //| Output exceeds cutoff limit.
	var v = ofDim[Int](10,10)                 //> v  : Array[Array[Int]] = Array(Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0
                                                  //| , 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0,
                                                  //|  0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 
                                                  //| 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0
                                                  //| , 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), Array(0, 0,
                                                  //|  0, 0, 0, 0, 0, 0, 0, 0))
	var l = List[Tile]()                      //> l  : List[de.fhk.mps.fhMahJongg.Tile] = List()
	var ind: Int = 0                          //> ind  : Int = 0
	for (i <- 0 to 9; j <-0 to 9)	{
		ind += 1
		var t = new Tile("test", ind, i, j, 1)
		l ++= List(t)
		v(i)(j) = ind
	}
	v                                         //> res12: Array[Array[Int]] = Array(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), Arra
                                                  //| y(11, 12, 13, 14, 15, 16, 17, 18, 19, 20), Array(21, 22, 23, 24, 25, 26, 27
                                                  //| , 28, 29, 30), Array(31, 32, 33, 34, 35, 36, 37, 38, 39, 40), Array(41, 42,
                                                  //|  43, 44, 45, 46, 47, 48, 49, 50), Array(51, 52, 53, 54, 55, 56, 57, 58, 59,
                                                  //|  60), Array(61, 62, 63, 64, 65, 66, 67, 68, 69, 70), Array(71, 72, 73, 74, 
                                                  //| 75, 76, 77, 78, 79, 80), Array(81, 82, 83, 84, 85, 86, 87, 88, 89, 90), Arr
                                                  //| ay(91, 92, 93, 94, 95, 96, 97, 98, 99, 100))
	//for (i <- 1 to l.length) println(l(i).position.toString)
	
	
   // test3 = new testTile
  
}