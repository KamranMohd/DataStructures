package com.geeksforgeeks.bst;

public class MinimumElement {

	public static void main(String[] args) {
		BST tree = new BST();
		BSTTreeOperations bst = tree.createTree();
		bst.printTree(bst.root);
		System.out.println("\nMinimum element is : " + getMin(bst.root).getData());
		System.out.println("Maximum element is : " + getMax(bst.root).getData());
	}
	
	public static BSTNode getMin(BSTNode current){
		if(current==null)
			return null;
		while(current.getLeft()!=null){
			current = current.getLeft();
		}
		return current;
	}
	
	public static BSTNode getMax(BSTNode current){
		if(current==null)
			return null;
		else{
			if(current.getRight()==null)
				return current;
			else
				return getMax(current.getRight());
		}
	}
}
