package com.gfg.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _22SubArraySumCases {

	public static void main(String[] args) {
		int[] numbers = { -1, 2, -1, 45, -11, 67, 23, -79, -1, -5, 6 };// Unsorted
		numbers = new int[] { -1, 2, -16, 45, -131, 67, 23, -79, -1, -5, 66, 0 };
		int subArray[] = findSubArraySumZero(numbers);
		System.out.println("SUB ARRAYZEROED ==> " + Arrays.toString(subArray));
		int k = 31;
		int subArray2[] = findSubArraySumK(numbers, k);
		System.out.println("SUB ARRAY 'K'[" + k + "] ==> " + Arrays.toString(subArray2));

	}

	private static int[] findSubArraySumZero(int[] numbers) {

//		calculating the sum array
		int sum = 0;
		int sumArray[] = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0)
				return new int[] { i, i };

			sum += numbers[i];
			sumArray[i] = sum;

			if (sum == 0)
				return new int[] { 0, i };
		}

		System.out.println("SUM ARRAY ==> " + Arrays.toString(sumArray));

		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < sumArray.length; i++) {
			if (hashMap.containsKey(sumArray[i])) {
				System.out.println(hashMap.get(sumArray[i]) + 1 + "    " + i);
				return new int[] { hashMap.get(sumArray[i]) + 1, i };
			} else {
				hashMap.put(sumArray[i], i);
			}
		}
		return null;
	}

	private static int[] findSubArraySumK(int[] numbers, int k) {

//		calculating the sum array
		int sum = 0;
		int sumArray[] = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == k)
				return new int[] { i, i };

			sum += numbers[i];
			sumArray[i] = sum;

			if (sum == k)
				return new int[] { 0, i };
		}

		System.out.println("SUM ARRAY ==> " + Arrays.toString(sumArray));

		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < sumArray.length; i++) {
			if (hashMap.containsKey(sumArray[i] - k)) {
				System.out.println(hashMap.get(sumArray[i]-k) + 1 + "    " + i);
				return new int[] { hashMap.get(sumArray[i]-k) + 1, i };
			} else {
				hashMap.put(sumArray[i], i);
			}
		}
		return null;
	}

	static Boolean subArrayExistsGFG(int arr[]) {
		// Creates an empty hashset hs
		Set<Integer> hs = new HashSet<Integer>();

		// Initialize sum of elements
		int sum = 0;

		// Traverse through the given array
		for (int i = 0; i < arr.length; i++) {
			// Add current element to sum
			sum += arr[i];

			// Return true in following cases
			// a) Current element is 0
			// b) sum of elements from 0 to i is 0
			// c) sum is already present in hash map
			if (arr[i] == 0 || sum == 0 || hs.contains(sum))
				return true;

			// Add sum to hash set
			hs.add(sum);
		}

		// We reach here only when there is
		// no subarray with 0 sum
		return false;
	}

}
