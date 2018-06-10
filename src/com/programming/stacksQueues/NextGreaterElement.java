package com.programming.stacksQueues;

/*
 * https://www.geeksforgeeks.org/next-greater-element/
 */
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		//	int arr[] = {11, 13, 21, 3};
		//	int arr[] = {1,2,3,4};
		//	int arr[] = {4,3,2,1};
		int [] arr = {1,4,-4,5,6,7,-2};
		printGreaterElement(arr);
	}
	
	public static void printGreaterElement(int [] arr){
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		for(int i=1;i<arr.length;i++){
			while(!stack.isEmpty() && stack.peek() < arr[i])
				System.out.println(stack.pop() + " -> " + arr[i]);
			stack.push(arr[i]);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop() + "-> -1");
		}
	}
}