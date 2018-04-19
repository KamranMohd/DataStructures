package com.geeksforgeeks.bst;

public class SearchElement {

	public static void main(String[] args) {
		BST tree = new BST();
		BSTTreeOperations bst = tree.createTree();
		bst.printTree(bst.root);
		int data = 81;
		System.out.println("\nIs " + data + " present : " + searchElement(data, bst.root));
	}
	
	public static boolean searchElement(int data, BSTNode current){
		if(current==null)
			return false;
		else if(data==current.getData())
			return true;
		else if(data < current.getData())
			return searchElement(data, current.getLeft());
		else
			return searchElement(data, current.getRight());
	}
}
