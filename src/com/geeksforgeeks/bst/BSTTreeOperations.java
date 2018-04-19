package com.geeksforgeeks.bst;

public class BSTTreeOperations {
	BSTNode root;

	public BSTTreeOperations() {
		this.root = null;
	}
	
	public void insert(int data){
		root = insertElement(data, root);
	}
	
	public void delete(int data){
		root = deleteElement(data, root);
	}
	
	private BSTNode insertElement(int data, BSTNode current){
		if(current==null){
			current = new BSTNode(data);
		}
		else if(data < current.getData()){
			current.setLeft(insertElement(data, current.getLeft()));
		}
		else
			current.setRight(insertElement(data, current.getRight()));
		return current;
	}
	
	private BSTNode deleteElement(int data, BSTNode current){
		if(current==null)
			return current;
		if(data < current.getData())
			current.setLeft(deleteElement(data, current.getLeft()));
		else if(data > current.getData())
			current.setRight(deleteElement(data, current.getRight()));
		else{
			//	Element to be deleted is found
			//	Case 1: Element has 2 children
			if(current.getLeft()!=null && current.getRight()!=null){
				BSTNode node = getMax(current.getLeft());
				current.setData(node.getData());
				current.setLeft(deleteElement(node.getData(), node.getLeft()));
			}
			else{
				//	Case 2: If element has 1 child or no child
				if(current.getLeft()==null)
					return current.getRight();
				if(current.getRight()==null)
					return current.getLeft();
			}
		}
		return current;
	}
	
	public BSTNode getMax(BSTNode current) {
		while(current.getRight()!=null){
			current = current.getRight();
		}
		return current;
	}
	
	public BSTNode getMin(BSTNode current) {
		while(current.getLeft()!=null){
			current = current.getLeft();
		}
		return current;
	}

	public void printTree(BSTNode current){
		if(current!=null){
			printTree(current.getLeft());
			System.out.print(current.getData() + " ");
			printTree(current.getRight());
		}
	}

	public BSTNode getMaxLeftSubTree(BSTNode current) {
		if(current.getLeft()==null)
			return null;
		current = current.getLeft();
		while(current.getRight()!=null){
			current = current.getRight();
		}
		return current;
	}

	public BSTNode getMinInRightSubTree(BSTNode current) {
		if(current.getRight()==null)
			return null;
		current = current.getRight();
		while(current.getLeft()!=null){
			current = current.getLeft();
		}
		return current;
	}
}