package com.programming.stacksQueues;

public class MaxStack {
	int top = -1, max = Integer.MIN_VALUE;
	int[] stack;

	public MaxStack(int size) {
		stack = new int[size];
	}

	public void push(int x) throws Exception {
		if (isFull() == true)
			throw new Exception("Stack is full");
		// Check if element is less than max or not
		System.out.println("Number inserted : " + x);
		if (x > max) {
			stack[++top] = 2 * x - max;
			max = x;
		} else {
			stack[++top] = x;
		}
	}

	public int pop() throws Exception {
		if (isEmpty() == true)
			throw new Exception("Stack is empty");
		int removeEle = stack[top--];
		int result = removeEle;
		if (removeEle > max) {
			result = max;
			max = 2 * max - removeEle;
		}
		return result;
	}

	public int peek() throws Exception {
		if (isEmpty() == true)
			throw new Exception("Stack is empty");
		return stack[top] > max ? max : stack[top];
	}

	public int getMax() throws Exception {
		if (isEmpty() == true)
			throw new Exception("Stack is empty");
		return max;
	}

	public boolean isFull() {
		return (top + 1 >= stack.length) ? true : false;
	}

	public boolean isEmpty() {
		return top == -1 ? true : false;
	}
}
