package com.geeksforgeeks.tree;

import java.util.ArrayList;

public class PathFromRootToNode {
	static ArrayList<TreeNode> result = new ArrayList<>();
	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		int data = 49;
		getPath(tree.root, data);
		if(result.size()>0){
			for(TreeNode node : result)
				System.out.print(node.data + " ");
		}
		else
			System.out.println("The element does not exist");
	}
	
	public static boolean getPath(TreeNode current, int data){
		if(current==null)
			return false;
		if(current.data==data)
			return true;
		result.add(current);
		if(current.left!=null && getPath(current.left, data)==true)
			return true;
		if(current.right!=null && getPath(current.right, data)==true)
			return true;
		result.remove(result.size()-1);
		return false;
	}
}
