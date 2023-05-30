package Udemy;

import java.util.Scanner;
public class AmountOfWords {
	
	public static void main(String[] args) {
	
		Scanner UserInput = new Scanner(System.in);
		System.out.print("Please input any text :");
		String Text = UserInput.nextLine();
		UserInput.close();
		System.out.print(GetNumberOfWords(Text));
		
		
	}
	
	public static int GetNumberOfWords(String Text) {
		String[] totalWord = Text.split("\\s+");
		return totalWord.length;
	}

}
