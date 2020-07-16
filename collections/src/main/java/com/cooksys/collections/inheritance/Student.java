package com.cooksys.collections.inheritance;

public class Student implements Person {

	private String socialSecurityNumber;
	private String name;
	private String team;

	public Student(String socialSecurityNumber, String name, String team) {
		this.socialSecurityNumber = socialSecurityNumber;
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

	@Override
	public String toString() {
		return "Student [socialSecurityNumber=" + socialSecurityNumber + ", name=" + name + ", team=" + team + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((socialSecurityNumber == null) ? 0 : socialSecurityNumber.hashCode());
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
		if (socialSecurityNumber == null) {
			if (other.socialSecurityNumber != null)
				return false;
		} else if (!socialSecurityNumber.equals(other.socialSecurityNumber))
			return false;
		return true;
	}
	
}
