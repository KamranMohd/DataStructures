package com.geeksforgeeks.bst;

public class MirrorTree {

	public static void main(String[] args) {
		BST tree = new BST();
		BSTTreeOperations bst = tree.createTree();
		bst.printTree(bst.root);
		BSTNode node = getMirror(bst.root);
		System.out.println();
		bst.printTree(node);
		System.out.println("\nAre T1 and T2 mirror trees : " + isMirrorTree(bst.root, node));
	}

	public static BSTNode getMirror(BSTNode root){
		if(root==null)
			return null;
		BSTNode mirrorLeft = getMirror(root.getLeft());
		BSTNode mirrorRight = getMirror(root.getRight());
		root.setLeft(mirrorRight);
		root.setRight(mirrorLeft);
		return root;
	}
	
	public static boolean isMirrorTree(BSTNode current1, BSTNode current2){
		if((current1==null && current2==null))
			return true;
		if(current1==null || current2==null)
			return false;
		System.out.println(current1.getData() + " , " + current2.getData());
		return ((current1.getData()==current2.getData()) && isMirrorTree(current1.getLeft(), current2.getRight()) && 
				isMirrorTree(current1.getRight(), current2.getLeft()));
	}
}
