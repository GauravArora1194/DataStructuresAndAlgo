package com.interview.multithreadingAndconcurrency.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {

	
	private final int threadCount;
	private final LinkedBlockingQueue<Runnable> queue;
	private final poolWorker[] threads;
	
	
	
	public CustomThreadPool(int threadCount) {
		
		this.threadCount = threadCount;
		queue = new LinkedBlockingQueue<>();
		threads = new poolWorker[this.threadCount];
		
		for(int i = 0; i < threadCount; i++) {
			threads[i] = new poolWorker();
			threads[i].start();
		}
	}
	
	public void execute(Runnable task) {
		synchronized (queue) {
			
			queue.add(task);
			queue.notify();
		}
	}
	
	
	// Shuts down the executor after executing all the task
	public void shutdown() {
		
		for(int i = 0; i < threadCount; i++ ) {
			
			threads[i].terminate();
		}
	}
	
	
	private class poolWorker extends Thread {
		
		private boolean isRunning = true;
		
		@Override
		public void run() {
			
			Runnable task;
			
			while(true && isRunning) {
				
				synchronized (queue) {
					
					while(queue.isEmpty()) {
						
						try {
							queue.wait();
						} catch (InterruptedException e) {
							//e.printStackTrace();
							System.out.println("An Error occurred while queue is waiting : " + e.getMessage());
						}
					}
					
					task = queue.poll();
				}
				
				// If we don't catch RuntimeException
				// the pool could leak threads
				try {
					task.run();
				} catch (RuntimeException e) {
					System.out.println("Thread pool is interrupted due to an issue : " + e.getMessage());
				}
			}
		}
		
		
		public void terminate() {
			while(!queue.isEmpty()) {}
			
			this.isRunning = false;
		}
	}
	
}
