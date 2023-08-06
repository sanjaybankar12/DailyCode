package com.utility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramExample {
	
	public static boolean isAnagram(String s1, String s2) {
		
		int flag = 0;
		
		if(s1.length() != s2.length()) {
			flag = 1;
		} else {
			String[] arr1 = s1.split("");
			String[] arr2 = s2.split("");
			
			Map<String, Integer> hm1 = new HashMap<>();
			Map<String, Integer> hm2 = new HashMap<>();
			for(int i = 0; i < arr1.length; i++) {
				hm1.compute(arr1[i], (k, v) -> (v == null) ? 1 : v + 1); 
				hm2.compute(arr2[i], (k, v) -> (v == null) ? 1 : v + 1); 
			}
						
			for(Map.Entry<String, Integer> data : hm1.entrySet()) {
				if(data.getValue() != hm2.get(data.getKey())) {
					flag = 1;
					break;
				}
			}
		}
		
		if(flag == 0) 
			return true;
		else		
			return false;
	}
	
	public static boolean isAnagramStr(String s1, String s2) {
		
		if(s1.length() != s2.length()) {
			return false;
		} else {			
			Map<String, Long> hm1 = Arrays.asList(s1.split("")).stream().collect(Collectors.groupingBy(String::new, Collectors.counting()));
			Map<String, Long> hm2 = Arrays.asList(s2.split("")).stream().collect(Collectors.groupingBy(String::new, Collectors.counting()));
			
			long count = hm1.entrySet().stream().takeWhile(e -> {
				if(e.getValue() != hm2.get(e.getKey())) {
					return false;
				} else {
					return true;
				}
					
			}).count();
						
			if(count == hm1.size())
				return true;
			else
				return false;			
		}	
	}

	public static void main(String[] args) {

		boolean val = isAnagramStr("fired","fried");
		System.out.println("isAnagram = "+ val);
		
	}

}
