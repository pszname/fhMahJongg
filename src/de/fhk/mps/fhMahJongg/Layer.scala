package de.fhk.mps.fhMahJongg

import Array._

/**
 * This class generates a new layer, that provides positions for a number of tiles
 * in addition to the layers size.
 * 
 * @param width and height of the field
 */
class Layer(var width: Int, var height: Int) {
  
	/**
	 * This is the matrix, that represents the field of the layer.
	 */
	private var Matrix = ofDim[Int](width, height)
  
	/**
	 * Sets a tile id to a certain position.
	 * 
	 * @param a unique ID and the position as x-intercept and y-intercept
	 * @return <code>true</code>, if the position is available and set, otherwise <code>false</code>
	 */
	def setTileIDToPosition(id: Int, x: Int, y: Int): Boolean	= {
	  if (Matrix(x)(y) == 0)	{	
	    Matrix(x)(y) = id
	    true
	  }
	  else false
	}
	
	/**
	 * Deletes a TileID from xy-position.
	 * 
	 * @param x-intercept, y-intercept
	 * @return new content of the position. 0, if faultless
	 */
	def deleteTileIDFromPosition(x: Int, y: Int): Int =	{
	  Matrix(x)(y) = 0
	  Matrix(x)(y)
	  }
		
	/**
	 * Returns a TileID from xy-position.
	 * 
	 * @param x-intercept, y-intercept
	 * @return TileID as <code>Int</code>
	 */
	def getIDFromPosition(x: Int, y: Int): Int = Matrix(x)(y)
	
	/**
	 * Returns the xy-position in addition to a TileID.
	 * 
	 * @param TileID
	 * @return xy-position as <code>Vector(Int, Int)</code>
	 */
	def getPositionFromID(id: Int): Vector[Int] =	{
	  for (i <- 0 until width; j <- 0 until height)	{
	    if (Matrix(i)(j) == id) return Vector(i, j)
	  }
	  Vector(0, 0)
	}
	
	/*/**
	 * Returns the the whole layer as field.
	 * 
	 * @return layer as <code>Array[Array[Int]]</code>
	 */
	def getField: Array[Array[Int]] = Matrix*/
}