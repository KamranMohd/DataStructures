package com.geeksforgeeks.bst;

public class BST {
	BSTTreeOperations tree;

	public BSTTreeOperations createTree() {
		tree = new BSTTreeOperations();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		return tree;
	}
}
