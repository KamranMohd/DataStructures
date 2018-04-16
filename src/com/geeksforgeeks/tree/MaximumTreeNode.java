package com.geeksforgeeks.tree;

public class MaximumTreeNode {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		System.out.println("Maximum value : " + getMaximum(tree.root));
	}

	public static int getMaximum(TreeNode root){
		int max = Integer.MIN_VALUE;
		if(root!=null){			
			int leftMax = getMaximum(root.left);
			int rightMax = getMaximum(root.right);
			if(leftMax > rightMax)
				max = leftMax;
			else
				max = rightMax;
			if(root.data > max)
				return root.data;
		}	
		return max;
	}
}
