package com.programming.linkedlists;

public class ReverseLL {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertElementAtStart(new LinkedListNode(10));
		ll.insertElementAtStart(new LinkedListNode(20));
		ll.insertElementAtStart(new LinkedListNode(30));
		ll.insertElementAtEnd(new LinkedListNode(40));
		ll.insertElementAtEnd(new LinkedListNode(50));
		ll.insertElementAtEnd(new LinkedListNode(60));
		ll.traverseLL();
		//reverseLL(ll);
		recursiveReversal(ll, ll.head, null);
		ll.traverseLL();
	}
	
	public static void recursiveReversal(LinkedList ll, LinkedListNode current, LinkedListNode prev){
		// Base condition 1 : Empty Linked list
		if(current==null)
			return;
		//	Base condition 2 : Last node
		else if(current.next==null){
			current.next = prev;
			ll.head = current;
			return;
		}
		else{
			LinkedListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			recursiveReversal(ll, current, prev);					
		}
	}
	
	public static void reverseLL(LinkedList ll){
		LinkedListNode current = ll.head;
		LinkedListNode prev = null;
		while(current!=null){
			LinkedListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		ll.head = prev;
	}
	
	/*public static void reverseLL(LinkedList ll){
		LinkedListNode p = ll.head;
		if(p==null || p.next==null)
			return;
		LinkedListNode q = p.next;
		LinkedListNode r = q.next;
		while(r!=null){
			if(p==ll.head)
				p.next = null;
			q.next = p;
			p = q;
			q = r;
			r = r.next;
		}
		if(p==ll.head)
			p.next = null;
		q.next = p;
		ll.head = q;
	}*/
	
	/*public static void reverseLL(LinkedList ll){
		LinkedListNode p = ll.head;
		if(p==null || p.next==null)
			return;
		LinkedListNode q = p.next;
		if(q.next==null){
			q.next = p;
			p.next = null;
			ll.head = q;
		}
		else{
			LinkedListNode r = q.next;
			while(r!=null){
				if(p==ll.head)
					p.next = null;
				q.next = p;
				p = q;
				q = r;
				r = r.next;
			}
			q.next = p;
			ll.head = q;
		}
	}*/
}
