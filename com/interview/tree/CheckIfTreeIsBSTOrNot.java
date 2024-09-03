package com.interview.tree;

class Node {

	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class CheckIfTreeIsBSTOrNot {

	// Another approach -
	// we can do the inorder traversal of the binary tree and and store the result
	// in an array
	// if the array is sorted then it is a BST else NOT BST

	boolean isBSTUtil(Node node, int min, int max) {

		if (node == null)
			return true;

		if (node.data < min || node.data > max)
			return false;

		return ((isBSTUtil(node.left, min, node.data - 1)) && (isBSTUtil(node.right, node.data + 1, max)));
	}

	boolean checkBST(Node root) {

		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// Given two nodes data, this method finds the lowest common ancestor of two
	// nodes.
	// Assume that both values exit in the BST.
	public Node lowestCommonAncestor(Node root, int node1, int node2) {

		// Assuming n1 < n2.

		if (root == null)
			return root;

		Node temp = root;

		while (temp != null) {

			if (temp.data > node1 && temp.data > node2)
				temp = temp.left;

			else if (temp.data < node1 && temp.data < node2)
				temp = temp.right;

			else
				break;

		}

		return temp;

	}

}
