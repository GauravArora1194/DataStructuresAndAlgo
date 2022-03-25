package com.interview.flipkart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559
 * 
 * @author gauravarora02
 *
 */
public class AggresiveCowProblem {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(6);

		System.out.println(aggressiveCows(list, 2));
	}

	public static int aggressiveCows(List<Integer> stalls, int k) {

		Collections.sort(stalls);
		int start = 0;
		int end = stalls.get(stalls.size() - 1);

		int mid = (start + end) / 2;
		int ans = -1;

		while (start <= end) {

			if (isPossibleSolution(stalls, k, mid)) {

				ans = mid;
				start = mid + 1;

			} else {

				end = mid - 1;
			}

			mid = (start + end) / 2;
		}

		return ans;

	}

	private static boolean isPossibleSolution(List<Integer> stalls, int k, int mid) {

		int cowCount = 1;
		int lastPos = stalls.get(0);

		for (int i = 0; i < stalls.size(); i++) {

			if (stalls.get(i) - lastPos >= mid) {

				cowCount++;

				if (cowCount == k) {
					return true;
				}

				lastPos = stalls.get(i);
			}

		}

		return false;
	}
}
