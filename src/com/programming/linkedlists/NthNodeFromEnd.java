package com.programming.linkedlists;

/*
 * https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
 */
public class NthNodeFromEnd {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertElementAtStart(new LinkedListNode(10));
		ll.insertElementAtStart(new LinkedListNode(20));
		ll.insertElementAtStart(new LinkedListNode(30));
		ll.insertElementAtEnd(new LinkedListNode(40));
		ll.insertElementAtEnd(new LinkedListNode(50));
		ll.insertElementAtEnd(new LinkedListNode(60));
		ll.traverseLL();
		getNthNodeFromEnd(ll, 1);
	}

	public static void getNthNodeFromEnd(LinkedList ll, int n){
		LinkedListNode p = ll.head;
		LinkedListNode q = ll.head;
		int count = 1;
		if(n <= 0)
			return;
		while(count <= n){
			if(p == null){
				System.out.println("Not enough nodes in the list");
				return;
			}
			p = p.next;
			count++;
		}
		while(p!=null){
			p = p.next;
			q = q.next;
		}
		System.out.println("Nth Node from End : " + q.data);
	}
}
