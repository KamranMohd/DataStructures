package com.geeksforgeeks.tree;

/*
 * https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 */
public class MaxSumPathAnyNodetoAnyNode {

	static int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(10);
		root.left.left = new Node(20);
		root.left.right = new Node(1);
		root.right.right = new Node(-25);
		root.right.right.left = new Node(3);
		root.right.right.right = new Node(4);
		getMaxSum(root);
		System.out.println("maximum path sum is : " +
							maxSum);
	}

	public static int getMaxSum(Node node){
		//	If root is null then sum is 0
		if(node==null)
			return 0;
		
		//	Get the sum from root to left subtree and 
		//	root to right subtree
		int lSum = getMaxSum(node.left);
		int rSum = getMaxSum(node.right);
		
		//	If the max sum path can contain ancestors
		//	of the current node. Then take maximum of left or right
		//	subtree and add it to root and compare it with just the node
		int single_max = Math.max(Math.max(lSum,rSum) + node.data, node.data);
		
		//	If no ancestors are on the path of the
		//	max sum path
		int top_max = Math.max(single_max, lSum + rSum + node.data);
		
		maxSum = Math.max(maxSum,top_max);
		return single_max;
	}
}
