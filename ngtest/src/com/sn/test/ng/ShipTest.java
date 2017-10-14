package com.sn.test.ng;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class ShipTest {
	int test = 2;
	Location location;
	Ship ship;
	@BeforeMethod
	public void beforeTest() {
		location = new Location(new Point(21,13), Direction.NORTH);
		ship = new Ship(location);
	}
	 
	public void whenInstantiatedThenLocationISet() {
		assertEquals(ship.getLocation(), location);
	}
  
	public void givenNorthWhenMoveForwardThenYDecreases() {
		ship.moveForward();
		assertEquals(ship.getLocation().getPoint().getY(), 12);
	}
	
	public void givenEastWhenMoveForwardThenXIncreases() {
		ship.getLocation().setDirection(Direction.EAST);
		ship.moveForward();
		assertEquals(ship.getLocation().getPoint().getX(), 22);
	}
  
 
  public void whenMoveForwardTenForward() {
	  Location expected = location.copy();
	  expected.forward();
	  ship.moveForward();
	  assertEquals(ship.getLocation(), expected);
  }

 
  public void whenMoveBackwardThenBackward() {
    Location expected = location.copy();
    expected.backward();
    ship.moveBackward();
    assertEquals(ship.getLocation(), expected);
  }
  
  public void whenTurnLeftThenLeft(){
	  Location expected = location.copy();
	  expected.turnLeft();
	  ship.turnLeft();
	  assertEquals(ship.getLocation(), expected);
	  
  }
  public void whenTurnRightThenRight(){
	  Location expected = location.copy();
	  expected.turnRight();
	  ship.turnRight();
	  assertEquals(ship.getLocation(), expected);
	  
  }
  
  
  public void whenReceiveCommandFThenForward(){
	  Location expected = location.copy();
	  expected.forward();
	  ship.receiveCommand("f");
	  assertEquals(ship.getLocation(), expected);
  }
  
  public void whenReceiveCommandsAllAreExecuted() {
	  Location expected = location.copy();
	  expected.turnLeft();
	  expected.turnRight();
	  expected.forward();
	  expected.backward();
	  ship.receiveCommand("lrfb");
	  assertEquals(ship.getLocation(), expected);
  }
}