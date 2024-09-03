package com.interview.arrays.advanced;

public class StockBuySellProbelm {

	
	public static int findMaxProfit(int[] arr) {
		
		int n = arr.length;
		
		int i = 0;
		int startIndex = 0;
		int endIndex = 0;
		
		int sum = 0;
		int count = 0;
		
		while(i < n - 1) {
			
			while(i < n - 1 && arr[i+1] <= arr[i])
				i++;
			
			if(i == n)
				break;
			else
				startIndex = i++;
			
			while(i < n && arr[i] >= arr[i-1])
				i++;
			
			endIndex = i - 1;
			
			sum = sum + arr[endIndex] - arr[startIndex];
			count++;
		}
		
		if(count == 0)
			return 0;
		else
			return sum;
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {100, 180, 260, 310, 40, 535, 695};
		
		int[] arr1 = {23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
		
		System.out.println(findMaxProfit(arr)); // 310-100 = 210 + (695 - 40)
		
		System.out.println(findMaxProfit(arr1)); //20 + 48
	}
}
