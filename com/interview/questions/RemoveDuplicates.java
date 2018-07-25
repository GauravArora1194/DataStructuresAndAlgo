package com.interview.questions;

import java.util.LinkedList;
import java.util.List;


//compares each node with next node, if equal then remove next node otherwise proceed.
public class RemoveDuplicates {

	
	//Remove duplicates from a sorted linked list
	public static List<Integer> removeDuplicate(List<Integer> list) {
		
		List<Integer> newList = new LinkedList<>();
		
		for(int i = 0 ; i < list.size(); i++) {
			
			if(!newList.contains(list.get(i))) {
				newList.add(list.get(i));
			}
		}
		
		return newList;
	}
	
	//without creating new list
	public static List<Integer> removeDuplicat(List<Integer> list){
		
		int currItem, nextItem;
		for(int i = 0 ; i < list.size() - 1; ) {
			
			currItem = list.get(i);
			nextItem = list.get(i+1);
			
			if(currItem == nextItem)
				list.remove(i+1);
			
			else
				i++;
		}
		
		return list;
		
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<>();
		list.add(11);
		list.add(11);
		list.add(11);
		list.add(21);
		list.add(43);
		list.add(43);
		list.add(60);
		list.add(60);
		System.out.println("Original list : ");
		for(Integer i : list)
			System.out.print(i + " ");
		
		//List<Integer> newList = removeDuplicate(list);
		List<Integer> newList = removeDuplicat(list);
		
		System.out.println("\n New List : ");
		for(Integer i : newList)
			System.out.print(i + " ");
		
		
	}
}
