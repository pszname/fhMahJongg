package de.fhk.mps.fhMahJongg

import Array._

/**
 * this class generates a new layer, that provides positions for a number of tiles
 * in addition to the layers size.
 * 
 * @param width and height of the field
 */
class Layer(var width: Int, var height: Int) {
  
	/**
	 * this is the matrix, that represents the field
	 */
	private var Matrix = ofDim[Int](width, height)
  
	/**
	 * sets a tile id to a certain position
	 * 
	 * @param a unique ID and the position as x-intercept and y-intercept
	 * @return <code>true</code>, if the position is available and set, otherwise <code>false</code>
	 */
	def setTileIDToPosition(id: Int, x: Int, y: Int): Boolean	= {
	  if (Matrix(x)(y) == 0)	{	
	    Matrix(x)(y) = id
	    return true
	  }
	  else	return false
	}
	
	/**
	 * deletes a TileID from xy-position
	 * 
	 * @param x-intercept, y-intercept
	 */
	def deleteTileIDFromPosition(x: Int, y: Int) { Matrix(x)(y) = 0 }
		
	/**
	 * returns a TileID from xy-position
	 * 
	 * @param x-intercept, y-intercept
	 * @return TileID as <code>Int</code>
	 */
	def getIDFromPosition(x: Int, y: Int): Int = Matrix(x)(y)
	
	/**
	 * returns the xy-position in addition to a TileID
	 * 
	 * @param TileID
	 * @return xy-position as <code>Vector(Int, Int)</code>
	 */
	def getPositionFromID(id: Int): Vector[Int] =	{
	  for (i <- 0 until width; j <- 0 until height)	{
	    if (Matrix(i)(j) == id) return Vector(i, j)
	  }
	  return Vector(0, 0)
	}
	
	/**
	 * returns the the whole layer as field
	 * 
	 * @return layer as <code>Array[Array[Int]]</code>
	 */
	def getField: Array[Array[Int]] = Matrix
}