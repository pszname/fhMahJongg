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
	    );                                    //> java.lang.IndexOutOfBoundsException: -2
                                                  //| 	at scala.collection.LinearSeqOptimized$class.apply(LinearSeqOptimized.sc
                                                  //| ala:51)
                                                  //| 	at scala.collection.immutable.List.apply(List.scala:76)
                                                  //| 	at de.fhk.mps.fhMahJongg.fhGenerator$$anonfun$de$fhk$mps$fhMahJongg$fhGe
                                                  //| nerator$$CheckFoes$1$$anonfun$apply$mcVI$sp$1.apply$mcVI$sp(fhGenerator.scal
                                                  //| a:357)
                                                  //| 	at scala.collection.immutable.Range.foreach$mVc$sp(Range.scala:78)
                                                  //| 	at de.fhk.mps.fhMahJongg.fhGenerator$$anonfun$de$fhk$mps$fhMahJongg$fhGe
                                                  //| nerator$$CheckFoes$1.apply$mcVI$sp(fhGenerator.scala:329)
                                                  //| 	at scala.collection.immutable.Range.foreach$mVc$sp(Range.scala:78)
                                                  //| 	at de.fhk.mps.fhMahJongg.fhGenerator$.de$fhk$mps$fhMahJongg$fhGenerator$
                                                  //| $CheckFoes(fhGenerator.scala:327)
                                                  //| 	at de.fhk.mps.fhMahJongg.fhGenerator$$anonfun$LoadTurtle$2.apply$mcVI$sp
                                                  //| (fhGenerator.scala:182)
                                                  //| 	at scala.collection.immutable.Range.foreach$mVc$sp(Range.scala:78)
                                                  //| 	at de.fhk.mps.fhMahJongg.fhGenerator$.Load
                                                  //| Output exceeds cutoff limit.
	    
	lpLayer = pMut1.value
	lpTiles = pMut2.value
	    
	println(lpLayer.length)
	var frm = new java.text.DecimalFormat("000");
	    
	// Ersten Layer Ausgeben
	for(y <- 0 until lpLayer(0).width)
	{
		for(x <- 0 until lpLayer(0).height)
		{
			//print(frm.format(lpLayer(0).getIDFromPosition(i, j)))
			print(String.format("|%s|", frm.format(lpLayer(0).getIDFromPosition(x, y))))
		}
		println
	}
}