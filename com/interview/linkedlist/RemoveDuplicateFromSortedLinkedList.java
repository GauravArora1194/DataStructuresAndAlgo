package com.interview.linkedlist;




class CustomLinkedList{
	
	
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
	
	public void removeDuplicate() {
		
		
		Node temp = head;
		Node q;
		
		while(temp != null && temp.next != null) {
			
			if(temp.data == temp.next.data) {
				q = temp.next.next;
				
				if(q == null) {
					temp.next = null;
					break;
				}
				temp.next = q;
			}
			if(temp.data != temp.next.data) {
				temp = temp.next;
			}
		}
		
	}
	
	
	public int findMiddle() {
		
		
		Node first = head;
		Node second = head;
		
		while(first != null && first.next != null) {
			
			first = first.next.next;
			second = second.next;
		}
		
		return second.data;
	}
}


	

public class RemoveDuplicateFromSortedLinkedList {

	
	public static void main(String[] args) {
		
		CustomLinkedList list = new CustomLinkedList();
		
		list.head = new CustomLinkedList.Node(1);
		list.push(2);
		list.push(2);
		list.push(3);
		list.push(3);
		list.push(3);
		list.push(4);
		list.push(5);
		
		list.printList();
		System.out.println("-------------Removing Duplicates----------------");
		list.removeDuplicate();
		list.printList();
		System.out.println("Middle Element : " + list.findMiddle());
		
	}
	
	
}
