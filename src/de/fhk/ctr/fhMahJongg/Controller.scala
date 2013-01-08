package de.fhk.ctr.fhMahJongg

import de.fhk.mps.fhMahJongg._

/**
 * this class is a static controller, that provides tools to control the game. It is the interface
 * between the view and the layout
 */
object Controller {
  
  var layout = new fhLayout
  
  /**
   * This method generates a virtual game board for the game play.
   * 
   * @param layout-type as integer referring to fhLayoutType
   */
  def generateGameBoard(iType: Int): Boolean = layout.CreateLayout(iType)  
  
  /**
   * This method provides a layer that contains all supreme tiles by id.
   * 
   * @return <code>Array[Array[Int]]</code>
   */
  def generateTopLayer: Array[Array[Int]] = layout.topTiles
  
    /**
   * This method provides a layer that contains all supreme tiles by name.
   * 
   * @return <code>Array[Array[String]]</code>
   */
  def generateTopLayerWithNames: Array[Array[String]] = layout.topTilesWithNames
  
  /**
   * This method provides an interface for checking tiles.
   * 
   * @param id of the tile, that should be checked
   * @return <code>Vector(0)</code>, if the tile was not checked or the tile is already checked; The position of the last checked tile, if the last checked tile and the new checked tile are not of the same type; The positions of the  last checked tile and the new checked tile, if they are of the same type, so they will be deleted 
   */
  def checkTile(id: Int): Vector[Int] =	layout.checkTile(id)
    
  /**
   * This method provides an interface for checking tiles.
   * 
   * @param x-intercept and y-intercept of a position, that should be checked
   * @return <code>Vector(0)</code>, if the tile was not checked or the tile is already checked; The position of the last checked tile, if the last checked tile and the new checked tile are not of the same type; The positions of the  last checked tile and the new checked tile, if they are of the same type, so they will be deleted 
   */
  def checkTile(x: Int, y: Int): Vector[Int] = layout.checkTile(x, y)
  
  /**
   * This method returns a specified tile by id.
   * 
   * @param id
   * @return <code>Tile</code> with specified id
   */
  def getTile(id: Int): Tile = (if (id > 0) layout.tiles(id-1) else null)
  
  /**
   * This method returns the tile count.
   * 
   * @return the tile count
   */
  def getTileCount() = layout.getTileCount
}  