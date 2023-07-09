package com.utility;

import java.util.*;

public class FirstNonRepeatingLetter {
	
	private static final String EMPTY_STRING = "";

	public String findFirstNonRepeatingLetter(String str) {
		String letter = EMPTY_STRING;
		
		String[] arr = str.split("");
		int idx = 0;
		Set<String> existingValues = new HashSet<>();
		for(int i  = 0; i < arr.length; i++) {
			String el = arr[i];			
			idx = str.substring(i+1).indexOf(el);
			if(idx == -1 && !existingValues.contains(el)) {
				letter = el;
				break;
			} else {
				existingValues.add(el);
			}
		}
		return letter;
	}
	
	public String findFirstNonRepeatingLetterEasy(String str) {
		String letter = EMPTY_STRING;
		
		String[] arr = str.split("");
		int idx = 0, lastIdx = 0;
		for(int i  = 0; i < arr.length; i++) {
			String el = arr[i];			
			idx = str.indexOf(el);
			lastIdx = str.lastIndexOf(el);
			if(idx == lastIdx) {
				letter = el;
				break;
			}
			
		}		
		return letter;
	}
	
	public static void main(String[] args) {

		String s = "welcome to Pune";
		String firstLetter = new FirstNonRepeatingLetter().findFirstNonRepeatingLetter(s);
		System.out.println("First non repeating letter in '" + s + "' is " + firstLetter);
		
		String firstLetterEasy = new FirstNonRepeatingLetter().findFirstNonRepeatingLetterEasy(s);
		System.out.println("First non repeating letter in '" + s + "' is " + firstLetterEasy);
	}
	
}
