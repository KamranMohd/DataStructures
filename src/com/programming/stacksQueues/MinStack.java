package com.programming.stacksQueues;

/*
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 */
public class MinStack {
	int top = -1, min = Integer.MAX_VALUE;
	int[] stack;

	public MinStack(int size) {
		stack = new int[size];
	}

	public void push(int x) throws Exception {
		if (isFull() == true)
			throw new Exception("Stack is full");
		// Check if element is less than min or not
		System.out.println("Number inserted : " + x);
		if (x < min) {
			stack[++top] = 2 * x - min;
			min = x;
		} else {
			stack[++top] = x;
		}
	}

	public int pop() throws Exception {
		if (isEmpty() == true)
			throw new Exception("Stack is empty");
		int removeEle = stack[top--];
		int result = removeEle;
		if (removeEle < min) {
			result = min;
			min = 2 * min - removeEle;
		}
		return result;
	}

	public int peek() throws Exception {
		if (isEmpty() == true)
			throw new Exception("Stack is empty");
		return stack[top] < min ? min : stack[top];
	}

	public int getMin() throws Exception {
		if (isEmpty() == true)
			throw new Exception("Stack is empty");
		return min;
	}

	public boolean isFull() {
		return (top + 1 >= stack.length) ? true : false;
	}

	public boolean isEmpty() {
		return top == -1 ? true : false;
	}
}
