package com.interview.linkedlist;



class MyLinkedList{
	
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	Node head;
	
	
	public void printList() {
		
		Node temp = head;
		
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public void push(int data) {
		
		Node temp = head;
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		}else {
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		
	}
	
	public int getCount() {
		
		Node temp = head;
		int count = 0;
		
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		
		return count;
	}
	
	
	public void reverse() {
		
		Node current = head;
		Node prev = null;
		Node next = null;
				
		while(current != null) {
			
			next = current.next;
			current.next = prev;
			
			prev = current;
			current = next;
			
		}
		
		head = prev;
	}
	
	public int findIntersection(MyLinkedList list1 , MyLinkedList list2) {
		
		int count1 = list1.getCount();
		int count2 = list2.getCount();
		Node n1 = list1.head;
		Node n2 = list2.head;
		int diff;
		
		if(count1 > count2) {
			diff = count1 - count2;
			
			for(int i = 0 ; i < diff; i++) {
				
				if(n1 == null)
					return -1;
				n1 = n1.next;
				
			}
			
		}else {
			diff = count2 - count1;
			
			for(int i = 0 ; i < diff; i++) {
				if(n2 == null)
					return -1;
				n2 = n2.next;
				
			}
		}
		

		while(n1 != null && n2 != null) {
			if(n1.data == n2.data) {
				return n1.data;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		
		return -1;
		
		
	}
}

public class LinkedListIntersection {
	
	
	public static void main(String[] args) {
		
		MyLinkedList list1  = new MyLinkedList();
		MyLinkedList list2 = new MyLinkedList();
		
		list1.head = new MyLinkedList.Node(3);
		list1.push(6);
		list1.push(15);
		list1.push(15);
		list1.push(30);
		
		System.out.println("------------List One-------------");
		list1.printList();
		
		
		list2.head = new MyLinkedList.Node(10);
		list2.push(15);
		list2.push(30);
		
		System.out.println("------------List Two-------------");
		list2.printList();
		
		System.out.println("-----------Intersect At-----------");
		System.out.println(list1.findIntersection(list1, list2));
		
		System.out.println("--------reversed List Two----------");
		list2.reverse();
		list2.printList();
		
	}
	
	

}
