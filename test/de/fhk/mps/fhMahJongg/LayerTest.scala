package de.fhk.mps.fhMahJongg

import org.specs2.mutable._
import Array._

/**
 * This class provides different tests for Layer.class.
 */
class LayerTest extends SpecificationWithJUnit	{
  "A new Layer with width = 100 and height = 200" should	{
    var l = new Layer(100, 200)
    var Matrix = ofDim[Int](100, 200)
    "return true, if a tileID was setted to a position" in	{
      l.setTileIDToPosition(1, 50, 75) must beTrue
    }
    "return false, if a tileID should be set to a position, that is already occupied" in	{
      l.setTileIDToPosition(2, 50, 75) must beFalse
    }  
    "return false, if x or y is out of bound while setting a tileID to position" in	{
      l.setTileIDToPosition(3, 100, 200) must beFalse
    }
    "return 0, if x or y is out of bound while requesting a tileID on position" in	{
      l.getIDFromPosition(1, -1) must be_==(0)
    }
    "return 1, if x or y is out of bound while deleting a tileID from its position" in	{
      l.deleteTileIDFromPosition(-1, 201) must be_!=(0)
    }
    "return the position as vector of a specified tileID" in	{
      l.setTileIDToPosition(2, 50, 76)
      l.getPositionFromID(2) must be_==(Vector(50, 76))
    }
    "return the id, that was setted to a specified position" in	{
      l.getIDFromPosition(50, 75) must be_==(1)
    }
    "be able to delete tileID from specified positions" in	{
      l.deleteTileIDFromPosition(50, 75) must be_==(0)
    }
  }

}