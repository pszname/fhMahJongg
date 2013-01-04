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
  
	// Defs ============================================================================= 

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
		    fRet = fhGenerator.LoadTurtle(fhMutableWrapper(this.m_lpLayer), 
		    						      fhMutableWrapper(this.m_lpTiles)
		    						      );
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
	 *  Selektiert ein Tile anhand der ID ab
	 */
	def SelectTile(iID: Int):Boolean=
	{
		return false;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 *  Selektiert ein Tile anhand seines Namens ab
	 */
	def SelectTile(szName: String):Boolean=
	{
		return false;
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
}