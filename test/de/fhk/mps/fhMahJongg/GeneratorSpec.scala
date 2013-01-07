package de.fhk.mps.fhMahJongg

import org.specs2.mutable._

class GeneratorSpec extends SpecificationWithJUnit
{
	"A IsDouble Check" should
	{
		var lpLayer: List[Layer] = List()
		var szName:  String      = "4B1"
		var lpPosit: Vector[Int] = Vector[Int](0, 0, 3)
		
		lpLayer ++= List(new Layer(1,1));
		lpLayer ++= List(new Layer(1,1));
		lpLayer ++= List(new Layer(1,1));
		lpLayer ++= List(new Layer(1,1));
		
		lpLayer(0).setTileIDToPosition(1, 0, 0)
		lpLayer(1).setTileIDToPosition(2, 0, 0)
		lpLayer(2).setTileIDToPosition(3, 0, 0)
		lpLayer(3).setTileIDToPosition(4, 0, 0)
		
		"Get a false with 4 times tile type" in
		{
			fhGenerator.IsDouble(lpLayer, szName, lpPosit) must be_==(false)
		}
	}
	
	// TURTLE-LAYOUT
	"A Turtle layout" should 
	{
		var lpLayer: List[Layer] = List();
		var lpTiles: List[Tile]  = List();
		var pMut1                = fhMutableWrapper(lpLayer);
		var pMut2				 = fhMutableWrapper(lpTiles);
		var fRet                 = fhGenerator.LoadTurtle(pMut1, pMut2);
		
		lpLayer = pMut1.value;
		lpTiles = pMut2.value;
		
		"return true" in
		{
		    fRet must be_==(true)
			//println(fRet)
		}
		
		"return a Layercount of 5" in
		{
			lpLayer.length must be_==(5)
			//println(lpLayer.length)
		}
		
		"return a Tile count of 144" in
		{
			lpTiles.length must be_==(144)
			//println(lpTiles.length)
		}
	}
	
	"A Test layout" should
	{
		var lpLayer: List[Layer] = List()
		var lpTiles: List[Tile]  = List()
		var pMut1				 = fhMutableWrapper(lpLayer)
		var pMut2			 	 = fhMutableWrapper(lpTiles)
		var fRet				 = fhGenerator.LoadTest(pMut1, pMut2)
		
		lpLayer    = pMut1.value
		lpTiles    = pMut2.value
		
		var posEl1: Int = lpLayer(0).getIDFromPosition(0, 0);
		
		"return true" in
		{
		    fRet must be_==(true)
			//println(fRet)
		}
		
		"return a Layercount of 5" in
		{
			lpLayer.length must be_==(5)
			//println(lpLayer.length)
		}
		
		"return a Tile count of 144 for 6 Playable Tiles" in
		{
			lpTiles.length must be_==(144)
			//println(lpTiles.length)
		}
		
		"The X- Position of Tile 1" in
		{
			//println(posEl1)
			lpTiles(posEl1-1).position(0) must be_==(0)
		}
		
		"The Y- Position of Tile 1" in
		{
			lpTiles(posEl1-1).position(1) must be_==(0)
		}
		
		"The Tile at (0,0) should have one Neighbor" in
		{
			lpTiles(posEl1-1).NeighborTile.length must be_==(1)
		}
		
		var posEl2: Int = lpLayer(0).getIDFromPosition(2, 0);
		
		"The Tile at (2, 0) should have two Neighbors" in
		{
			lpTiles(posEl2-1).NeighborTile.length must be_==(2)
		}
	}
}