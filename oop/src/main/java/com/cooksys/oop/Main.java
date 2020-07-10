package com.cooksys.oop;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		String[] teams = { "echo", "foxtrot", "november", "x-ray", "yankee" };

		String[] newTeams = new String[teams.length + 1];
		for (int i = 0; i < teams.length; i++) {
			newTeams[i] = teams[i];
		}

		newTeams[5] = "charlie";

//		for (String team : newTeams) {
//			System.out.println(team);
//		}

//		while (teams.length > 5) {
//			System.out.println("this won't ever run");
//		}

//		do {
//		System.out.println("Will always run once");
//	} while (teams.length > 5);

		// Example calls to the add method
//		int add(1, 2);
//		add(5, 20);
//		add(1, 2);
//		add(300, 690);

		int[] numbers = { 1, 2, 40, 50, 17, 3, -100, 20, 60, 6 };

		System.out.println(Arrays.toString(filterNumbersGreaterThanTen(numbers)));

		Student student1 = new Student();

		Student student2 = student1;

		student1.name = "Will";
		student1.team = "charlie";

		student2.name = "Peter";
		student2.team = "charlie";

		System.out.println(student1.name);
		System.out.println(student2.name);

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
				// Addign a value to an array using a second temporary array
//				int[] temp = new int[result.length + 1];
//				for (int j = 0; j < result.length; j++) {
//					temp[j] = result[j];
//				}
//				temp[temp.length - 1] = numbers[i];
//				result = temp;
				// Adding a value to an array using the Arrays object
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = numbers[i];
			}
		}
		return result;
	}

}
