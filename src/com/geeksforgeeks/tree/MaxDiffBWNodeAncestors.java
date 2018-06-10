package com.geeksforgeeks.tree;

/*
 * https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/
 */
class MaxDiff {
	int val;
}

public class MaxDiffBWNodeAncestors {

	public static void main(String[] args) {
		Node root = new Node(8);
		root.left = new Node(3);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		root.right = new Node(10);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);

		System.out.println("Maximum difference between a node and"
				+ " its ancestor is : " + getMaxDiff(root));
	}

	public static int getMaxDiff(Node root) {
		MaxDiff max_diff = new MaxDiff();
		getMaxDiffUtil(root, max_diff);
		return max_diff.val;
	}

	private static int getMaxDiffUtil(Node node, MaxDiff max_diff) {
		// If the node is not present, then return
		// maximum integer value. As, we are returning the min value
		// this max value will be ignored.
		if (node == null)
			return Integer.MAX_VALUE;
		// If it is a leaf node, then return the value
		if (node.left == null && node.right == null)
			return node.data;

		// Else, get the minimum value from the left subtree and
		// the right subtree
		int min_val = Math.min(getMaxDiffUtil(node.left, max_diff),
				getMaxDiffUtil(node.right, max_diff));
		
		//	Now, find the difference between the minimum of left
		//	and right subtree with current node's value.
		max_diff.val = Math.max(max_diff.val, node.data - min_val);
		
		//	Return the minimum value between current node and min of
		//	left and right subtree
		return Math.min(node.data, min_val);
	}

}
