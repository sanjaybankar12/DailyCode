package com.stream.bi;

import java.util.*;
import java.util.function.BiConsumer;

public class BiConsumerExample implements BiConsumer<String, Integer> {

	@Override
	public void accept(String s, Integer d) {
		System.out.println(s + " " + d);
	}
	
	public static void main(String[] args) {
		//Step-1
		BiConsumer<String, Integer> bc = new BiConsumerExample();
		bc.accept("Sam", 4500);
		
		//Step-2
		BiConsumer<String, Integer> bc1 = (s, d) -> System.out.println(s + ":" + d);
		bc1.accept("adi", 1200);
		
		//Step-3 we can use for map as well 
		Map<String, Integer> map = new HashMap<>();
		map.put("Adi", 2000);
		map.put("Ravi", 3000);
		map.put("Saks", 2500);
		//BiConsumer in forEach
		map.forEach((k, v) -> System.out.println(k +" : "+v));
		
		//Step-4 
		map.compute("Adi", (k, v) -> v + 500);
		System.out.println(map);
	}

}
