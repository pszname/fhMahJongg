package de.fhk.mps.fhMahJongg

class Tile(sName: String, iID: Int, X: Int, Y: Int, Z: Int) {
  
  var checked: Boolean = false
  var blocked: Boolean = false
  var id: Int = iID
  var name: String = sName
  var position = Vector(X, Y, Z)		//muss die Position hier rein oder reicht es, dies über ein Grid zuzuordnen?
  var UpperTile = List[Int]()
  
  /**Für den Fall, dass die Kacheln nicht 1:1 übereinanderliegen sollen, sondern eine Kachel mehrere Andere
  abdeckt, können hiermit mehrere Kacheln hinzugefügt werden, die einer Kachel übergeordnet sind*/
  def pushUpper(id: Int)	{
    if (id != this.id)	{
     UpperTile ++= List(id)
     blocked = true
    }
  }
  
  /**hiermit wird eine übergeordnete Kachel als Blockierende einer untergeordneten Kachel entfernt*/
  def popUpper(id: Int)	{
    UpperTile -= id
    if (UpperTile.length == 0) blocked = false
  }
	
  /**hiermit kann eine Kachel angewählt werden. Ist das Anwählen nicht möglich, wird false zurückgegeben, 
  andernfalls true*/
  def check: Boolean =	{
    if (blocked == false) checked = !checked
    return !blocked
  }
} 

