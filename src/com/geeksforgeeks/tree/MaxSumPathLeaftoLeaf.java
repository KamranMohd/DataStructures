package com.geeksforgeeks.tree;

/*
 * https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
 */
public class MaxSumPathLeaftoLeaf {
	static int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Node root = new Node(-15);
		root.left = new Node(5);
		root.right = new Node(6);
		root.left.left = new Node(-8);
		root.left.right = new Node(1);
		root.left.left.left = new Node(2);
		root.left.left.right = new Node(6);
		root.right.left = new Node(3);
		root.right.right = new Node(9);
		root.right.right.right = new Node(0);
		root.right.right.right.left = new Node(4);
		root.right.right.right.right = new Node(-1);
		root.right.right.right.right.left = new Node(10);
		maxSum(root);
		System.out.println("Max pathSum of the given binary tree is " + maxSum);
	}

	public static int maxSum(Node node) {
		// Base condition: If node is null, return 0
		if (node == null)
			return 0;
		// If it is a leaf node, return it's value
		if (node.left == null && node.right == null)
			return node.data;

		// Calculate the sum for left and right subtree
		int leftSum = maxSum(node.left);
		int rightSum = maxSum(node.right);

		// Now there are 2 cases
		// Case 1: When both the left and right nodes are present
		// In this cases, we return the sum of node + max(right, left)
		if (node.left != null && node.right != null) {
			//	This case occurs when no ancestors of the current node
			//	are in the path and max sum passes through root.
			maxSum = Math.max(maxSum, leftSum + rightSum + node.data);
			return Math.max(leftSum, rightSum) + node.data;
		}

		// Case when only 1 child is present
		return node.left == null ? rightSum + node.data : leftSum + node.data;

	}

}
