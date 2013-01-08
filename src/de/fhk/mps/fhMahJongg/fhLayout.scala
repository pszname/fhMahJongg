package de.fhk.mps.fhMahJongg

import fhLayoutType._
import Array._
import de.fhk.ctr.fhMahJongg._

/**
 * This class provides a new layout. A layout contains multiple layers, that provides the position
 * of each tile. Further it contains a list off all tiles.
 * In addition the layout has methods for checking and deleting tiles.
 */
class fhLayout 
{   
	def Layer = m_lpLayer											/* Gibt die Layer Zurueck */
	def tiles = m_lpTiles
	private def lastCheckedTileID = m_iLastCheckedTileID
  
	// Defs ============================================================================= 

	private var m_iLastCheckedTileID: Int = 0	
	private var m_lpLayer: List[Layer] = List()					/* Hier werden die Layer gespeichert */
	private var m_lpTiles: List[Tile]  = List()					/* Hier werden die Referenzen auf die Kacheln gespeichert */
	
	/**
	 * Creates a new layout.
	 * 
	 * @param layout-type as integer referring to the fhLayoutType enumeration
	 * @return <code>true</code>, if layout was created faultless
	 */
	def CreateLayout(iType: Int):Boolean=
	{
		var fRet = false
	  
		fhLayoutType(iType) match		{		 
		  	case fhLayoutType.LT_GENERATE =>		  {
				var pMut1 = fhMutableWrapper(this.m_lpLayer)
				var pMut2 = fhMutableWrapper(this.m_lpTiles)
		    
				fRet 	  = fhGenerator.Generate(pMut1, pMut2, fhGenerator.MAX_TILES)
		    
				m_lpLayer = pMut1.value
				m_lpTiles = pMut2.value
			}
		  	case fhLayoutType.LT_TURTLE   =>		  {
		  		var pMut1 = fhMutableWrapper(this.m_lpLayer)
		  		var pMut2 = fhMutableWrapper(this.m_lpTiles)
		  		
		  		fRet      = fhGenerator.LoadTurtle(pMut1, pMut2)
		    
		  		m_lpLayer = pMut1.value
		  		m_lpTiles = pMut2.value
		  	}
		  	case fhLayoutType.LT_USER		=>		  {
			fRet = fhGenerator.LoadUser(this.m_lpLayer)
		  	}
		}
		fRet
	}
		
	/**
	 * This method deletes a tile from a layer and unlocks neighbor tiles.
	 * 
	 * @param TileID
	 * @return position of the deleted tile as <code>Vector[Int]</code>
	 */
	def deleteTile(id: Int): Vector[Int] = {
	  
	  var tile: Tile = tiles(id-1)
	  
	  var x: Int = tile.position(0)
	  var y: Int = tile.position(1)
	  var z: Int = tile.position(2)
	  
	  var layer: Layer = m_lpLayer(z)
	  
	  for(i <- 0 until tile.NeighborTile.length ) if (tile.NeighborTile(i) > 0)	tiles(tile.NeighborTile(i)-1).popNeighbor(id)
	  
	  if (z > 0)	{
	    for (i <- -1 to 1 by 1; j <- -1 to 1 by 1) if (x+i >= 0 && x+i < Layer(z).width && y+j >= 0 && y+j < Layer(z).height &&
	        Layer(z-1).getIDFromPosition(x+i, y+j) > 0)	tiles(Layer(z-1).getIDFromPosition(x+i, y+j)-1).popUpper(id)
	  }
	  
	  if (layer.deleteTileIDFromPosition(x, y) != 0) Vector(0, 0, 0) else Vector(x+1,y+1,z+1)
	}
		
