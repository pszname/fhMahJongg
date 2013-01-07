package de.fhk.mps.fhMahJongg

import scala.util.Random
import sun.security.util.Length

object Generator
{
  println("Worksheet for the Generator")          //> Worksheet for the Generator
  
  var r = new Random(144)                         //> r  : scala.util.Random = scala.util.Random@73cd1e4e
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
                                                  //| |000||000||000||052||000||031||000||012||000||125||000||071||000||043||000||
                                                  //| 015|
                                                  //| |000||000||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| |000||000||000||000||000||000||000||056||000||045||000||020||000||117||000||
                                                  //| 047|
                                                  //| |000||000||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| |000||000||000||000||000||101||000||134||000||097||000||094||000||042||000||
                                                  //| 054|
                                                  //| |000||000||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| |000||000||000||086||000||023||000||001||000||140||000||126||000||075||000||
                                                  //| 124|
                                                  //| |000||067||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| |000||000||000||029||000||118||000||111||000||061||000||142||000||004||000||
                                                  //| 119|
                                                  //| |000||000||000||000||000||000||000||000||000||000||000||000||000||000||000||
                                                  //| 000|
                                                  //| Output exceeds cutoff limit.
	
	var szT1 = "1B1"                          //> szT1  : java.lang.String = 1B1
	var szT2 = "2B1"                          //> szT2  : java.lang.String = 2B1
	
	szT1(1) + szT1(2) == szT2(1) + szT2(2)    //> res2: Boolean = true
}