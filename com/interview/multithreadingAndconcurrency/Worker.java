package com.interview.multithreadingAndconcurrency;

import java.util.Timer;
import java.util.TimerTask;

public class Worker  extends Thread {
	
	private Object lock = new Object();

	private volatile boolean quittingTime = false;
	
	public void run() {
		
		while(!quittingTime) {
			working();
			System.out.println("Still working ...");
		}
		
		System.out.println("Coffee is good !");
	}
	

	private void working() {
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	synchronized void quit() throws InterruptedException {
		synchronized (lock) {
			quittingTime = true;
			join();
		}
	}
	
	

	synchronized void keepWorking() {
		synchronized (lock) {
			quittingTime = false;
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		final Worker worker = new Worker();
		
		worker.start();
		
		Timer t = new Timer(true);  // Daemon Thread
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				worker.keepWorking();
			}
		}, 500);
		
		Thread.sleep(400);
		worker.quit();
	}


	
}
