package com.programming.arrays;

/*
 * https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
 */
import java.util.Arrays;

public class RelativeSorting {

	public static void main(String[] args) {
		int arr[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
		int rel[] = { 2, 1, 9 };
		doRelativeSorting(arr, rel);
		for (int num : arr)
			System.out.print(num + " ");
	}

	public static void doRelativeSorting(int[] arr, int rel[]) {
		// Create a temporary array and a visited array
		// and initialize it with false
		int n = arr.length;
		int[] temp = new int[n];
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[i];
			visited[i] = false;
		}

		// Sort the temporary array
		Arrays.sort(temp);

		// Search for element of rel in temp[]
		int index = 0;
		for (int i = 0; i < rel.length; i++) {
			int ind = firstOccurence(temp, rel[i], 0, n);
			if (ind == -1)
				continue;
			for (int j = ind; (j < n && temp[j] == rel[i]); j++) {
				arr[index++] = temp[j];
				visited[j] = true;
			}

		}

		// Place the remaining elements which are not visited at the end
		for (int i = 0; i < n; i++) {
			if (visited[i] == false)
				arr[index++] = temp[i];
		}
	}

	private static int firstOccurence(int[] arr, int num, int low, int high) {
		if (low > high)
			return -1;
		if (low == high)
			return low;
		int mid = low + (high - low) / 2;
		if ((mid == 0 || num > arr[mid - 1]) && arr[mid] == num)
			return mid;
		else if (num > arr[mid])
			return firstOccurence(arr, num, mid + 1, high);
		return firstOccurence(arr, num, low, mid - 1);
	}

}
