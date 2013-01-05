package de.fhk.tui.fhMahJongg

import de.fhk.ctr.fhMahJongg._

/////////////////////////////////////////////////////////////////////////////////////////
/**
 * TUI
 */
class fhTui 
{
	/////////////////////////////////////////////////////////////////////////////////////
  
	private var m_Settings: fhSettings = new fhSettings("config.inf");					/** Enthaelt die Einstellungen */;
	
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Gibt den Kopf der Ausgabe an.
	 */
	def PrintHead()=
	{
	  println("|+++++++++++++++++++++++++ fhMahJongg! +++++++++++++++++++++++++|")
      println("|                                                               |")
      println("| Autoren: pszName & Doncanalie                                 |")
	}
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Startet die Anwendung und laedt alle benoetigten Einstellungen
	 */
	def Begin()=
	{
		// Einstellungen laden
		m_Settings.LoadSettings();
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
	def StartOption():String=
	{
		return "1";
	}
}