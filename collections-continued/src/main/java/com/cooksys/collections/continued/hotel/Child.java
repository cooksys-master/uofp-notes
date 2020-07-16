package com.cooksys.collections.continued.hotel;

import java.util.ArrayList;
import java.util.List;

public class Child implements Person {
	
	private String name;
	private int age;
	private Adult parent;
	
	public Child(String name, int age, Adult parent) {
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
	public Adult getParent() {
		return parent;
	}

	@Override
	public List<Adult> generateAncestorsList() {
		List<Adult> result = new ArrayList<>();
		Adult currentParent = parent;
		while (currentParent != null) {
			result.add(currentParent);
			currentParent = currentParent.getParent();
		}
		return result;
	}

	@Override
	public String toString() {
		return "Child [name=" + name + ", age=" + age + "]";
	}
	
	

}
