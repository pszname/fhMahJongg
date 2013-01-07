import de.fhk.ctr.fhMahJongg._

object Mahjongg	{
  def main(args: Array[String]) {
	println("Geben Sie ein Layout-Typ ein: ")
	Controller.generateGameBoard(Console.readInt)
	while (1 == 1)	{
	  for (i <- 29 to 0 by -1) println((i+1).toString + " " + Controller.generateTopLayer(i).toList)
	  println((for (i <- 0 until Controller.layout.tiles.length) yield Controller.layout.tiles(i).id).toString)
	  println("Geben Sie eine ID ein: ")
	  var id = Console.readInt
	  println(Controller.checkTile(id))
	  println(Controller.layout.tiles(id).position)
	  println(Controller.layout.tiles(id).id)
	}
  }
}
