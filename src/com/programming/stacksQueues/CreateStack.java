package com.programming.stacksQueues;

public class CreateStack {

	public static void main(String[] args) throws Exception {
		FixedSizeStack stack = new FixedSizeStack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.printStack();
		System.out.println("Popped element : " + stack.pop());
		stack.printStack();
		stack.push(5);
		System.out.println("Top element : " + stack.peek());
		stack.printStack();
		//stack.push(6);
	}
}
