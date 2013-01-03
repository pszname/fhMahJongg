package de.fhk.mps.fhMahJongg

import org.specs2.mutable._

class LayerSpec extends SpecificationWithJUnit
{
  
	"A new Layout with 1 Layer" should 
	{
	  val pLayout = new fhLayout(1,0,0)
	  "return a Layercount of 1" in 
	  {
		  pLayout.GetLayerCount must be_==(1)
	  }
	}
}