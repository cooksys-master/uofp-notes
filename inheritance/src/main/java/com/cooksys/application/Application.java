package com.cooksys.application;

import com.cooksys.inheritance.*;

public class Application {

	public static void main(String[] args) {
		
//		Person p1 = new Teacher("Will");
//		
//		p1.speak("Hello World!");
//		
//		p1 = new Student("Peter", "charlie");
//		
//		p1.speak("Hello world!");
//		
//		System.out.println(p1.getName());
		
		Student s1 = new Student("Will", "charlie");
		
		s1.speak("Hello World!");
		
		Person p1 = new Teacher("Will");
		
		p1.speak("Hello");
		
//		((Student) p1).doAssignment();
		
		Teacher t1 = new Teacher("Will");
		Teacher t2 = new Teacher("Peter");
		
		t1.speak("Hello");
		
		t1.grade(s1);
		
		System.out.println(t1);
		System.out.println(t2);
		
		System.out.println(s1.getName());
		
	}

}
