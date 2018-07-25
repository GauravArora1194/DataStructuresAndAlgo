package com.interview.tree;

public class BinaryTreeAncestor {

	Node root;

	static class Node {

		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}

	}
	
	
	// finds the lowest common ancestor between two nodes in a binary tree
	public Node findLCA(Node root, int n1, int n2) {
		
		if(root == null)
			return root;
		
		if(root.data == n1 || root.data == n2) 
			return root;
			
		Node temp = root;
		
		Node leftLCA = findLCA(temp.left, n1, n2);
		Node rightLCA = findLCA(temp.right, n1, n2);
		
		if(leftLCA != null && rightLCA != null)
			return root;
		
		return leftLCA != null ? leftLCA : rightLCA;
		
	}
	
	
	public  int findDistance(Node root, int n1, int n2) {
		
		Node LCA = findLCA(root, n1, n2);
		
		if(LCA == null)
			return -1;
		
		int d1 = findLevel(LCA,n1,0);
		int d2 = findLevel(LCA, n2, 0);
		
		return d1 + d2;
	}


	private int findLevel(Node root, int n1, int level) {
		
		if(root == null)
			return -1;
		
		if (root.data == n1)
			return level;
		int left = findLevel(root.left, n1, level + 1);
		
		if(left == -1)
			return findLevel(root.right, n1, level + 1);
		
		return left;
	}
	
	
	public static void main(String[] args) {
		
		// Let us create binary tree given in
        // the above example
		
		BinaryTreeAncestor tree = new BinaryTreeAncestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        System.out.println("Dist(4, 5) = "
                             + tree.findDistance(tree.root, 4, 5));
                              
        System.out.println("Dist(4, 6) = "
                             + tree.findDistance(tree.root, 4, 6));
                              
        System.out.println("Dist(3, 4) = "
                             + tree.findDistance(tree.root, 3, 4));
                              
        System.out.println("Dist(2, 4) = "
                             + tree.findDistance(tree.root, 2, 4));
                              
        System.out.println("Dist(8, 5) = "
                             + tree.findDistance(tree.root, 8, 5));
 
    }
		
		
		
}
