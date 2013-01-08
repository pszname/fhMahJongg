package de.fhk.mps.fhMahJongg

/*
 * TODO: scaladoc erzeugen --> download und in cmd ausfuehren	--> in cmd C:\Users\hendrik\scala-SDK-2.1-M2-2.9-win32.win32.x86\eclipse\scala-2.10.0\bin>s
 * caladoc.bat C:\Users\hendrik\git\fhMahJongg\src\de\fhk\mps\fhMahJongg\*.scala -e
 * ncoding Cp1252 aufuehren. Doku ist dann in C:\Users\hendrik\scala-SDK-2.1-M2-2.9-win32.win32.x86\eclipse\scala-2.10.0\bin>s
 * caladoc.bat C:\Users\hendrik\git\fhMahJongg\src\de\fhk\mps\fhMahJongg\*.scala -e
 * ncoding Cp1252 
 * Doku ist dann in C:\Users\hendrik\scala-SDK-2.1-M2-2.9-win32.win32.x86\eclipse\scala-2.10.0\bin\index.html
 * den Befehl fuer alle source-files (*.scala) ausfuehren. Zeilen, die Fehler erzeugen ggf. auskommentieren.
 */

/**
 * This class generates a new tile. A tile is a single element
 * of the mahjongg game. It provides different methods and properties
 * to manage its state and position.
 */
class Tile(sName: String, iID: Int, X: Int, Y: Int, Z: Int) {
  
  var checked: Boolean = false
  var blocked: Boolean = false
  var id:      Int 	   = iID
  var name:    String  = sName
  var position		   = Vector(X, Y, Z)
  var UpperTile        = List[Int]()
  var LeftNeighborTile	   = List[Int]()
  var RightNeighborTile	   = List[Int]()
  
  /**
   * Equals two tiles.
   * 
   * @param another tile
   * @return <code>true</code>, if the tiles are from the same type/name, otherwise <code>false</code>
   */
  def ==(otherTile: Tile): Boolean = {
    return sName.endsWith(otherTile.name.substring(1))    
  }

  /**
   * With this method, it is possible to set an other tile by id as blocking neighbor.
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
   * This method deletes a neighbor tile from the blocking neighbors list.
   * If the list gets empty, the tile becomes unblocked.
   * 
   * @param id of the neighbor tile
   * */
  def popUpper(id: Int)	{
    UpperTile -= id
    if (UpperTile.length == 0 && (LeftNeighborTile.length == 0 || RightNeighborTile.length == 0)) blocked = false
  }
  
   /**
    * This method adds a neighbor tile.
    * 
    * @param id of the neighbor tile 
    */
  def pushLeftNeighbor(id: Int)	{
    if (id != this.id) LeftNeighborTile ++= List(id)
    if (LeftNeighborTile.length > 0 && RightNeighborTile.length > 0) blocked = true
  }
  
     /**
    * This method adds a neighbor tile.
    * 
    * @param id of the neighbor tile 
    */
  def pushRightNeighbor(id: Int)	{
    if (id != this.id) RightNeighborTile ++= List(id)
    if (LeftNeighborTile.length > 0 && RightNeighborTile.length > 0) blocked = true
  }
  
  /**
    * This method removes a neighbor tile.
    * 
    * @param id of the neighbor tile 
    */
  def popNeighbor(id: Int)	{
    if (id != this.id)	{
      LeftNeighborTile -= id
      RightNeighborTile -= id
    }
    if (UpperTile.length == 0 && (LeftNeighborTile.length == 0 || RightNeighborTile.length == 0)) blocked = false
  }
	
  /**
   * With this method, the tile gets checked or unchecked depending on its state,
   * if the tile is not blocked.
   * 
   * @return <code>true</code>, if the tile was checked or unchecked. <code>false</code>, if the tile is blocked
   */
  def check: Boolean =	{
    if (blocked == false) checked = !checked
    return !blocked
  }
} 

