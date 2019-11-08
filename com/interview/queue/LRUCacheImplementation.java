package com.interview.queue;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheImplementation {

	class Node {

		int key;
		int value;
		Node previous;
		Node next;

		Node(int key, int value) {

			this.key = key;
			this.value = value;
			this.next = null;
			this.previous = null;
		}
	}

	class LRUCache {

		private Map<Integer, Node> map;
		private int capacity;
		private int count;
		private Node head;
		private Node tail;

		public LRUCache(int capacity) {

			this.capacity = capacity;
			this.map = new HashMap<>();
			this.head = new Node(0, 0);
			this.tail = new Node(0, 0);
			head.next = tail;
			tail.previous = head;
			head.previous = null;
			tail.next = null;
			count = 0;
		}

		public void deleteNode(Node node) {

			node.previous.next = node.next;
			node.next.previous = node.previous;
		}

		public void addToHead(Node node) {

			node.next = head.next;
			node.next.previous = node;
			node.previous = head;
			head.next = node;
		}

		// This method works in O(n)
		public int get(int key) {

			if (map.get(key) != null) {

				Node node = map.get(key);
				int result = node.value;
				deleteNode(node);
				addToHead(node);
				System.out.println("Got the value : " + result + " for the key : " + key);
				return result;
			}

			System.out.println("Did not got any value for the key : " + key);
			return -1;

		}

		// This method works in O(n)
		public void set(int key, int value) {

			if (map.get(key) != null) {

				Node node = map.get(key);
				node.value = value;
				deleteNode(node);
				addToHead(node);
			} else {

				Node node = new Node(key, value);
				map.put(key, node);

				if (count < capacity) {

					count++;
					addToHead(node);
				} else {

					map.remove(tail.previous.key);
					deleteNode(tail.previous);
					addToHead(node);
				}
			}
		}
	}

	public static void main(String[] args) {

		System.out.println("Going to test the LRU " + " Cache Implementation");

		LRUCacheImplementation l = new LRUCacheImplementation();
		LRUCache cache = l.new LRUCache(2);

		// it will store a key (1) with value
		// 10 in the cache.
		cache.set(1, 10);

		// it will store a key (2) with value 20 in the cache.
		cache.set(2, 20);
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10

		// evicts key 2 and store a key (3) with
		// value 30 in the cache.
		cache.set(3, 30);

		System.out.println("Value for the key: 2 is " + cache.get(2)); // returns -1 (not found)

		// evicts key 1 and store a key (4) with
		// value 40 in the cache.
		cache.set(4, 40);
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns -1 (not found)
		System.out.println("Value for the key: 3 is " + cache.get(3)); // returns 30
		System.out.println("Value for the key: 4 is " + cache.get(4)); // return 40
	}

}
