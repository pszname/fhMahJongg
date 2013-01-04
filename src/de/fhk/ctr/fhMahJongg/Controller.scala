package de.fhk.ctr.fhMahJongg

import de.fhk.mps.fhMahJongg._

/**
 * this class is a static controller, that provides tools to control the game. It is the interface
 * between the view and the layout
 */
object Controller {
  
  var layout = new fhLayout
  
  def generateGameBoard(eType: fhLayoutType.fhLayoutType)	{
      
      layout.CreateLayout(eType)
  }
  
  def checkTile(id: Int): Int =	{
    
    if (layout.tiles(id).check == false) return -1 
//    else if (layout.tiles(id) == layout.tiles(layout.lastCheckedTileID))
    
    
    
    return 0
  }
}
