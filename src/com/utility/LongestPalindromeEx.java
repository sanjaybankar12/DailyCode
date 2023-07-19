package com.utility;

import java.util.Map;
import java.util.TreeMap;

public class LongestPalindromeEx {

	public static int getLongestPalindromeLength(String str) {
		String longPalindrome = "";
		
		String[] arr = str.split("");
		Map<String, Integer> hm = new TreeMap<>();
		String el;
		StringBuilder mid = new StringBuilder();
		StringBuilder sideLetter = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			el = arr[i];
			hm.compute(el, (k, v) -> v == null ? 1 : v + 1);
		}
		
		hm.forEach((k, v) -> {
			if(v == 1) {
				mid.append(k);
			} else {
				if(v%2 != 0) {
					mid.append(k);
				}
				sideLetter.append(buildString(k,v/2));
			}
		});
		
		longPalindrome = sideLetter.toString() + (mid.length() > 0 ? mid.charAt(0) : "") + sideLetter.reverse().toString();				
		System.out.println(longPalindrome);
		//System.out.println(hm);
		return longPalindrome.length();
	}
	
	public static String buildString(String s, Integer value) {
		String str = "";		
		int val = value;
		while(val > 0) {
			str +=s;
			val--;
		}		
		return str;
	}
	
	public static void main(String[] args) {

		String s = "abccccdd";
		int length =getLongestPalindromeLength(s);
		System.out.println("Longest Palindrome Length : " + length);
	}

}
