package com.geeksforgeeks.tree;

import java.util.Stack;

public class IterativePreoderTraversal {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		preOrderTraversal(tree.root);
	}
	
	public static void preOrderTraversal(TreeNode root){
		if(root==null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode currentRoot = stack.pop();
			System.out.print(currentRoot.data + " ");
			if(currentRoot.right!=null)
				stack.push(currentRoot.right);
			if(currentRoot.left!=null)
				stack.push(currentRoot.left);
		}
	}
}