package de.fhk.mps.fhMahJongg
/*
 * Bildet eine Matrix.
 */
class Layer(private var m_iXmax: Int, private var m_iYmax: Int) 
{
	// Properties =======================================================================
	def X_Coord = m_iXmax
	def X_Coord_= (iNewX: Int) = m_iXmax = iNewX
	
	def Y_Coord = m_iYmax
	def Y_Coord_= (iNewY: Int) = m_iYmax = iNewY
	
	// Defs =============================================================================
	
}