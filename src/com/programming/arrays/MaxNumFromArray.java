package com.programming.arrays;

/*
 * https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MaxNumFromArray {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		arr.add("54");
		arr.add("546");
		arr.add("548");
		arr.add("60");
		printLargestNo(arr);
	}

	public static void printLargestNo(List<String> arr) {
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String X, String Y) {
				String XY = X + Y;
				String YX = Y + X;
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});
		Iterator<String> it = arr.iterator();
		while (it.hasNext())
			System.out.print(it.next());
	}

}
