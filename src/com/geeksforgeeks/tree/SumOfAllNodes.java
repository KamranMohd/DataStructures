package com.geeksforgeeks.tree;

/*
 * https://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 */
public class SumOfAllNodes {

	public static void main(String[] args) {
		// BinaryTree tree = Tree.createTree();
		BinaryTree tree = Tree2.createTree();
		System.out.println("Total sum : " + getSum(tree.root, 0));
	}

	public static int getSum(TreeNode current, int value) {
		if (current == null)
			return 0;
		value = value * 10 + current.data;
		if (current.left == null && current.right == null)
			return value;
		return getSum(current.left, value) + getSum(current.right, value);
	}

}
