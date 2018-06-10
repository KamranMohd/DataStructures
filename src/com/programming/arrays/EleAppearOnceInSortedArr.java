package com.programming.arrays;

/*
 * https://www.geeksforgeeks.org/find-the-element-that-appears-once-in-a-sorted-array/
 */
public class EleAppearOnceInSortedArr {

	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 4, 4, 5, 5, 6, 6};
		//int[] arr = {1, 1, 2, 2, 4, 4, 5, 5, 6, 6};
		getMidElement(arr, 0, arr.length-1);
	}

	public static void getMidElement(int[] arr, int low, int high) {
		if (low > high) {
			System.out.println("No such element found");
			return;
		}
		if (low == high) {
			System.out.println("Element found : " + arr[low]);
			return;
		}
		int mid = low + (high - low) / 2;
		if (mid % 2 == 0) {
			if (arr[mid] == arr[mid + 1])
				getMidElement(arr, mid + 2, high);
			else
				getMidElement(arr, low, mid);
		} else {
			if (arr[mid] == arr[mid - 1])
				getMidElement(arr, mid + 1, high);
			else
				getMidElement(arr, low, mid - 1);
		}

	}

}
