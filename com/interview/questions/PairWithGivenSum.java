package com.interview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Using hashing
public class PairWithGivenSum {

	public static void findPair(int[] arr, int sum) {

		if (arr.length < 2) {
			return;
		}

		HashSet<Integer> set = new HashSet<>(arr.length);

		for (int n : arr) {

			int target = sum - n;

			if (!set.contains(target)) {
				set.add(n);
			} else {
				System.out.println("{" + n + " , " + target + " }");
			}

		}

	}

	public static int[][] pairSum(int[] arr, int s) {
        // Write your code here.
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Pair> pairs = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            
            if(map.containsKey(s - arr[i])) {
                int count = map.get(s - arr[i]);
                map.put(arr[i], map.get(s - arr[i]) + 1);
                while(count != 0) {
                    pairs.add(new Pair(s - arr[i], arr[i]));
                    count--;
                }
                
                
            } else {
                map.put(arr[i],  1);
            }
        }
        
        if(pairs.size() == 0) {
            return new int[0][0];
        } else {
            int[][] result = new int[pairs.size()][2];
            int k = 0;
            Collections.sort(pairs);
            for (int i = 0; i < pairs.size() ; i++) {
                
                Pair p = pairs.get(i);
                result[k][0] = p.getLeftIndex() > p.getRightIndex() ? p.getRightIndex() : p.getLeftIndex();
				result[k][1] = p.getLeftIndex() > p.getRightIndex() ? p.getLeftIndex() : p.getRightIndex();
                k++;
            }
            
            return result;
        }
        
    }
	
	static class Pair implements Comparable<Pair> {

		private int leftIndex;
		private int rightIndex;

		Pair(int leftIndex, int rightIndex) {
			this.leftIndex = leftIndex;
			this.rightIndex = rightIndex;
		}

		public int getLeftIndex() {
			return this.leftIndex;
		}

		public int getRightIndex() {
			return this.rightIndex;
		}

		@Override
		public int compareTo(Pair o) {

			return this.leftIndex - o.leftIndex;
		}
	}

	public static void main(String[] args) {

		int[] arr = { 0, 14, 0, 4, 7, 8, 3, 5, 7 };

		findPair(arr, 11);

		int[] arr1 = { 1,2,3,4,5};

		System.out.println(pairSum(arr1, 5));

	}
}
