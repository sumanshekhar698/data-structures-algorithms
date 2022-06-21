package com.gfg.arrays;

public class _24SumOfAllSubArrays {

	/* Driver program to test above function */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int n = arr.length;
		System.out.println("Sum of SubArray : " + subArraySumNaive(arr, n));
		System.out.println("Sum of SubArray : " + subArraySumOPtimizedLinear(arr, n));
	}

	public static long subArraySumNaive(int arr[], int n) {
		long result = 0, temp = 0;
		for (int i = 0; i < n; i++) {
			temp = 0;// *temp very crucial to compute all the sum
			for (int j = i; j < n; j++) {
				temp += arr[j];// *
				result += temp;
			}
		}
		return result;
	}

	public static long subArraySumOPtimizedLinear(int arr[], int n) {
		long result = 0;
		for (int i = 0; i < n; i++)
			result += (arr[i] * (i + 1) * (n - i));
		// Formula Discovery
		// We can see a pattern if we add all the Array Elements
		// Case 1: SUM of all arrays starting with arr[i] -> (n-1) times
		// Case 2: SUM of all arrays NOT starting with arr[i] -> i(n-1) times
		// SUM : CASE 1 + CASE 2 = (arr[i] * (i + 1) * (n - i))

		return result;
	}

}