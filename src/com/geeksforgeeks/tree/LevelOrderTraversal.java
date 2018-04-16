package com.geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		levelOrderTraversal(tree.root);
		System.out.println();
		levelOrderQueue(tree.root);
	}
	
	public static void levelOrderQueue(TreeNode root){
		if(root==null)
			return;
		Queue<TreeNode> q = new LinkedList();
		while(root!=null){
			System.out.print(root.data + " ");
			if(root.left!=null)
				q.add(root.left);
			if(root.right!=null)
				q.add(root.right);
			root = q.poll();
		}
	}
	
	public static void levelOrderTraversal(TreeNode root){
		if(root==null)
			return;
		int height = getHeight(root);
		for(int i=1;i<=height;i++)
			printSameLevelNode(root,i);
	}
	
	private static void printSameLevelNode(TreeNode root, int level){
		if(root==null)
			return;
		if(level==1)
			System.out.print(root.data + " ");
		else{
			printSameLevelNode(root.left, level-1);
			printSameLevelNode(root.right, level-1);
		}
	}

	private static int getHeight(TreeNode root) {
		if(root==null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	
}
