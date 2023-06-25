package com.utility;

public class DisplayStarPattern {
	
	public void displayStarAscending(int n) {
		
		for(int i = 0; i < n; i++) { 
			for(int j = 0; j < (i+1); j++) { 
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void displayStarDescending(int n) {
		
		for(int i = 0; i < n; i++) { 
			for(int j = 0; j < (n-i); j++) { 
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void displayNumberAscending(int n) {
		
		for(int i = 0; i < n; i++) { 
			for(int j = 1; j <= (i+1); j++) { 
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	public void displayNumberDescending(int n) {
		
		for(int i = 0; i < n; i++) { 
			for(int j = n-i; j >= 1; j--) { 
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	public void displayStarPyramid(int n) {
		 
		for(int i = 1; i <= n; i++) {
			for(int j = (n-i); j >= 1; j--) {
				System.out.print(" ");
			}
			for(int j = (i+1); j < i*3; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {

		DisplayStarPattern dsp = new DisplayStarPattern();
		System.out.println("Ascending Star Pattern: ");
		dsp.displayStarAscending(5);
		
		System.out.println("\nDescending Star Pattern: ");
		dsp.displayStarDescending(5);
		
		System.out.println("\nAscending Number Pattern: ");
		dsp.displayNumberAscending(5);

		System.out.println("\nDescending Number Pattern: ");
		dsp.displayNumberDescending(5);

		System.out.println("\nStar Pyramid: ");
		dsp.displayStarPyramid(5);

	}

}
