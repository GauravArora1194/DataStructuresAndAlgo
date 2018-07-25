package com.interview.linkedlist;

public class LinkedList {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}

	}

	public void printList() {

		Node n = head;

		while (n != null) {
			System.out.println(n.data + " ");
			n=n.next;
		}

	}
	
	public void pushAtFront(int data) {
		
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
		
	}
	
	public void insertAfter(Node previousNode, int data) {
		
		if(previousNode == null) {
			return;
		}
		
		Node newNode = new Node(data);
		newNode.next = previousNode.next;
		previousNode.next = newNode;
	}
	
	public void append(int data) {
		
		if(head == null) {
			head = new Node(data);
			return;
		}
		
		Node newNode = new Node(data);
		
		Node temp =head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		return;
		
	}
	
	public int getCount() {
		
		Node temp = head;
		
		int count=0;
		
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		
		
		return count;
	}
	
	public void deleteKey(int key) {
		
		Node temp = head;
		Node previous = null;
		
		//head is the node to be deleted(key present at head position)
		if(temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		
		while(temp != null && temp.data != key) {
			previous = temp;
			temp = temp.next;
		}
		
		//if Key is not present in the list
		if(temp == null) {
			System.out.println("Key not present in the list!");
			return ;
		}
		
		previous.next = temp.next;
		
	}
	
	public void deleteNodeAtPosition(int position) {
		
		if(head ==null) {
			return ;
		}
		
		Node temp = head;
		
		//If first Node is to be deleted
		if(position == 0) {
			head = temp.next;
			return;
		}
		
		for(int i = 0; i<position-1 && temp != null; i++) {
			temp = temp.next;
		}
		
		//Position is greater than list length
		if(temp == null || temp.next == null) {
			return;
		}
		
		temp.next = temp.next.next;
		return;
		
		
	}
	
	public int detectLoop() {
		
		Node slowPtr = head;
		Node fastPtr = head;
		
		while(slowPtr != null && fastPtr != null && fastPtr.next != null) {
			
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			
			if(slowPtr == fastPtr) {
				System.out.println("Loop Found!");
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {

		LinkedList linkList = new LinkedList();

		linkList.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		linkList.head.next = second;
		second.next = third;

//		System.out.println("First Node : " + linkList.head.data + " Next Pointer : " + linkList.head.next);
//		System.out.println("Secong Node : " + second.data + " Next Pointer : " + second.next);
//		System.out.println("Third Node : " + third.data + " Next Pointer : " + third.next);

//		linkList.printList();
//		linkList.pushAtFront(0);
//		linkList.printList();
//		linkList.insertAfter(second, 10);
//		linkList.printList();
		
		linkList.append(4);
		linkList.printList();
		System.out.println("Total Elements in the List are : "+ linkList.getCount());
		//linkList.deleteKey(10);
		linkList.deleteNodeAtPosition(3);
		linkList.printList();
		
		System.out.println("Total Elements in the List are : "+ linkList.getCount());
		
	}

}
