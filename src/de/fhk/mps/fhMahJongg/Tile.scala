package de.fhk.mps.fhMahJongg

class Tile(sName: String, iID: Int, X: Int, Y: Int, Z: Int) {
  
  var checked: Boolean = false
  var blocked: Boolean = false
  var id: Int = iID
  var name: String = sName
  var position = Vector(X, Y, Z)		//muss die Position hier rein oder reicht es, dies �ber ein Grid zuzuordnen?
  var UpperTile = List[Int]()
  
  /**F�r den Fall, dass die Kacheln nicht 1:1 �bereinanderliegen sollen, sondern eine Kachel mehrere Andere
  abdeckt, k�nnen hiermit mehrere Kacheln hinzugef�gt werden, die einer Kachel �bergeordnet sind*/
  def pushUpper(id: Int)	{
    if (id != this.id)	{
     UpperTile ++= List(id)
     blocked = true
    }
  }
  
  /**hiermit wird eine �bergeordnete Kachel als Blockierende einer untergeordneten Kachel entfernt*/
  def popUpper(id: Int)	{
    UpperTile -= id
    if (UpperTile.length == 0) blocked = false
  }
	
  /**hiermit kann eine Kachel angew�hlt werden. Ist das Anw�hlen nicht m�glich, wird false zur�ckgegeben, 
  andernfalls true*/
  def check: Boolean =	{
    if (blocked == false) checked = !checked
    return !blocked
  }
} 

