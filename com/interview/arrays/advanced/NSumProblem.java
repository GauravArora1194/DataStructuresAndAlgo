package com.interview.arrays.advanced;

// Find the number of ways to add up to a sum N using first N Natural numbers.
// e.g for n = 3, o/p =4

// [1+1+1], [1+2], [2+1], [3] 

public class NSumProblem {

	static int count = 0;
	
	public static void findWays(int n, int sum, String str) {
		
		if(sum == 0) {
			count++;
			System.out.println(count + "." + "[ "+ str + "]");
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			
			if(i <= sum) {
				findWays(n, sum - i, str + i + " ");
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int n = 3;
		
		findWays(n, n, "");
	}
	
}
