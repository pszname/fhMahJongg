package de.fhk.mps.fhMahJongg

import fhLayoutType._

/////////////////////////////////////////////////////////////////////////////////////////
//
// Diese Klasse definiert, erzeugt und Lädt ein Layout für ein Spiel
class fhLayout(cbLayer: Int, private var m_iXmax: Int, private var m_iYmax: Int) 
{ 
	// Properties =======================================================================
  
	def Layer = m_lpLayer;											/* Gibt die Layer Zurueck */
	
	def X_Max = m_iXmax;											/* Gibt das Ausmaß von X zurueck */
	def Y_Max = m_iYmax;											/* Gibt das Ausmaß von Y zurueck */
  
	// Defs ============================================================================= 

	private var m_lpLayer: List[Layer] = InitLayer(cbLayer);		/* Hier werden die Layer gespeichert */
	
	// Methods ==========================================================================
	// Initialisiert den Layer
	private def InitLayer(cb: Int):List[Layer]=
	{
		var lpLayer: List[Layer] = List();
		// Initialisiere die Layer
			for (i <- 0 until cb)
			{
				lpLayer ++= List(new Layer(m_iXmax, m_iYmax));
			}
			
			return lpLayer;
	}
	
	// ==================================================================================
	// Erzeugt ein neues Layout
	def CreateLayout(eType: fhLayoutType):Boolean=
	{
		return true;
	}
	
	// ==================================================================================
	// Selektiert ein Tile anhand der ID ab
	def SelectTile(iID: Int):Boolean=
	{
		return false;
	}
	
	// ==================================================================================
	// Selektiert ein Tile anhand seines Namens ab
	def SelectTile(szName: String):Boolean=
	{
		return false;
	}
	
	// ==================================================================================
	// Selektiert ein Tile an Position x, y. Ruft den Index der Ebene ab.
	// Es wird < 0 zurückgegeben, falls nichts ausgewählt wurde bzw. es nicht möglich
	// ist etwas auszuwählen.
	def SelectPos(iXPos: Int, iYPos: Int):Int=
	{
		return -1;
	}
}