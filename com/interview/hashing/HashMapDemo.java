package com.interview.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class HashMapDemo {

	
	public static void main(String[] args) {
		
		// with hashmap size remains same even after garbage collection.
		//Map<Order, Integer> map = new HashMap<>();
		
		// with this size changes to 0 after garbage collection
		Map<Order, Integer> map = new WeakHashMap<>();
		
		map.put(new Order(3, "order3"), 100);
		map.put(new Order(4, "order4"), 200);
		
		System.out.println(map.size());
		
		System.gc();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(map.size());
	}
}


class Order{
	
	int orderId;
	String details;
	
	Order(int orderId, String details){
		
		this.orderId = orderId;
		this.details = details;
	}
}
