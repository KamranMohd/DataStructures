package com.programming.linkedlists;

/*
 * https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 */

public class CyclicLinkedList {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertElementAtStart(new LinkedListNode(10));
		ll.insertElementAtStart(new LinkedListNode(20));
		ll.insertElementAtStart(new LinkedListNode(30));
		ll.insertElementAtEnd(new LinkedListNode(40));
		ll.insertElementAtEnd(new LinkedListNode(50));
		ll.insertElementAtEnd(new LinkedListNode(60));
		ll.traverseLL();
		LinkedListNode end = getNthNodeFromEnd(ll, 1);
		LinkedListNode connect = getNthNodeFromEnd(ll, 5);
		end.next = connect;
		//ll.traverseLL();
		findCyclicLLNode(ll);
		
	}
	public static void findCyclicLLNode(LinkedList ll){
		LinkedListNode fast = ll.head;
		LinkedListNode slow = ll.head;
		boolean isCyclic = false;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow){
				System.out.println("Loop exists in the list");
				isCyclic = true;
				break;
			}
		}
		System.out.println("No loop in the list");
		if(isCyclic==true){
			LinkedListNode p = ll.head;
			while(p!=slow){
				p = p.next;
				slow = slow.next;
			}
			System.out.println("Cyclic node is : " + slow.data);
		}
	}
	
	public static LinkedListNode getNthNodeFromEnd(LinkedList ll, int n){
		LinkedListNode p = ll.head;
		LinkedListNode q = ll.head;
		int count = 1;
		if(n <= 0)
			return null;
		while(count <= n){
			if(p == null){
				System.out.println("Not enough nodes in the list");
				return null;
			}
			p = p.next;
			count++;
		}
		while(p!=null){
			p = p.next;
			q = q.next;
		}
		return q;
	}
}
