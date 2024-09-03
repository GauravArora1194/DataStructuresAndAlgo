package com.interview.dynamic.programming;

public class FibonacciMemoization {

	
	public static int fibonacci(int n, int[] memoizedArr) {
		
		if(n == 0 || n == 1) {
			return n;
		}
		
		if(memoizedArr[n] != 0) {
			return memoizedArr[n];
		}
		
		int fnm1 = fibonacci(n-1, memoizedArr);
		int fnm2 = fibonacci(n-2, memoizedArr);
		
		int fn = fnm1 + fnm2;
		
		memoizedArr[n] = fn;
		return fn;
	}
	
	public static void main(String[] args) {
		
		int n = 43;
		long startTime = System.currentTimeMillis();
		System.out.println(fibonacci(n, new int[n+1]));
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken : " + (endTime - startTime));
	}
}
