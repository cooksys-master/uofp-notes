package com.cooksys.inheritance;

public class Student implements Person {

	private String name;
	private String team;

	public Student(String name, String team) {
		this.name = name;
		this.team = team;
	}
	
	public void learn() {
		System.out.println(getName() + " is learning");
	}

	public void doAssignment() {
		System.out.println(getName() + " from team " + team + " is working on their assignment");
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	@Override
	public void speak(String sentence) {
		System.out.println(sentence);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
