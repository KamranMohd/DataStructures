package com.geeksforgeeks.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TopView {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		printTopView(tree.root);
	}

	private static void printTopView(TreeNode root) {
		if (root == null)
			return;
		Set<Integer> set = new HashSet<>();
		Queue<QItem> q = new LinkedList();
		q.offer(new QItem(root, 0));
		while (!q.isEmpty()) {
			QItem currentNode = q.poll();
			if (!set.contains(currentNode.hd)) {
				System.out.print(currentNode.node.data + " ");
				set.add(currentNode.hd);
			}
			if (currentNode.node.left != null)
				q.offer(new QItem(currentNode.node.left, currentNode.hd - 1));
			if (currentNode.node.right != null)
				q.offer(new QItem(currentNode.node.right, currentNode.hd + 1));
		}
	}
}
