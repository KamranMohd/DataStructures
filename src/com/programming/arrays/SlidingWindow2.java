package com.programming.arrays;

/*
 * https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/
 */
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow2 {

	public static void main(String[] args) {
		int arr[] = {2, 5, -1, 7, -3, -1, -2} ;
		int k = 4;
		printMaxMinSumInWindow(arr, k);
	}
	public static void printMaxMinSumInWindow(int arr[], int k){
		Deque<Integer> max = new LinkedList<Integer>();
		Deque<Integer> min = new LinkedList<Integer>();
		for(int i=0;i<k;i++){
			//	Remove all elements which are smaller than current element
			while(!max.isEmpty() && arr[i] >= arr[max.peekLast()])
				max.removeLast();
			while(!min.isEmpty() && arr[i] <= arr[min.peekLast()])
				min.removeLast();
			max.addLast(i);
			min.addLast(i);
		}
		for(int i=k;i<arr.length;i++){
			System.out.print((arr[max.peekFirst()] + arr[min.peekFirst()]) + " ");
			//	Remove all elements which are out of the current window
			while(!max.isEmpty() && max.peekFirst()<=i-k)
				max.removeFirst();
			while(!min.isEmpty() && min.peekFirst()<=i-k)
				min.removeFirst();
			
			//	Remove all elements which are smaller than current element
			while(!max.isEmpty() && arr[i] >= arr[max.peekLast()])
				max.removeLast();
			while(!min.isEmpty() && arr[i] <= arr[min.peekLast()])
				min.removeLast();
			max.addLast(i);
			min.addLast(i);
		}
		//	Print the maximum from the last window
		System.out.print((arr[max.peekFirst()] + arr[min.peekFirst()]) + " ");
	}
}
