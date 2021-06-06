package com.interview.arrays;

public class RemoveDuplicateFromSortedArr {

	public static int removeDuplicates(int[] nums) {

		if (nums.length == 0)
			return 0;
		int prev = nums[0], count = 1, indx = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == prev && count > 1) {
				while ((i + 1) < nums.length && nums[i + 1] == prev)
					i++;
			} else if (nums[i] == prev) {
				nums[indx++] = nums[i];
				count++;
			} else {
				nums[indx++] = nums[i];
				count = 1;
			}
			prev = nums[i];
		}
		return indx;

	}

	public static String reverseWords(String s) {

		String str = s.trim();

		String[] words = str.split(" ");

		StringBuilder sb = new StringBuilder();

		int i = 0;
		int j = words.length - 1;

		while (i < j) {

			while (i < j && words[i].equals("")) {
				i++;
			}

			while (i < j && words[j].equals("")) {
				j--;
			}

			if (i < j) {

				String s1 = words[i];
				words[i] = words[j];
				words[j] = s1;
				i++;
				j--;
			}
		}

		for (int k = 0; k < words.length; k++) {
			sb.append(words[k]).append(" ");
		}

		return sb.toString().trim();

	}

	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 2, 2, 3 };

		System.out.println(removeDuplicates(arr));
		reverseWords("a good   example");

	}

}
