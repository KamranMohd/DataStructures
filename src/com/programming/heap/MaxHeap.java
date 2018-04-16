package com.programming.heap;

public class MaxHeap {
	int size;
	int maxSize;
	int heapArr[];
	
	public MaxHeap(int maxSize, int size){
		this.size = size;
		this.maxSize = maxSize;
		this.heapArr = new int[maxSize];
	}
	
	void insert(int element){
		if(size >= maxSize)
			System.out.println("Overflow");
		heapArr[this.size] = element;
		heapify(size);
		size++;
		System.out.println("Successfully inserted the element : " + element + " at index : " + (size-1));
	}
	
	private void heapify(int index) {
		int value = this.heapArr[index];
		while(index>0 && this.heapArr[getParent(index)] < value){
			int temp = this.heapArr[getParent(index)];
			this.heapArr[getParent(index)] = this.heapArr[index];
			this.heapArr[index] = temp;
			index = getParent(index);
		}
	}
	
	int getLeftChild(int pos){
		if(pos<0 || pos>=size)
			return -1;
		return 2*pos+1;
	}
	
	int getRightChild(int pos){
		if(pos<0 || pos>=size)
			return -1;
		return 2*pos+2;
	}
	
	int getParent(int pos){
		/*if(pos<0 || pos>=size)
			return -1;
		System.out.println((pos-1)/2);*/
		return (pos-1)/2;
	}
	
	int getMaximum(){
		return this.heapArr[0];
	}
	
	void printHeap(){
		System.out.print("Current heap array : ");
		for(int i=0;i<size;i++)
			System.out.print(this.heapArr[i] + " ");
		System.out.println();
	}
}
