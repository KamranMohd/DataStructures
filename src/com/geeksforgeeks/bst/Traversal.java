package com.geeksforgeeks.bst;

public class Traversal {

	public static void main(String[] args) {
		BST tree = new BST();
		BSTTreeOperations bst = tree.createTree();
		System.out.println("Before deleting 20");
		bst.printTree(bst.root);
		System.out.println("\nAfter deleting 20");
		bst.delete(20);
		bst.printTree(bst.root);
	}
}