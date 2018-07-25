package com.interview.questions;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
	
	//Using sieve of eratosthenes method
	
	
	public static List<Integer> getPrimeNumbers(int n) {
		
		Boolean[] arr = new Boolean[n+1];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = true;
		}
		List<Integer> list = new ArrayList<>();
		
		for(int i = 2 ; i*i <= n; i++) {
			
			if(arr[i] == true) {
				
				for(int j = 2*i; j <= n; j = j + i) {
					
					arr[j] = false;
				}
				
			}
			
		}
		
		for(int i = 2 ; i <= n ; i++) {
			
			if(arr[i] == true)
				list.add(i);
		}
		
		
		return list;
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = getPrimeNumbers(30);
		
		for(int i : list) {
			System.out.print(i + " " );
		}
	}
	
	

}
