package Udemy;

import java.util.Scanner;

public class SumDigitsInNumber {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please, enter integer: ");
		int number = userInput.nextInt();
		userInput.close();
		
		int sumOfDigits = sumDigitsInNumber(number);
		System.out.println(sumOfDigits);
	}

	public static int sumDigitsInNumber(int number) {
	   int result = 0;
	   System.out.println(number);
	  while (number != 0) {
			result += number % 10;
			number /= 10;
		}
	   return Math.abs(result);
		
	}
}
	