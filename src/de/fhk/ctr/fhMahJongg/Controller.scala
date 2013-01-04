package de.fhk.ctr.fhMahJongg

import de.fhk.mps.fhMahJongg._

/**
 * this class is a static controller, that provides tools to control the game. It is the interface
 * between the view and the layout
 */
object Controller {
  
  def generateGameBoard(iLayerCount: Int, iWidth: Int, iHeight: Int)	{
      var layout = new fhLayout(iLayerCount, iWidth, iHeight)
  }
  
  def checkTile(id: Int): Int =	{
    
    if (layout.tiles(id).check == false) return -1 else if (layout.m_lpTiles(id))	
    
    return 0
  }
}
