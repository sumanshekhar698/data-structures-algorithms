package com.gfg.arrays;

import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/mean-and-median-1587115620/0/?track=DSASP-Arrays&batchId=154#
public class _03MeanMedianOfAnArray {
	public static void main(String[] args) {

//		int[] intArr = new int[] { 11, 22, 33, 44, 57, 0 };
		int[] intArr = new int[] { 1, 2, 19, 28, 5 };
		System.out.println("Array -> " + Arrays.toString(intArr));

		int mean = findMean(intArr);
		int median = findMedian(intArr);
		System.out.println("MEAN -> " + mean);
		System.out.println("MEDIAN -> " + median);
	}

	private static int findMedian(int[] intArr) {
		int N = intArr.length;
		Arrays.sort(intArr);
		// If median is fraction then convert it to integer and return
		if (N % 2 != 0)
			return intArr[N / 2];
		else
			return (intArr[N / 2] + intArr[(N / 2) - 1]) / 2;
	}

	private static int findMean(int[] intArr) {
		int sum = 0;
		int N = intArr.length;
		for (int i = 0; i < N; i++)
			sum += intArr[i];
		return sum / N;
	}

}
