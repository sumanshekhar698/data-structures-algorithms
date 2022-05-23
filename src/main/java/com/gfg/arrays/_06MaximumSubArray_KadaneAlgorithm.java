package com.gfg.arrays;

import java.util.Arrays;

//https://www.youtube.com/watch?v=86CQq3pKSUw
//https://practice.geeksforgeeks.org/problems/who-has-the-majority/0/?track=DSASP-Arrays&batchId=154
public class _06MaximumSubArray_KadaneAlgorithm {
	public static void main(String[] args) {

		int[] intArr = new int[] { 1, 2, 3, -2, 5 };// {-1,-2,-3,-4}
		int[] intArr1 = new int[] { 2,3,-8,7,-1,2,3 };//11
		System.out.println(intArr);
		System.out.println("Array -> " + Arrays.toString(intArr));
		int ans = maximumContiguousSubArraySum(intArr);// Occurrence
		System.out.println(ans);
	}

	private static int maximumContiguousSubArraySum(int[] intArr) {
		// TODO Auto-generated method stub
		int globalMax = intArr[0], currentMax = intArr[0];

		for (int i = 1; i < intArr.length; i++) {
			currentMax = Math.max(intArr[i], currentMax + intArr[i]);
			if (currentMax > globalMax)
				globalMax = currentMax;
		}
		return globalMax;
	}
}
