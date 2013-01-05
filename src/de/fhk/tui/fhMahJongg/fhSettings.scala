package de.fhk.tui.fhMahJongg

/////////////////////////////////////////////////////////////////////////////////////////
/**
 * Diese Klasse laedt und speichert Einstellungen, die fuer die TUI verantwortlich sind.
 */
class fhSettings (m_Path: String)
{	
	val SET_END 				=	1;					/** Beended die Anwendung */
	val SET_NEW					=	2;					/** Startet ein neues Feld */
	val SET_SAVE				=   3;					/** Speichert ein angefangenes Spiel */
	val SET_LOAD				=   4;					/** Laedt ein angefangenes Spiel */
	val SET_CONFIG				=   5;					/** Aendert die Einstellungen */
	
	private var m_lpSettings: Array[String] = Array();	/** Enthaelt die Einstellungen */
	
	def Setting = m_lpSettings;
  
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Lädt die Einstellungen aus der Config und gibt diese in einer Liste zurueck.
	 * Der Index der Eingaben entspricht den Konstanten dieser Klasse.
	 */
	def LoadSettings()=
	{
		if (m_Path == null || m_Path == "")
		  m_lpSettings = LoadDefault();
	  
		m_lpSettings = ReadSettingFile(m_Path);
	}
	/////////////////////////////////////////////////////////////////////////////////////
	/** 
	 * Laedt die Standardeinstellungen fuer die Eingabe.
	 * Der Index der Eingaben entspricht den Konstanten dieser Klasse 
	 */
	def LoadDefault():Array[String]=
	{
	  return Array("e", "n", "s", "l", "c");
	}
	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Liest ein SettingFile aus. Ist dieses nicht vorhanden, es kann nicht geoffnet
	 * werden oder die Settingfile ist inkonsistent, so wird die Standardeinstellung
	 * abgerufen.
	 * 
	 * @Param: szPath Der Pfad zu Datei.
	 */
	private def ReadSettingFile(szPath: String):Array[String]=
	{
		return LoadDefault();
	}
	/////////////////////////////////////////////////////////////////////////////////////
}