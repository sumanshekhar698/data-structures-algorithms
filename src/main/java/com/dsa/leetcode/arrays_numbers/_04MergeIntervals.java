package com.dsa.leetcode.arrays_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _04MergeIntervals {

//	https://leetcode.com/problems/merge-intervals/submissions/
//	https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
		
	public static void main(String... args) {
		// TODO Auto-generated method stub

		int[][] sample = { { 1, 3 }, { 15, 18 }, { 2, 6 }, { 8, 10 } };
		int[][] result = mergerOptimized(sample);
		print2dArray(result);

	}

	private static void print2dArray(int[][] result) {
		// TODO Auto-generated method stub

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static int[][] mergerOptimized(int[][] sample) {
		
		// TODO Auto-generated method stub
		//O(n) = nlogn + n
		List<int[]> result = new ArrayList<int[]>();
		if (sample.length == 0 || sample == null)
			return result.toArray(new int[0][]);

//		before sorting -> { { 1, 3 }, { 15, 18 }, { 2, 6 }, { 8, 10 } }
//		after sorting -> { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }
		Arrays.sort(sample, (a, b) -> a[0] - b[0]);

		int start = sample[0][0];
		int end = sample[0][1];

		// the merge will happen if end is > start of the next element
		for (int[] interval : sample) {
			if (end >= interval[0])
				/*
				 * Input [[1,4],[2,3]] ; Output [[1,3]] ; Expected [[1,4]]
				 */
				end = Math.max(end, interval[1]);

			else {
				result.add(new int[] { start, end });
				start = interval[0];
				end = interval[1];
			}
		}
		result.add(new int[] { start, end });

		return result.toArray(new int[0][]);
	}

}