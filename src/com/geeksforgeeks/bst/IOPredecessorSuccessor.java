package com.geeksforgeeks.bst;

import com.geeksforgeeks.bst.BSTTreeOperations;

public class IOPredecessorSuccessor {
	static BSTTreeOperations bst;
	static BSTNode predecessor = null, successor = null;
	public static void main(String[] args) {
		BST tree = new BST();
		bst = tree.createTree();
		bst.printTree(bst.root);
		int data = 40;
		getPredecessor(bst.root,data);
		getSuccessor(bst.root,data);
		System.out.println("\nPredecessor of " + data + " : " + (predecessor==null?"No predecessor":predecessor.getData()));
		System.out.println("Successor of " + data + " : " + (successor==null?"No successor":successor.getData()));
	}
	
	public static void getPredecessor(BSTNode current, int data){
		if(current==null)
			return;
		if(current.getData()==data){
			//	Maximum values in the left subtree
			if(bst.getMaxLeftSubTree(current)!=null)
				predecessor = bst.getMaxLeftSubTree(current);
			return;
		} 
		else if(current.getData() < data){
			predecessor = current;
			getPredecessor(current.getRight(), data);
		}
		else
			getPredecessor(current.getLeft(), data);
	}
	
	public static void getSuccessor(BSTNode current, int data){
		if(current==null)
			return;
		if(current.getData()==data){
			//	Maximum values in the left subtree
			if(bst.getMinInRightSubTree(current)!=null)
				successor = bst.getMinInRightSubTree(current);
			return;
		} 
		else if(current.getData() > data){
			successor = current;
			getSuccessor(current.getLeft(), data);
		}
		else
			getSuccessor(current.getRight(), data);
	}
}
