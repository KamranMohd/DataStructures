package com.geeksforgeeks.tree;

public class NumberOfNodes {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		System.out.println("Total nodes : " + countNodes(tree.root));
	}

	private static int countNodes(TreeNode root) {
		if(root==null)
			return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
}
