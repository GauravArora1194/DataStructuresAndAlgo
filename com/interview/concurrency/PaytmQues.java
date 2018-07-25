package com.interview.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PaytmQues {

	
	public static void main(String[] args) {
		
		
		Runnable r1 = ( ) -> {
			
			System.out.print("1");
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Runnable r2 = ( ) -> {
			
			System.out.print("2");
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Runnable r3 = ( ) -> {
			
			System.out.print("3");
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		// Same as above
		//ExecutorService executor = Executors.newFixedThreadPool(1);
		
		int i = 0;
		while(i != 10) {
			
			executor.submit(r1);
			executor.submit(r2);
			executor.submit(r3);
			i++;
		}
		
		executor.shutdown();
				
	}
}
