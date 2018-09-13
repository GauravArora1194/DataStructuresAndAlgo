package com.interview.linkedlist;

public class LinkedListMergeSort {

	Node head;
	
	private class Node {
		
		int data;
		Node next;
		
		Node (int data) {
			this.data = data;
			this.next = null;
		}
		
	}
	
	
	public void addLast(int data) {
		
		Node node = new Node(data);
		
		if(head == null) {
			head = node;
			return;
		}
		
		Node temp = head;
		
		while(temp.next != null ) {
			temp = temp.next;
		}
		
		
		temp.next = node;
	}
	
	
	public void display() {
		
		Node temp = head;
		
		while(temp != null ) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
		System.out.println();
	}
	
	
	public Node midNode(Node head) {
		
		Node slow = head;
		Node fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	
	public Node mergeSort(Node head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		Node mid = midNode(head);
		Node next = mid.next;
		mid.next = null;
		
		Node left = mergeSort(head);
		Node right = mergeSort(next);
		
		Node merged = merge(left, right);
		
		return merged;
		
		
	}
	
	public Node merge(Node node1, Node node2) {
		
		Node head1 = node1;
		Node head2 = node2;
		
		Node merged = new Node(-1);
		Node temp = merged;
		
		while(head1 != null && head2 != null) {
			
			if(head1.data < head2.data) {
				temp.next = head1;
				head1 = head1.next;
				
			} else {
				temp.next = head2;
				head2 = head2.next;
			}
			
			temp = temp.next;
		}
		
		while(head1 != null ) {
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		
		while(head2 != null ) {
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		
		merged = merged.next;
		
		return merged;
		
	}
	
	
	public static void main(String[] args) {
		
		LinkedListMergeSort list1 = new LinkedListMergeSort();
		
		list1.addLast(1);
		list1.addLast(30);
		list1.addLast(20);
		list1.addLast(1);
		list1.addLast(4);
		list1.addLast(35);
		list1.addLast(15);
		
		/*LinkedListMergeSort list2 = new LinkedListMergeSort();
		
		list2.addLast(1);
		list2.addLast(15);
		list2.addLast(36);
		list2.addLast(45);
		
		list1.display();
		list2.display();
		
		list1.head = list1.merge(list1.head, list2.head);*/
		
		
		list1.display();
		
		list1.head = list1.mergeSort(list1.head);
		
		list1.display();
		
		
		
	}
}
