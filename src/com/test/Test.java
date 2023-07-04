package com.test;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
	

	public static void main(String[] args) {

		String str = "I am Sanjay BankarZZZZZZ";
		List<String> list = new ArrayList<>(Arrays.asList(str.split("")));
		int maxCount = 0, count = 0;
		String maxEl = "";
		for(int i = 0; i < list.size(); i++) {
			String el = list.get(i);
			count = Collections.frequency(list, el);
			if(maxCount < count) {
				maxCount = count;
				maxEl = el;
			}
		}
		System.out.println(maxEl);
		
		
		Map<String, Integer> hm = new HashMap<>();
		list.stream().forEach(i -> {
			hm.compute(i, (k, v) -> v == null ? 1 : v+1);
			});
		System.out.println(hm);
		for(int i = 0; i < list.size(); i++) {
			String el = list.get(i);
			hm.compute(el, (k, v) -> v == null ? 1 : v+1);
		}
		//System.out.println(hm);
	}

}
