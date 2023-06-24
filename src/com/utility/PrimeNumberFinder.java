package com.utility;

public class PrimeNumberFinder {
	
	public void displayPrimeNums(int n) {
	
		int flag = 0;
		int m = n/2;
		if(n == 0 || n == 1) {
			System.out.println(n + " is not Prime number");
		} else {
			for(int i = 2; i < m; i++) {
				if(n % i == 0) {
					System.out.println(n + " is not Prime number");
					flag = 1;
					break;
				}
			}
			
			if(flag == 0) {
				System.out.println(n + " is Prime number");
			}
		}
	}

	public static void main(String[] args) {
		new PrimeNumberFinder().displayPrimeNums(11);
	}
 
}
