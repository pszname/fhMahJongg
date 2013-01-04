package de.fhk.mps.fhMahJongg

import Array._

/*
 * Bildet eine Matrix.
 */
class Layer(private var m_iXmax: Int, private var m_iYmax: Int) {
  
	private var Matrix = ofDim[Int](m_iXmax, m_iYmax)
  
	// Properties =======================================================================
	//def X_Coord = m_iXmax
	//def X_Coord_= (iNewX: Int) = m_iXmax = iNewX
	
	//def Y_Coord = m_iYmax
	//def Y_Coord_= (iNewY: Int) = m_iYmax = iNewY
	
	// Defs =============================================================================
	
	//returns TRUE, if position is available, else FALSE
	def setTileIDToPosition(id: Int, x: Int, y: Int): Boolean	= {
	  if (Matrix(x)(y) == 0)	{	
	    Matrix(x)(y) = id
	    return true
	  }
	  else	return false
	}
	
	def deleteTileIDFromPosition(x: Int, y: Int) { Matrix(x)(y) = 0 }
			
	def getIDFromPosition(x: Int, y: Int): Int = Matrix(x)(y)
	
	def getPositionFromID(id: Int): Vector[Int] =	{
	  for (i <- 0 until m_iXmax; j <- 0 until m_iYmax)	{
	    if (Matrix(i)(j) == id) return Vector(i, j)
	  }
	  return Vector(0, 0)
	}
	
	def getField: Array[Array[Int]] = Matrix
}