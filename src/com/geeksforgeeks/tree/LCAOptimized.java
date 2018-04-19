package com.geeksforgeeks.tree;

/*
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * Using single traversal
 */

public class LCAOptimized {
	static boolean v1 = false, v2 = false;
	public static void main(String[] args) {
		BinaryTree tree = Tree.createTree();
		int n1 = 30;
		int n2 = 40;
		TreeNode lca = findLCA(tree.root, n1, n2);
		if((v1==true && v2==true) || (v1==true && findPath(lca, n2)) || (v2==true && findPath(lca, n1))){
			System.out.println("LCS of (" + n1 + "," + n2 + ") : "
					+ (lca == null ? "" : lca.data));
		}else{
			System.out.println("No LCA. One of the nodes is not present");
		}
		
	}
	
	private static boolean findPath(TreeNode current, int data) {
		if(current==null)
			return false;
		if(current.data==data)
			return true;
		if(current.left!=null && findPath(current.left, data))
			return true;
		if(current.right!=null && findPath(current.right, data))
			return true;
		return false;
	}

	private static TreeNode findLCA(TreeNode current, int n1, int n2) {
		//	No assumptions
		if (current == null)
			return null;
		if (current.data == n1){
			v1 = true;
			return current;
		}
		if (current.data == n2){
			v2 = true;
			return current;
		}

		TreeNode leftLca = findLCA(current.left, n1, n2);
		TreeNode rightLca = findLCA(current.right, n1, n2);

		if (leftLca != null && rightLca != null)
			return current;

		return (leftLca == null ? rightLca : leftLca);
	}

	/*private static TreeNode findLCA(TreeNode current, int n1, int n2) {
		//	Assumption : Both the nodes are present in the tree
		if (current == null)
			return null;
		if (current.data == n1 || current.data == n2)
			return current;

		TreeNode leftLca = findLCA(current.left, n1, n2);
		TreeNode rightLca = findLCA(current.right, n1, n2);

		if (leftLca != null && rightLca != null)
			return current;

		return (leftLca == null ? rightLca : leftLca);
	}*/
}
