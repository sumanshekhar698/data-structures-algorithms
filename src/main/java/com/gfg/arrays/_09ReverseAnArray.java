package com.gfg.arrays;

import java.util.Arrays;

public class _09ReverseAnArray {

	public static void main(String[] args) {
//idea - we shouldn't have a smaller element on the right sector of the given element
		int[] input = { -1234, 1, 1, 2, 3, 4, 4, 7, 8, 10 };
		System.out.println("Original ==>" + Arrays.toString(input));
		reverse(input);
		System.out.println("Revresed ==>" + Arrays.toString(input));

	}

	private static void reverse(int[] input) {
		int i = 0, j = input.length - 1;//two pointer tech O(n) = n/2 = n
		while (j > i) {// works for even and odd sized array
			int temp = input[i];
			input[i] = input[j];
			input[j] = temp;// swap
			i++;// traverse the array
			j--;
		}
	}

}
