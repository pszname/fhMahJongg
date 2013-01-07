import de.fhk.ctr.fhMahJongg._
import org.specs2.internal.scalaz.Length

object Mahjongg	{
  def main(args: Array[String]) {
	println("Geben Sie ein Layout-Typ ein: ")
	Controller.generateGameBoard(Console.readInt)
	while (1 == 1)	{
	  //for (i <- 0 until 30) println((i+1).toString + " " + Controller.generateTopLayer(i).toList)
	  var tT: Array[Array[String]] = Controller.layout.topTilesWithNames
	  var ttT: Array[Array[Int]] = Controller.generateTopLayer
	  for (j <- 0 until tT(0).length; i <- 0 until tT.length)	{
	    var id = ttT(i)(j)-1
	    //if (id > 0 && !Controller.layout.tiles(id).blocked) Console.BLUE
	    Console.BLUE
	    Console.out.print(tT(i)(j) + " ")
	    if (i == tT.length-1) println
	  }
	  //for (i <- 0 until tT.length) println((i+1).toString + " " + tT(i).toList)
	  //println((for (i <- 0 until Controller.layout.tiles.length) yield Controller.layout.tiles(i).id).toString)
	  /*println("Geben Sie eine Spalte ein: ")
	  var x = Console.readInt
	  println("Geben Sie eine Zeile ein: ")
	  var y = Console.readInt*/
	  println("Geben Sie den Namen einer Kachel ein, die ausgewählt werden soll: ")
	  var in = Console.readLine
	  var x = 0
	  var y = 0
	  for(i <- 0 until tT.length; j <- 0 until tT(0).length)	{
		  if (tT(i)(j) == in)	{
		    x = i
		    y = j
		  }
	  }
	  var id = ttT(x)(y)
  	  if (id > 0) id -= 1
  	  println(id)
	  println(Controller.checkTile(id))
	  println(Controller.layout.tiles(id).checked)
	  println(Controller.layout.tiles(id).position)
	  println(Controller.layout.tiles(id).id)
	  println(Controller.layout.tiles(id).name)
	}
  }
}
