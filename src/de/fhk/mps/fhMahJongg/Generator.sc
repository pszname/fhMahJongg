package de.fhk.mps.fhMahJongg

import scala.util.Random
import sun.security.util.Length

object Generator
{
  println("Worksheet for the Generator")          //> Worksheet for the Generator
  
  var r = new Random(144)                         //> r  : scala.util.Random = scala.util.Random@2ed4e99c
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
                                                  //| |000||000||000||022||000||003||000||085||000||031||000||049||000||005||000||
                                                  //| 040|
                                                  //| |000||000||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| |000||000||000||000||000||000||000||033||000||125||000||116||000||053||000||
                                                  //| 058|
                                                  //| |000||000||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| |000||000||000||000||000||018||000||025||000||048||000||128||000||103||000||
                                                  //| 056|
                                                  //| |000||000||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| |000||000||000||133||000||012||000||007||000||132||000||092||000||039||000||
                                                  //| 003|
                                                  //| |000||050||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| |000||000||000||092||000||095||000||070||000||109||000||045||000||139||000||
                                                  //| 065|
                                                  //| |000||000||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| Output exceeds cutoff limit.
}