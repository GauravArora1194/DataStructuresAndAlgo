package com.interview.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayConcepts {

	public static void main(String[] args) {

		
		
		int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(arr.length);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

		for (int i : arr) {
			System.out.print(i);
		}

		
		System.out.println("\n" + arr.getClass().getName());

		// An Object copy is usually called a clone.
		// A shallow copy of an object copies the main object but doesn't copy the inner
		// object.The ‘inner objects’ are shared between the original object and its copy.
		// A deep copy of an object copies inner object as well i.e a new independent
		// object is created.

		// for one dimensional array deep copy is created and for multidimensional array
		// shallow copy is created.
		
		//If a class does not implement Cloneable interface then 'shallow' copy is created.
		
		// For class implementing Cloneable interface deep copy is created

		int[] cloneArray = arr.clone();

		System.out.println(cloneArray == arr);
		System.out.println(cloneArray.getClass().getName());
		System.out.println(cloneArray.getClass() == arr.getClass());
		System.out.println(cloneArray.equals(arr));
		
		
		//deep copy is created
		cloneArray[0] =100;
		System.out.println(arr[0] + " . " + cloneArray[0]);
		
		Map<String, String> map = new HashMap<>();
		
		map.put("name", "gaurav");
		map.put("id", "q1");
		map.put("email", "abc@gmail.com");
		map.put("name", "Rahul");
		System.out.println(map);
		
		Set<String> set = new HashSet<>();
		
		set.add("abc");
		set.add("bcd");
		set.add("cfr");
		set.add("abc");
		set.add("cfr");
		
		System.out.println(set);
		

	}

}
