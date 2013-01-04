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
object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(387); 
	
	
	var t1 = new Tile("dragon", 2, 1, 2, 3);System.out.println("""t1  : de.fhk.mps.fhMahJongg.Tile = """ + $show(t1 ));$skip(16); val res$0 = 
	t1.position(0);System.out.println("""res0: Int = """ + $show(res$0));$skip(16); val res$1 = 
	
	t1.UpperTile;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(16); 
	t1.popUpper(3);$skip(23); val res$2 = 

	"hallo".substring(1);System.out.println("""res2: java.lang.String = """ + $show(res$2));$skip(35); 
   var layer = new Layer(100, 100);System.out.println("""layer  : de.fhk.mps.fhMahJongg.Layer = """ + $show(layer ));$skip(64); val res$3 = 
   //layer.Matrix(1)(2)
   layer.setTileIDToPosition(1, 45, 88);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(38); val res$4 = 
   layer.setTileIDToPosition(2, 4, 2);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(30); val res$5 = 
   layer.getPositionFromID(1);System.out.println("""res5: Vector[Int] = """ + $show(res$5))}
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