	/**
	 * This method provides checking tiles by id.
	 * 
	 * @param id of the tile, that should be checked
	 * @return <code>Vector(0)</code>, if the tile was not checked or the tile is already checked; The position of the last checked tile, if the last checked tile and the new checked tile are not of the same type; The positions of the  last checked tile and the new checked tile, if they are of the same type, so they will be deleted 
	 */
	def checkTile(id: Int): Vector[Int] =	{    
		if (id == lastCheckedTileID || id == 0) Vector(0) 
		else if (tiles(id-1).check == false) Vector(0) 
		else if (lastCheckedTileID > 0 && tiles(id-1) == tiles(lastCheckedTileID-1) && tiles(id-1).checked && tiles(lastCheckedTileID-1).checked)
			deleteTile(id) ++ deleteTile(lastCheckedTileID)                
		else	{
		  var oldlastCheckedTileID = lastCheckedTileID
		  m_iLastCheckedTileID = id
		  if (oldlastCheckedTileID > 0)	{
		    tiles(oldlastCheckedTileID-1).check
		    tiles(oldlastCheckedTileID-1).position
		  }
		  else Vector(0, 0, 0)
		}
	}
	
	/**
	 * This method provides checking tiles by position.
	 * 
	 * @param x-intercept and y-intercept of a position, that should be checked
	 * @return <code>Vector(0)</code>, if the tile was not checked or the tile is already checked; The position of the last checked tile, if the last checked tile and the new checked tile are not of the same type; The positions of the  last checked tile and the new checked tile, if they are of the same type, so they will be deleted 
	 */
	def checkTile(x: Int, y: Int): Vector[Int] = checkTile(topTile(x, y))
	
	/**
	 * This method returns a field that contains all tiles on top by id.
	 * 
	 * @return <code>Array[Array[Int]]</code>
	 */
	def topTiles: Array[Array[Int]] = {
	  var layer = new Layer(Layer(0).width, Layer(0).height)
	  for (i <- 0 until layer.width; j <- 0 until layer.height)	{
	    layer.setTileIDToPosition(topTile(i, j), i, j)
	  }
	  layer.getField
	}
	
	/**
	 * This method returns a field that contains all tiles on top by name.
	 * 
	 * @return <code>Array[Array[Int]]</code>
	 */
	def topTilesWithNames: Array[Array[String]] = {
	  var layer = ofDim[String](Layer(0).width, Layer(0).height)
	  var tT = topTiles
	  for (i <- 0 until Layer(0).width; j <- 0 until Layer(0).height) if (tT(i)(j) > 0) layer(i)(j) = tiles(tT(i)(j)-1).name else layer(i)(j) = "   "
	  layer
	}
	
	/**
	 * This method returns the supreme tile on a position.
	 * 
	 * @param xy-position
	 * @return tileID of the supreme tile. If there is no tile on the position, it provides 0
	 */
	def topTile(x: Int, y: Int): Int = {
	  var i = Layer.length - 1
	  while (i >= 0 && Layer(i).getIDFromPosition(x, y) == 0)	i -= 1
	  if (i < 0) 0 else Layer(i).getIDFromPosition(x, y)
	}
	
	/**
	 * This method returns the supreme tile on a position.
	 * 
	 * @param xyz-position
	 * @return tileID of the supreme tile. If there is no tile on the position, it provides 0
	 */
	def topTile(x: Int, y: Int, z: Int): Int = {
	  var i = z
	  while (Layer(i).getIDFromPosition(x, y) == 0 && i >= 0)	i -= 1
	  if (i < 0) 0 else Layer(i).getIDFromPosition(x, y)
	}
	
	/**
	 * This method returns the count of tiles in the layout.
	 * 
	 * @return count as integer
	 */
	def getTileCount() = m_lpTiles.length
	
	/**
	 * This method returns all Tiles with their names
	 * @return The Field with the tile names
	 */
	def getAllTiles(): Array[fhTileVec]=
	{
		var lpRet: Array[fhTileVec] = Array()
		
		for (i <- 0 until m_lpTiles.length)
		{
			lpRet ++= Array(new fhTileVec(m_lpTiles(i).position, m_lpTiles(i).name))
		}
		
		lpRet
	}
}
