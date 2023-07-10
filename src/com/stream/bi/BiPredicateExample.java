package com.stream.bi;

import java.util.function.BiPredicate;

public class BiPredicateExample implements BiPredicate<String, String> {

	public boolean test(String s1, String s2) {
		return s1.equals(s2);
	}
	
	public static void main(String[] args) {
		//Step-1
		BiPredicate<String, String> bip = new BiPredicateExample();
		System.out.println(bip.test("sam", "sam"));
		
		//Step-2
		BiPredicate<String, String> bip1 =  (s1, s2) -> s1.equals(s2);
		System.out.println(bip1.test("sam", "sam"));
	}

}
