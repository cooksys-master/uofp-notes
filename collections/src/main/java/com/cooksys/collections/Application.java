package com.cooksys.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cooksys.collections.generics.Box;
import com.cooksys.collections.inheritance.Student;

public class Application {
	
	public static void main(String[] args) {
		
		// Type Erasure
//		Box b = new Box(6);
//		
//		System.out.println(b.getX());
//		
//		Box b1 = new Box("This is cool!");
//		
//		System.out.println(b1.getX());
		
		// Type inference
		Box<Student> studentBox = new Box<>(new Student("Will", "charlie"));
		
		println(studentBox.getX());
		
		Box<String> stringBox = new Box<>("This is cool!");
		
		println(stringBox.getX());
		
		Box<Integer> integerBox = new Box<>(5);
		
		Box<Box<Integer>> integerBoxInABox = new Box<>(new Box<>(5));
		
		List<Student> integerList = new ArrayList<>();
		
		integerList.add(new Student("Will", "charlie"));
		integerList.add(new Student("Peter", "charlie"));
		
		Set<Student> exampleSet = new HashSet<>();
		
		Student student1 = new Student("Will", "charlie");
		
		exampleSet.add(student1);
		exampleSet.add(student1);
		
		System.out.println(exampleSet.size());
		
		Map<Integer, Student> studentMap = new HashMap<>();
		
		studentMap.put(1, student1);
		studentMap.put(2, student1);
		
		System.out.println(studentMap.get(1));
		
	}
	
	public static <T> void println(T toPrint) {
		System.out.println(toPrint);
	}
	
	public static String message(int n) {
		String result = n + ": ";
		if (n % 3 == 0) {
			result += "Fizz";
		}
		if (n % 5 == 0) {
			result += "Buzz";
		}
		if (result.equals(n + ": ")) {
			return null;
		}
		return result;
	}
	
	public static String[] messages(int start, int end) {
		List<String> result = new ArrayList<>();
		for (int i = start; i < end; i++) {
			String msg = message(i);
			if (msg != null) {
				result.add(msg);
			}
		}
		return result.toArray(new String[result.size()]);
	}

}
