package com.cooksys.oop;

public class Student {
	
	private String name;
	private String team;
	
	public Student(String name, String team) {
		this.name = name;
		this.team = team;
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	public void learn() {
		System.out.println(name + " is learning");
	}
	
	public void doAssignment() {
		System.out.println(name + " from team " + team + " is working on their assignment");
		System.out.println(Main.pi);
	}
	
	public String getName() {
		return name;
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}

}
