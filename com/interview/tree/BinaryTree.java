package com.interview.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTree {
	
	Node root;
	
	static class Node{
		
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
		
	}
	
	
	public void preOrderTraversal(Node node) {
		
		if(node == null) {
			return;
		}
		
		System.out.print(node.data + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	
	public void inOrderTraversal(Node node) {
		
		if(node == null) {
			return;
		}
		
		inOrderTraversal(node.left);
		System.out.print(node.data + " ");
		inOrderTraversal(node.right);
	}
	
	
	public void postOrderTraversal(Node node) {
		
		if(node == null) {
			return;
		}
		
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.data + " ");
	}
	
	// prints the level order traversal of a binary tree.
	public static void levelOrderTraversal(Node node) {
		
		Queue<Node> queue = new LinkedList<>();
		
		Node temp = node;
		
		queue.add(temp);
		
		// Do level order traversal 
		while(!queue.isEmpty()) {
			
			temp = queue.remove(); 
			
			System.out.print(temp.data + " ");
			
			if(temp.left != null)
				queue.add(temp.left);
			
			if(temp.right != null)
				queue.add(temp.right);
			
			
		}
		
	}
	
	
	// prints the level order of binary tree in spiral form
	public static void levelOrderInSpiralForm(Node node) {
		
		
		// create two stacks one for left to right traversal and one for right to left traversal
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		
		Node temp = node;
		stack1.push(temp);
		
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			
			
			while (!stack1.isEmpty()) {
				
				temp = stack1.pop();
				System.out.print(temp.data + " ");
				
				if(temp.left != null)
					stack2.push(temp.left);
				if(temp.right != null)
					stack2.push(temp.right);
			}
			
			while (!stack2.isEmpty()) {
				
				temp = stack2.pop();
				System.out.print(temp.data + " ");
				
				if(temp.right != null)
					stack1.push(temp.right);
				if(temp.left != null)
					stack1.push(temp.left);
			}
		}
	}
	
	public void addNode(Node root, int key) {
		
		Queue<Node> queue = new LinkedList<>();
		
		Node temp = root;
		
		queue.add(temp);
		
		// Do level order traversal until we find an empty place
		while(!queue.isEmpty()) {
			temp = queue.peek();
			queue.remove();
			
			if(temp.left == null) {
				temp.left = new Node(key);
				break;
			}else {
				queue.add(temp.left);
			}
			
			if(temp.right == null) {
				temp.right = new Node(key);
				break;
			}else {
				queue.add(temp.right);
			}
		}
		
	}
	
	
	public void deleteNode(Node root, int data) {
		
		Queue<Node> queue = new LinkedList<>();
		
		Node temp = root;
		
		Node keyNode = null;
		
		queue.add(temp);
		
		// Do level order traversal until we find an empty place
		while(!queue.isEmpty()) {
			temp = queue.peek();
			queue.remove();
			
				if(temp.data == data)
					keyNode = temp;
			
				if(temp.left != null)
					queue.add(temp.left);
			
				if(temp.right != null)
					queue.add(temp.right);
			
		}
		
		if(keyNode == null) {
			return;
		}else {
			int d = temp.data;
			deleteLastNodeOfTree(root,temp);
			keyNode.data = d;
		}
		
	}

	
	private void deleteLastNodeOfTree(Node root, Node lastNode) {

		Queue<Node> queue = new LinkedList<>();
		
		Node temp = root;
		
		queue.add(temp);
		
		while(!queue.isEmpty()) {
			
			temp = queue.peek();
			queue.remove();
			
			if(temp.right != null) {
				
				if(temp.right == lastNode) {
					temp.right = null;
				}else {
					queue.add(temp.right);
				}
			}
			
			if(temp.left != null) {
				
				if(temp.left == lastNode) {
					temp.left = null;
				}else {
					queue.add(temp.left);
				}
			}
			
		}

	}
	
	// finds tree max height or depth
	public static int treeMaxHeight(Node node) {
		
		if(node == null)
			return 0;
		
		int leftHeight = treeMaxHeight(node.left);
		int rightHeight = treeMaxHeight(node.right);
		
		if(leftHeight > rightHeight)
			return leftHeight + 1; 
		else
			return rightHeight + 1;
	}
	
	
	
	// prints the left view of binary tree
	public  void leftViewOfBinaryTree(Node node) {
		
		if (node == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		
		Node temp = node;
		
		int nodesAtLevel;
		
		queue.add(temp);
		
		while(!queue.isEmpty()) {
			
			nodesAtLevel = queue.size();
			boolean firstNode = true;
			
			
			while(nodesAtLevel != 0) {
				
				temp = queue.remove();
				
				
				if(firstNode) {
					System.out.println(temp.data);
					firstNode = false;
				}
				
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
				
				nodesAtLevel--;
			}
		}
		
	}
	
	
	
	// prints the right view of binary tree
		public  void rightViewOfBinaryTree(Node node) {
			
			if (node == null)
				return;
			
			Queue<Node> queue = new LinkedList<>();
			
			Node temp = node;
			
			int nodesAtLevel;
			
			queue.add(temp);
			
			while(!queue.isEmpty()) {
				
				nodesAtLevel = queue.size();
				boolean lastNode = true;
				
				
				while(nodesAtLevel != 0) {
					
					temp = queue.remove();
					
					if(lastNode && nodesAtLevel == 1) {
						System.out.println(temp.data);
						lastNode = false;
					}
					
					if(temp.left != null)
						queue.add(temp.left);
					if(temp.right != null)
						queue.add(temp.right);
					
					nodesAtLevel--;
				}
			}
			
		}


	// prints the vertical order traversal of binary tree
	public static void verticalOrderTraversal(Node node) {
		
		
		if(node == null)
			return;
		
		// hd is the horizontal distance from left side;
		int hd = 0;
		
		Queue<Node> queue = new LinkedList<>();
		// for storing value of hd of parent node
		Queue<Integer> distanceQueue = new LinkedList<>();
		
		
		// Instead of using treemap (for sorting the elements) we can use a hashmap and use two 
		// variables min and max where, min is the least value of hd and max is the max value of hd.
		// then we can traverse the map from min to max linearly.
		Map<Integer, List<Integer>> map = new TreeMap<>();
		
		Node temp = node;
		
		
		queue.add(temp);
		distanceQueue.add(hd);
		List<Integer> list = new ArrayList<>();
		list.add(temp.data);
		map.put(hd, list);
		
		List<Integer> l;
		
		while(!queue.isEmpty()) {
			
			temp = queue.remove();
			hd = distanceQueue.remove();
			
			if(temp.left != null) {
				
				if(map.get(hd - 1) != null) {
					 
					l = map.get(hd-1);
				}else {
					
					l = new ArrayList<>();
				}
				
				l.add(temp.left.data);
				map.put(hd - 1,l);
				
				queue.add(temp.left);
				distanceQueue.add(hd-1);
				
			}
			
			
			if(temp.right != null) {
				
				if(map.get(hd + 1) != null) {
					 
					l = map.get(hd + 1);
				}else {
					
					l = new ArrayList<>();
				}
				
				l.add(temp.right.data);
				map.put(hd + 1,l);
				
				queue.add(temp.right);
				distanceQueue.add(hd + 1);
			}
			
			
			
		}
		
		Set<Entry<Integer, List<Integer>>> entries = map.entrySet();
		for(Map.Entry<Integer, List<Integer>> entry : entries) {
			
			System.out.println(entry.getValue());
			// Important note - for bottom view of binary tree, just print the last element
			// of every list in above map or use the below method ( best approach ).
		}
			
		
	}
	
	
	// prints the bottom view of binary tree.
	public static void bottomviewOfBinarytree(Node node) {
		
		
		if(node == null)
			return;
		
		// hd is the horizontal distance from left side;
		int hd = 0;
		
		Queue<Node> queue = new LinkedList<>();
		
		// for storing value of hd of parent node
		Queue<Integer> distanceQueue = new LinkedList<>();
		
		
		// Instead of using treemap (for sorting the elements) we can use a hashmap and use two 
		// variables min and max where, min is the least value of hd and max is the max value of hd.
		// then we can traverse the map from min to max linearly.
		Map<Integer, Integer> map = new TreeMap<>();
		
		Node temp = node;
		
		
		queue.add(temp);
		distanceQueue.add(hd);
		map.put(hd, temp.data);
		
		
		while(!queue.isEmpty()) {
			
			temp = queue.remove();
			hd = distanceQueue.remove();
			
			if(temp.left != null) {
				
				map.put(hd - 1, temp.left.data);
				
				queue.add(temp.left);
				distanceQueue.add(hd-1);
				
			}
			
			
			if(temp.right != null) {
				
				
				map.put(hd + 1,temp.right.data);
				
				queue.add(temp.right);
				distanceQueue.add(hd + 1);
			}
			
			
			
		}
		
		Set<Entry<Integer, Integer>> entries = map.entrySet();
		for(Map.Entry<Integer, Integer> entry : entries) {
			
			System.out.println(entry.getValue());
		}
		
	}
	
	
	// checks if two binary trees are identical
	// we can also use level order traversal method
	// but instead of 1 queue, we use 2 queues, one for each tree. 
	public boolean checkIfTreesIdentical(Node root1, Node root2) {
		
		// if both are empty;
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 != null && root2 != null) {
			
			return (root1.data == root2.data
					&& checkIfTreesIdentical(root1.left, root2.left)
					&& checkIfTreesIdentical(root1.right, root2.right));
		}
		
		else 
			return false;
	}
	
	// convert binary tree to its mirror image
	
	public Node mirror(Node root) {
		
		if(root == null)
			return root;
		
		Node leftNode = mirror(root.left);
		Node rightNode = mirror(root.right);
		
		root.left = rightNode;
		root.right = leftNode;
		
		return root;
	}
	
		
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		//tree.root = new Node(4);
		
		/*tree.addNode(tree.root, 2);
		tree.addNode(tree.root, 3);
		tree.addNode(tree.root, 4);
		tree.addNode(tree.root, 5);
		tree.addNode(tree.root, 6);
		tree.addNode(tree.root, 7);*/
		//tree.addNode(tree.root, 8);
		
		/*System.out.println("Maximum height of tree is : " + treeMaxHeight(tree.root));
		
		System.out.println("\n-------------Pre order traversal-------------");
		tree.preOrderTraversal(tree.root);
		System.out.println("\n-------------In order traversal-------------");
		tree.inOrderTraversal(tree.root);
		System.out.println("\n-------------Post order traversal-------------");
		tree.postOrderTraversal(tree.root);
		
		tree.deleteNode(tree.root, 4);
		
		System.out.println("\nAfter deleting a node new Tree is : \n");
		
		System.out.println("-------------Pre order traversal-------------");
		tree.preOrderTraversal(tree.root);
		System.out.println("\n-------------In order traversal-------------");
		tree.inOrderTraversal(tree.root);
		System.out.println("\n-------------Post order traversal-------------");
		tree.postOrderTraversal(tree.root);*/
		
		
		// ----------------------------------------------
		//tree.addNode(tree.root, 4);
		/*tree.addNode(tree.root, 5);
		tree.addNode(tree.root, 2);
		tree.addNode(tree.root, 3);
		tree.addNode(tree.root, 1);
		tree.addNode(tree.root, 6);
		tree.addNode(tree.root, 7);
		tree.addNode(tree.root, 8);*/
		
		/*tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);
 
		
		
		tree.leftViewOfBinaryTree(tree.root);
		
		System.out.println("------------------------------");
		
		tree.rightViewOfBinaryTree(tree.root);*/
		
		
		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);
		
		System.out.println("-----------------------------------");
		levelOrderTraversal(tree.root);
		System.out.println("\n-----------------------------------");
		
		System.out.println("-----------------------------------");
		levelOrderInSpiralForm(tree.root);
		System.out.println("\n-----------------------------------");
		
		
		verticalOrderTraversal(tree.root);
		
		System.out.println("-----------BOTTOM VIEW---------------------------");
		
		bottomviewOfBinarytree(tree.root);
		
		System.out.println("Max height : " + treeMaxHeight(tree.root));
		
		
	}
}
