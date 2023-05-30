package Udemy;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class ConvertDecimalToRoman {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		mainLoop: while (true) {
			System.out.print("Please, select mode. If you want to convert Roman "
					+ "numbers to decimal - type 'R2D' and press enter."
					+ System.lineSeparator()
					+ "If you want to convert decimal numbers to Roman - type 'D2R' and press enter: ");

			String mode = sc.next();
			if (mode.equalsIgnoreCase("R2D")) {
				while (true) {
					System.out.print("Please, enter Roman number you want to convert: ");
					String romanNumber = sc.next();
					if (isRomanNumberValid(romanNumber)) {
						System.out.println(roman2Decimal(romanNumber));
						break mainLoop;
					} else {
						System.out.println("You entered invalid Roman number. "
								+ "Please, try one more time.");
						continue;
					}
				}
			} else if (mode.equalsIgnoreCase("D2R")) {
				while (true) {
					System.out.print("Please, enter decimal number "
							+ "you want to convert: ");
					int decimalNumber = sc.nextInt();
					if (isDecimalNumberValid(decimalNumber)) {
						System.out.println(decimal2Roman(decimalNumber));
						break mainLoop;
					} else {
						System.out.println("Please, enter positive int from 1 to 100.");
						continue;
					}

				}

			}
			
			System.out.println("Please, enter 'R2D' or 'D2R.");
			sc.close();
		}
	}

	public static String decimal2Roman(int number) {
	    int[] decimalValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    StringBuilder result = new StringBuilder();
	    for (int i = 0; i < decimalValues.length; i++) {
	        while (number >= decimalValues[i]) {
	            number -= decimalValues[i];
	            result.append(romanNumerals[i]);
	        }
	    }
	    return result.toString();
	}

	public static int roman2Decimal(String romanNumber) {
		Map<Character, Integer> romanValues = new HashMap<>();
		romanValues.put('I', 1);
	    romanValues.put('V', 5);
	    romanValues.put('X', 10);
	    romanValues.put('L', 50);
	    romanValues.put('C', 100);
	    romanValues.put('D', 500);
	    romanValues.put('M', 1000);
	    
	    int NewromanNumber = 0;
	    for (int i = 0; i < romanNumber.length(); i++) {
	    	 int currentValue = romanValues.get(romanNumber.charAt(i));
	         if (i < romanNumber.length() - 1 && currentValue < romanValues.get(romanNumber.charAt(i + 1))) {
	             NewromanNumber -= currentValue;
	         } else {
	             NewromanNumber += currentValue;
	         }
	     }
	     return NewromanNumber;
			
		
	    
	}


	/**
	 * Validation for Roman numbers.
	 * 
	 * Use regular expression which is checking if string really could be Roman
	 * number.
	 * 
	 * @param romanNumber
	 * @return true if String is Roman number
	 */
	public static boolean isRomanNumberValid(String romanNumber) {
	    return romanNumber
				.matches("^(?i)M{0,3}(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$");
	}
	
	public static boolean isDecimalNumberValid(int decimalNumber) {
		return decimalNumber > 0 && decimalNumber <= 3999;
}
}