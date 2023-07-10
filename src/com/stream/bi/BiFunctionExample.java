package com.stream.bi;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionExample implements BiFunction<List<Integer>, List<Integer>, List<Integer>> {

	@Override
	public List<Integer> apply(List<Integer> list1, List<Integer> list2) {
		return Stream.of(list1, list2).flatMap(List::stream).distinct().sorted().collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(4,2,5,4,6,8);
		List<Integer> list2 = Arrays.asList(1,2,7,5,6,9);
	
		BiFunction<List<Integer>, List<Integer>, List<Integer>> bf = (l1, l2) -> Stream.of(l1, l2).flatMap(List::stream).distinct().sorted().collect(Collectors.toList());
		
		System.out.println(bf.apply(list1, list2));
		
		Map<String, Integer> map = new HashMap<>();
		map.put("sam", 4500);
		map.put("ravi", 1500);
		
		BiFunction<String, Integer, Integer> bf1 = (key, value) -> value + 500;
		map.replaceAll(bf1);
		System.out.println(map);
	}

}
