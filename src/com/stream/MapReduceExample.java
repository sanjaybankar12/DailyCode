package com.stream;

import java.util.Arrays;
import java.util.List;

public class MapReduceExample {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(10,5,6,8,9,6,2);
		
		Integer maxNum = list.stream().reduce(0,(a, b) -> a > b ? a : b);
		System.out.println("Max = " + maxNum);
		
		Integer minNum = list.stream().reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
		System.out.println("Min = " + minNum);

		Integer sum = list.stream().reduce(0, (a, b) -> a + b);
		System.out.println("Sum = " + sum);
		
		Integer sumN = list.stream().reduce(0, Integer::sum);
		System.out.println("Sum = " + sumN);

		
		List<Integer> listnew = list.stream().map(n -> n*2).toList();
		System.out.println(listnew);

		System.out.println("--------------------------------------------");
		List<String> listStr = Arrays.asList("10","5","6","8","9","6","2");
		System.out.println(listStr);
		int tot = listStr.stream().mapToInt(n -> Integer.parseInt(n)).filter(num -> num % 2 == 0).sum();
		System.out.println("Total sum of even numbers = " + tot);

	}

}
