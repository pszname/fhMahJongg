package de.fhk.ctr.fhMahJongg

import de.fhk.mps.fhMahJongg._

/**
 * this class is a static controller, that provides tools to control the game. It is the interface
 * between the view and the layout
 */
object Controller {
  
  var layout = new fhLayout		//muss eigentlich private sein, nur zum testen public
  
  def generateGameBoard(iType: Int)	{
      
      layout.CreateLayout(iType)
  }
  
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
}
