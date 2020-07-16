package com.cooksys.collections.continued.hotel;

import java.util.List;

public class Adult implements Person {

	private String name;
	private int age;
	private Adult parent;

	public Adult(String name, int age, Adult parent) {
		super();
		this.name = name;
		this.age = age;
		this.parent = parent;
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

	@Override
	public Adult getParent() {
		return parent;
	}

	@Override
	public List<Adult> generateAncestorsList() {
		// TODO Auto-generated method stub
		return null;
	}

}
