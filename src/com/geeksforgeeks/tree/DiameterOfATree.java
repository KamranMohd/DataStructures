package com.geeksforgeeks.tree;

/*
 * https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/
 */

public class DiameterOfATree {
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);
        System.out.println("Diameter of the tree : " + getDiameter(root));
        getDiameterOpt(root);
        System.out.println("Diameter of the tree : " + ans);
	}
	
	public static int getDiameter(Node root){
		if(root==null)
			return 0;
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);
		int ld = getDiameter(root.left);
		int rd = getDiameter(root.right);
		return Math.max(lh+rh+1, Math.max(ld,rd));
		
	}

	private static int getHeight(Node root) {
		if(root==null)
			return 0;
		return (1+Math.max(getHeight(root.left), getHeight(root.right)));
	}
	
	//	Optimized Method: Using only height in O(n)
	public static int getDiameterOpt(Node root){
		if(root==null)
			return 0;
		int lh = getDiameterOpt(root.left);
		int rh = getDiameterOpt(root.right);
		
		ans = Math.max(ans, 1 + lh + rh);
		return 1+ Math.max(lh, rh);
	}
}
