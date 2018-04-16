package com.geeksforgeeks.tree;

public class ElementSearch {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		System.out.println(isElementPresent(tree.root, 40, false));
		System.out.println(isElementPresent2(tree.root, 40));
	}
	
	public static boolean isElementPresent(TreeNode root, int data, boolean result){
		//	Base condition 1 : When the root is null
		if(root==null)
			return false;
		//	Base condition 2 : When the root value is equal to search value
		else if(root.data==data)
			return true;
		result = isElementPresent(root.left, data, result);
		if(result == true)
			return result;
		else
			result = isElementPresent(root.right, data, result);
		return result;
	}
	
	public static boolean isElementPresent2(TreeNode root, int data){
		//	Base condition 1 : When the root is null
		if(root==null)
			return false;
		//	Base condition 2 : When the root value is equal to search value
		else if(root.data==data)
			return true;
		return isElementPresent2(root.left, data) || isElementPresent2(root.right, data);
	}
}
