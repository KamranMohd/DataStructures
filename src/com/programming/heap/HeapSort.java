package com.programming.heap;

public class HeapSort {

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};
		System.out.println("Before sorting:");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		heapSort(arr);
		System.out.println("\nAfter sorting");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
	}
	
	public static void heapSort(int [] arr){
		for(int i=arr.length/2-1;i>=0;i--)
			heapify(arr, i, arr.length);
		for(int i=arr.length-1;i>=0;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, 0, i);
		}
	}
	public static void heapify(int [] arr, int index, int size){
		int max = index;
		int left = 2*index + 1;
		int right = 2*index + 2;
		if(left < size && arr[left] > arr[index])
			max = left;
		if(right < size && arr[right] > arr[max])
			max = right;
		if(max!=index){
			int temp = arr[max];
			arr[max] = arr[index];
			arr[index] = temp;
			heapify(arr, max, size);
		}
	}
}