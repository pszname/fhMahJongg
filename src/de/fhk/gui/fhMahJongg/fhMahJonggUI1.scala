package de.fhk.gui.fhMahJongg

import scala.swing._
import scala.swing.event.Key
import de.fhk.ctr.fhMahJongg._
import de.fhk.mps.fhMahJongg.fhGenerator
import Array._
import javax.swing.ImageIcon
import scala.swing.Action$
import scala.swing.event.MouseClicked

class fhMahJonggUI1 extends Frame 
{
  
	private var m_lstLabel: Array[Label] = ofDim(144)
  
	// Properties ///////////////////////////////////////////////////////////////////////
	title   = "fhMahJongg"
	visible = true
	bounds  = new Rectangle(640, 480)
	  
	// UI-Content ///////////////////////////////////////////////////////////////////////
	  
	var mainPanel = new FlowPanel
	{
	  	visible   = true
	  	contents += new Label("test")
	  	
	  	for (i <- 0 until 144)
	  	{
	  		var pLabel  = new Label
	  		{
	  			var iID = i+1
	  			text    = ""
	  			visible = false
	  				reactions += {
	  					case e: MouseClicked =>	SelectTile(iID)
	  					}
	  		}
	  		m_lstLabel(i) = pLabel
	  		contents     += pLabel
	  	}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	menuBar = new MenuBar 
	{
      contents += new Menu("Game") 
      {
	      mnemonic  = Key.G
	      contents += new MenuItem(Action("New")  { MenuNewTurtle })
	      contents += new MenuItem(Action("Quit") { System.exit(0)})
      }
    }
    
    /////////////////////////////////////////////////////////////////////////////////////
    
    private def MenuNewTurtle()=
	{
		if (Controller.generateGameBoard(1))
		    createLayer
	}
    
    /////////////////////////////////////////////////////////////////////////////////////
	
	private def createLayer()=
	{
		var iAlloc  = Controller.getTileVectors
		
		for(i <- 1 until Controller.getTileCount)
		{
			// System.getProperty("user.dir")
			m_lstLabel(i - 1).icon 	  = new ImageIcon( "de/fhk/gui/fhMahJongg" + iAlloc(i).name(1).toUpper + iAlloc(i).name(2) + ".png")
			m_lstLabel(i - 1).visible = true;
			m_lstLabel(i - 1).text    = iAlloc(i).name
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	private def SelectTile(iID: Int)=
	{
    	println("test")
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	contents = mainPanel
	
	/////////////////////////////////////////////////////////////////////////////////////
}