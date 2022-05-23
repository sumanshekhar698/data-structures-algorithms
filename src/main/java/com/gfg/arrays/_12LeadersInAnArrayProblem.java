package com.gfg.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class _12LeadersInAnArrayProblem {

	public static void main(String[] args) {
//idea - we shouldn't have a smaller element on the right sector of the given element
		int[] input0 = { 7, 18, 10, 4, 10, 3, 6, 5, 2 };
		int[] input = { 2, 3, 10, 6, 4, 8, 1 };
		System.out.println("Original ==>" + Arrays.toString(input));
		int differnce = findDiffernceNaive(input);
		System.out.println("MAX Diff ==>" + differnce);
		System.out.println("Original ==>" + Arrays.toString(input));
		differnce = findDiffernceOptimized(input);
		System.out.println("MAX Diff ==>" + differnce);

	}

	private static int findDiffernceOptimized(int[] input) {
		int difference = input[1] - input[0], min = input[0];
		for (int j = 1; j < input.length; j++) {
			difference = Integer.max(difference, input[j] - min);
			min = Integer.min(min, input[j]);
		}
		return difference;
	}

	private static int findDiffernceNaive(int[] input) {
		int difference = input[1] - input[0];

		for (int i = 0; i < input.length - 1; i++) {
			for (int j = i + 1; j < input.length; j++) {
//				if (input[j] - input[i] > difference)
//					difference = input[j] - input[i];
				difference = Integer.max(difference, input[j] - input[i]);
			}
		}
		return difference;
	}

}
