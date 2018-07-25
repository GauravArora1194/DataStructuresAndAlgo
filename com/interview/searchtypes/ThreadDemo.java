package com.interview.searchtypes;

public class ThreadDemo extends Thread {

	
	public void run() {
		
		for(int i = 0; i <= 10; i++) {
			System.out.println("Thread : "+ Thread.currentThread().getName() + " " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		//join() method demo
		ThreadDemo t1 = new ThreadDemo();
		ThreadDemo t2 = new ThreadDemo();
		
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.start();
		
	}
}
