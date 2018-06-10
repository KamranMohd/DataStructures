package com.geeksforgeeks.string;

/*
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */
public class PrintAllPermutations {

	public static void main(String[] args) {
		String str = "ABC";
		printPermutations(str, 0, str.length() - 1);
	}

	public static void printPermutations(String str, int low, int high) {
		if (low > high)
			return;
		if (low == high)
			System.out.println(str);
		for (int i = low; i <= high; i++) {
			str = swap(str, low, i);
			printPermutations(str, low + 1, high);
			str = swap(str, low, i);
		}
	}

	private static String swap(String str, int i, int j) {
		char cha[] = str.toCharArray();
		char temp = cha[i];
		cha[i] = cha[j];
		cha[j] = temp;
		return String.valueOf(cha);
	}

}
