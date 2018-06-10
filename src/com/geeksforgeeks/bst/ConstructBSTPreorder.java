package com.geeksforgeeks.bst;

import java.util.Stack;

class Node {
	int data;
	Node right;
	Node left;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class ConstructBSTPreorder {

	public static void main(String[] args) {
		int arr[] = {10, 5, 1, 7, 40, 50};
		//int[] arr = { 40, 20, 19, 21, 70, 45, 75 };
		int n = arr.length;
		Node root = getBST(arr, n);
		printTree(root);
	}

	private static void printTree(Node root) {
		if (root == null)
			return;
		printTree(root.left);
		System.out.print(root.data + " ");
		printTree(root.right);
	}

	public static Node getBST(int[] arr, int n) {
		Stack<Node> s = new Stack();
		Node root = new Node(arr[0]);
		s.push(root);
		for (int i = 1; i < n; i++) {
			Node node = new Node(arr[i]);
			Node temp = null;
			while (!s.isEmpty() && arr[i] > s.peek().data)
				temp = s.pop();
			if (temp != null)
				temp.right = node;
			else
				s.peek().left = node;
			s.push(node);
		}
		return root;
	}
}
