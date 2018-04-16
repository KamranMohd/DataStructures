package com.programming.stacks;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 */

public class StockSpan {

	public static void main(String[] args) {
		//int price[] = {100, 80, 60, 70, 60, 75, 85};
		int price[] = {10, 4, 5, 90, 120, 80};
		printStockSpan(price);
	}
	
	public static void printStockSpan(int [] price){
		int stockSpan[] = new int[price.length];
		stockSpan[0] = 1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		for(int i=1;i<price.length;i++){
			while(!stack.isEmpty() && price[stack.peek()]<=price[i])
				stack.pop();
			stockSpan[i] = (stack.isEmpty())?i+1:(i-stack.peek());
			stack.push(i);
		}
		printArr(stockSpan);
 	}

	private static void printArr(int[] stockSpan) {
		for(int i=0;i<stockSpan.length;i++)
			System.out.print(stockSpan[i] + " ");
	}
}
