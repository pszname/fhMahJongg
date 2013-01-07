package de.fhk.mps.fhMahJongg

import de.fhk.ctr.fhMahJongg._



/*import org.specs2.mutable._

class TileTest extends SpecificationWithJUnit {
   	"A new Tile with X = 1, Y = 2, Z = 3" should	{
   			val t = new Tile("test", 0, 1, 2, 3)
  	 	"return its position as vector" in	{
  	 	t.position must be(Vector(1,2,3)
  		 }
  	 }
   }*/
   
   

import Array._
object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(408); val res$0 = 
	Controller.generateGameBoard(1);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(26); val res$1 = 
	Controller.checkTile(70);System.out.println("""res1: Vector[Int] = """ + $show(res$1));$skip(29); val res$2 = 
	Controller.generateTopLayer;System.out.println("""res2: Array[Array[Int]] = """ + $show(res$2));$skip(52); val res$3 = 
                         
	Controller.checkTile(71);System.out.println("""res3: Vector[Int] = """ + $show(res$3))}
		
	
	/*Controller.layout.tiles(70).position
	Controller.layout.tiles(70).name
	Controller.layout.tiles(70).checked
	Controller.layout.tiles(78).name
	Controller.checkTile(78)
	Controller.layout.Layer(0).getIDFromPosition(3, 9)
	fhLayoutType(1)
	//Controller.layout.Layer(0).getField
	
	var t1 = new Tile("dragon", 2, 1, 2, 3)
	t1.position(0)
	
	t1.UpperTile
	t1.popUpper(3)
	t1.check
	t1.checked



	"hallo".substring(1)
   var layer = new Layer(100, 100)
   layer.Matrix(1)(2)
   layer.setTileIDToPosition(1, 45, 88)
   layer.setTileIDToPosition(2, 4, 2)
   layer.getPositionFromID(1)
   layer.deleteTileIDFromPosition(4, 2)
   var matrix = layer.getField
   matrix(4)(2)
   
   
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