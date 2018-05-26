package com.geeksforgeeks.tree;

public class BoundaryTraversal {

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.left.left = new Node(14);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		root.right.right = new Node(25);
		root.right.right.right = new Node(30);
		printBoundary(root);
	}

	private static void printBoundary(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		printBoundaryLeft(node.left);

		printLeaves(node.left);
		printLeaves(node.right);

		printBoundaryRight(node.right);

	}

	private static void printBoundaryRight(Node node) {
		if (node != null) {
			if (node.right != null) {
				printBoundaryLeft(node.right);
				System.out.print(node.data + " ");
			} else if (node.left != null) {
				printBoundaryLeft(node.left);
				System.out.print(node.data + " ");			}
			// Else it is a leaf node,therefore,do nothing
		}
	}

	private static void printLeaves(Node node) {
		if(node!=null){
			printLeaves(node.left);
			if(node.left==null && node.right==null)
				System.out.print(node.data + " ");
			printLeaves(node.right);
		}
	}

	private static void printBoundaryLeft(Node node) {
		if (node != null) {
			if (node.left != null) {
				System.out.print(node.data + " ");
				printBoundaryLeft(node.left);
			} else if (node.right != null) {
				System.out.print(node.data + " ");
				printBoundaryLeft(node.right);
			}
			// Else it is a leaf node,therefore,do nothing
		}

	}

}
