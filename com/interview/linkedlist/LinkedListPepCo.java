package com.interview.linkedlist;

public class LinkedListPepCo {

	Node head;
	Node tail;
	int size;
	
	private static class Node {
		
		int data;
		Node next;
		
		Node (int data){
			this.data = data;
			this.next = null;
		}
	}
	
	private class HeapMover {
		
		Node node;
	}
	
	
	public void addAtLast(int data) {
		
		Node node = new Node(data);
		
		if(head == null) {
			
			this.head =  this.tail = node;
			this.size++;
			return;
		}
		
		
		this.tail.next = node;
		this.tail = node;
		this.size++;
		
	}
	
	public void display() {
		
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + " " );
			temp = temp.next;
		}
		
		System.out.println();
	}
	
	public void fold() {
		
		HeapMover left = new HeapMover();
		left.node = head;
		fold(left, head, 0);
		
	}
	
	public void fold(HeapMover left, Node right, int floor) {
		
		if(right == null) {
			return;
		}
		
		fold(left, right.next, floor + 1);
		
		if(floor > this.size / 2) {
			
			Node temp = left.node.next;
			left.node.next = right;
			right.next = temp;
			
			left.node = temp;
		}
		
		if(floor == this.size / 2) {
			this.tail = right;
			this.tail.next = null;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		LinkedListPepCo list = new LinkedListPepCo();
		
		list.addAtLast(10);
		list.addAtLast(20);
		list.addAtLast(30);
		list.addAtLast(40);
		list.addAtLast(50);
		list.addAtLast(60);
		
		list.display();
		
		list.fold();
		
		list.display();
		
	}
}
