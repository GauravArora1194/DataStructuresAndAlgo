package com.interview.questions;


class Node { 
	
	int data;
	Node left, right;
	
	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree {

	
	Node root;
	
	/*BinaryTree(int data){
		root = new Node(data);
	}*/
	
	public BinaryTree() {
		root = null;
	}
	
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		
		System.out.println(" "+ tree.root.data);
		System.out.println("/  \\");
		System.out.print(tree.root.left.data);
		System.out.print("  "+ tree.root.right.data);
		
	}
}
