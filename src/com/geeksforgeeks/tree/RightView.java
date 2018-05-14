package com.geeksforgeeks.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RightView {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		printRightView(tree.root, new Values());
	}

	private static void printRightView(TreeNode root, Values val) {
		if(root==null)
			return;
		Queue<QItem> q = new LinkedList();
		Map<Integer, TreeNode> map = new HashMap<>();
		q.offer(new QItem(root,0));
		while(!q.isEmpty()){
			QItem item = q.poll();
			if(val.max < item.hd)
				val.max = item.hd;
			map.put(item.hd, item.node);
			if(item.node.left!=null)
				q.offer(new QItem(item.node.left, item.hd+1));
			if(item.node.right!=null)
				q.offer(new QItem(item.node.right, item.hd+1));
		}
		for(int i=0;i<=val.max;i++)
			System.out.print(map.get(i).data + " ");
	}
}
