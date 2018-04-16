package com.geeksforgeeks.tree;

public class TotalLeafNodes {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		System.out.println(getTotalLeaves(tree.root));
	}
	
	public static int getTotalLeaves(TreeNode root){
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		return getTotalLeaves(root.left) + getTotalLeaves(root.right);
	}

	public static int getTotalLeavesIterative(TreeNode root){
		int result = 0;
		
		return result;
	}
}
