package com.programming.arrays;

/*
 * https://www.geeksforgeeks.org/check-loop-array-according-given-constraints/
 */

import java.util.HashSet;
import java.util.Set;

public class LoopInArray {

	public static void main(String[] args) {
		// int arr[] = { 2, -1, 1, 2, 2 };
		// int arr[] = {1, 1, 1, 1, 1, 1};
		// int arr[] = {1, 2};
		int arr[] = { 0 };
		System.out.println(isLoopPresent(arr));

	}

	public static boolean isLoopPresent(int[] arr) {
		boolean isLoopPresent = false;
		int index = 0, size = arr.length;
		Set<Integer> visited = new HashSet<>();
		visited.add(index);
		while (isLoopPresent != true && index < size) {
			if ((arr[index] % size) > 0)
				index = (index + arr[index]) % size;
			else if ((arr[index] % size) < 0)
				index = (index - arr[index]) % size;
			else
				break;
			if (visited.contains(index) == true)
				isLoopPresent = true;
			else
				visited.add(index);
		}
		return isLoopPresent;
	}

}
