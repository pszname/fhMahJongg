import de.fhk.ctr.fhMahJongg._

object Mahjongg	{
  def main(args: Array[String]) {
	println("Geben Sie ein Layout-Typ ein: ")
	Controller.generateGameBoard(Console.readInt)
	while (1 == 1)	{
	  println((for (i <- 0 until Controller.layout.tiles.length) yield Controller.layout.tiles(i).id).toString)
	  for (i <- 0 until 30) println((i+1).toString + " " + Controller.generateTopLayer(i).toList)
	  println("Geben Sie eine ID ein: ")
	  println(Controller.checkTile(Console.readInt))
	}
  }
}
