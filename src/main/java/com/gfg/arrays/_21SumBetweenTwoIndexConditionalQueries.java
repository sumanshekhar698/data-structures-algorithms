package com.gfg.arrays;

import java.util.Arrays;

public class _21SumBetweenTwoIndexConditionalQueries {

	public static void main(String[] args) {
		int[] numbers = { 1, 45, 67, 2323, 22, 0, -1, -5, -999 };// Unsorted
		int i = 2, j = 5;
		int sum = findSum(numbers, i, j);
		System.out.println("SUM ==> " + sum);
		int[][] queries = { { 2, 6 }, { 0, 8 }, { 5, 7 } };
		int sumComplex = findSumComplexBrute(numbers, queries);
		System.out.println("SUM COMPLEX ==> " + sumComplex);
		sumComplex = findSumComplexOptimized(numbers, queries);
		System.out.println("SUM COMPLEX ==> " + sumComplex);

	}

	private static int findSumComplexOptimized(int[] numbers, int[][] queries) {

		int overAllSum = 0;
		int sum = 0;
		int sumArray[] = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
			sumArray[i] = sum;
		}

		System.out.println("SUM ARRAY ==> " + Arrays.toString(sumArray));

		for (int[] query : queries) {
			if (query[0] == 0)
				overAllSum += sumArray[query[1]];
			else
				overAllSum += sumArray[query[1]] - sumArray[query[0] - 1];
		}
		return overAllSum;
	}

	private static int findSumComplexBrute(int[] numbers, int[][] queries) {

//		O = q*n
		int sumOmega = 0;
		for (int[] query : queries) {
			sumOmega += findSum(numbers, query[0], query[1]);
		}
		return sumOmega;
	}

	private static int findSum(int[] numbers, int i, int j) {
		int sum = 0;
		for (int k = i; k <= j; k++) {
			sum += numbers[k];
		}
		return sum;
	}

}
