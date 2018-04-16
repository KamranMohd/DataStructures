package com.programming.linkedlists;

public class SortLinkedList {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertElementAtStart(new LinkedListNode(52));
		ll.insertElementAtStart(new LinkedListNode(41));
		ll.insertElementAtStart(new LinkedListNode(13));
		ll.insertElementAtStart(new LinkedListNode(62));
		ll.insertElementAtStart(new LinkedListNode(10));
		ll.traverseLL();
		LinkedListNode sortedList = mergeSort(ll.head);
		ll.printLL(sortedList);
	}

	private static LinkedListNode mergeSort(LinkedListNode head) {
		//	Base condition
		if(head==null || head.next==null)
			return head;
		//	Get the middle element
		LinkedListNode middle = getMiddleNode(head);
		LinkedListNode nextOfMiddle = middle.next;
		//	Divide the linked list into 2 halves
		middle.next = null;
		//	Call mergeSort for the 2 halves
		LinkedListNode first = mergeSort(head);
		LinkedListNode sec = mergeSort(nextOfMiddle);
		
		//	Merge the 2 halves and return the head node
		LinkedListNode sorted = merge(first,sec);
		return sorted;
	}

	private static LinkedListNode merge(LinkedListNode first, LinkedListNode sec) {
		LinkedListNode result = null;
		if(first==null)
			return sec;
		else if(sec==null)
			return first;
		if(first.data < sec.data){
			result = first;
			result.next = merge(first.next,sec);
		}
		else{
			result = sec;
			result.next = merge(first,sec.next);
		}
		return result;
	}

	private static LinkedListNode getMiddleNode(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		LinkedListNode slow_prev = null;
		while(fast!=null && fast.next!=null){
			slow_prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow_prev;
	}

}
