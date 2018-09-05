package com.interview.multithreadingAndconcurrency.deadlock;

public class DeadLock {

	
	public static void main(String[] args) throws InterruptedException {
		
		Demo demo = new Demo();
		
		Runnable r1 = () -> demo.a();
		Runnable r2 = () -> demo.b();
		
		Thread t1 = new Thread(r1);
		t1.start();
		
		Thread t2 = new Thread(r2);
		t2.start();
		
		t1.join();
		t2.join();
				
	}
	
}
