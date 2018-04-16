package com.programming.linkedlists;

public class LinkedListOps {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertElementAtStart(new LinkedListNode(10));
		ll.insertElementAtStart(new LinkedListNode(20));
		ll.insertElementAtStart(new LinkedListNode(30));
		ll.insertElementAtEnd(new LinkedListNode(40));
		ll.traverseLL();
	}
}