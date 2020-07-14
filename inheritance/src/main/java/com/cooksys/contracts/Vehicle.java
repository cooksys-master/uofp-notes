package com.cooksys.contracts;

public abstract class Vehicle implements Driveable {
	
	protected int wheels;
	protected String name;
	
	protected Vehicle (int wheels, String name) {
		this.wheels = wheels;
		this.name = name;
	}
	
	@Override
	public void drive() {
		System.out.println(this.name + " drivin' on " + this.wheels + " wheels");
	}

}
