package com.geeksforgeeks.bst;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 */
public class PreoderArrayBST {

	public static void main(String[] args) {
		//int pre[] = { 2, 4, 3 };
		//int pre[] = {2, 4, 1};
		//int pre[] = {40, 30, 35, 80, 100};
		//int pre[] = {40, 30, 35, 20, 80, 100};
		int pre[] = {40, 30, 35, 37, 80, 40};
		System.out.println(isArrayPreorder(pre, pre.length));
	}

	public static boolean isArrayPreorder(int[] arr, int n) {
		Stack<Integer> stack = new Stack();
		int root = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] < root)
				return false;
			while (!stack.isEmpty() && arr[i] > stack.peek()){
				root = stack.pop();
				System.out.print(root + " ");
			}
			System.out.println();
				
			stack.push(arr[i]);
		}
		return true;
	}

}
