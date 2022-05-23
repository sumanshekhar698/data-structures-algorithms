package com.gfg.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _23LongestNonDecrerasingSubArray {

	public static void main(String[] args) {
		int[] numbers = { -1, 2, -1, 45, -11, 67, 23, -79, -1, -5, 6 };// Unsorted
		numbers = new int[] { -1, 2, -16, 45, -131, 67, 231, 321, -79, -1, -5, 66, 0 };
		int subArray2[] = findLongestNonDecreasingSubArrayGFG(numbers);
		System.out.println("LONGEST INCREASING SUB ARRAY ==> " + Arrays.toString(subArray2));

	}

	private static int[] findLongestNonDecreasingSubArray(int[] numbers) {

		int length = 1, max = 1;
		int start = 0, end = 0, hStart = 0, hEnd = 0;
		while (end < numbers.length) {
			if (numbers[start + 1] >= numbers[start])
				++end;
			else {

				if ((end - start) >= (hEnd - hStart)) {
					hEnd = end;
					hStart = start;
				}
				start = end;
			}
		}
		return new int[] { hStart, hEnd };
	}

	private static int[] findLongestNonDecreasingSubArrayGFG(int[] numbers) {
		int max = 1, len = 1, maxIndex = 0;
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] >= numbers[i - 1])
				len++;
			else {
				if (max < len) {
					max = len;
					maxIndex = i - max;
				}
				len = 1;// resetting the length
			}
		}

//		CORNER CASE
		if (max < len) {// checking for the last element in the array if its is taking into account
			max = len;
			maxIndex = numbers.length - max;
		}
		return new int[] { maxIndex, max + maxIndex - 1 };// -1 to account the 1st element of sub array

	}


}
