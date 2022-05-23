package com.gfg.arrays;

import java.util.Arrays;

public class _20MaximumCircularSubArray {
	public static void main(String[] args) {

		int[] intArr = new int[] { 5, -2, 3, 4 };// {-1,-2,-3,-4}
		int[] intArr1 = new int[] { 2, 3, -8, 7, -1, 2, 3 };// 11
		System.out.println(intArr);
		System.out.println("Array -> " + Arrays.toString(intArr));
		int ans = maximumCircularContiguousSubArraySumNaive(intArr);// Occurrence
		System.out.println(ans);
		ans = maximumCircularSubArraySumOptimized(intArr);// Occurrence
		System.out.println(ans);
	}

	private static int maximumCircularContiguousSubArraySumNaive(int[] intArr) {
//		Every subarray starts with an array element
		int res = intArr[0];
		int n = intArr.length;
		for (int i = 0; i < intArr.length; i++) {
			int currentMax = intArr[i];
			int currentSum = intArr[i];
			for (int j = 1; j < intArr.length; j++) {
				int index = (i + j) % n;// to dry run
				currentSum += intArr[index];
				currentMax = Math.max(currentMax, currentSum);
			}
			res = Math.max(currentMax, res);
		}
		return res;
	}

	private static int maximumCircularSubArraySumOptimized(int[] intArr) {
		// NormalSubArrayMaxSum
		int maxNormalArraySubArraySum = maximumContiguousSubArraySum(intArr);

		// Optimizes and a major correction for our specific logic because for complete
		// negative array maxCircularSubArray sum will come zero if we remove this if {}
		if (maxNormalArraySubArraySum < 0)
			return maxNormalArraySubArraySum;

		// CircularSubArrayMaxSum
		int intArrSum = 0;
		for (int i = 0; i < intArr.length; i++) {// Inversion of Array
			intArrSum += intArr[i];
			intArr[i] = -intArr[i];
		}
		int maxCircularSubArray = intArrSum + maximumContiguousSubArraySum(intArr);// adding because -(-) = +
		// return the MAX of Circular and Linear subarray
		return Math.max(maxNormalArraySubArraySum, maxCircularSubArray);
	}

	private static int maximumContiguousSubArraySum(int[] intArr) {
		int globalMax = intArr[0], currentMax = intArr[0];

		for (int i = 1; i < intArr.length; i++) {
			currentMax = Math.max(intArr[i], currentMax + intArr[i]);
			if (currentMax > globalMax)
				globalMax = currentMax;
		}
		return globalMax;
	}
}
