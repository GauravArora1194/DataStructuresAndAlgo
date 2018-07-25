package com.interview.dynamic.programming;

public class CoinChangeMemoized {

	// counts the number of ways in which we can pay a amount using coins of different denominations.
	
	
	public static long countWays(int[] coins, int amt) {
		
		long[] countArr = new long[amt+1];
		
		countArr[0] = 1;
		
		for(int i = 0; i < coins.length; i++) {
			
			for(int j = coins[i]; j <= amt; j++) {
				
				countArr[j] = countArr[j] + countArr[j-coins[i]];
			}
		}
		
		
		return countArr[amt];
	}
	
	
	public static void main(String[] args) {
		
		int[] coins = {2,3,5,6};
		int amt = 10;
		
		System.out.println("Total number of ways : " + countWays(coins, amt));
		
		
	}
}
