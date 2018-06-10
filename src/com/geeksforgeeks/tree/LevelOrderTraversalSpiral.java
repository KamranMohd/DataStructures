package com.geeksforgeeks.tree;

/*
 * https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
 */
import java.util.Stack;

public class LevelOrderTraversalSpiral {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		System.out.println("Spiral Order traversal of Binary Tree is ");
		printSpiralOrder(root);
	}

	public static void printSpiralOrder(Node root) {
		if (root == null)
			return;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		// Push root to stack s1
		s1.push(root);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				Node temp = s1.pop();
				System.out.print(temp.data + " ");
				// Push left and right tree in stack s2
				// such that the left node is at the top of the stack
				if (temp.right != null)
					s2.push(temp.right);
				if (temp.left != null)
					s2.push(temp.left);
			}
			while (!s2.isEmpty()) {
				Node temp = s2.pop();
				System.out.print(temp.data + " ");
				// Push left and right tree in stack s1
				// such that the right node is at the top of the stack
				if (temp.left != null)
					s1.push(temp.left);
				if (temp.right != null)
					s1.push(temp.right);
			}
		}
	}

}
