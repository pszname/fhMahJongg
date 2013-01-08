package de.fhk.tui.fhMahjongg

import de.fhk.ctr.fhMahJongg._
import org.specs2.text.AnsiColors._

/**
 * This object provides a main method, that creates a text user interface.
 */
object Mahjongg	{
  
  /**
   * This method calculates, if there are any more pairs of tiles left in the game.
   * 
   * @param top layer with names and top layer as <code>Array[Array[Int]]</code>
   * @return <code>true</code>, if at least one pair was found
   */
  def openPairs(tT: Array[Array[String]], ttT: Array[Array[Int]]): Boolean = {
	  var openPairList = List[Vector[Int]]()  	  
  	  for (i <- 0 until tT.length; j <- 0 until ttT(0).length) if (ttT(i)(j) > 0 && !Controller.isBlockedAt(ttT(i)(j))) openPairList ++= List(Vector(i, j))
  	  for (i <- 0 until openPairList.length; j <- 0 until openPairList.length)	{
  	    if (i != j) if (tT(openPairList(i)(0))(openPairList(i)(1)).substring(1) == tT(openPairList(j)(0))(openPairList(j)(1)).substring(1)) return true
  	  }
	  false
  }
  
  /**
   * This is the main program of the text user interface.
   * 
   * @param commandline parameter args: <code>Array[String</code>
   */
  def main(args: Array[String]) {
	
    while(true)	{
    
    println("Geben Sie ein Layout-Typ ein: ")
	Controller.generateGameBoard(Console.readInt)
	
	var count = 0
    var openPair: Boolean = true
    
    var tT: Array[Array[String]] = Controller.generateTopLayerWithNames
	var ttT: Array[Array[Int]] = Controller.generateTopLayer
	
	while (openPair)	{
	  
	  //for (i <- 0 until 30) println((i+1).toString + " " + Controller.generateTopLayer(i).toList)
	  	  	  
	  for (j <- 0 until tT(0).length; i <- 0 until tT.length)	{		
	    
	    var str = ""
	      
	    if (Controller.isBlockedAt(ttT(i)(j))) str = "\033[31m" + tT(i)(j) + " \033[0m"
	    else str = "\033[32m" + tT(i)(j) + " \033[0m"

	    print(str)
	    
	    if (i == tT.length-1) println
	  }

	  println
	  println("Geben Sie den Namen einer Kachel ein, die ausgewaehlt werden soll: ")
	  
	  var in: String = Console.readLine
	  
	  if (in.toLowerCase() == "exit")	{
	    println("MahJongg wurde beendet.")
	    return
	  }
	  
	  var x = 0
	  var y = 0
	  
	  for(i <- 0 until tT.length; j <- 0 until tT(0).length)	{
		  if (tT(i)(j) == in)	{
		    x = i
		    y = j
		  }
	  }
	  
	  var id = ttT(x)(y)
	  var str = ""
  	  
  	  var erg = Controller.checkTile(id)
  	  
  	  if (erg.length > 1) str = tT(x)(y) + " wurde ausgewaehlt"
  	  else str = tT(x)(y) + " ist geblockt oder nicht vorhanden"
  	  if (erg.length > 3) str += " und wurde zusammen mit der letzten Kachel entfernt"

  	  println(str)      	  
  	  
  	  count += 1
  	  
  	  tT = Controller.generateTopLayerWithNames
	  ttT= Controller.generateTopLayer
  	  
  	  openPair = openPairs(tT, ttT)
  	    	  
  	  
  	  /*println(id)
  	  if (id > 0)	{
	  println(Controller.layout.tiles(id-1).checked)
	  println(Controller.layout.tiles(id-1).position)
	  println(Controller.layout.tiles(id-1).id)
	  println(Controller.layout.tiles(id-1).name)
	  println("uppertile")
	  for (i <- 0 until Controller.layout.tiles(id-1).UpperTile.length) println(Controller.layout.tiles(Controller.layout.tiles(id-1).UpperTile(i)-1).name)
	  for (i <- 0 until Controller.layout.tiles(id-1).UpperTile.length) println(Controller.layout.tiles(id-1).UpperTile(i).toString())
	  println("neighbortile")
	  for (i <- 0 until Controller.layout.tiles(id-1).NeighborTile.length) println(Controller.layout.tiles(Controller.layout.tiles(id-1).NeighborTile(i)-1).name)
	  for (i <- 0 until Controller.layout.tiles(id-1).NeighborTile.length) println(Controller.layout.tiles(id-1).NeighborTile(i).toString())
  	  }*/
	}
    
      println
  	  println("Keine weiteren Zuege moeglich!")
  	  println
  	  println("Sie haben erfolgreich " + count + "Paerchen geloest.")
  	  println  	
  	  
    }
  }
}
