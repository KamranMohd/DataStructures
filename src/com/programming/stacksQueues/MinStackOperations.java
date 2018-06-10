package com.programming.stacksQueues;

/*
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 */
public class MinStackOperations {

	public static void main(String[] args) throws Exception {
		MinStack s = new MinStack(10);
		s.push(3);
		s.push(5);
		System.out.println("Min : " + s.getMin());
		s.push(2);
		s.push(1);
		System.out.println("Min : " + s.getMin());
		System.out.println("Pop : " + s.pop());
		System.out.println("Min : " + s.getMin());
		System.out.println("Pop : " + s.pop());
		System.out.println("Peek : " + s.peek());
	}
}
