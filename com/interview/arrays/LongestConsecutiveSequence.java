package com.interview.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 * 
 * 
 * Input: nums = [100,4,200,1,3,2] Output: 4 Explanation: The longest
 * consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * @author gauravarora02
 *
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		int[] arr = { 100, 4, 200, 1, 3, 2 };

		System.out.println(longestConsecutive(arr));
		System.out.println(longestConsecutive1(arr));
	}

	// Using sorting, time complexity - O(nlogn)
	public static int longestConsecutive1(int[] nums) {

		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}

		Arrays.sort(nums);

		int longest = 1;
		int current = 1;

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] != nums[i - 1]) {

				if (nums[i] == nums[i - 1] + 1) {
					current++;
				} else {

					longest = Math.max(longest, current);
					current = 1;
				}
			}
		}

		return Math.max(longest, current);
	}

	// Using set, time complexity - O(n)
	public static int longestConsecutive(int[] nums) {

		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}

		int longest = 1;

		Set<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num);
		}

		for (int num : set) {

			int current = 1;
			if (!set.contains(num - 1)) {

				while (set.contains(num + 1)) {
					current++;
					num++;
				}

				longest = Math.max(longest, current);
			}
		}

		return longest;

	}
}
