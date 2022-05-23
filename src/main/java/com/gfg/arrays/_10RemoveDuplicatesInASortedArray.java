package com.gfg.arrays;

import java.util.Arrays;

public class _10RemoveDuplicatesInASortedArray {

	public static void main(String[] args) {
//idea - we shouldn't have a smaller element on the right sector of the given element
		int[] input = { -1234, 1, 1, 2, 3, 4, 4, 7, 8, 10 };
		Arrays.sort(input);
		System.out.println("Original ==>" + Arrays.toString(input));
		int removeDuplicatesNaiveResult = removeDuplicatesNaive(input);
		System.out.println("Duplicates Removed ==>" + Arrays.toString(input) + "\n Current count ==> "
				+ removeDuplicatesNaiveResult);
		removeDuplicatesNaiveResult = removeDuplicatesOptimizedForSpace(input);
		System.out.println("Duplicates Removed ==>" + Arrays.toString(input) + "\n Current count ==> "
				+ removeDuplicatesNaiveResult);

	}

	private static int removeDuplicatesOptimizedForSpace(int[] input) {
		int result = 0;
		for (int i = 1; i < input.length; i++) {
			if (input[i] != input[result]) {
				input[++result] = input[i];
			}
		}
		for (int i = result; i < input.length; i++) {
			input[i] = 0;
		}
		return result;
	}

	private static int removeDuplicatesNaive(int[] input) {
		int[] temp = new int[input.length];
		temp[0] = input[0];
		int index = 0;
		for (int i = 1; i < input.length; i++) {
			if (temp[index] != input[i])
				temp[++index] = input[i];
		}

		for (int i = 0; i < temp.length; i++) {
			input[i] = temp[i];
		}
//		input = temp;// have to check
//		System.out.println(Arrays.toString(input));
		return ++index;
	}
}
