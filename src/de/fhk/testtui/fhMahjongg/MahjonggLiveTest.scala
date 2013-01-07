package de.fhk.testtui.fhMahjongg

import de.fhk.ctr.fhMahJongg._
import org.specs2.text.AnsiColors._

object Mahjongg	{
  def main(args: Array[String]) {
	
    println("Geben Sie ein Layout-Typ ein: ")
	Controller.generateGameBoard(Console.readInt)
	
	while (1 == 1)	{
	  
	  //for (i <- 0 until 30) println((i+1).toString + " " + Controller.generateTopLayer(i).toList)
	  
	  var tT: Array[Array[String]] = Controller.generateTopLayerWithNames
	  var ttT: Array[Array[Int]] = Controller.generateTopLayer
	  
	  for (j <- 0 until tT(0).length; i <- 0 until tT.length)	{		
	    var str = ""
	    if (Controller.getTile(ttT(i)(j)) != null && Controller.getTile(ttT(i)(j)).blocked)
	      str = Console.RED
	    else str = Console.GREEN
	    str = tT(i)(j) + " "
	    print(str)
	    if (i == tT.length-1) println
	  }

	  println
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
	  var str = ""
	    
  	  if (id > 0) id -= 1
  	  
  	  var erg = Controller.checkTile(id)
  	  
  	  if (erg.length > 1) str = tT(x)(y) + " wurde ausgewählt"
  	  else str = tT(x)(y) + " ist geblockt"
  	  if (erg.length > 3) str += " und wurde zusammen mit der letzten Kachel entfernt"

  	  //System.out.printf("\033[31m" + str + "\033[0m\n")
  	  println(str)
  	      	  
  	  /*println(id)
	  println(Controller.checkTile(id))
	  println(Controller.layout.tiles(id).checked)
	  println(Controller.layout.tiles(id).position)
	  println(Controller.layout.tiles(id).id)
	  println(Controller.layout.tiles(id).name)*/
	}
  }
}
