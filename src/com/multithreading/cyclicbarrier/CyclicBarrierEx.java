package com.multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Cyclic Barrier is used in synchronize environment where we can run group of threads before other threads.
 * Cyclic Barrier is similar with Count down latch where we can used cyclic barrier instead of count own latch 
 * but vice versa not possible.
 * Count down latch can not be restart once it reaches to zero
 * but Cyclic barrier can break the barrier and start again if we assign more tasks.
 */
public class CyclicBarrierEx {

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
		
		Passenger p1 = new Passenger(cyclicBarrier, "P1", 2000);
		Passenger p2 = new Passenger(cyclicBarrier, "P2", 2000);
		Passenger p3 = new Passenger(cyclicBarrier, "P3", 2000);
		Passenger p4 = new Passenger(cyclicBarrier, "P4", 2000);
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
		
		Passenger p5 = new Passenger(cyclicBarrier, "P5", 3000);
		Passenger p6 = new Passenger(cyclicBarrier, "P6", 4000);
		Passenger p7 = new Passenger(cyclicBarrier, "P7", 3000);
		Passenger p8 = new Passenger(cyclicBarrier, "P8", 3000);
		
		p5.start();
		p6.start();
		p7.start();
		p8.start();
			
	
	}
}
