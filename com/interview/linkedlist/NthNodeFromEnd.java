package com.interview.linkedlist;


public class NthNodeFromEnd {

	
	//maintain two pointers to head
	//move first pointer by N
	//move both pointers until end is reached
	
	
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
	
	
	public int nthValueFromLast(int n) {
		
		
		Node n1 = head;
		Node n2 = head;
		
		for(int i = 0 ; i < n; i++) {
			n1= n1.next;
		}
		
		while(n1 != null) {
			
			n1 = n1.next;
			n2 = n2.next;
		}
		
		return n2.data;
	}
	
	
	public static void main(String[] args) {
		
		int n= 4;
		
		NthNodeFromEnd list = new NthNodeFromEnd();
		
		list.head = new Node(20);
		list.push(4);
		list.push(15);
		list.push(35);
		
		list.printList();
		
		System.out.println("Node from last "+ n +" : " + list.nthValueFromLast(n));
		
	}
}
