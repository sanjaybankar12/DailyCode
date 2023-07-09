package com.utility;

public class SecondMaxNumber {
	
	public static int findMaxAndSecondMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			int el = arr[i];
			if(el > max) {
				secondMax = max;
				max = el;
			} else if(el > secondMax && el != max) {
				secondMax = el;
			}
		}
		return secondMax;
	}

	public static void main(String[] args) {

		int[] arr = {1,12,9,4,8,12,6};
		
		int max = findMaxAndSecondMax(arr);
		System.out.println("Max number from array is " + max);
		
	}

	

}
