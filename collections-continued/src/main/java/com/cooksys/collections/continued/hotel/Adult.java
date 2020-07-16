package com.cooksys.collections.continued.hotel;

public class Adult implements Person {

	private String name;
	private int age;

	public Adult(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Adult [name=" + name + ", age=" + age + "]";
	}

}
