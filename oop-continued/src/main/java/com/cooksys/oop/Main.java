package com.cooksys.oop;

import java.util.Arrays;

public class Main {
	
	public static double pi = 3.1415;

	public static void main(String[] args) {
		
		Student student1 = new Student("Will", "charlie");

		Student student2 = new Student("Peter", "charlie");

		Student student3 = new Student("Frank");
		
		Student student4 = new Student("Will", "charlie");
		
		
		System.out.println(student1.getName());
		System.out.println(student2.getName());

		student1.learn();
		student2.learn();
		
		student1.doAssignment();
		
//		Main m1 = new Main();
//		Main m2 = new Main();
//		
//		m2.pi = 3.1798;
//		
//		System.out.println(Main.pi);
//		System.out.println(m1.pi);
//		System.out.println(m2.pi);
		
		student3.setTeam("charlie");
		
		int x = 5;
		int y = 3;
		
		if (x == y) {
			System.out.println("x and y are equal");
		} else {
			System.out.println("x and y are not equal");
		}
		
		if (student1.equals(student4)) {
			System.out.println("student1 and student4 are equal");
		} else {
			System.out.println("student1 and student4 are not equal");
		}
		
	}

	/**
	 * This method takes two integers, a and b, and returns the sum of those two
	 * integers
	 * 
	 * @param a some integer value
	 * @param b some integer value
	 * @return the sum of the integers a and b
	 */
	public static int add(int a, int b) {
		System.out.println("Do I run?");
		return a + b;
	}

	public static boolean lessThan10(int n) {
		return n < 10;
	}

	public static int[] filterNumbersGreaterThanTen(int[] numbers) {
		int[] result = new int[0];
		for (int i = 0; i < numbers.length; i++) {
			if (lessThan10(numbers[i])) {
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = numbers[i];
			}
		}
		return result;
	}

}
