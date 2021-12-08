package com.interview.strings;

/**
 * Given a string, what is the minimum number of adjacent swaps required to
 * convert a string into a palindrome. If not possible, return -1.
 * 
 * @author gauravarora02
 *
 */
public class MinimumSwapsToMakeStringPalindrome {

	public static void main(String[] args) {

		String s1 = "mamad";
		System.out.println("Swaps: " + minSwaps(s1));

		String s2 = "ntiin";
		System.out.println("Swaps: " + minSwaps(s2));

		String s3 = "aabb";
		System.out.println("Swaps: " + minSwaps(s3));

		String s4 = "asflkj";
		System.out.println("Swaps: " + minSwaps(s4));
	}

	public static int minSwaps(String str) {

		if (str.length() == 0 || str == null)
			return -1;

		int minSwaps = 0;

		boolean isShuffled = isShuffledPalindrome(str);

		if (isShuffled) {

			char[] chars = str.toCharArray();
			int left = 0;
			int right = chars.length - 1;

			while (left < right) {

				if (chars[left] != chars[right]) {

					int k = right;

					while (left < k && chars[left] != chars[k]) {
						k--;
					}

					if (k == left) {

						// Swap left with next element
						swap(chars, left, left + 1);
						minSwaps++;

					} else {

						while (k < right) {
							swap(chars, k, k + 1);
							minSwaps++;
							k++;
						}

						left++;
						right--;
					}

				} else {

					left++;
					right--;
				}

			}

		} else {
			minSwaps = -1;
		}

		return minSwaps;
	}

	private static void swap(char[] chars, int left, int right) {

		char temp = chars[left];
		chars[left] = chars[right];
		chars[right] = temp;

	}

	private static boolean isShuffledPalindrome(String str) {

		int[] charCount = new int[26];
		int oddCharCount = 0;

		for (int i = 0; i < str.length(); i++) {
			charCount[str.charAt(i) - 'a']++;
		}

		for (int count : charCount) {

			if (count % 2 != 0) {
				oddCharCount++;
			}
		}

		return oddCharCount <= 1;
	}
}
