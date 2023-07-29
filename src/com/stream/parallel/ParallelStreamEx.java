package com.stream.parallel;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Sequential stream execute all the tasks in single core of processor whereas
 * Parallel Stream execute all tasks in separate core of processor
 */
public class ParallelStreamEx {

	public static void main(String[] args) {

		long start = 0;
		long end = 0;
		
		start = System.currentTimeMillis();
		IntStream.range(1, 10).forEach(n -> {
			System.out.println(Thread.currentThread().getName() + " : " + n);
		});
		end = System.currentTimeMillis();
		System.out.println("\nSequential stream time : " + (end - start));
		
		start = System.currentTimeMillis();
		IntStream.range(1, 10).parallel().forEach(n -> {
			System.out.println(Thread.currentThread().getName() + " : " + n);
		});
		end = System.currentTimeMillis();
		System.out.println("\nParallel stream time : " + (end - start));
		
		
		int[] arr = {1,10,42,1,0,1,0,2,2,2,5,6,6,8,9,9,4,5,6,4,8,5};
		Arrays.stream(arr).parallel().forEach(n -> System.out.println(Thread.currentThread().getName() + " : " + n));
		
		
		
	}

}
