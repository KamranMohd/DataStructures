package com.programming.arrays;

/*
 * https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 */
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindMax {

	public static void main(String[] args) {
		 int arr[]={12, 1, 78, 90, 57, 89, 56};
	     int k=4;
	     printMaxInWindow(arr, k);
	     System.out.println();
	     printMinInWindow(arr, k);
	}

	public static void printMaxInWindow(int arr[], int k){
		Deque<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<k;i++){
			//	Remove all elements which are smaller than current element
			while(!q.isEmpty() && arr[i] >= arr[q.peekLast()])
				q.removeLast();
			q.addLast(i);
		}
		for(int i=k;i<arr.length;i++){
			System.out.print(arr[q.peekFirst()] + " ");
			//	Remove all elements which are out of the current window
			while(!q.isEmpty() && q.peekFirst()<=i-k)
				q.removeFirst();
			
			//	Remove all elements which are smaller than current element
			while(!q.isEmpty() && arr[i] >= arr[q.peekLast()])
				q.removeLast();
			q.addLast(i);
		}
		//	Print the maximum from the last window
		System.out.print(arr[q.peekFirst()] + " ");
	}
	
	public static void printMinInWindow(int arr[], int k){
		Deque<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<k;i++){
			//	Remove all elements which are greater than current element
			while(!q.isEmpty() && arr[i] <= arr[q.peekLast()])
				q.removeLast();
			q.addLast(i);
		}
		for(int i=k;i<arr.length;i++){
			System.out.print(arr[q.peekFirst()] + " ");
			//	Remove all elements which are out of the current window
			while(!q.isEmpty() && q.peekFirst()<=i-k)
				q.removeFirst();
			
			//	Remove all elements which are greater than current element
			while(!q.isEmpty() && arr[i] <= arr[q.peekLast()])
				q.removeLast();
			q.addLast(i);
		}
		//	Print the smallest element from the last window
		System.out.print(arr[q.peekFirst()] + " ");
	}
}
