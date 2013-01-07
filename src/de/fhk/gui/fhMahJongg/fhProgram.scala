package de.fhk.gui.fhMahJongg

import javax.swing.JFrame

/////////////////////////////////////////////////////////////////////////////////////////

/**
 * Main Entrypoint for the Gui
 *
 */
object fhProgram 
{
	def main(args: Array[String])=
	{
		var frmGameUI = new fhMahJonggUI()
		frmGameUI.setTitle("fhMahJongg")
		frmGameUI.setSize(640, 480)
		frmGameUI.setVisible(true)
		frmGameUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
	}
}

/////////////////////////////////////////////////////////////////////////////////////////