package com.data.structure;

/**
 * Insertion sort is comparison based sorting algorithm in which elements will be move
 * from unsorted part to sorted part one by one.
 * O(n^2)
 *  sorted area | unsorted area
 */
public class InsertionSort {

	public static void main(String[] args) {

		int[] arr = { 2, 1, 8, 7, 3, 6 };

		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];
			int j = i - 1; //for sorted area
			while(j >= 0 && current < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = current;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}}

}
