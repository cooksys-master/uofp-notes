package com.cooksys.inheritance;

public class Teacher implements Person {
	
	private String name;

	public Teacher(String name) {
		this.name = name;
	}
	
	public void grade(Student student) {
		student.setName("Bob");
		System.out.println(student.getName());
	}
	
	public void giveLesson() {
		System.out.println(name + " is giving a lesson");
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void speak(String sentence) {
		System.out.println(name + " says:" + sentence);
	}

}
