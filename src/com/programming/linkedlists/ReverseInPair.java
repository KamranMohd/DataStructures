package com.programming.linkedlists;

public class ReverseInPair {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertElementAtStart(new LinkedListNode(5));
		ll.insertElementAtStart(new LinkedListNode(4));
		ll.insertElementAtStart(new LinkedListNode(3));
		ll.insertElementAtStart(new LinkedListNode(2));
		ll.insertElementAtStart(new LinkedListNode(1));
		ll.traverseLL();
		//doPairReversal(ll);
		swapLLData(ll);
		ll.traverseLL();
	}
	
	/*
	 * Method 1: Swapping the links of the link list
	 */
	public static void doPairReversal(LinkedList ll){
		LinkedListNode prev = ll.head;
		LinkedListNode cur = prev.next;
		ll.head = cur;
		while(true){
			LinkedListNode next = cur.next;
			cur.next = prev;
			// If list ends or the remaining node is the last node
			if(next == null || next.next == null){
				prev.next = next;
				break;
			}
			prev.next = next.next;
			prev = next;
			cur = prev.next;
		}
	}
	
	/*
	 * Method 2: Swapping data of the nodes instead
	 */
	public static void swapLLData(LinkedList ll){
		if(ll.head==null)
			return;
		LinkedListNode cur = ll.head;
		LinkedListNode next = cur.next;
		while(next !=null && next.next!=null){
			int temp = next.data;
			next.data = cur.data;
			cur.data = temp;
			cur = next.next;
			next = cur.next;
		}
	}
}
