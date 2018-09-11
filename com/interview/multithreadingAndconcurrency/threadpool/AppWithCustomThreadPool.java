package com.interview.multithreadingAndconcurrency.threadpool;


public class AppWithCustomThreadPool {

	public static void main(String[] args) {
		
		CustomThreadPool pool = new CustomThreadPool(2);
		
		Task t1 = new Task();
		Task t2 = new Task();
		Task t3 = new Task();
		
		
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		
		pool.shutdown();
		
		System.out.println("All Task Completed");
		
	}
	
}

class Task implements Runnable {

	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
