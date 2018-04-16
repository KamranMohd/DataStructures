package com.geeksforgeeks.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumDepthTree {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		System.out.println("Recursive minimum depth of the tree : " + getMiniumDepth(tree.root));
		System.out.println("Iterative minimum depth of the tree : " + getMinDepthIterative(tree.root));
	}

	private static int getMiniumDepth(TreeNode root) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		if(root.left==null)
			return getMiniumDepth(root.right) + 1;
		if(root.right==null)
			return getMiniumDepth(root.left) + 1;
		return 1 + Math.min(getMiniumDepth(root.left), getMiniumDepth(root.right));
	}
	
	private static int getMinDepthIterative(TreeNode root){
		if(root==null)
			return 0;
		Map<TreeNode,Integer> map = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		map.put(root,1);
		while(!q.isEmpty()){
			TreeNode temp = q.poll();
			if(temp.left==null && temp.right==null)
				return map.get(temp);
			if(temp.left!=null){
				q.offer(temp.left);
				map.put(temp.left, map.get(temp) + 1);
			}
			if(temp.right!=null){
				q.offer(temp.right);
				map.put(temp.right, map.get(temp) + 1);
			}
		}
		return 0;
	}
}
