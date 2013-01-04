package de.fhk.mps.fhMahJongg

import scala.util.Random

/////////////////////////////////////////////////////////////////////////////////////////
/**
 *  Der fhGenerator erzeugt das Layout und setzt die Bedingungen der einzelnen Tile's
 */
object fhGenerator 
{
    /**
     * Liste mit den Namen der Tiles
     */
	private val TILE_NAMES: Array[String] = Array(
			"1B1", "2B1", "3B1", "4B1",	// Bambus 1
			"1B2", "2B2", "3B2", "4B2",	// Bambus 2
			"1B3", "2B3", "3B3", "4B3",	// Bambus 3
			"1B4", "2B4", "3B4", "4B4",	// Bambus 4
			"1B5", "2B5", "3B5", "4B5",	// Bambus 5
			"1B6", "2B6", "3B6", "4B6",	// Bambus 6
			"1B7", "2B7", "3B7", "4B7",	// Bambus 7
			"1B8", "2B8", "3B8", "4B8",	// Bambus 8
			"1B9", "2B9", "3B9", "4B9",	// Bambus 9
			// ---------------------------------------
			"1Z1", "2Z1", "3Z1", "4Z1",	// Zahl 1
			"1Z2", "2Z2", "3Z2", "4Z2",	// Zahl 2
			"1Z3", "2Z3", "3Z3", "4Z3",	// Zahl 3
			"1Z4", "2Z4", "3Z4", "4Z4",	// Zahl 4
			"1Z5", "2Z5", "3Z5", "4Z5",	// Zahl 5
			"1Z6", "2Z6", "3Z6", "4Z6",	// Zahl 6
			"1Z7", "2Z7", "3Z7", "4Z7",	// Zahl 7
			"1Z8", "2Z8", "3Z8", "4Z8",	// Zahl 8
			"1Z9", "2Z9", "3Z9", "4Z9",	// Zahl 9
			// ---------------------------------------
			"1M1", "2M1", "3M1", "4M1",	// Muenze 1
			"1M2", "2M2", "3M2", "4M2",	// Muenze 2
			"1M3", "2M3", "3M3", "4M3",	// Muenze 3
			"1M4", "2M4", "3M4", "4M4",	// Muenze 4
			"1M5", "2M5", "3M5", "4M5",	// Muenze 5
			"1M6", "2M6", "3M6", "4M6",	// Muenze 6
			"1M7", "2M7", "3M7", "4M7",	// Muenze 7
			"1M8", "2M8", "3M8", "4M8",	// Muenze 8
			"1M9", "2M9", "3M9", "4M9",	// Muenze 9
			// ---------------------------------------
			"1W1", "2W1", "3W1", "4W1",	// Wind 1
			"1W2", "2W2", "3W2", "4W2",	// Wind 2
			"1W3", "2W3", "3W3", "4W3",	// Wind 3
			"1W4", "2W4", "3W4", "4W4",	// Wind 4
			// ---------------------------------------
			"1D1", "2D1", "3D1", "4D1",	// Drache 1
			"1D2", "2D2", "3D2", "4D2",	// Drache 2
			"1D3", "2D3", "3D3", "4D3",	// Drache 3
			// ---------------------------------------
			"1F1", "2F1", "3F1", "4F1",	// Blumen 1
			"1F2", "2F2", "3F2", "4F2",	// Blumen 2
			"1F3", "2F3", "3F3", "4F3",	// Blumen 3
			"1F4", "2F4", "3F4", "4F4",	// Blumen 4
			// ---------------------------------------
			"1J1", "2J1", "3J1", "4J1",	// Jahreszeiten 1
			"1J2", "2J2", "3J2", "4J2",	// Jahreszeiten 2
			"1J3", "2J3", "3J3", "4J3",	// Jahreszeiten 3
			"1J4", "2J4", "3J4", "4J4" 	// Jahreszeiten 4
	)
	/////////////////////////////////////////////////////////////////////////////////////
	val MAX_TILES :Int = 144;
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 *  Generiert ein Layout per Zufall
	 */
	def Generate(lstLayer: List[Layer]):Boolean=
	{
		return false;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 *  Laedt einfaches Layout
	 */
	def LoadTurtle(lstLayer: fhMutableWrapper[List[Layer]], lpTiles: fhMutableWrapper[List[Tile]]):Boolean=
	{
	    var pRand      = new Random(MAX_TILES);
		var lpTmp      = CreateTiles();				// Erzeuge die nötigen Tiles
		lstLayer.value = InitLayer(5, 15, 8);		// Erzeuge die Layer
		lpTiles.value  = List();					// Loesche oder erzeuge die Tile-Liste
		
		// Generiere die Position der Tiles
		// erste Reihe ------------------------------------------------------------------
		
		
		return false;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 *  Laedt ein Layout aus einer Textdatei
	 */
	def LoadUser(lstLayer: List[Layer]):Boolean=
	{
		return false;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 *  Erzeugt alle Kacheln der Laufindex ist hierbei die ID der Kacheln
	 */
	private def CreateTiles():List[Tile] =
	{
	    var lpTiles: List[Tile] = List();
	    
	    for (i <- 1 to MAX_TILES)
	    {
	    	lpTiles ++= List(new Tile(TILE_NAMES(i), i, 0, 0, 0));
	    }
	    
		return lpTiles;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 *  Initialisiert den Layer
	 *  Die Achsen Abschnitte werden dabei mal zwei genommen.
	 */
	private def InitLayer(cb: Int, iXmax: Int, iYmax: Int):List[Layer]=
	{
		var lpLayer: List[Layer] = List();
		// Initialisiere die Layer
			for (i <- 0 until cb)
			{
				lpLayer ++= List(new Layer(iXmax*2, iYmax*2));
			}
			
			return lpLayer;
	}
	/////////////////////////////////////////////////////////////////////////////////////
}