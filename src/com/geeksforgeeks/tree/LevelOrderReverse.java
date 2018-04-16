package com.geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderReverse {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		printReverseLevelOrder(tree.root);
	}

	private static void printReverseLevelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();	
		Stack<TreeNode> s = new Stack<>();
		q.offer(root);
		while(!q.isEmpty()){
			TreeNode temp = q.poll();
			if(temp.right!=null)
				q.offer(temp.right);
			if(temp.left!=null)
				q.offer(temp.left);
			s.push(temp);
		}
		while(!s.isEmpty())
			System.out.print(s.pop().data + " ");
	}
}
