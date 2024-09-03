package com.interview.hashing;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

// operations on concurrent hash map are not Atomic
// also null keys are not allowed in concurrent hash map.
public class ConcurrentHashMapDemo {

	// here we will use AtomicLong instead of Long to avoid the errors due to concurrency
	// AtomicLong ensures that the write operation is performed before any read operation.
	
	static Map<String, AtomicLong> orders = new ConcurrentHashMap<>();
	
	static void processOrders() {
		
		for(String city : orders.keySet()) {
			
			for(int i = 0; i < 50; i++) {
				
				//Long oldOrder = orders.get(city);
				//orders.put(city, oldOrder + 1);
				
				orders.get(city).getAndIncrement();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		//orders.put("Bombay", 0l);
		//orders.put("Beijing", 0l);
		//orders.put("London", 0l);
		//orders.put("New York", 0l);
		
		orders.put("Bombay", new AtomicLong());
		orders.put("Beijing", new AtomicLong());
		orders.put("London", new AtomicLong());
		orders.put("New York", new AtomicLong());
				
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.submit(ConcurrentHashMapDemo :: processOrders);
		
		executor.submit(ConcurrentHashMapDemo :: processOrders);
		
		executor.awaitTermination(1, TimeUnit.SECONDS);
		
		executor.shutdown();
		
		System.out.println(orders);
		
		
	}
}
