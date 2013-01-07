package de.fhk.gui.fhMahJongg

/////////////////////////////////////////////////////////////////////////////////////////

import javax.swing._
import de.fhk.ctr.fhMahJongg._
import java.awt.event._

/////////////////////////////////////////////////////////////////////////////////////////

class fhMahJonggUI extends JFrame
{
	// Defs /////////////////////////////////////////////////////////////////////////////
  
	private var m_Container 			  = getContentPane
	private var m_menuBar   			  = new JMenuBar
	private var m_menu					  = new JMenu("Game")
	private var m_menuItem  			  = new JMenuItem
	private var m_lstImages: List[JLabel] = List() 
	private val m_menuListener            = new MenuListener
	
	// Game menu
	m_menu.setMnemonic(KeyEvent.VK_G)
	m_menuItem = new JMenuItem
	m_menuItem.setMnemonic(KeyEvent.VK_N)
	m_menuItem.addActionListener(m_menuListener)
	m_menuItem.setActionCommand("Turtle")
	m_menuItem.setText("Neu Pryramide")
	m_menu.add(m_menuItem)
	
	m_menuBar.add(m_menu)
	
	setJMenuBar(m_menuBar)
	
	// Listener /////////////////////////////////////////////////////////////////////////
	
	private class MenuListener extends ActionListener /* Implements */
	{
		def actionPerformed(e: ActionEvent)=
		{
			
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////