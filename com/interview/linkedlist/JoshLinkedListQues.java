package com.interview.linkedlist;

import java.util.LinkedList;

public class JoshLinkedListQues {

	
	// i/p- 1-2-3-4-5-6
	//o/p - 1-3-5-6-4-2
	
	public static void print(LinkedList<Integer> list) {
		
		LinkedList<Integer> temp = new LinkedList<>();
		
		
		for(Integer i : list) {
			
			if(i%2 == 0 ) {
				temp.addFirst(i);
			}
		}
		
		list.removeAll(temp);
		
		list.addAll(temp);
		
		System.out.println("Modified List : ");
		System.out.println(list);
		
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		print(list);
		
		System.out.println(list);
	}
}
