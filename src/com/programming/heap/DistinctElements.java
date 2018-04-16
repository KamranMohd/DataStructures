package com.programming.heap;

/*
 * https://www.geeksforgeeks.org/maximum-distinct-elements-removing-k-elements/
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistinctElements {

	public static void main(String[] args) {
		//int arr[] = {5, 7, 5, 5, 1, 2, 2}, k = 3;
		int arr[] = {1, 2, 3, 4, 5, 6, 7}, k = 5;
		System.out.println(getDistinctElements(arr, k));
	}
	
	public static int getDistinctElements(int [] arr, int k){
		Map<Integer, Integer> map = new HashMap<>();
		//	Writing frequency of elements in the hashmap
		for(int i=0;i<arr.length;i++){
			if(map.get(arr[i])==null)
				map.put(arr[i],1);
			else
				map.put(arr[i],map.get(arr[i])+1);
		}
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((x,y) -> y-x);
		for(Integer values : map.values()){
			//System.out.println(values);
			heap.add(values);
		}
		
		for(int i=k;i>0;i--){
			int temp = heap.peek();
			heap.remove();
			temp--;
			if(temp!=0)
				heap.add(temp);
		}
		return heap.size();		
	}
}
