package com.interview.arrays;

import java.util.ArrayList;
import java.util.List;

public class HackerRankQues {
	
	
	
	static void dynamicArray(int n, int[][] queries) {
        /*
         * Write your code here.
         */
        
        
            List<List<Integer>> seqList = new ArrayList<List<Integer>>(); 
            
            for(int i = 0 ; i < n; i++) {
            	seqList.add(i, new ArrayList<Integer>());
            }
        
        int lastAnswer = 0;
        for(int i = 0 ; i < queries.length; i++ ){
            
            int queryNumber = queries[i][0];
            int x = queries[i][1];
            int y = queries[i][2];
            
            int seq = (x ^ lastAnswer) % n;
            
            if(queryNumber == 1){
                seqList.get(seq).add(y);
            }else{
                int size = seqList.get(seq).size();
                int index = y % size;
                lastAnswer = seqList.get(seq).get(index);
                //result[j] = lastAnswer;
                //j++;
                System.out.println(lastAnswer);
            }
            
            
        }
        
    }


	public static void main(String[] args) {
		
		
		int[][] arr = {{1,0,5}, {1,1,7}, {1,0,3}, {2,1,0}, {2,1,1}};
		
		dynamicArray(2, arr);
		
	}
	
}
