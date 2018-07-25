package com.interview.sortings;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianInAStream {

	
	public static double[] getMedians(int[] arr) {
		
		// Max Heap
		PriorityQueue<Integer> lowers = new PriorityQueue<>( new Comparator<Integer>() {

			// change comparison to put biggest element on top.
			@Override
			public int compare(Integer a, Integer b) {
				return -1 * a.compareTo(b);
			}
		});
		
		// Min Heap
		PriorityQueue<Integer> highers = new PriorityQueue<>();
		
		double[] medians = new double[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			
			int number =  arr[i];
			addNumber(number, lowers, highers);
			rebalance(lowers,highers);
			
			medians[i] = getMedians(lowers, highers);
		}
		
		return medians;
	}

	private static double getMedians(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {

		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
		
		
		if(biggerHeap.size() == smallerHeap.size()) {
			return (double)(biggerHeap.peek() + smallerHeap.size()) / 2;
		}else {
			
			return biggerHeap.peek();
		}
			
	}

	private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		
		PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
		PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
		
		if(biggerHeap.size() - smallerHeap.size() >= 2) {
			smallerHeap.add(biggerHeap.poll());
		}
		
	}

	private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		
		if(lowers.size() == 0 || number < lowers.peek())
			lowers.add(number);
		else
			highers.add(number);
	}
}
