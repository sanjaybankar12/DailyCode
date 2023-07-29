package com.stream;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamMapOperations {

	/**
	 * If we use HashMap/TreeMap then by default, it will be sort Map by it's key in
	 * ascending order. LinkedHashMap will preserve insertion order.
	 * 
	 * @return
	 */
	public static Map<String, Integer> sortMapByKey(Map<String, Integer> hm) {

		Map<String, Integer> lhm = hm.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(e1 -> e1.getKey(), e2 -> e2.getValue()));

		return lhm;
	}

	public static Map<String, Integer> sortMapByValue(Map<String, Integer> hm) {

		return hm.entrySet().stream().sorted(Map.Entry.comparingByValue((o1, o2) -> o2.compareTo(o1)))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (t, u) -> u, LinkedHashMap::new));
	}

	public static Map<String, Integer> convertListToMap(List<String> list) {
		return list.stream().collect(Collectors.toMap(t -> t.split(":")[0], t -> Integer.valueOf(t.split(":")[1]),
				(t, u) -> u, TreeMap::new));
	}

	public static void main(String[] args) {

		Map<String, Integer> hm = new LinkedHashMap<>();
		hm.put("C", 10);
		hm.put("E", 15);
		hm.put("A", 19);
		hm.put("G", 11);
		hm.put("B", 18);
		hm.put("D", 12);
		hm.put("F", 16);

		System.out.println("Actual Map key-value : " + hm);

		Map<String, Integer> sortedMapByKey = sortMapByKey(hm);
		System.out.println("Sorted Map By Key   : " + sortedMapByKey);

		Map<String, Integer> sortedMapByValuey = sortMapByValue(hm);
		System.out.println("Sorted Map By Value : " + sortedMapByValuey);

		List<String> list = new ArrayList<>();
		list.add("a:1");
		list.add("c:4");
		list.add("l:5");
		list.add("m:3");
		list.add("e:2");

		Map<String, Integer> listMap = convertListToMap(list);
		System.out.println(listMap);
	}

}
