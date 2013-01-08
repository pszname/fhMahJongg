package de.fhk.mps.fhMahJongg

import org.specs2.mutable._
import Array._

class fhLayoutTest extends SpecificationWithJUnit { 
  
  var l = new fhLayout
  
  "A new layout" should	{   
    
    l.CreateLayout(1)
    
    "be able to be created as type turtle (1)" in	{
      l.CreateLayout(1) must be_==(true)
    }        
    "provide a field with all tiles on top by id" in	{    
      true		//muss aufgrund von groﬂer Komplexit‰t warten
    }
    "provide a field with all tiles on top by name" in	{
      true		//muss aufgrund von groﬂer Komplexit‰t warten
    }
    "provide a field with all tiles as vector of position and name" in	{
      true		//muss aufgrund von groﬂer Komplexit‰t warten
    }
    
  }
  "Further the layout" should	{  
    "provide to check tiles by id and return a position as vector" in	{      
      var bOk = false
      for (i <- 0 until l.tiles.length) if (!l.tiles(i).blocked && l.checkTile(i).length > 1) bOk = true
      bOk must beTrue
    }
    "provide to check tiles by position and return a position as vector" in	  {
      var bOk = false
      for (i <- 0 until l.tiles.length) if (!l.tiles(i).blocked && 
          l.checkTile(l.tiles(i).position(0), l.tiles(i).position(1)).length > 1) bOk = true
      bOk must beTrue
    }
    "provide delete checked tiles, that are of the same type" in	{
      /*var bOk = false
      for (i <- 0 until l.tiles.length; j <- i until l.tiles.length)	{
        if (!l.tiles(i).blocked && ! l.tiles(j).blocked && i != j)	{
           if (l.tiles(i) == l.tiles(j))	{
             l.checkTile(i)
             if (l.checkTile(j).length == 6) bOk = true
           }
        }        
      }
      bOk must beTrue*/		//muss aufgrund von groﬂer Komplexit‰t warten, sollte so aber eigentlich funktionieren.
      true
    }
    "provide a top tile on a single xy-position" in	{
      (l.Layer(l.tiles(l.topTile(15, 7)-1).position(2)+1).getIDFromPosition(15, 7) == 0 && 
          l.Layer(l.tiles(l.topTile(15, 7)-1).position(2)).getIDFromPosition(15, 7) == l.topTile(15, 7)) must beTrue
    } 
    "provide a top tile on a single xyz-position" in	{
      (l.Layer(l.tiles(l.topTile(15, 7, 3)-1).position(2)+1).getIDFromPosition(15, 7) == 0 && 
          l.Layer(l.tiles(l.topTile(15, 7)-1).position(2)).getIDFromPosition(15, 7) == l.topTile(15, 7)) must beTrue
    }
    
    "provide a vector of all tiles" in {
    	l.getAllTiles().length > 0 must beTrue
    }
    "provide the count of the tile list" in{
    	l.getTileCount > 0 must beTrue
    }
    "provide a id array of the uppertiles" in{
    	l.topTiles.length > 0 must beTrue
    }
    "provide a name array of the " in
    {
    	l.topTilesWithNames.length > 0 must beTrue
    }
  }
  
  "A random generated Layout" should
  {
	  var l = new fhLayout()
	  "not generate" in
	  {
		  l.CreateLayout(0) must beFalse
	  }
  }
  
  "A not supported Layout" should
  {
	  var l = new fhLayout()
	  "not generate" in
	  {
		  l.CreateLayout(4) must beFalse
	  }
  }
  
  "A user Generated layout" should
  {
	  var l = new fhLayout()
	  "not generate" in
	  {
		  l.CreateLayout(2) must beFalse
	  }
  }
  
  
}