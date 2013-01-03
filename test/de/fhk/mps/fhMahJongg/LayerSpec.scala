package de.fhk.mps.fhMahJongg

import org.specs2.mutable._

class LayerSpec extends SpecificationWithJUnit
{
  
	// ----------------------------------------------------------------------------------
    // Layoutclass
	// ----------------------------------------------------------------------------------
	"A new Layout with 1 Layer, X_Max = 10 and Y_Max = 11" should 
	{
	  val pLayout = new fhLayout(1,10,11)
	  // Layercount 
	  "return a Layercount of 1" in 
	  {
		  pLayout.Layer.length must be_==(1)
	  }
	  // X_Max
	  "return a X_Max of 10" in
	  {
		  pLayout.X_Max must be_==(10)
	  }
	  // Y_Max
	  "return a Y Max of 11" in
	  {
	    pLayout.Y_Max must be_==(11)
	  }
	}
}