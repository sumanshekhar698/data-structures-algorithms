package com.dsa.general;

import java.util.Arrays;
import java.util.Iterator;

public class _01FindTheMissingAndRepeatingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Given the sample array will be of length n
		// array elements from 1->n where one is missing and one is repeating
		int[] sample1 = { 6, 3, 2, 4, 1, 4 };
		int[] sample = { 6, 3, 7, 4, 1, 3, 5 };

		finderBrute(sample);
		finderMaths(sample);
		finderBetter(sample);
		finderOptimised(sample);

	}

	private static void finderBrute(int[] sample) {
		// TODO Auto-generated method stub
		Arrays.sort(sample);
		for (int i = 0; i < sample.length; i++) {
			if (i != sample.length - 1 && sample[i] == sample[i + 1])
				System.out.println("The repeating element is -> " + sample[i]);
			if (sample[i] != i + 1)
				System.out.println("The missing element is -> " + (i + 1));

		}
	}

	private static void finderOptimised(int[] sample) {
		// TODO Auto-generated method stub
		// Using XOR
		int start = sample[0];
		int bit = 0;
		int i = 1;
		for (i = 1; i < sample.length; i++) {
			start ^= sample[i];// XORing the elements
			start ^= i;// XORing the natural numbers
		}
		start ^= i;// XORing the last element which was missed in the loop
		System.out.println(start + "after XORred");

		// position of first 1 from right to left, in binary representation of an
		// Integer
		// position starts from 1
		bit = start & ~(start - 1);

		System.out.println(bit);

		i = 0;
		int x = 0;
		int y = 0;
		for (i = 0; i < sample.length; i++) {
			if ((sample[i] & bit) != 0)
				/* arr[i] belongs to first set */
				x = x ^ sample[i];

			else
				/* arr[i] belongs to second set */
				y = y ^ sample[i];
		}
		for (i = 1; i <= sample.length; i++) {
			if ((i & bit) != 0)
				/* i belongs to first set */
				x = x ^ i;

			else
				/* i belongs to second set */
				y = y ^ i;
		}
		System.out.println(x + " " + y);

	}

	private static void finderMaths(int[] sample) {
		// TODO Auto-generated method stub
		// Using Arithmetic maths O(n)=n
		int n = sample.length;
		int sum = ((n) * (n + 1)) / 2;
		int squareSum = ((n) * (n + 1) * ((2 * n) + 1)) / 6;
		int iterativeSum = sum;
		int iterativeSquareSum = squareSum;

		for (int i = 0; i < sample.length; i++) {

			iterativeSum -= sample[i];
			iterativeSquareSum -= sample[i] * sample[i];

		}

		System.out.println("*********** Using Maths *********");
		System.out.println("The missing element is -> " + (((iterativeSquareSum / iterativeSum) + iterativeSum) / 2));
		System.out.println("The repeating element is -> " + (((iterativeSquareSum / iterativeSum) - iterativeSum) / 2));

	}

	private static void finderBetter(int[] sample) {
		// TODO Auto-generated method stub
		// will make use of hashing
		// O(n)=2n=n O(s)=s
		int[] frequency = new int[sample.length + 1];
		for (int i = 0; i < sample.length; i++) {
			++frequency[sample[i]];
		}

		System.out.println("*********** Using Hashing *********");
		for (int i = 1; i < frequency.length; i++) {
			if (frequency[i] == 0)
				System.out.println("The missing element is -> " + i);
			else if (frequency[i] == 2)
				System.out.println("The repeating element is -> " + i);
		}
	}

}
