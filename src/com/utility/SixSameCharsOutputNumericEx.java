package com.utility;

import java.util.HashSet;

public class SixSameCharsOutputNumericEx {

	/**
	 *  A * BCDEF = GGGGGG
	 *  A,B,C,D,E,F are unique numbers after multiplication 
	 *  that generate unique 6 numbers format
	 */
	public void displayUniqueCharsNumbers() {
		int result = 0, count = 0, jCount = 0;
		
		HashSet<String> hs = new HashSet<>();
		for(int i = 1; i < 10; i++) {
			for(int j = 10000; j < 99999; j++) {
				result = i * j;
				count = getUniqueCharsCount(hs, -1, result);
				if(count == 1) {
					jCount = getUniqueCharsCount(hs, i, j);
					if(jCount == 6) {
						System.out.println(i + " * " + j + " = " + result);
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @param hs
	 * @param numStr
	 * @return
	 */
	private int getUniqueCharsCount(HashSet<String> hs, int i, int num) {
		int count = 0;
		String numStr;
			
		if(i == -1) {
			numStr = String.valueOf(num);
		} else {
			numStr = String.valueOf(i) + String.valueOf(num);
		}
		
		if(numStr.length() == 6) {
			String[] arr = numStr.split("");
			for(String arrNum : arr) {
				hs.add(arrNum);
			}
			count = hs.size();
			hs.clear();
		}
		return count;
	}
	
	public static void main(String[] args) {
		new SixSameCharsOutputNumericEx().displayUniqueCharsNumbers();		
	}

}
