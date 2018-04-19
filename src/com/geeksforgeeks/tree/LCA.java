package com.geeksforgeeks.tree;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * Using multiple traversal
 */

public class LCA {
	
	static List<TreeNode> p1 = new ArrayList<>();
	static List<TreeNode> p2 = new ArrayList<>();
	
	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		int n1 = 40;
		int n2 = 40;
		TreeNode lca = findLCA(tree.root, n1, n2);
		System.out.println("LCS of (" + n1 + "," + n2 + ") : " + (lca==null?"":lca.data));
	}

	private static TreeNode findLCA(TreeNode current, int n1, int n2) {
		if(current==null)
			return null;
		if(findPath(current,n1,p1)!=true || findPath(current,n2,p2)!=true){
			System.out.println("One of the nodes is not present");
			return null;
		}
		int i;
		for(i=0;i<p1.size() && i<p2.size();i++){
			if(p1.get(i)!=p2.get(i))
				break;
		}
		return p1.get(i-1);
	}

	private static boolean findPath(TreeNode current, int num, List<TreeNode> list) {
		if(current==null)
			return false;
		if(current.data==num)
			return true;
		list.add(current);
		if(current.left!=null && findPath(current.left, num, list)==true)
			return true;
		if(current.right!=null && findPath(current.right, num, list)==true)
			return true;
		list.remove(list.size()-1);
		return false;
	}
}
