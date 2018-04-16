package com.geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		System.out.println("Recursive Height of the tree : " + getHeight(tree.root));
		System.out.println("Iterative Height of the tree : " + getHeightIterative(tree.root));
	}

	private static int getHeight(TreeNode root) {
		if(root==null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	private static int getHeightIterative(TreeNode root) {
		if(root==null)
			return 0;
		int height = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(1==1){
			int size = q.size();
			if(size == 0)
				return height;
			height++;
			while(size>0){
				TreeNode temp = q.remove();
				if(temp.left!=null)
					q.offer(temp.left);
				if(temp.right!=null)
					q.offer(temp.right);
				size--;
			}
		}
	}
}