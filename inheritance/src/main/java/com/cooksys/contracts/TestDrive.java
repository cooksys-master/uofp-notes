package com.cooksys.contracts;

public class TestDrive {
	
	public static void testDrive(Vehicle d) {
		d.drive();
	}
	
	public static void main(String[] args) {
		Motorcycle m = new Motorcycle();
		Sedan s = new Sedan();
		Truck t = new Truck();
		
		testDrive(m);
		testDrive(s);
		testDrive(t);
	}

}
