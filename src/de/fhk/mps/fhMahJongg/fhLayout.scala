package de.fhk.mps.fhMahJongg

import fhLayoutType._

/////////////////////////////////////////////////////////////////////////////////////////
/**
 *  Diese Klasse definiert, erzeugt und Lädt ein Layout für ein Spiel
 */
class fhLayout 
{ 
	// Properties =======================================================================
  
	def Layer = m_lpLayer;											/* Gibt die Layer Zurueck */
	def tiles = m_lpTiles
	def lastCheckedTileID = m_iLastCheckedTileID
  
	// Defs ============================================================================= 

	private var m_iLastCheckedTileID: Int = 0	
	private var m_lpLayer: List[Layer] = List();					/* Hier werden die Layer gespeichert */
	private var m_lpTiles: List[Tile]  = List();					/* Hier werden die Referenzen auf die Kacheln gespeichert */
		
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 *  Erzeugt ein neues Layout
	 */
	def CreateLayout(eType: fhLayoutType):Boolean=
	{
		var fRet = false;
	  
		// Entscheide wie das Feld erzeugt wird
		eType match
		{
		  // Erzeuge ein generiertes Feld -----------------------------------------------
		  case fhLayoutType.LT_GENERATE =>
		  {
		    fRet = fhGenerator.Generate(this.m_lpLayer);
		  }
		  // Erzeuge eine Pyramide/Schildkroete -----------------------------------------
		  case fhLayoutType.LT_TURTLE   =>
		  {
		    var pMut1 = fhMutableWrapper(this.m_lpLayer);
		    var pMut2 = fhMutableWrapper(this.m_lpTiles);
		    fRet      = fhGenerator.LoadTurtle(pMut1, pMut2);
		    
		    m_lpLayer = pMut1.value;
		    m_lpTiles = pMut2.value;
		  }
		  // Lade ein Nutzerdefiniertes Feld --------------------------------------------
		  case fhLayoutType.LT_USER		=>
		  {
			fRet = fhGenerator.LoadUser(this.m_lpLayer);
		  }
		}
		
		return fRet;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 *  Selektiert ein Tile an Position x, y. Ruft den Index der Ebene ab.
	 *  Es wird < 0 zurückgegeben, falls nichts ausgewählt wurde bzw. es nicht möglich
	 *  ist etwas auszuwählen.
	 */
	def SelectPos(iXPos: Int):Int=
	{
		return -1;
	}
	/////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * this method deletes a tile from a layer and unlocks neighbor tiles
	 * 
	 * @param TileID
	 * @return position of the deleted tile as <code>Vector[Int]</code>
	 */
	def deleteTile(id: Int): Vector[Int] = {
	  
	  var tile: Tile = m_lpTiles(id)
	  
	  var x: Int = tile.position(0)
	  var y: Int = tile.position(1)
	  var z: Int = tile.position(2)
	  
	  var layer: Layer = m_lpLayer(z)
	  
	  for(i <- 0 until tile.NeighborTile.length )	{
	    m_lpTiles(tile.NeighborTile(i)).popNeighbor(id)
	    m_lpTiles(tile.NeighborTile(i)).popUpper(id)
	  }
	  
	  m_lpTiles = m_lpTiles.updated(id, new Tile("dummy", 0, x, y, z))
	  
	  layer.deleteTileIDFromPosition(x, y)
	  
	  Vector(x,y,z)
	}
}