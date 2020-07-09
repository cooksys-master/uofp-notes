package fundamentals;

import java.util.Arrays;

public class Application {
	
	/**
	 * 8 primitives
	 * 1 - int
	 * 2 - double
	 * 3 - float
	 * 4 - byte
	 * 5 - char 'a' '1' '@'
	 * 6 - boolean true | false
	 * 7 - short
	 * 8 - long
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 5;
		int y = 2;
		
		char character = 'a';
		
		boolean bool = false;
		
		System.out.println(x + y);
		System.out.println(x - y);
		
//		x += 7;
		
		int[] intArray = new int[5];
		intArray[0] = 1;
		intArray[1] = 2;
		intArray[2] = 3;
		intArray[3] = 4;
		intArray[4] = 5;
		
		int[] biggerIntArray = new int[] {1, 2, 3, 4, 5, 6};
		
		System.out.println(Arrays.toString(biggerIntArray));
		
		System.out.println(intArray[4]);
		
		System.out.println(x);
		
		if ((x + y > intArray[4]) && (x + y != intArray[4])) {
			System.out.println("The sum of x and y is greater than the value stored at index 4 of the intArray variable");
		} else if (x + y == intArray[4]) {
			System.out.println("The sum of x and y is equal to the value stored at index 4 of the intArray variable");
		} else {
			System.out.println("The sum of x and y is less than the value stored at index 4 of the intArray variable");
		}
		
		switch (x) {
			case 1:
				System.out.println("X is 1");
				break;
			case 2:
				System.out.println("X is 2");
				break;
			case 3:
				System.out.println("X is 3");
				break;
			default:
				System.out.println("X is " + x);
				break;
		}
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}

	}

}
