package com.geeksforgeeks.tree;

import java.util.Stack;

public class IterativeInorderTraversal {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		inOrderTraversal(tree.root);
	}
	
	public static void inOrderTraversal(TreeNode root){
		if(root==null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode current = root.left;
		//	Push the nodes to the stack until there is a node which does not have left node
		while(current!=null){
			stack.push(current);
			current = current.left;
		}
		//	Pop the element and print the node data and if there is a right node, push it and repeat the above step
		while(!stack.isEmpty()){
			current = stack.pop();
			System.out.print(current.data +  " ");
			if(current.right!=null){
				current = current.right;
				while(current!=null){
					stack.push(current);
					current = current.left;
				}
			}
		}
	}
}