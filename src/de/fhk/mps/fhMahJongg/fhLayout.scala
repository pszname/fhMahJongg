package de.fhk.mps.fhMahJongg

class fhLayout(cbLayer: Int, private var m_iXmax: Int, private var m_iYmax: Int) {
  
	// Properties =======================================================================
  
	def Layer = m_lpLayer;											/* Gibt die Layer Zurueck */
	
	def X_Max = m_iXmax;											/* Gibt das Ausmaﬂ von X zurueck */
	def Y_Max = m_iYmax;											/* Gibt das Ausmaﬂ von Y zurueck */
  
	// Defs ============================================================================= 

	private var m_lpLayer: List[Layer] = InitLayer(cbLayer);		/* Hier werden die Layer gespeichert */
	
	// Constructor ======================================================================
	
	
	// Methods ==========================================================================
	/*
	 * Initialisiert den Layer
	 */
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
	
}