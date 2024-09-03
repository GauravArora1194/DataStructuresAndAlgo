package com.interview.dynamic.programming;

public class KnapSackProblem {

	public static int knapSack(int w, int[] wt, int[] val, int n) {
		
		int i, j;
		int[][] k = new int[n+1][w+1];
		
		// build table in bottom up manner
		for(i = 0; i <= n; i++) {
		
			for(j = 0; j <= w; j++) {
				
				if(i == 0 || j == 0)
					k[i][j] = 0;
				else if(wt[i-1] <= j)
					k[i][j] = Math.max(val[i-1] + k[i-1][j - wt[i-1]], k[i-1][j]);
				else
					k[i][j] = k[i-1][j];
			}
			
		}
		
		return k[n][w];
	}
	
	public static void main(String[] args) {
		
		
		 int val[] = new int[]{60, 100, 120};
		 int wt[] = new int[]{10, 20, 30};
		 int  W = 50;
		 int n = val.length;
		 System.out.println(knapSack(W, wt, val, n));
		    
	}
}
