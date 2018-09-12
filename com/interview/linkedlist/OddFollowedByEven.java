package com.interview.linkedlist;


// convert the given list such that it first contains
// odd element followed by even elements

public class OddFollowedByEven {

	Node head;
	
	private class Node {
		
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public void addAtLast(int data) {
		
		Node node = new Node(data);
		
		if(head == null) {
			head = node;
			return;
		}
		
		Node temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = node;
	}
	
	public void display() {
		
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		
		System.out.println();
	}
	
	
	public void oddThenEven() {
		
		Node lastNode = head;
		Node temp = head;
		
		while(lastNode.next != null) {
			lastNode = lastNode.next;
		}
		
		Node end = lastNode;
		
		while(temp.data % 2 == 0 && temp != lastNode) {
			
			end.next = temp;
			end = temp;
			temp = temp.next;
			end.next = null;
		}
		
		if(temp == lastNode && temp.data % 2 == 0) {
			end.next = temp;
			end = temp;
			head = temp.next;
			end.next = null;
			return;
			
		} else {
			
			head = temp;
			Node prev = temp;
			temp = temp.next;
			
			while(temp != lastNode) {
				
				if(temp.data % 2 == 0) {
					
					prev.next = temp.next;
					end.next = temp;
					end = temp;
					end.next = null;
					temp = prev.next;
				}else {
					
					prev = temp;
					temp = temp.next;
				}
			}
			

			if(temp == lastNode && temp.data % 2 == 0) {
				prev.next = temp.next;
				end.next = temp;
				end = temp;
				end.next = null;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		
		OddFollowedByEven list = new OddFollowedByEven();
		
		list.addAtLast(10);
		list.addAtLast(20);
		list.addAtLast(3);
		list.addAtLast(41);
		list.addAtLast(50);
		list.addAtLast(63);
		list.addAtLast(70);
		list.addAtLast(45);
		list.addAtLast(60);
		
		list.display();
		
		list.oddThenEven();
		
		list.display();
				
	}
	
}
