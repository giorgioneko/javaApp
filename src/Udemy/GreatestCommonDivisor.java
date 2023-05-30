package Udemy;

import java.util.Scanner;

public class GreatestCommonDivisor {
	

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please, enter two numbers separated by space: ");
		String Text = userInput.nextLine();
		userInput.close();
		
		String[] inputArgumentsArray = Text.split("\\s+");
		int number1 = Integer.parseInt(inputArgumentsArray[0]);
		int number2 = Integer.parseInt(inputArgumentsArray[1]);

		System.out.println(gcdRecursive(number1, number2));
	}
	
	public static int gcdRecursive(int num1, int num2) {
		if(num2 == 0) {
	        return num1;
	    } else {
	        return gcdRecursive(num2, num1 % num2);
	    }
	}
}