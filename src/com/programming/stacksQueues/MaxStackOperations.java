package com.programming.stacksQueues;

public class MaxStackOperations {

	public static void main(String[] args) throws Exception {
		MaxStack s = new MaxStack(10);
		s.push(3);
		s.push(5);
		System.out.println("Max : " + s.getMax());
		System.out.println("Pop : " + s.pop());
		s.push(2);
		s.push(1);
		System.out.println("Max : " + s.getMax());
		System.out.println("Pop : " + s.pop());
		System.out.println("Pop : " + s.pop());
		System.out.println("Peek : " + s.peek());
	}
}
