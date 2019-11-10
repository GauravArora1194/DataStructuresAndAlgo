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

	private class HeapMover {

		Node node;
	}

	public void printList() {

		Node n = head;

		while (n != null) {
			System.out.println(n.data + " ");
			n = n.next;
		}

	}

	public void pushAtFront(int data) {

		Node newNode = new Node(data);

		newNode.next = head;
		head = newNode;

	}

	public void insertAfter(Node previousNode, int data) {

		if (previousNode == null) {
			return;
		}

		Node newNode = new Node(data);
		newNode.next = previousNode.next;
		previousNode.next = newNode;
	}

	public void append(int data) {

		if (head == null) {
			head = new Node(data);
			return;
		}

		Node newNode = new Node(data);

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		return;

	}

	public int getCount() {

		Node temp = head;

		int count = 0;

		while (temp != null) {
			count++;
			temp = temp.next;
		}

		return count;
	}

	public int getCount(Node node) {

		if (node == null) {
			return 0;
		}

		return 1 + getCount(node.next);
	}

	public void deleteKey(int key) {

		Node temp = head;
		Node previous = null;

		// head is the node to be deleted(key present at head position)
		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}

		while (temp != null && temp.data != key) {
			previous = temp;
			temp = temp.next;
		}

		// if Key is not present in the list
		if (temp == null) {
			System.out.println("Key not present in the list!");
			return;
		}

		previous.next = temp.next;

	}

	public void deleteNodeAtPosition(int position) {

		if (head == null) {
			return;
		}

		Node temp = head;

		// If first Node is to be deleted
		if (position == 0) {
			head = temp.next;
			return;
		}

		for (int i = 0; i < position - 1 && temp != null; i++) {
			temp = temp.next;
		}

		// Position is greater than list length
		if (temp == null || temp.next == null) {
			return;
		}

		temp.next = temp.next.next;
		return;

	}

	public int detectLoop() {

		Node slowPtr = head;
		Node fastPtr = head;

		while (slowPtr != null && fastPtr != null && fastPtr.next != null) {

			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if (slowPtr == fastPtr) {
				System.out.println("Loop Found!");
				return 1;
			}
		}
		return 0;
	}

	public void removeLoop(Node loop, Node head) {

		// Here loop is the Node of the loop (slow pointer node) and head is the head
		// node.

		Node ptr1 = loop;
		Node ptr2 = loop;

		// Step 1 : Count the number of nodes in the loop.

		int count = 1;

		while (ptr2.next != ptr1) {

			count++;
			ptr2 = ptr2.next;
		}

		// Step 2 : Initialize two pointers, one at head and other at count position
		// ahead.

		ptr1 = head;
		ptr2 = head;

		for (int i = 0; i < count; i++) {

			ptr2 = ptr2.next;
		}

		// Step 3 : Move the pointers until they meet at the starting of the loop.

		while (ptr2 != ptr1) {

			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		// Step 4 : Find last node of loop and set it's next to NULL.

		while (ptr2.next != ptr1) {

			ptr2 = ptr2.next;
		}

		ptr2.next = null;

	}

	public void displayReverse() {

		displayReverseHelper(head);
	}

	private void displayReverseHelper(Node node) {

		if (node == null) {
			return;
		}

		displayReverseHelper(node.next);
		System.out.print(node.data + " -> ");
	}

	public boolean isPalindrome() {

		HeapMover left = new HeapMover();
		left.node = head;

		return isPalindromeHelper(left, head);
	}

	private boolean isPalindromeHelper(HeapMover left, Node right) {

		if (null == right) {
			return true;
		}

		boolean isPalindrome = isPalindromeHelper(left, right.next);

		if (!isPalindrome) {
			return false;
		} else {

			if (left.node.data == right.data) {
				left.node = left.node.next;
				return true;
			} else {
				return false;
			}
		}

	}

	public boolean isPalindrome(Node head) {

		// Step 1 : Get the middle Node in the list.

		Node slow = head;
		Node fast = head;
		Node prevOfMidNode = null;

		while (fast != null && fast.next != null) {

			fast = fast.next.next;
			prevOfMidNode = slow;
			slow = slow.next;
		}

		Node midNode = slow;

		// If there are odd number of nodes then discard the middle node for comparison.
		Node temp = null;

		if (fast != null) {

			temp = midNode;
			midNode = midNode.next;

		}

		// Step 2 : Two list are obtained in head1 and head2.
		Node head1 = head;
		Node head2 = midNode;
		prevOfMidNode.next = null;

		// Step 3 : Reverse second list.

		head2 = reverse(head2);

		// Step 4 : Compare the list for equality.

		boolean res = compareList(head1, head2);

		// Step 5 : Reconstruct the original list

		head2 = reverse(head2);

		if (temp != null) {

			prevOfMidNode.next = temp;
			temp.next = head2;
		} else {
			prevOfMidNode.next = head2;
		}

		return res;

	}

	public boolean compareList(Node node1, Node node2) {

		while (node1 != null && node2 != null) {

			if (node1.data == node2.data) {
				node1 = node1.next;
				node2 = node2.next;
			} else {
				return false;
			}
		}

		if (node1 == null && node2 == null) {
			return true;
		}

		return false;
	}

	public Node reverse(Node node) {

		Node current = node;
		Node prev = null;
		Node next;

		while (current != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;

	}

	public int midInList() {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {

			fast = fast.next.next;
			slow = slow.next;
		}

		return slow.data;
	}

	public Node middleNode(Node head) {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.next;
	}

	public void deleteAlternateNodes() {

		if (head == null || head.next == null) {
			return;
		}

		Node prev = head;
		Node next = head.next;

		while (prev != null && next != null) {

			prev.next = next.next;
			prev = prev.next;

			if (prev != null) {

				next = prev.next;
			}

		}
	}

	public void segregate0s1s2s() {

		int count[] = new int[3];

		Node temp = head;

		while (temp != null) {

			count[temp.data]++;
			temp = temp.next;
		}

		temp = head;
		int i = 0;

		while (temp != null) {

			if (count[i] == 0) {
				i++;
			} else {

				temp.data = i;
				count[i]--;
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) {

		LinkedList linkList = new LinkedList();

		linkList.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		linkList.head.next = second;
		second.next = third;

		// System.out.println("First Node : " + linkList.head.data + " Next Pointer : "
		// + linkList.head.next);
		// System.out.println("Secong Node : " + second.data + " Next Pointer : " +
		// second.next);
		// System.out.println("Third Node : " + third.data + " Next Pointer : " +
		// third.next);

		// linkList.printList();
		// linkList.pushAtFront(0);
		// linkList.printList();
		// linkList.insertAfter(second, 10);
		// linkList.printList();

		linkList.append(4);
		linkList.printList();
		System.out.println("-----------Display Reverse Start----------------");
		linkList.displayReverse();
		System.out.println();
		System.out.println("-----------Display Reverse End----------------");
		System.out.println("Total Elements in the List are : " + linkList.getCount());
		// linkList.deleteKey(10);
		linkList.deleteNodeAtPosition(3);
		linkList.printList();

		System.out.println("Total Elements in the List are : " + linkList.getCount());

		linkList.append(2);
		linkList.append(1);
		// linkList.append(2);

		linkList.printList();

		System.out.println("Is Palindrome : " + linkList.isPalindrome());

		System.out.println("Is Palindrome : " + linkList.isPalindrome(linkList.head));

		System.out.println("Middle Element is : " + linkList.midInList());

		linkList.deleteNodeAtPosition(4);

		linkList.deleteAlternateNodes();

		linkList.printList();
	}

}
