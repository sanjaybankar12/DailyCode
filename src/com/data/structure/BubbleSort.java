package com.data.structure;

/**
 * 
 * Bubble sort is sorting algorithm which sort the array element by moving greater element at the end.
 * n-1 element sort and time complexity will be O(n^2)
 */
public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = {2,1,8,7,3,6};
		
		for(int i = 0;i < arr.length-1; i++) {
			for(int j = 0;j < arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for(int i = 0;i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

}
