package com.programming.arrays;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/beautiful-journey-1/description/
 * @author Mohd.Kamran
 * Tip: Mulitiplicaiton wil be maximum when the two sums are as close as possible
 */
public class MaximumMultiplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<size;i++)
			arr[i] = sc.nextInt();
		getMaxMultiplication(arr);
		sc.close();
	}
	
	static void getMaxMultiplication(int [] arr){
		int len = arr.length;
		long prefixSum[] = new long[len];
		prefixSum[0] = arr[0];
		for(int i=1;i<len;i++)
			prefixSum[i] = prefixSum[i-1] + arr[i];
		long ans = Long.MIN_VALUE;
		for(int i=0;i<len;i++){
			if((prefixSum[len-1] - prefixSum[i]) * prefixSum[i] > ans)
				ans = (prefixSum[len-1] - prefixSum[i]) * prefixSum[i];
		}
		System.out.println(ans);
	}
}