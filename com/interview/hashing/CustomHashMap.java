package com.interview.hashing;

import java.util.HashMap;
import java.util.Map;

public class CustomHashMap<K, V> {

	private Node<K, V>[] bucket;

	private static final int MAX_CAPACITY = 1 << 4;

	private int size = 0;

	public CustomHashMap() {

		this(MAX_CAPACITY);

	}

	@SuppressWarnings("unchecked")
	public CustomHashMap(int maxCapacity) {

		this.bucket = new Node[maxCapacity];
	}

	public void put(K key, V value) {

		int hash = key != null ? hash(key) : 0;

		Node<K, V> node = new Node<>(hash, key, value, null);

		if (bucket[(hash % getBucketSize())] == null) {

			bucket[(hash % getBucketSize())] = node;
			this.size++;
		} else {

			Node<K, V> existing = bucket[(hash % getBucketSize())];

			while (existing.next != null) {

				if (existing.hash == node.hash && existing.key.equals(node.key)) {

					// key exist already
					existing.value = node.value;
					break;
				}

				existing = existing.next;

			}

			if (existing.hash == node.hash && existing.key.equals(node.key)) {

				// key exist already
				existing.value = node.value;
			} else {

				existing.next = node;
				size++;
			}
		}

	}

	public V get(K key) {

		int hash = hash(key);

		Node<K, V> node = bucket[(hash % getBucketSize())];

		while (node != null) {

			if (node.key.equals(key)) {

				return node.value;
			}

			node = node.next;
		}

		return null;

	}

	public boolean isEmpty() {

		return size == 0;
	}

	public int getBucketSize() {

		return this.bucket.length;
	}

	public int size() {

		return size;
	}

	private int hash(K key) {

		return key.hashCode();

	}

	public static void main(String[] args) {

		//CustomHashMap<String, Integer> map = new CustomHashMap<>();
		Map<String, String> map = new HashMap<>();
		map.put("name", "gaurav");
		map.put("ksad", "afgs");
		
		System.out.println(map.toString());
		
		System.out.println(map.isEmpty());

		//map.put("one", 1);
		//map.put("two", 2);
		//map.put("three", 3);

		System.out.println(map.size());

		System.out.println(map.get("one"));
		System.out.println(map.get("two"));
		System.out.println(map.get("three"));
		
		System.out.println(map.isEmpty());

	}

}

class Node<K, V> {

	final int hash;
	final K key;
	V value;
	Node<K, V> next;

	Node(int hash, K key, V value, Node<K, V> next) {

		this.hash = hash;
		this.key = key;
		this.value = value;
		this.next = next;
	}
}
