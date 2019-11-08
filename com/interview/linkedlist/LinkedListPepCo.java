package com.interview.linkedlist;

public class LinkedListPepCo {

	Node head;
	Node tail;
	int size;

	private static class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private class HeapMover {

		Node node;
	}

	public void addAtLast(int data) {

		Node node = new Node(data);

		if (head == null) {

			this.head = this.tail = node;
			this.size++;
			return;
		}

		this.tail.next = node;
		this.tail = node;
		this.size++;

	}

	public void display() {

		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println();
	}

	public void fold() {

		// Re-arrange linked list in place i.e pick first node then last node and
		// continue this process.

		HeapMover left = new HeapMover();
		left.node = head;
		fold(left, head, 0);

	}

	public void fold(HeapMover left, Node right, int floor) {

		if (right == null) {
			return;
		}

		fold(left, right.next, floor + 1);

		if (floor > this.size / 2) {

			Node temp = left.node.next;
			left.node.next = right;
			right.next = temp;

			left.node = temp;
		}

		if (floor == this.size / 2) {
			this.tail = right;
			this.tail.next = null;
		}

	}

	public Node fold(Node head) {

		// Step 1 : Find the middle node in the list and reverse the second half.

		Node mid = middleNode(head);

		Node head1 = head;
		Node head2 = mid.next;
		mid.next = null;

		head2 = reverse(head2);

		// Do the merge in the desired order by selecting one node from each one at a time.
		head = mergeList(head1, head2);

		return head;

	}

	public Node mergeList(Node node1, Node node2) {

		Node result = new Node(-1);
		Node temp = result;

		while (node1 != null || node2 != null) {

			if (node1 != null) {
				temp.next = node1;
				node1 = node1.next;
				temp = temp.next;

			}

			if (node2 != null) {
				temp.next = node2;
				node2 = node2.next;
				temp = temp.next;

			}
		}

		result = result.next;

		return result;
	}

	public Node reverse(Node head) {

		Node current = head;
		Node prev = null;
		Node next = null;

		while (current != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}

	public Node middleNode(Node head) {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
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

		// list.fold();

		list.head = list.fold(list.head);

		list.display();

	}
}
