package com.interview.recursion;

public class HackerRackQues {
	
	// another approach is using below formula-
	// A(n) = A(n - 1) + A(n - 2) + A(n - 3)
	// A(1)=1; A(2)=2; A(3)=4. (Set this as default and calculate for others using this.)
	
	static int[] arr = {1,2,3};
    static int count = 0;
    static int sum = 0;
    // Complete the stepPerms function below.
    static int stepPerms(int n) {

        if(sum == n){
            count++;
            return count;
        }
        
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            if(sum <= n)
                stepPerms(n);
            sum = sum - arr[i];
        }

        return count;
    }

    

    public static void main(String[] args) {
        System.out.println(stepPerms(5));
        
    }

}
