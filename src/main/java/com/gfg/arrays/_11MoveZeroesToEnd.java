package com.gfg.arrays;

import java.util.Arrays;

public class _11MoveZeroesToEnd {

	public static void main(String[] args) {
//idea - we shouldn't have a smaller element on the right sector of the given element
		int[] input = { -1234, 1, 1, 0, 2, 3, 0, 4, 4, 7, 8, 10, 0, 0 };
		int[] inputSecond = input.clone();
		System.out.println("Original ==>" + Arrays.toString(input));
		moveZeroesRightNaive(input);// 0s will bubble to the right
		System.out.println("Right Shifted ==>" + Arrays.toString(input));
		System.out.println("Original ==>" + Arrays.toString(input));
		moveZeroesRightOptimizedLinear(inputSecond);
		System.out.println("Right Shifted ==>" + Arrays.toString(inputSecond));

	}

	private static void moveZeroesRightOptimizedLinear(int[] input) {
		int count = 0, temp;
		for (int i = 0; i < input.length; i++) {
			if (input[i] != 0) {
				temp = input[i];
				input[i] = input[count];
				input[count++] = temp;
			}
		}
	}

	private static void moveZeroesRightNaive(int[] input) {
//		O(n) = n^2;
		int temp;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 0) {
				for (int j = i + 1; j < input.length; j++) {
					if (input[j] != 0) {
						temp = input[i];
						input[i] = input[j];
						input[j] = temp;
					}
				}
			}
		}

	}

}
