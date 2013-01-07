package de.fhk.tui.fhMahJongg

import de.fhk.ctr.fhMahJongg._

/////////////////////////////////////////////////////////////////////////////////////////
/**
 * TUI
 */
class fhTui 
{
	/////////////////////////////////////////////////////////////////////////////////////
  
	private val MAX_ROWS = 50;
  
	private var m_Settings: fhSettings = new fhSettings("config.inf");					/** Enthaelt die Einstellungen */;
	
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Gibt den Kopf der Ausgabe an.
	 */
	def PrintHead()=
	{
	  println("|------------------------- fhMahJongg! -------------------------|")
      println("|                                                               |")
      println("| Autoren: pszName & Doncanalie                                 |")
      println("|                                                               |")
      println("|---------------------------------------------------------------|")
	}
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Startet die Anwendung und laedt alle benoetigten Einstellungen
	 */
	def Begin()=
	{
		m_Settings.LoadSettings();					    /* Laedt die Einstellungen */
		Controller.generateGameBoard(StartOption)	    /* Laedt das Spielelayout  */
	}
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Beendet die Anwendung.
	 */
	def End()=
	{
	  
	}
	/////////////////////////////////////////////////////////////////////////////////////
	def Refresh()=
	{
	  
	}
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Legt das Spiel fest.
	 * 
	 * @returns Die Spielwahl.
	 */
	def StartOption():Int=
	{
		var iRet = 0
	  
		println("|                                                               |")
		println("| Spieloption:                                                  |")
		println("| 1. Generiert                                                  |")
		println("| 2. Pyramide                                                   |")
		println("| 3. Nutzerdefiniert                                            |")
		println("|                                                               |")
		println("|---------------------------------------------------------------|")
		
		/*ShowInput match
		{
		  case '1' => iRet = 1
		  case '2' => iRet = 2
		  case '3' => iRet = 3
		  case _   => iRet = 2
		}*/
		
		return 1;
	}
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Zeigt die Eingabemaske an.
	 * 
	 * @Param cbRows Die Anzahl der bereits geschriebenen Zeilen
	 * @returns Liefert die Eingabe als String zurueck
	 */
	def ShowInput(cbRows: Int): Char=
	{
	  for(i <- cbRows until MAX_ROWS - 3)
	  {
		  println("|                                                               |")
	  }
	  
	  println("|---------------------------------------------------------------|")
	  println("| n: neues Spiel, l: Spiel laden, s: Spiel speichern            |")
	  println("| c: Einstellungen, e: Ende                                     |")
	  print("--> ")
	  
	  Console.readChar
	}
	/////////////////////////////////////////////////////////////////////////////////////
}