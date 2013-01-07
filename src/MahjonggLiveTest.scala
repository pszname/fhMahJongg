import de.fhk.ctr.fhMahJongg._

object Mahjongg	{
  def main(args: Array[String]) {
	println("Geben Sie ein Layout-Typ ein: ")
	Controller.generateGameBoard(Console.readInt)
	while (1 == 1)	{
	  //for (i <- 0 until 30) println((i+1).toString + " " + Controller.generateTopLayer(i).toList)
	  for (i <- 0 until 30) println((i+1).toString + " " + Controller.layout.topTilesWithNames(i).toList)
	  //println((for (i <- 0 until Controller.layout.tiles.length) yield Controller.layout.tiles(i).id).toString)
	  println("Geben Sie eine Zeile ein: ")
	  var x = Console.readInt
	  println("Geben Sie eine Spalte ein: ")
	  var y = Console.readInt
	  var id = Controller.layout.topTiles(x-1)(y-1)
  	  if (id > 0) id -= 1
	  println(Controller.checkTile(id))
	  println(Controller.layout.tiles(id).position)
	  println(Controller.layout.tiles(id).id)
	  println(Controller.layout.tiles(id).name)
	}
  }
}
