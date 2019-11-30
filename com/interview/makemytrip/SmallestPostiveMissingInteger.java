package com.interview.makemytrip;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Finds the smallest positive missing integer in an array
 * 
 * @author gauravarora02
 *
 */
public class SmallestPostiveMissingInteger {

	public int getSmallestPositiveInteger(int[] arr) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int j = 0;

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] < min)
				min = arr[i];

			if (arr[i] > max)
				max = arr[i];

			set.add(arr[i]);
		}

		if (max < 0)
			return 1;

		for (j = min + 1; j < max; j++) {

			if (!set.contains(j))
				return j;
		}

		return max + 1;
	}

	public static void main(String[] args) {

		SmallestPostiveMissingInteger s = new SmallestPostiveMissingInteger();

		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { -1, -3 };
		int[] arr3 = { 1, 2, 3, 4, 6, 1 };

		System.out.println(s.getSmallestPositiveInteger(arr1));
		System.out.println(s.getSmallestPositiveInteger(arr2));
		System.out.println(s.getSmallestPositiveInteger(arr3));
	}

}
