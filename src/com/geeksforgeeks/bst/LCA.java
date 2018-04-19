package com.geeksforgeeks.bst;

/*
 * https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 */

public class LCA {

	public static void main(String[] args) {
		BST tree = new BST();
		BSTTreeOperations bst = tree.createTree();
		bst.printTree(bst.root);
		int n1 = 21;
		int n2 = 31;
		System.out.println("\nLCA of (" + n1 + "," + n2 + ") : " + 
				(getLCA(bst.root, n1, n2)!=null?getLCA(bst.root, n1, n2).getData():"Either n1 or n2 or both not present"));
	}
	
	public static BSTNode getLCA(BSTNode current, int n1,int n2){
		//	Handles case where one of the nodes or both the nodes are not present
		if(current==null)
			return null;
		if(current.getData() > n1 && current.getData() > n2)
			return getLCA(current.getLeft(), n1, n2);
		if(current.getData() < n1 && current.getData() < n2)
			return getLCA(current.getRight(), n1, n2);
		return (findNode(current, n1) && findNode(current, n2)? current: null);
	}

	private static boolean findNode(BSTNode current, int num) {
		if(current==null)
			return false;
		if(current.getData() > num)
			return findNode(current.getLeft(), num);
		if(current.getData() < num)
			return findNode(current.getRight(), num);
		return true;
	}

	/*public static BSTNode getLCA(BSTNode current, int n1,int n2){
		//	Assumption : Both the nodes are present in the tree
		if(current==null)
			return null;
		if(current.getData() > n1 && current.getData() > n2)
			return getLCA(current.getLeft(), n1, n2);
		if(current.getData() < n1 && current.getData() < n2)
			return getLCA(current.getRight(), n1, n2);
		return current;
	}*/
	
	
}
