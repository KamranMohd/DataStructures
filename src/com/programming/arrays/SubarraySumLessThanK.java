package com.programming.arrays;

/**
 * Given an array of n positive integers and a positive integer k, the task is to find the maximum subarray size 
 * such that all subarrays of that size have sum of elements less than k.
 * @author Mohd.Kamran
 *
 */
public class SubarraySumLessThanK {

	public static void main(String[] args) {
		//int arr[] = {1, 2, 10, 4};
		//int k = 14;
		int arr[] = {1, 2, 10, 4};
		int k = 8;
		printMaxSizeSubarray(arr, k);
	}
	
	public static void printMaxSizeSubarray(int [] arr, int k){
		int length = arr.length;
		int prefixSum[] = new int[length];
		prefixSum[0] = arr[0];
		for(int i=1;i<length;i++){
			prefixSum[i] += prefixSum[i-1] + arr[i];
		}
		int low = 0,high = length-1,ans = -1,i;
		while(low<=high){
			int mid = (low+high)/2;
			for(i=mid;i<length;i++){
				if(prefixSum[i] - prefixSum[i - mid] > k)
					break;
			}
			if(i==length){
				low = mid+1;
				ans = mid;
			}
			else
				high = mid-1;
		}
		System.out.println("Maximum size subarray with sum less than K : " + ans);
	}
}