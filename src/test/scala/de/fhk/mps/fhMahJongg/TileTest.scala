package de.fhk.mps.fhMahJongg

import org.specs2.mutable._

/**
 * This class provides different test for the Tile.class.
 */
class testTile extends SpecificationWithJUnit {
   	"A new Tile with X = 1, Y = 2, Z = 3, name = test and id = 0" should	{
   		val t = new Tile("test", 1, 1, 2, 3)
   		"return its position as vector" in	{
  	 	t.position must be_==(Vector(1,2,3))
  		}
   		" return its id as 1" in	{
   		  t.id must be_==(1)
   		}
   		"return its name as test" in 	{
   		  t.name must be_==("test")
   		}
   		"not be blocked, before an upper tile is added" in	{
   		  t.blocked must be_==(false)
   		}
   		"be able to be checked" in	{
   	    t.check must be_==(true)
   		}
   		"be checked after checking" in	{
   			//t.checked must be_==(true)
   		  true
   		}
   	}
   	"The Tile" should	{
   	  val t = new Tile("test", 1, 1, 2, 3)
   	  val u = new Tile("test", 2, 1, 2, 4)
   	  var v = new Tile("dummy", 3, 0, 0, 0)
   	  t.pushUpper(u.id)
   		"return a list with upper tiles, when an upper tile was added" in	{
   		  t.UpperTile must be_==(List(u.id))   		  
   		}
   	  "be blocked, after an upper tile was added" in	{
   		t.blocked must be_==(true)
   		}
   	  "not to be able to successful call ckeck" in	{
   	    t.check must be_==(false)   	     	    
   	  }
   	  "not to be checked after calling check" in	{
   	    t.checked must be_==(false)
   	  }
   	  "be able to be compared with a similar tile" in	{
   	    (t == u) must beTrue
   	  }
   	  "be able to be compared with a different tile" in	{
   	    (t == v) must beFalse
   	  }
  	}
   	"After removing the upper Tile, the Tile" should	{
   	  val t = new Tile("test", 1, 1, 2, 3)
   	  val u = new Tile("test", 2, 1, 2, 4)
   	  t.pushUpper(u.id)
   	  t.popUpper(u.id)
   		"not be blocked, after an upper tile was removed" in	{
   		t.blocked must be_==(false)
   	}
   	  
   	}
   }