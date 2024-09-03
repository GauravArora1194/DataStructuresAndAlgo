package com.interview.questions;

import java.util.HashMap;
import java.util.Map;

public class Factorial {

	static int getFactorial(int num) {
		
		if(num == 0) {
			return 1;
		}
		
		int fact = num * getFactorial(num-1);
		
		return fact;
	}
	
	
	public static int check(int i, int[] arr) {
	
		int count = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int j : arr) {
			if(!map.containsKey(j)) {
				map.put(j, 1);
			}else {
				map.put(j, map.get(j)+1);
			}
		}
		
		for(int k = 1; k<= i; k++) {
			
			if(map.get(k) == null) {
				count++;
			}
			/*else if(map.get(k) != 1) {
			
				count++;
			}*/
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		int num = 5;
		int[] arr = {3,2,1};
		System.out.println("Factorial of " + num + " is : " + getFactorial(num));
		System.out.println(check(3, arr));
	}
}
