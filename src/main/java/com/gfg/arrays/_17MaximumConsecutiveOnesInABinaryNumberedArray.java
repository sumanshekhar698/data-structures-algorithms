package com.gfg.arrays;

import java.util.Arrays;

public class _17MaximumConsecutiveOnesInABinaryNumberedArray {

	public static void main(String[] args) {
		int[] binaryArray = { 0, 1, 1, 1, 0, 1, 1 };
		System.out.println("Original Array==> " + Arrays.toString(binaryArray));
		int frequency = countConsecutiveOnesNaive(binaryArray);
		System.out.println("Frequency  ==> " + frequency);
		frequency = countConsecutiveOnesOptimizedLinear(binaryArray);
		System.out.println("Frequency for Optimized ==> " + frequency);

	}

	private static int countConsecutiveOnesOptimizedLinear(int[] binaryArray) {
		int result = 0;
		int current = 0;
		for (int i = 0; i < binaryArray.length; i++) {
			if (binaryArray[i] == 1)
				current++;
			else {
				result = Math.max(current, result);
				current = 0;
			}

			// GFG
//			if (binaryArray[i] == 0)
//				current = 0;
//			else {
//				current++;
//				result = Math.max(current, result);
//			}

		}
		return result;
	}

	private static int countConsecutiveOnesNaive(int[] binaryArray) {
		int result = 0;
		for (int i = 0; i < binaryArray.length; i++) {
			int current = 0;
			for (int j = i; j < binaryArray.length; j++) {
				if (binaryArray[j] == 1)
					current++;
				else
					break;
			}
			result = Math.max(current, result);
		}

		return result;
	}

}
