package Udemy;


import java.util.Scanner;
public class EmptyRectangle {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please, enter height of rectangle: ");
		int height = userInput.nextInt();
		System.out.print("Please, enter width of rectangle: ");
		int width = userInput.nextInt();
		userInput.close();
		
		drawnRectangle(height, width);
	}

	public static void drawnRectangle(int height, int width) {
		for (int i = 0;i < height ;i++ ) {
		    	for (int i2 = 0; i2 < width; i2++) {
				if (i2 == 0 || i2 == width - 1 || i == 0 || i == height -1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
				
			}
			System.out.println();
		}
	}

}