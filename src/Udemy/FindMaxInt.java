package Udemy;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxInt {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter integer numbers separated by space: ");
	    String numbers = sc.nextLine();
	    int[] intArray = convertStringArrayToIntArray(numbers.split("\\s+"));
	    int maxInt = findMaxIntInArray(intArray);
		sc.close();
		System.out.println("*** Initial Array ***");
		System.out.println(Arrays.toString(intArray));
		System.out.println("*** Max number in array ***");
		System.out.print(maxInt);
	}

	
public static int findMaxIntInArray(int[] intArray) {
    	Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter integer numbers separated by space: ");
		int max = intArray[0];
		for (int i : intArray) {
			if (i > max) {
				max = i;
			}
		}
		sc.close();
		return max;
	}
	
	private static int[] convertStringArrayToIntArray(String[] stringArray) {
		int[] intArray = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			intArray[i] = Integer.valueOf(stringArray[i]);
		}
		return intArray;
		
	}

}