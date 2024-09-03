package com.interview.questions;

import java.util.Scanner;

public class VolatileKeyword {
	
	public static void main(String[] args) {
		
		Counter c = new Counter();
		c.start();
		
		Scanner stopCount = new Scanner(System.in);
		stopCount.nextLine();
		
		c.stopCounting();
		
		stopCount.close();
		
	}
	

}

class Counter extends Thread{
	
	private volatile boolean counting = true;
	
	private int counter = 1;
	
	public void run() {
		
		while(counting) {
			System.out.println(counter);
			counter++;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopCounting() {
		counting = false;
	}
}


//Volatile keyword guarantees Visibility
// when the thread is created it copies the value of all accessible variables in its own memory

//the volatile keyword is used to say to the jvm "warning", that this variable may be modified in another thread.
//and the same value of the variable can be shared across all threads.

//the volatile keyword can be used on any kind of  variable, either primitive or objects.