package com.multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Passenger extends Thread {

	private CyclicBarrier cyclicBarrier;
	private long duration;
	
	public Passenger(CyclicBarrier cyclicBarrier, String name, long duration) {
		super(name);
		this.cyclicBarrier = cyclicBarrier;
		this.duration = duration;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(duration);
			System.out.println(Thread.currentThread().getName() + " arrived");
			
			int partiesCount = this.cyclicBarrier.await();
			if(partiesCount == 0) {
				System.out.println("4 Passenger boarded Vehicle can start now.");
			}
		} catch(InterruptedException | BrokenBarrierException be) {
			be.printStackTrace();
		}
	}
}
