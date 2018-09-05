package com.interview.multithreadingAndconcurrency.racecondition;

public class RaceCondition {

	
	public static void main(String[] args) throws InterruptedException {
		
		LongWrapper longWrapper = new LongWrapper(0L);
		
		Runnable r = () -> {
			
			for(int  i = 0; i < 1_000; i++) {
				longWrapper.incrementValue();
			}
		};
		
		//Thread t = new Thread(r);
		
		//t.start();
		
		//t.join();
		
		// Note- 1_000 is same as 1000
		
		// Race Condition
		Thread[] threads = new Thread[1_000];
		for(int i = 0; i < threads.length; i++) {
			
			threads[i] = new Thread(r);
			threads[i].start();
		}
		
		for(int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		
		// The final output should be 1000000 but due to race condition it never reaches that value
		// and final result is less than 1000000.
		
		// to solve this problem we use synchronization on the incrementValue method 
		
		System.out.println("Value : " + longWrapper.getValue());
		
	}
}
