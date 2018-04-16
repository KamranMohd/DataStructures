package com.geeksforgeeks.tree;

public class RecursiveTraversal {

	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		System.out.print("Pre Order traversal : ");
		preOrderTraversal(tree.root);
		System.out.println();
		System.out.print("Post Order traversal : ");
		postOrderTraversal(tree.root);
		System.out.println();
		System.out.print("In Order traversal : ");
		InOrderTraversal(tree.root);
		System.out.println();
	}

	public static void preOrderTraversal(TreeNode root) {
		if(root!=null){
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public static void postOrderTraversal(TreeNode root) {
		if(root!=null){
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void InOrderTraversal(TreeNode root) {
		if(root!=null){
			InOrderTraversal(root.left);
			System.out.print(root.data + " ");
			InOrderTraversal(root.right);
		}
	}
}
