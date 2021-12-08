package com.interview.flipkart;

public class CandiesProblem {
	
	//hackerrank problem-
	// link -> https://www.hackerrank.com/challenges/candies/problem
	
	
	 // Complete the candies function below.
    static long candies(int n, int[] arr) {

        int[] countArr = new int[arr.length];
        long sum = 0;
        
        for(int i = 0 ; i < arr.length; i++)
            countArr[i] = 1;
        
        //traversing left to right
        for(int i = 1 ; i < arr.length; i++){
            if(arr[i] > arr[i-1])
                countArr[i] = countArr[i-1] + 1;
        }
        
        //traversing right to left
        for(int i = arr.length -2 ; i >= 0; i--){
            if(arr[i] > arr[i+1] && countArr[i] <= countArr[i+1])
                countArr[i] = countArr[i+1] + 1;
                
        }
        
        
        //counting sum;
        for(int i : countArr)
            sum = sum + i;

        return sum;
    }

}
