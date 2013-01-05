package de.fhk.mps.fhMahJongg

import scala.util.Random
import sun.security.util.Length

object Generator
{
  println("Worksheet for the Generator")          //> Worksheet for the Generator
  
  var r = new Random(144)                         //> r  : scala.util.Random = scala.util.Random@7a5fe968
  r.nextInt(144)                                  //> res0: Int = 16
  r.nextInt(95)                                   //> res1: Int = 3
  
  var lpLayer: List[Layer] = List();              //> lpLayer  : List[de.fhk.mps.fhMahJongg.Layer] = List()
	var lpTiles: List[Tile]  = List();        //> lpTiles  : List[de.fhk.mps.fhMahJongg.Tile] = List()
	
	var pMut1								 = fhMutableWrapper(lpLayer)
                                                  //> pMut1  : de.fhk.mps.fhMahJongg.fhMutableWrapper[List[de.fhk.mps.fhMahJongg.L
                                                  //| ayer]] = fhMutableWrapper(List())
	var pMut2								 = fhMutableWrapper(lpTiles)
                                                  //> pMut2  : de.fhk.mps.fhMahJongg.fhMutableWrapper[List[de.fhk.mps.fhMahJongg.T
                                                  //| ile]] = fhMutableWrapper(List())
	
	var fRet                 = fhGenerator.LoadTurtle(
	    pMut1,
	    pMut2
	    );                                    //> fRet  : Boolean = true
	    
	lpLayer = pMut1.value
	lpTiles = pMut2.value
	    
	println(lpLayer.length)                   //> 5
	var frm = new java.text.DecimalFormat("000");
                                                  //> frm  : java.text.DecimalFormat = java.text.DecimalFormat@674dc
	    
	// Ersten Layer Ausgeben
	for(y <- 0 until lpLayer(0).width)
	{
		for(x <- 0 until lpLayer(0).height)
		{
			//print(frm.format(lpLayer(0).getIDFromPosition(i, j)))
			print(String.format("|%s|", frm.format(lpLayer(0).getIDFromPosition(x, y))))
		}
		println
	}                                         //> |000||000||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| |000||000||000||099||000||098||000||057||000||139||000||044||000||140||000||
                                                  //| 089|
                                                  //| |000||000||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| |000||000||000||000||000||000||000||032||000||096||000||003||000||088||000||
                                                  //| 131|
                                                  //| |000||000||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| |000||000||000||000||000||021||000||134||000||038||000||017||000||080||000||
                                                  //| 085|
                                                  //| |000||000||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| |000||000||000||139||000||069||000||088||000||062||000||066||000||022||000||
                                                  //| 060|
                                                  //| |000||067||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| |000||000||000||011||000||012||000||070||000||111||000||119||000||088||000||
                                                  //| 138|
                                                  //| |000||000||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| Output exceeds cutoff limit.
}