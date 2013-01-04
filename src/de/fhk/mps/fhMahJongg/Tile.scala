package de.fhk.mps.fhMahJongg

/**
 * this class generates a new tile. A tile is a single element
 * of the mahjongg game. It provides different methods and properties
 * to manage its state and position
 * 
 * @param a tile requires a name, an unique id and an xy-position on a layer Z
 */
class Tile(sName: String, iID: Int, X: Int, Y: Int, Z: Int) {
  
  var checked: Boolean = false
  var blocked: Boolean = false
  var id:      Int 	   = iID
  var name:    String  = sName
  var position         = Vector(X, Y, Z)		//muss die Position hier rein oder reicht es, dies über ein Grid zuzuordnen?
  var UpperTile        = List[Int]()
  
   

  /**
   * with this method, it is possible to set an other tile by id as blocking neighbor.
   * This could be upper tiles or tiles beside. If a neighbor is pushed, the tile becomes blocked.
   * 
   * @param id of the neighbor tile 
   */
  def pushUpper(id: Int)	{
    if (id != this.id)	
    {
     UpperTile ++= List(id)
     blocked = true
    }
  }
  
  /**
   * this method deletes a neighbor tile from the blocking neighbors list.
   * If the list gets empty, the tile becomes unblocked.
   * @param id of the neighbor tile
   * */
  def popUpper(id: Int)	{
    UpperTile -= id
    if (UpperTile.length == 0) blocked = false
  }
	
  /**
   * with this method, the tile gets checked or unchecked in addition to its state,
   * if the tile is not blocked.
   * 
   * @return <code>true</code>, if the tile was checked or unchecked. <code>false>/code>, if the tile is blocked
  e*/
  def check: Boolean =	{
    if (blocked == false) checked = !checked
    return !blocked
  }
} 

