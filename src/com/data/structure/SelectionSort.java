package com.data.structure;

/**
 *	Selection sort in which we move smallest element at the first position.
 *	In one iteration there will be only one swap after comparing with all elements.
 *  n-1
 */
public class SelectionSort {

	public static void main(String[] args) {

		int[] arr = {2,1,8,7,3,6};
		
		for(int i = 0;i < arr.length-1; i++) {
			int smallest = i;
			for(int j = i+1;j < arr.length; j++) {
				if(arr[smallest] > arr[j]) {
					smallest = j;
				}
			}
			
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
		}
		
		for(int i = 0;i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}

}
