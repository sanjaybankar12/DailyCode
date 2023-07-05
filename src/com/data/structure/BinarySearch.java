package com.data.structure;

/**
 * Binary sort is works only on sorted array
 *
 */
public class BinarySearch {

	public static int binarySearch(int[] arr,int begin, int end, int num) {
		int mid;
		
		if(end >= begin) {
			
			mid = (begin + end)/2;
			if(arr[mid] == num) {
				return mid+1;
			}
			else if(arr[mid] < num) {
				return binarySearch(arr, mid + 1, end, num);
			} else {
				return binarySearch(arr, begin, mid - 1, num);
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {1,5,6,8,7,10,11};
		
		int num = 5;
		int idx = binarySearch(arr, 0, arr.length-1, num);
		System.out.println("Element " + num + " is at location " + idx);
	}

}
