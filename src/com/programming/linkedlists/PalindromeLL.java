package com.programming.linkedlists;

public class PalindromeLL {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		/*ll.insertElementAtStart(new LinkedListNode(5));
		ll.insertElementAtStart(new LinkedListNode(4));
		ll.insertElementAtStart(new LinkedListNode(3));
		ll.insertElementAtStart(new LinkedListNode(2));
		ll.insertElementAtStart(new LinkedListNode(1));*/
		ll.insertElementAtStart(new LinkedListNode(5));
		ll.insertElementAtStart(new LinkedListNode(4));
		ll.insertElementAtStart(new LinkedListNode(3));
		ll.insertElementAtStart(new LinkedListNode(4));
		ll.insertElementAtStart(new LinkedListNode(5));
		//ll.insertElementAtStart(new LinkedListNode(6));
		ll.traverseLL();
		checkIsPalindrome(ll);
		ll.traverseLL();
	}
	
	public static void checkIsPalindrome(LinkedList ll){
		LinkedListNode slow = ll.head;
		LinkedListNode fast = ll.head;
		LinkedListNode slow_prev = null;
		//	Find the middle node
		while(fast!=null && fast.next!=null){
			slow_prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//	Reverse the second half of the linked list
		LinkedListNode head2 = null;
		if(fast==null)
			head2 = reverseLinkedList(slow);
		else
			head2 = reverseLinkedList(slow.next);
		
		//	Compare the first half with the second half
		boolean isPalindrome = compareLL(ll.head,head2);
		System.out.println("Is Linked List palindrome : " + isPalindrome);
		
		//	Reverse the second half again and join with the first half
		head2 = reverseLinkedList(head2);
		if(fast==null)
			slow_prev = head2;
		else
			slow.next = head2;
	}
	
	private static boolean compareLL(LinkedListNode head1, LinkedListNode head2) {
		while(head2!=null){
			if(head1.data!=head2.data)
				return false;
			head1 = head1.next;
			head2 = head2.next;
		}
		return true;
	}

	public static LinkedListNode reverseLinkedList(LinkedListNode head){
		LinkedListNode prev = null;
		LinkedListNode cur = head;
		while(cur!=null){
			LinkedListNode temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}
}