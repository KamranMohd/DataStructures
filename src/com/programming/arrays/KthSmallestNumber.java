package com.programming.arrays;

/*
 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/
 */
public class KthSmallestNumber {

	public static void main(String[] args) {
		int arr[] = { 12, 3, 5, 7, 4, 19, 26 };
		int k = 3;
		System.out.println("Kth smallest element is : "
				+ getKthSmallestElement(arr, 0, arr.length - 1, k));
	}

	public static int getKthSmallestElement(int[] arr, int low, int high, int k) {
		// If k is within the range of number of elements in
		// the array.
		if (k >= 0 && k <= high - low + 1) {
			int pos = partition(arr, low, high);
			if (pos - low == k - 1)
				return arr[pos];
			if (pos - low > k - 1)
				return getKthSmallestElement(arr, low, pos - 1, k);
			// Recur in the right subarray and change kth element to k - (pos -
			// low + 1) i.e.
			// including both the low and pivot element
			return getKthSmallestElement(arr, pos + 1, high, k
					- (pos - low + 1));
		}
		return Integer.MAX_VALUE;
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		// Swap with pivot
		swap(arr, i + 1, high);
		return i + 1;
	}

	private static void swap(int[] arr, int i, int high) {
		int temp = arr[i];
		arr[i] = arr[high];
		arr[high] = temp;
	}

}
