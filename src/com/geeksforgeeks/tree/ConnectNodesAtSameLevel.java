package com.geeksforgeeks.tree;

/*
 * https://www.geeksforgeeks.org/connect-nodes-at-same-level/
 */
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int data;
	Node left;
	Node right;
	Node nextRight;
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
		this.nextRight = null;
	}
}

public class ConnectNodesAtSameLevel {

	public static void main(String[] args) {
		Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(90);
        connectNodes(root);
     // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in \n" +
      "the tree (-1 is printed if there is no nextRight)");
        System.out.println("nextRight of "+ root.data +" is "+
        ((root.nextRight != null) ? root.nextRight.data : -1));
        System.out.println("nextRight of "+ root.left.data+" is "+
        ((root.left.nextRight != null) ? root.left.nextRight.data : -1));
        System.out.println("nextRight of "+ root.right.data+" is "+
        ((root.right.nextRight != null) ? root.right.nextRight.data : -1));
        System.out.println("nextRight of "+  root.left.left.data+" is "+
        ((root.left.left.nextRight != null) ? root.left.left.nextRight.data : -1));
        System.out.println("nextRight of "+  root.right.right.data+" is "+
        ((root.right.right.nextRight != null) ? root.right.right.nextRight.data : -1));
	}

	public static void connectNodes(Node root){
		if(root==null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty()){
			Node pop = q.poll();
			if(pop!=null){
				pop.nextRight = q.peek();
				if(pop.left!=null)
					q.add(pop.left);
				if(pop.right!=null)
					q.add(pop.right);
			}
			else if(!q.isEmpty())
				q.add(null);
		}
	}
}
