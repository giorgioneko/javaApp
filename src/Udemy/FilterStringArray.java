package Udemy;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class FilterStringArray {
    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter any words separated by space: ");
		String userInput = sc.nextLine();
		System.out.print("Please, enter minumum word length to filter words: ");
		int minLength = sc.nextInt();
		
		String[] words = userInput.split("\\s+");
		String[] filteredWords = filterWordsByLength(minLength, words);
		System.out.println(Arrays.toString(filteredWords));
		sc.close();
	}

	
	
	public static String[] filterWordsByLength(int minLength, String[] words) {
		ArrayList<String> ar = new ArrayList<String>();
 		for (int i = 0;i <= words.length - 1 ;i++ ) {
 		    if (words[i].length() >= minLength){
 		        ar.add(words[i]);
		        
 		    }
 		}
		String[] stringArray = ar.toArray(new String[0]);
		return stringArray;
	}

}