package com.data.structure;

/**
 * 	Linear search is used to search element 
 *
 */
public class LinearSearch {
	
	public static int linearSearch(int num, int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == num) {
				return i+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1,5,6,8,7,10,11};
		
		int num = 5;
		int idx = linearSearch(num, arr);
		System.out.println("Element " + num + " is at location " + idx);
	}
}
