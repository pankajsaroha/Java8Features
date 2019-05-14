package org.java.practice;

class Vehicle {
	void turn() {
		System.out.println("Turning the vehicle");
	}
}

class Car extends Vehicle {
	void turn() {
		System.out.println("Turning Car");
	}
}

class Bike extends Vehicle {
	void turn() {
		System.out.println("Turning Bike");
	}
}

class Driver {
	
	static void turnMachine(Vehicle vehicle) {
		vehicle.turn();
	}
}

public class InheritanceVsCompositionInterface {

	public static void main(String args[]) {
		Car car = new Car();
		Driver.turnMachine(car);
	}
}
