package com.utility;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NumberByCountAndOrderByCount {
	
	public static Map<Integer, Integer> numberByCount(List<Integer> list) {
		Map<Integer, Integer> hm = new HashMap<>();
		for(Integer num : list) {
			hm.compute(num, (k, v) -> (v == null) ? 1 : v+1);
		}
		return hm;
	}
	
	public static Map<Integer, Integer> orderByCount(Map<Integer, Integer> hm) {
		List<Map.Entry<Integer, Integer>> list = new LinkedList<>(hm.entrySet());
		Collections.sort(list, (o1,o2) -> o2.getValue().compareTo(o1.getValue()));
		
		Map<Integer, Integer> finalMap = new LinkedHashMap<>();
		for(Map.Entry<Integer, Integer> data : list) {
			finalMap.put(data.getKey(), data.getValue());
		}
		return finalMap;
	}	
	
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(7,4,5,4,10,7,5,5,5,6,6);
		Map<Integer, Integer> hm = numberByCount(list);
		System.out.println("Number by count : " + hm);
		
		hm = orderByCount(hm);
		System.out.println("Sorted By count : " + hm);
	}
}
