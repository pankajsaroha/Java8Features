/*package org.java.practice;

interface CanTurn {
	void turn ();
}

class Vehicle {
	public void turn() {
		System.out.println("Turning Vehicle");
	}
}

class Car implements CanTurn {
	
	private Vehicle vehicle = new Vehicle();
	public void turn() {
		vehicle.turn();
	}
}

class Driver {
	static void turnMachine (CanTurn machine) {
		machine.turn();
	}
}

public class CompositionInterfacePolymorphism {
	
	public static void main(String args[]) {
		Car car = new Car();
		Driver.turnMachine(car);
	}
}

class Bike implements CanTurn {
	private Vehicle vehicle = new Vehicle();
	public void turn() {
		vehicle.turn();
	}
}*/