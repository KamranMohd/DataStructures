package com.programming.heap;

public class CheckArrayIsHeap {

	public static void main(String[] args) {
		int arr[] = {90, 15, 10, 7, 12, 2, 7, 3};
		isHeapArray(arr);
	}
	
	public static void isHeapArray(int [] arr){
		int len = arr.length, left, right;
		boolean flag = true;
		for(int i=0;i<=len/2-1;i++){
			left = 2*i + 1;
			right = 2*i + 2;
			if(left < len && arr[left] > arr[i]){
				flag = false;
				break;
			}
			if(right < len && arr[right] > arr[i]){
				flag = false;
				break;
			}	
		}
		if(flag==false)
			System.out.println("Not a heap array");
		else
			System.out.println("Heap array");
	}

}
