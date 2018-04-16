package com.geeksforgeeks.tree;

public class Tree {
	BinaryTree tree;
	public static BinaryTree createTree(){
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(31);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		//tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		tree.root.left.left.right = new TreeNode(40);
		tree.root.left.left.left = new TreeNode(40);
		return tree;
	}
}
