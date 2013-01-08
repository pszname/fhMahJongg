package de.fhk.gui.fhMahJongg

/////////////////////////////////////////////////////////////////////////////////////////

import javax.swing._
import java.awt._
import java.awt.event._
import de.fhk.ctr.fhMahJongg._
import de.fhk.mps.fhMahJongg.fhGenerator
import Array._

/////////////////////////////////////////////////////////////////////////////////////////

class fhMahJonggUI extends JFrame
{
	// Defs /////////////////////////////////////////////////////////////////////////////
  
	private var m_Container		           = getContentPane
	private var m_menuBar   			   = new JMenuBar
	private var m_menu					   = new JMenu("Game")
	private var m_menuItem  			   = new JMenuItem
	private var m_lstImages: Array[JLabel] = Array() 
	private val m_menuListener             = new MenuListener
	
	m_Container.setLayout(new FlowLayout)
	
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
			if (Controller.generateGameBoard(1))
			  createLayer
		}
		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	private def createLayer()=
	{
		var iAlloc  = Controller.getTileVectors
		m_lstImages = ofDim[JLabel](144)
		
		for(i <- 1 until Controller.getTileCount)
		{
			var imgTile    = new ImageIcon(iAlloc(i).name(1) + iAlloc(i).name(2) + ".png")
			m_lstImages(i) = new JLabel(imgTile) 
			m_lstImages(i).setBounds(20, 20, 80, 80)
			m_lstImages(i).setBackground(Color.RED)
			m_lstImages(i).setVisible(true)
			getContentPane.add(m_lstImages(i))
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	private class TileListener extends ActionListener
	{
		def actionPerformed(e: ActionEvent)=
		{
			
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
}

/////////////////////////////////////////////////////////////////////////////////////////