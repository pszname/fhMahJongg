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
object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(365); val res$0 = 

	"hallo".substring(1);System.out.println("""res0: java.lang.String = """ + $show(res$0));$skip(35); 
   var layer = new Layer(100, 100);System.out.println("""layer  : de.fhk.mps.fhMahJongg.Layer = """ + $show(layer ));$skip(64); val res$1 = 
   //layer.Matrix(1)(2)
   layer.setTileIDToPosition(1, 45, 88);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(38); val res$2 = 
   layer.setTileIDToPosition(2, 4, 2);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(30); val res$3 = 
   layer.getPositionFromID(1);System.out.println("""res3: Vector[Int] = """ + $show(res$3))}
   //layer.getField
   
   /*
	var m = new map(30, 45)
	m.field(1)(2) = 5
	//m.field

	var i = 1
  var t1 = new Tile("dragon", i, 1, 1, 1)
  i += 1
  var t2 = new Tile("dragon", i, 1, 1, 2)
  i += 1
  var t3 = new Tile("dragon", i, 1, 2, 2)
  t1.pushUpper(t2.id)
  t1.pushUpper(t3.id)
  t1.UpperTile
  t1.blocked
  t1.popUpper(t3.id)
  t1.UpperTile
  t1.blocked
  t1.popUpper(t2.id)
  t1.UpperTile
  t1.blocked
  t1.check
  t1.checked
  t1.check
  t1.checked
  t1.pushUpper(t2.id)
  t1.UpperTile
  t1.popUpper(t2.id)
  t1.UpperTile
  var liste = List[Tile]()
  for (i <- 1 to 100) {
  	liste ++= List(new Tile("test", i, i, 1, 1))
  }
  for (i <- 0 to 99)	println(liste(i).position.toString)
	var v = ofDim[Int](10,10)
	var l = List[Tile]()
	var ind: Int = 0
	for (i <- 0 to 9; j <-0 to 9)	{
		ind += 1
		var t = new Tile("test", ind, i, j, 1)
		l ++= List(t)
		v(i)(j) = ind
	}
	v
	//for (i <- 1 to l.length) println(l(i).position.toString)
	
	
   // test3 = new testTile */
  
}