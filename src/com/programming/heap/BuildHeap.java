package com.programming.heap;

public class BuildHeap {

	public static void main(String[] args) {
		MaxHeap heap = new MaxHeap(10,0);
		heap.insert(10);
		heap.insert(5);
		heap.insert(2);
		heap.insert(8);
		heap.printHeap();
		System.out.println("Maximum element : " + heap.getMaximum());
	}
}