package com.programming.stacks;

public class FixedSizeStack {
	int top, capacity;
	int [] stackArr;
	public FixedSizeStack(int capacity){
		this.top = -1;
		this.capacity = capacity;
		stackArr = new int[capacity];
	}
	
	public void push(int val) throws Exception{
		if(isFull()==true){
			throw new Exception("Stack is full");
		}
		stackArr[++top] = val;
	}
	
	public int pop() throws Exception{
		if(isEmpty()==true){
			throw new Exception("Stack is empty");
		}
		return stackArr[top--];
	}
	
	public int peek() throws Exception{
		if(isEmpty()==true){
			throw new Exception("Stack is empty");
		}
		return stackArr[top];
	}
	
	public int getSize(){
		return top+1;
	}
	
	public boolean isFull(){
		return (top+1==capacity);
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	public void printStack() throws Exception{
		if(isEmpty()==true){
			throw new Exception("Stack is empty");
		}
		for(int i=0;i<getSize();i++)
			System.out.print(stackArr[i] + " ");
		System.out.println();
	}
}
