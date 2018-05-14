package com.geeksforgeeks.tree;

/**
 * https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class QItem {
	TreeNode node;
	int hd;

	public QItem(TreeNode node, int hd) {
		this.node = node;
		this.hd = hd;
	}
}

public class VerticalTraversal {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		printVerticalTraversal(tree.root);
	}

	public static void printVerticalTraversal(TreeNode node) {
		if (node == null)
			return;
		Map<Integer, ArrayList<TreeNode>> map = new HashMap<>();
		Queue<QItem> q = new LinkedList<>();
		q.offer(new QItem(node, 0));
		while (!q.isEmpty()) {
			QItem popNode = q.poll();
			if (map.containsKey(popNode.hd))
				map.get(popNode.hd).add(popNode.node);
			else {
				ArrayList<TreeNode> list = new ArrayList<>();
				list.add(popNode.node);
				map.put(popNode.hd, list);
			}
			if (popNode.node.left != null)
				q.offer(new QItem(popNode.node.left, popNode.hd - 1));
			if (popNode.node.right != null)
				q.offer(new QItem(popNode.node.right, popNode.hd + 1));

		}
		List<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		for (Integer dist : keys) {
			for (TreeNode n : map.get(dist)) {
				System.out.print(n.data + " ");
			}
			System.out.println();
		}
	}

}
