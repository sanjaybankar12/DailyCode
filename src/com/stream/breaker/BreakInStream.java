package com.stream.breaker;

import java.util.Arrays;
import java.util.List;

public class BreakInStream {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,2,5,6,3,8,9,7);
		
		//Java 9's takeWhile
		//It will continue to execute till takeWhile condition becomes fail
		list.stream().takeWhile(n -> n < 5).forEach(System.out::println);
		
		//Java 8 uses splitIterator
		
		
	}

}
