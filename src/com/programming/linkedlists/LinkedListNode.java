package com.programming.linkedlists;

public class LinkedListNode {
	public int data;
	public LinkedListNode next;
	
	public LinkedListNode(int data){
		this.data = data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	public int getData(){
		return this.data;
	}
	
	public void setNext(LinkedListNode next){
		this.next = next;
	}
	public LinkedListNode getNext(){
		return this.next;
	}
}