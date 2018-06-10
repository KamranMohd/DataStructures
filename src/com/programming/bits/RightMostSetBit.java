package com.programming.bits;

public class RightMostSetBit {

	public static void main(String[] args) {
		int n = 12;
		System.out.println(getRMSetBit(n));
	}
	
	public static int getRMSetBit(int n){
		if(n==0)
			return 0;
		//	Take bitwise AND of n and 2's complement of n (~n + 1)
		int and = n & -n;
		//	Calculate log2 for 'and' to find the position of the set bit
		//	logb(a) = log10(a)/log10(b);
		int pos = (int)(Math.log10(and)/Math.log10(2)) + 1;
		return pos;
	}
}
