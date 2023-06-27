package com.utility;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringFinder {
	
	//Longest Substring Without Repeating Characters
	public static String findLongestSubstring(String s) {
		int largeSubstringLength = 0;
		String largeSubstring = "";
		
		String[] arr = s.split("");
		Set<String> hs = new HashSet<>();
		String str = "";
		for(int i = 0; i < arr.length; i++) {
			String el = arr[i];
			boolean val = hs.add(el);
			if(val) {
				str = str + el;
			} else {
				if(largeSubstringLength < str.length()) {
					largeSubstringLength = str.length();
					largeSubstring = str;
				}
				hs.clear();
				hs.add(el);
				str = el;
			}
		}
		return largeSubstring;
	}

	public static void main(String[] args) {

		String inputStr = "abcabcbb";
		String inputStr1 = "bbbbb";
		String inputStr2 = "pwwkew";
		
		String largeSubstring = findLongestSubstring(inputStr);
		System.out.println(largeSubstring);				
	}

}
