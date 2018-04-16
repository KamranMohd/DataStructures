package com.programming.linkedlists;

public class LinkedList {
	LinkedListNode head;
	
	public LinkedList(){
		this.head = null;
	}
	
	public void insertElementAtStart(LinkedListNode node){
		if(head == null){
			head = node;
			head.next = null;
		}else{
			node.next = head;
			head = node;
		}
	}
	
	public void insertElementAtEnd(LinkedListNode node){
		LinkedListNode p = head;
		if(head == null){
			head = node;
			head.next = null;
		}
		while(p.next!=null)
			p = p.next;
		p.next = node;
		node.next = null;	
	}
	
	public void insertAtPos(LinkedListNode node, int pos){
		
	}
	
	public int getLength(){
		int len = 0;
		LinkedListNode p = head;
		while(p!=null){
			len++;
			p = p.next;
		}	
		return len;
	}
	
	public void traverseLL(){
		LinkedListNode p = head;
		while(p!=null){
			System.out.print(p.data + ((p.next==null)? "" :" -> "));
			p = p.next;
		}
		System.out.println();
	}

	public void printLL(LinkedListNode sortedList) {
		while(sortedList!=null){
			System.out.print(sortedList.data + (sortedList.next!=null?" -> ":""));
			sortedList = sortedList.next;
		}
		System.out.println();
	}
}
