package com.geeksforgeeks.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeftView {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		printLeftView(tree.root);
	}

	private static void printLeftView(TreeNode root) {
		if(root==null)
			return;
		Queue<QItem> q = new LinkedList();
		Map<Integer, TreeNode> map = new HashMap<>();
		q.offer(new QItem(root,0));
		while(!q.isEmpty()){
			QItem item = q.poll();
			if(map.get(item.hd)==null){
				map.put(item.hd, item.node);
				System.out.print(item.node.data + " ");
			}
			if(item.node.left!=null)
				q.offer(new QItem(item.node.left, item.hd+1));
			if(item.node.right!=null)
				q.offer(new QItem(item.node.right, item.hd+1));
		}
	}
}
