package com.programming.linkedlists;

public class DisplayReverseLL {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertElementAtStart(new LinkedListNode(11));
		ll.insertElementAtStart(new LinkedListNode(99));
		ll.insertElementAtStart(new LinkedListNode(33));
		ll.insertElementAtEnd(new LinkedListNode(44));
		ll.insertElementAtEnd(new LinkedListNode(55));
		ll.insertElementAtEnd(new LinkedListNode(77));
		ll.insertElementAtEnd(new LinkedListNode(100));
		ll.traverseLL();
		displayReverseLL(ll, ll.head);
	}
	
	public static void displayReverseLL(LinkedList ll, LinkedListNode head){
		if(head==null)
			return;
		else{
			displayReverseLL(ll, head.next);
			System.out.print(head.data + " -> ");
		}
	}
}