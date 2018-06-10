package com.geeksforgeeks.tree;

/*
 * https://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
 */

class Result {
	int maxSum = Integer.MIN_VALUE;
	Node leafNode;
}

public class MaxSumRootToLeaf {
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);
		Result result = new Result();
		getMaxSum(root, result,0);
		System.out.println("Maximum sum : " + result.maxSum);
		System.out.println("Path from root to maximum sum"
				+ " leaf node : ");
		printPath(root, result.leafNode);
	}

	private static boolean printPath(Node node, Node leafNode) {
		if(node==null)
			return false;
		if(node==leafNode || printPath(node.left, leafNode) || printPath(node.right, leafNode)){
			System.out.print(node.data + " ");
			return true;
		}
		return false;	
	}

	public static void getMaxSum(Node node, Result result, int currentSum) {
		if (node == null)
			return;
		currentSum += node.data;
		if (node.left == null && node.right == null) {
			if (currentSum > result.maxSum){
				result.maxSum = currentSum;
				result.leafNode = node;
			}	
		}
		getMaxSum(node.left, result, currentSum);
		getMaxSum(node.right, result, currentSum);
	}

}
