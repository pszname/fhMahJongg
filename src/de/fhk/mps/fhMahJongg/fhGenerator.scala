package de.fhk.mps.fhMahJongg

import scala.util.Random
import scala.collection.immutable.Nil

/////////////////////////////////////////////////////////////////////////////////////////
/**
 *  Der fhGenerator erzeugt das Layout und setzt die Bedingungen der einzelnen Tile's
 */
object fhGenerator 
{
    /**
     * Liste mit den Namen der Tiles
     */
	val TILE_NAMES: Array[String] = Array(
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
	/*
	 * Koordinaten fuer Turtle/Pyramid Layout.
	 */
	val TURTLE_COORD: Array[Vector[Int]] = Array(
			// Reihe 1 ------------------------------------------------------------------
			Vector( 3, 1, 0), Vector( 5, 1, 0), Vector( 7, 1, 0), Vector( 9, 1, 0), Vector(11, 1, 0), Vector(13, 1, 0),			// 6
			Vector(15, 1, 0), Vector(17, 1, 0), Vector(19, 1, 0), Vector(21, 1, 0), Vector(23, 1, 0), Vector(25, 1, 0),			// 12
			// Reihe 2, Ebene 1 ---------------------------------------------------------
			Vector( 7, 3, 0), Vector( 9, 3, 0), Vector(11, 3, 0), Vector(13, 3, 0), Vector(15, 3, 0), Vector(17, 3, 0),			// 18
			Vector(19, 3, 0), Vector(21, 3, 0),																					// 20
			// Reihe 2, Ebene 2 ---------------------------------------------------------
			Vector( 9, 3, 1), Vector(11, 3, 1), Vector(13, 3, 1), Vector(15, 3, 1), Vector(17, 3, 1), Vector(19, 3, 1),			// 26
			// Reihe 3, Ebene 1 ---------------------------------------------------------
			Vector( 5, 5, 0), Vector( 7, 5, 0), Vector( 9, 5, 0), Vector(11, 5, 0), Vector(13, 5, 0),							// 31
			Vector(15, 5, 0), Vector(17, 5, 0), Vector(19, 5, 0), Vector(21, 5, 0), Vector(23, 5, 0),							// 36
			// Reihe 3, Ebene 2 ---------------------------------------------------------
			Vector( 9, 5, 1), Vector(11, 5, 1), Vector(13, 5, 1), Vector(15, 5, 1), Vector(17, 5, 1), Vector(19, 5, 1),			// 42
			// Reihe 3, Ebene 3 ---------------------------------------------------------
			Vector(11, 5, 2), Vector(13, 5, 2), Vector(15, 5, 2), Vector(17, 5, 2),												// 46
			// Reihe 4, Ebene 1 ---------------------------------------------------------
			Vector( 3, 7, 0), Vector( 5, 7, 0), Vector( 7, 7, 0), Vector( 9, 7, 0), Vector(11, 7, 0), Vector(13, 7, 0),			// 52
			Vector(15, 7, 0), Vector(17, 7, 0), Vector(19, 7, 0), Vector(21, 7, 0), Vector(23, 7, 0), Vector(25, 7, 0),			// 58
			// Reihe 4, Ebene 2 ---------------------------------------------------------
			Vector( 9, 7, 1), Vector(11, 7, 1), Vector(13, 7, 1), Vector(15, 7, 1), Vector(17, 7, 1), Vector(19, 7, 1),			// 64	
			// Reihe 4, Ebene 3 ---------------------------------------------------------
			Vector(11, 7, 2), Vector(13, 7, 3), Vector(15, 7, 3), Vector(17, 7, 2),												// 68
			// Reihe 4, Ebene 4 ---------------------------------------------------------
			Vector(13, 7, 2), Vector(15, 7, 2),																					// 70
			// Reihe 5, Ebene 1 ---------------------------------------------------------
			Vector( 3, 9, 0), Vector( 5, 9, 0), Vector( 7, 9, 0), Vector( 9, 9, 0), Vector(11, 9, 0), Vector(13, 9, 0),			// 76
			Vector(15, 9, 0), Vector(17, 9, 0), Vector(19, 9, 0), Vector(21, 9, 0), Vector(23, 9, 0), Vector(25, 9, 0),			// 82
			// Reihe 5, Ebene 2 ---------------------------------------------------------
			Vector( 9, 9, 1), Vector(11, 9, 1), Vector(13, 9, 1), Vector(15, 9, 1), Vector(17, 9, 1), Vector(19, 9, 1),			// 88
			// Reihe 5, Ebene 3 ---------------------------------------------------------
			Vector(11, 9, 2), Vector(13, 9, 2), Vector(15, 9, 2), Vector(17, 9, 2),												// 92
			// Reihe 5, Ebene 4 ---------------------------------------------------------
			Vector(13, 9, 3), Vector(15, 9, 3),																					// 94
			// Zwischen Reihe 4 und Reihe 5 ---------------------------------------------
			Vector(1, 8, 0), Vector(14, 8, 4), Vector(27, 8, 0), Vector(29, 8, 0),												// 97
			// Reihe 6, Ebene 1 ---------------------------------------------------------
			Vector( 5, 11, 0), Vector( 7, 11, 0), Vector( 9, 11, 0), Vector(11, 11, 0), Vector(13, 11, 0),						// 102
			Vector(15, 11, 0), Vector(17, 11, 0), Vector(19, 11, 0), Vector(21, 11, 0), Vector(23, 11, 0),						// 107
			// Reihe 6, Ebene 2 ---------------------------------------------------------
			Vector( 9, 11, 1), Vector(11, 11, 1), Vector(13, 11, 1), Vector(15, 11, 1), Vector(17, 11, 1), Vector(19, 11, 1),	// 113
			// Reihe 6, Ebene 3 ---------------------------------------------------------
			Vector(11, 11, 2), Vector(13, 11, 2), Vector(15, 11, 2), Vector(17, 11, 2),											// 117
			// Reihe 7, Ebene 1 ---------------------------------------------------------
			Vector( 7, 13, 0), Vector( 9, 13, 0), Vector(11, 13, 0), Vector(13, 13, 0), Vector(15, 13, 0), Vector(17, 13, 0),	// 123
			Vector(19, 13, 0), Vector(21, 13, 0),																				// 125
			// Reihe 7, Ebene 2 ---------------------------------------------------------
			Vector( 9, 13, 1), Vector(11, 13, 1), Vector(13, 13, 1), Vector(15, 13, 1), Vector(17, 13, 1), Vector(19, 13, 1),	// 131
			// Reihe 8 ------------------------------------------------------------------
			Vector( 3, 15, 0), Vector( 5, 15, 0), Vector( 7, 15, 0), Vector( 9, 15, 0), Vector(11, 15, 0), Vector(13, 15, 0),	// 137
			Vector(15, 15, 0), Vector(17, 15, 0), Vector(19, 15, 0), Vector(21, 15, 0), Vector(23, 15, 0), Vector(25, 15, 0)	// 143
			
	);
	/////////////////////////////////////////////////////////////////////////////////////
	val TEST_COORD: Array[Vector[Int]] = Array(
			Vector(0, 0, 0), Vector(2, 0, 0), Vector(4, 0, 0),
			Vector(0, 2, 0), Vector(2, 2, 0), Vector(4, 2, 0)
	);
	/////////////////////////////////////////////////////////////////////////////////////
	val MAX_TILES :Int = 144;
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 *  Generiert ein Layout per Zufall
	 *  
	 *  @param lstLayer Referenz auf die Layer
	 *  @param lstTiles Referenz auf die Kacheln
	 *  @param cbTiles Anzahl der Kacheln, falls ungerade wird die Anzahl + 1 genommen
	 *  
	 *  @return Liefert true, falls die Layer erzeugt werden konnten und false, falls
	 *  		das Feld nicht gebaut werden konnte.
	 */
	def Generate(lstLayer: fhMutableWrapper[List[Layer]], lstTiles: fhMutableWrapper[List[Tile]], cbTiles: Int):Boolean=
	{
		if (cbTiles > MAX_TILES)
			return false
			
		
		false
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 *  Laedt Turtle Layout
	 */
	def LoadTurtle(lstLayer: fhMutableWrapper[List[Layer]], lpTiles: fhMutableWrapper[List[Tile]]):Boolean=
	{
	    var iTile      = 0 
		var lpTmp      = CreateTiles() 							// Erzeuge die benoetigten Tiles
		lstLayer.value = InitLayer(5, 15, 8) 					// Erzeuge die Layer
		lpTiles.value  = List() 								// Loesche oder erzeuge die Tile-Liste
		
		// Generiere die Position der Tiles
		for(i <- 0 until TURTLE_COORD.length)
		{
		    var fOK = false
			
		    // Prüfe, ob Tiles des selben Typs nicht 
		    // mehr als doppelt vorkommen, da sonst unloesbar
			while(!fOK)
			{
			    iTile = SelectTile(lpTmp);						// Hol per Zufall eine Kachel aus der Liste
				fOK   = IsDouble(								// Prüft, ob schon doppelt vorhanden ist
					lstLayer.value,								// Den Layer als Referenz zum Prüfen
				    lpTmp(iTile).name, 							// Den Namen des gewählten Tiles
				    TURTLE_COORD(i)								// Die Position des gewählten Tiles
				    )
			}
			
			// Setzt die gewaehlte Kachel ein
			lpTmp(iTile).position 			   = TURTLE_COORD(i);
			lpTiles.value       			 ++= List(lpTmp(iTile));
			lstLayer.value(TURTLE_COORD(i)(2)).setTileIDToPosition(
			    lpTmp(iTile).id,
			    lpTmp(iTile).position(0), 
			    lpTmp(iTile).position(1)
			    )
			//lpTmp.drop(iTile);
			lpTmp -= lpTmp(iTile)
		}
		
		lpTiles.value = lpTiles.value.sortWith(_.id < _.id) 					// Sortiere die Referenzliste
		
		// Nachbarn prüfen
		for (i <- 0 until lstLayer.value(0).height)
		{
			CheckFoes(lpTiles, lstLayer.value, i)
		}
		
		true
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 *  Laedt Turtle Layout
	 */
	def LoadTest(lstLayer: fhMutableWrapper[List[Layer]], lpTiles: fhMutableWrapper[List[Tile]]):Boolean=
	{
	    var iTile      = 0 
		var lpTmp      = CreateTiles() 							// Erzeuge die benoetigten Tiles
		lstLayer.value = InitLayer(5, 15, 8) 					// Erzeuge die Layer
		lpTiles.value  = List() 								// Loesche oder erzeuge die Tile-Liste
		
		// Generiere die Position der Tiles
		for(i <- 0 until TEST_COORD.length)
		{
		    var fOK = false
			
		    // Prüfe, ob Tiles des selben Typs nicht 
		    // mehr als doppelt vorkommen, da sonst unloesbar
			while(!fOK)
			{
			    iTile = SelectTile(lpTmp);						// Hol per Zufall eine Kachel aus der Liste
				fOK   = IsDouble(								// Prüft, ob schon doppelt vorhanden ist
					lstLayer.value,								// Den Layer als Referenz zum Prüfen
				    lpTmp(iTile).name, 							// Den Namen des gewählten Tiles
				    TEST_COORD(i)								// Die Position des gewählten Tiles
				    )
			}
			
			// Setzt die gewaehlte Kachel ein
			lpTmp(iTile).position 			   = TEST_COORD(i);
			lpTiles.value       			 ++= List(lpTmp(iTile))
			lstLayer.value(TEST_COORD(i)(2)).setTileIDToPosition(
			    lpTmp(iTile).id,
			    lpTmp(iTile).position(0), 
			    lpTmp(iTile).position(1)
			    )
			//lpTmp.drop(iTile);
			lpTmp -= lpTmp(iTile)
		}
		
		// Rest auffüllen
		for (i <- 0 until lpTmp.length)
		{
			lpTiles.value ++= List(lpTmp(i))
		}
		
		lpTiles.value = lpTiles.value.sortWith(_.id < _.id) 					// Sortiere die Referenzliste
		CheckFoes(lpTiles, lstLayer.value, 0)
		CheckFoes(lpTiles, lstLayer.value, 2)
		
		true
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 *  Laedt ein Layout aus einer Textdatei
	 */
	def LoadUser(lstLayer: List[Layer]):Boolean=
	{
		false
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 *  Erzeugt alle Kacheln der Laufindex ist hierbei die ID der Kacheln
	 */
	private def CreateTiles():List[Tile] =
	{
	    var lpTiles: List[Tile] = List()
	    
	    for (i <- 1 to MAX_TILES)
	    	lpTiles ++= List(new Tile(TILE_NAMES(i), i, 0, 0, 0))
	    
		return lpTiles
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 *  Initialisiert den Layer
	 *  Die Achsen Abschnitte werden dabei mal zwei genommen.
	 */
	private def InitLayer(cb: Int, iXmax: Int, iYmax: Int):List[Layer]=
	{
		var lpLayer: List[Layer] = List()
		// Initialisiere die Layer
		for (i <- 0 until cb)
			lpLayer ++= List(new Layer(iXmax*2, iYmax*2))
			
	    lpLayer
	}
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Entscheidet welches Tile in einer Position des Layers gesteckt werden soll.
	 */
	private def SelectTile(lpTiles: List[Tile]):Int=
	{
		return Random.nextInt(lpTiles.length)
	}
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Prüft, ob eine ID schon Doppelt vorkommt, so wird verhindert, dass das Spiel
	 * unlösbar wird.
	 */
	/*private*/ def IsDouble(lpLayer: List[Layer], szName: String, pPos: Vector[Int]):Boolean =
	{
		var cb = 0			// Zaehlvariabel
		
	    // Test noetig?
		if (lpLayer.length < 4 || pPos(2) < 3)	 // bei maximal 3 Ebenen muss nicht getestet werden 
		  return true
		
		// Prüfe an der Position x/y den z Vektor durch
		for (i <- 0 to pPos(2))
		{
			var iID   = lpLayer(i).getIDFromPosition(pPos(0), pPos(1))
			var szTmp = "   "
			  
			if (iID > 0)
				szTmp = TILE_NAMES(iID - 1)
				
			if(szTmp(1) + szTmp(2) == szName(1) + szName(2))
			  cb += 1
		}
		
		if (cb > 2)
			false
		else
			true
	}
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Suche nach sperrenden Kacheln.
	 * @Param: lpTiles Die Liste mit den referenzierten Kacheln.
	 * @Param: lpLayer Die Liste mit den Layern.
	 * @Param: iRow    Die Zeile die aktuell untersucht wird.
	 */
	private def CheckFoes(lpTiles: fhMutableWrapper[List[Tile]], lpLayer: List[Layer], iRow: Int)=
	{
		// Hoehe 
		for (z <- 0 until lpLayer.length; x <- 0 until lpLayer(z).width)
		{
		    var iID = lpLayer(z).getIDFromPosition(x, iRow) - 1
		    // besetzt?
			if (iID >= 0)
			{
				// befindet sich noch eine Kachel darueber?
				if (lpLayer.length > z+1)
					CheckUpperFoes(lpTiles, lpLayer, iRow, iID, z, x)
			    
			    CheckNeighborFoes(lpTiles, lpLayer, iRow, iID, z, x)
					
			}
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	private def CheckUpperFoes(lpTiles: fhMutableWrapper[List[Tile]], lpLayer: List[Layer], iRow: Int, iID: Int, z: Int, x: Int)=
	{
		//var iUpperID = 0
		
		// Direkt darüber
		if (lpLayer.length > z+1 && lpLayer(z+1).getIDFromPosition(x, iRow) > 0)
	    {
	    	// Merke den Darueberliegenden
	        lpTiles.value(iID).pushUpper(lpLayer(z+1).getIDFromPosition(x, iRow))
	    }
	    // Um einen Punkt versetzt
	    else if (lpLayer(z+1).getIDFromPosition(x+1, iRow) > 0)
	    {
	    	lpTiles.value(iID).pushUpper(lpLayer(z+1).getIDFromPosition(x+1, iRow))
	    }
		// x - 1 : iRow
    	else if (lpLayer(z+1).getIDFromPosition(x-1, iRow) > 0)
    	{
    		lpTiles.value(iID).pushUpper(lpLayer(z+1).getIDFromPosition(x-1, iRow))
    	}
    	else
    	{
    		if (lpLayer(z+1).getIDFromPosition(x+1, iRow+1) > 0)
    		  lpTiles.value(iID).pushUpper(lpLayer(z+1).getIDFromPosition(x+1, iRow+1))
    		if (lpLayer(z+1).getIDFromPosition(x-1, iRow+1) > 0)
    		  lpTiles.value(iID).pushUpper(lpLayer(z+1).getIDFromPosition(x-1, iRow+1))
    		if (lpLayer(z+1).getIDFromPosition(x+1, iRow-1) > 0)
    		  lpTiles.value(iID).pushUpper(lpLayer(z+1).getIDFromPosition(x+1, iRow-1))
    		if (lpLayer(z+1).getIDFromPosition(x-1, iRow-1) > 0)
    		  lpTiles.value(iID).pushUpper(lpLayer(z+1).getIDFromPosition(x-1, iRow-1))
    	}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	private def CheckNeighborFoes(lpTiles: fhMutableWrapper[List[Tile]], lpLayer: List[Layer], iRow: Int, iID: Int, z: Int, x: Int)=
	{
		// kein Nachbar rechts ----------------------------------------------
	    if (lpLayer(z).getIDFromPosition(x+2, iRow) <= 0)
	    {
	    	// Schraeg rechts oben?
	    	if (lpLayer(z).getIDFromPosition(x+2, iRow-1) > 0)
	    	{
	    		lpTiles.value(iID).pushNeighbor(
	    				lpLayer(z).getIDFromPosition(x+2, iRow-1))
	    		
	    		// sich selbst als linken Nachbarn eintragen
	    		lpTiles.value(lpLayer(z).getIDFromPosition(x+2, iRow-1) - 1).pushNeighbor(iID+1)
	    	}
	    	// Schraeg rechts unten?
		    if (lpLayer(z).getIDFromPosition(x+2, iRow+1) > 0)
		    {
		    	lpTiles.value(iID).pushNeighbor(
	    				lpLayer(z).getIDFromPosition(x+2, iRow+1))
		    	
		    	// sich selbst als linken Nachbarn eintragen
	    		lpTiles.value(lpLayer(z).getIDFromPosition(x+2, iRow+1) - 1).pushNeighbor(iID+1)
		    }
	    }
	    // Nachbar rechts ---------------------------------------------------
	    else
	    if (lpLayer(z).getIDFromPosition(x+2, iRow) > 0)	{
	      // Merke dir den rechten Nachbarn
	      lpTiles.value(iID).pushNeighbor(
	          lpLayer(z).getIDFromPosition(x+2, iRow))
	      
	      // sich selbst als linken Nachbarn eintragen
	      lpTiles.value(lpLayer(z).getIDFromPosition(x+2, iRow)-1).pushNeighbor(iID+1)
	    } // Out Nachbar rechts
	  
	  
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
}
