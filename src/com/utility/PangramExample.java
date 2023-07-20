package com.utility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * String contains all the 26 alphabets
 *
 */
public class PangramExample {
	
	public static boolean isPangram(String s) {
		boolean isPangram = false;
		
		String el;
		String[] arr = s.split("");
		HashSet<String> hs = new HashSet<>();
		for(int i = 0; i < arr.length; i++) {
			el = arr[i];
			if(el != null && !el.trim().equals("")) {
				hs.add(el.toLowerCase());
			}
		}
		if(hs.size() == 26) {
			isPangram = true;
		}		
		return isPangram;
	}
	
	public static boolean isPangramUsingStream(String s) {
		boolean isPangram = false;
	
		List<String> list = Arrays.asList(s.split(""));
		long ct = list.stream().filter(t -> (t != null && !t.trim().equals(""))).map(t -> t.toLowerCase()).distinct().count();
		if(ct == 26) {
			isPangram = true;
		}
		return isPangram;
	}

	public static void main(String[] args) {

		String s = "The quick brown fox jumps over the lazy dog";
		String s2 = "the five boxing wizards jump quickly";
		boolean val = isPangramUsingStream(s);
		if(val) {
			System.out.println("\"" + s2 + "\" is Pangram");
		}
	}

}
