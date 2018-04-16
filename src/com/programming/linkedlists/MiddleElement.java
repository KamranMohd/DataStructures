package com.programming.linkedlists;

public class MiddleElement {

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
		getMiddleElement(ll);
	}

	public static void getMiddleElement(LinkedList ll){
		if(ll==null || ll.head==null)
			return;
		LinkedListNode slow = ll.head;
		LinkedListNode fast = slow;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("Middle element is : " + slow.data);
	}
}
