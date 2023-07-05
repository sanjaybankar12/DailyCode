package com.multithreading.countdownlatch;

public class Breakfast extends Thread {

	public Breakfast(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
