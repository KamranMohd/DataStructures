package com.geeksforgeeks.tree;

import java.util.Stack;

public class IterativePostorderTraversal {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		postOrderTraversal(tree.root);
	}

	public static void postOrderTraversal(TreeNode root){
		TreeNode node = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(node!=null || !s.isEmpty()){
			while(node!=null){
				s.push(node);
				node = node.left;
			}
			node = s.peek();
			if(node.right!=null)
				node = node.right;
			else{
				node = s.pop();
				System.out.print(node.data + " ");
				while(!s.isEmpty()){
					if(node == s.peek().right){
						node = s.pop();
						System.out.print(node.data + " ");
					}
					else{
						node = s.peek().right;
						break;
					}	
				}
			}
		}
	}
	
	/*public static void postOrderTraversal(TreeNode root){
		TreeNode node = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(node!=null || !s.isEmpty()){
			if(node!=null){
				s.push(node);
				node = node.left;
			}
			else{
				TreeNode temp = s.peek().right;
				if(temp==null){
					temp = s.pop();
					System.out.print(temp.data + " ");
					while(!s.isEmpty() && temp == s.peek().right){
						temp = s.pop();
						System.out.print(temp.data + " ");
					}
				}
				else
					node = temp;
			}
		}
	}*/
}