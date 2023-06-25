package com.utility;

public class ClosestNumberFinder {

	public int findClosestNumber(int num, int[] arr) {
		int closestNum = 0;
		int diff = Integer.MAX_VALUE;
		int elValue, res;
		for(int i = 0; i < arr.length; i++) {
			elValue = arr[i];
			if(elValue > num) {
				res = elValue - num;
			} else {
				res = num - elValue;
			}
			
			if(res < diff) {
				diff = res;
				closestNum = elValue;
			}
		}		
		return closestNum;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {4,5,7,11,6,20,17,25};
		int n = 8;

		int num = new ClosestNumberFinder().findClosestNumber(n,arr);
		System.out.println("Closest number of " + n + " is " + num);
	}

}
