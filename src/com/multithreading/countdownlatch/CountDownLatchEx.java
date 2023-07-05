package com.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Count down latch is used to execute group of threads before other threads.
 *
 * Breakfast threads should not get call before bath
 */

public class CountDownLatchEx {

	public static void main(String[] args) throws InterruptedException {
		
		//Create CountDownLatch for 2 threads
		CountDownLatch countDownLatch = new CountDownLatch(2);
		
		//Assign count down latch for 2 threads
		Bath bath1 = new Bath(countDownLatch, "Person A Bath");
		Bath bath2 = new Bath(countDownLatch, "Person B Bath");
		bath1.start();
		bath2.start();
		
		//imp method: this will allow current thread to wait until count down latch reached to 0. 
		countDownLatch.await();
		
		//Normal Threads
		Breakfast bf1 = new Breakfast("Person A Breakfast");
		Breakfast bf2 = new Breakfast("Person B Breakfast");
		bf1.start();
		bf2.start();
	}

}
