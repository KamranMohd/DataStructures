package com.geeksforgeeks.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Values {
	int max, min;

	public Values() {
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
	}
}

public class BottomView {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		printBottomView(tree.root, new Values());
	}

	private static void printBottomView(TreeNode root, Values val) {
		if (root == null)
			return;
		Map<Integer, TreeNode> map = new HashMap<>();
		Queue<QItem> q = new LinkedList();
		q.offer(new QItem(root, 0));
		map.put(0, root);
		while (!q.isEmpty()) {
			QItem item = q.poll();
			map.put(item.hd, item.node);
			if (item.hd < val.min)
				val.min = item.hd;
			if (item.hd > val.max)
				val.max = item.hd;
			if (item.node.left != null)
				q.offer(new QItem(item.node.left, item.hd - 1));
			if (item.node.right != null)
				q.offer(new QItem(item.node.right, item.hd + 1));
		}
	
		for(int i=val.min;i<=val.max;i++){
			System.out.print(map.get(i).data + " ");
		}
	}
}
