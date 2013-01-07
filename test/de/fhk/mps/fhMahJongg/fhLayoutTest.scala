package de.fhk.mps.fhMahJongg

import org.specs2.mutable._

class fhLayoutTest extends SpecificationWithJUnit {
  "A new layout" should	{
    var l = new fhLayout
    "be able to be created as type turtle (1)" in	{
      l.CreateLayout(1) must be_==(true)
    }
    
  }
}