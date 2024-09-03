package com.interview.dynamic.programming;

public class FibonacciTabulated {

	
	public static int fibonacci(int n) {
		
		int[] f = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		
		for(int x = 2 ; x <= n; x++) {
			f[x] = f[x-1] + f[x-2];
		}
		
		return f[n];
	}
	
	public static void main(String[] args) {
		
		int n = 43 ;
		long startTime = System.currentTimeMillis();
		System.out.println(fibonacci(n));
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken : " +(endTime - startTime));
		
	}
}
