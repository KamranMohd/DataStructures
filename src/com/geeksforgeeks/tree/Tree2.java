package com.geeksforgeeks.tree;

public class Tree2 {
	BinaryTree tree;
	public static BinaryTree createTree(){
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(6);
		tree.root.left = new TreeNode(3);
		tree.root.right = new TreeNode(5);
		tree.root.left.left = new TreeNode(2);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.right = new TreeNode(4);
		tree.root.left.right.right = new TreeNode(4);
		tree.root.left.right.left = new TreeNode(7);
		return tree;
	}
}
