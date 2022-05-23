package com.gfg.arrays;

import java.util.ArrayList;

public class _08CheckForAscendingSortedArray {

	public static void main(String[] args) {
//idea - we shouldn't have a smaller element on the right sector of the given element
		int[] input = { -1234, 1, 1, 2, 3, 4, 4, 7, 8, 10 };
		boolean result = checkSortedAscending(input);
		System.out.println("Sorted ? ==>" + result);

	}

	private static boolean checkSortedAscending(int[] input) {
		for (int i = 1; i < input.length; i++) {
			if (input[i] < input[i - 1])
				return false;
		}
		return true;
	}

}
