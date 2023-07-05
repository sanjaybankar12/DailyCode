package com.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Bath extends Thread {

	private CountDownLatch countDownLatch;
	
	public Bath(CountDownLatch countDownLatch, String name) {
		super(name);
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.countDownLatch.countDown();
	}
	
}
