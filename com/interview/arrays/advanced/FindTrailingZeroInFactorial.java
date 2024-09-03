package com.interview.arrays.advanced;

public class FindTrailingZeroInFactorial {
	
	// count the number of zeros at the end of factorial of a number n.
	
	
	//Trailing 0s in n! = Count of 5s in prime factors of n!
    		//= floor(n/5) + floor(n/25) + floor(n/125) + ....
	
	
	public static int countZeros(int num) {
		
		int count = 0;
		 
		for(int i = 5; num/ i >= 1; i = i * 5) {
			count = count + num / i;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		int num = 100;
		
		System.out.println("Number of trailing 0s in " + num + "! is : " + countZeros(num));
	}

}
