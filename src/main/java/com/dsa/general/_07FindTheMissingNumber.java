package com.dsa.general;

import java.util.Scanner;

public class _07FindTheMissingNumber {
//	 Given an array of non-duplicating numbers from 1 to n where one number is missing, write an efficient java program to find that missing number.
	public static void main(String[] args) {
		int[] array = { 4, 3, 8, 7, 5, 2, 6 };
		int missingNumber = findMissingNum(array);
		System.out.println("Missing Number is " + missingNumber);
		missingNumber = getMissingNoIntegerOverFlowAvoided(array);
		System.out.println("Missing Number is " + missingNumber);
		missingNumber = findMissingNumOptimizedSafeXOR(array);
		System.out.println("Missing Number is " + missingNumber);
	}

	private static int findMissingNumOptimizedSafeXOR(int[] a) {
		int n = a.length;
		int x1 = a[0];
		int x2 = 1;

		/*
		 * For xor of all the elements in array
		 */
		for (int i = 1; i < n; i++)
			x1 = x1 ^ a[i];

		/*
		 * For xor of all the elements from 1 to n+1
		 */
		for (int i = 2; i <= n + 1; i++)
			x2 = x2 ^ i;

		return (x1 ^ x2);
	}

	public static int findMissingNum(int[] array) {
		int n = array.length + 1;// +1 because one is missing
		int sumOfFirstNNums = n * (n + 1) / 2;
		int actualSumOfArr = 0;
		for (int i = 0; i < array.length; i++) {
			actualSumOfArr += array[i];
		}
		return sumOfFirstNNums - actualSumOfArr;
	}

	static int getMissingNoIntegerOverFlowAvoided(int a[]) {
		int n = a.length;
		int total = 1;
		for (int i = 2; i <= (n + 1); i++) {
			total += i;
			total -= a[i - 2];// traverse all the array
		}
		return total;
	}
}
