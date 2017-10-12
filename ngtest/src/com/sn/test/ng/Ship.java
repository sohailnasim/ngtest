package com.sn.test.ng;

public class Ship {
	private Location location;
	
	public Ship(Location location){
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public boolean moveForward() {
		return location.forward();
		
	}

	public boolean moveBackward() {
		return location.backward();
		
	}

	public void turnLeft() {
		location.turnLeft();
		
	}

	public void turnRight() {
		location.turnRight();
		
	}

	public void receiveCommand(String commandStr) {
		for (char command: commandStr.toCharArray()) {
			switch(command){
			case 'f':
				moveForward();
				break;
			case 'b':
				moveBackward();
				break;
			case 'l':
				turnLeft();
				break;
			case 'r':
				turnRight();
				break;
			}
		}
		
	}
	
	

}
