package com.dsa.tricks;

public class _02DecimalToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * If the binary number is 10. Step 1: Remainder when 10 is divided by 2 is
		 * zero. Therefore, arr[0] = 0. Step 2: Divide 10 by 2. New number is 10/2 = 5.
		 * Step 3: Remainder when 5 is divided by 2 is 1. Therefore, arr[1] = 1. Step 4:
		 * Divide 5 by 2. New number is 5/2 = 2. Step 5: Remainder when 2 is divided by
		 * 2 is zero. Therefore, arr[2] = 0. Step 6: Divide 2 by 2. New number is 2/2 =
		 * 1. Step 7: Remainder when 1 is divided by 2 is 1. Therefore, arr[3] = 1. Step
		 * 8: Divide 1 by 2. New number is 1/2 = 0. Step 9: Since number becomes = 0.
		 * Print the array in reverse order. Therefore the equivalent binary number is
		 * 1010
		 */

//		int sample = 10;// b1010
		int sample = 4;// b0100

		int sampleB = 0b1010;
		int[] sampleBarray = { 1, 1, 1, 0, 0, 1 };
		System.out.println(sampleB);
		binaryToDecimal(sampleBarray);
		binaryConvertorAlgoBasedMath(sample);
		binaryConvertorAlgoBasedBitWise(sample);

	}

	private static void binaryToDecimal(int[] sampleBArray) {
		// TODO Auto-generated method stub
		int len = sampleBArray.length;
		int sum = 0;
		int temp;

		for (int i = 0; i < len; i++) {
			sum += sampleBArray[i] * Math.pow(2, len - i - 1);
		}
		System.out.println(sum);
	}

	private static void binaryConvertorAlgoBasedBitWise(int sample) {
		// TODO Auto-generated method stub
		/*
		 * The program scans the decimal digit from left to write, working on each bit.
		 * The decimal digit is supposed to have 32 bits, hence the for loop runs 32
		 * times.
		 * 
		 * The first time, the value of c is 31.
		 * 
		 * Assuming the bit representation of decimal_num initially is
		 * x................................ ( . represents any digit )
		 * 
		 * decimal_num >> 31 shifts all bits rightwards 31 times, such that the first
		 * bit is shifted at the right most end. The result is
		 * 0000000000000000000000000000x. Note that when digits are shifted, 0 is
		 * pre-pended to the left end.
		 * 
		 * The result is then checked to see if it was 0 or 1, and printed accordingly.
		 * 0000000000000000000000000000x & 00000000000000000000000000001 = 1 if x is one
		 * 0000000000000000000000000000x & 00000000000000000000000000001 = 0 if x is
		 * zero.
		 * 
		 * Moving on, and checking the second bit when c is 30. :
		 * 
		 * .Y..............................
		 * 
		 * decimal_num >> 30 results in 000000000000000000000000000000.Y
		 * 
		 * 000000000000000000000000000.Y & 00000000000000000000000000001 = 1 if Y is one
		 * 000000000000000000000000000.Y & 00000000000000000000000000001 = 0 if Y is
		 * zero.
		 * 
		 * We go on printing the results until the last digit.
		 */
		String binary = "";
		for (int i = 31; i >= 0; i--) {
			int k = sample >> i;
			if ((k & 1) > 0)
				binary += 1;
			else
				binary += 0;
		}
		System.out.println(binary + " using bit wise");

	}

	private static void binaryConvertorAlgoBasedMath(int sample) {
		// TODO Auto-generated method stub
		/*
		 * Algorithm: Store the remainder when the number is divided by 2 in an array.
		 * Divide the number by 2 Repeat the above two steps until the number is greater
		 * than zero. Print the array in reverse order now.
		 */
		int i = 0;
		int[] binaryArray = new int[32];// sample is an integer

		while (sample > 0) {
			binaryArray[i++] = sample % 2;
			sample = sample / 2;
		}

		for (int j = binaryArray.length - 1; j >= 0; j--) {
			System.out.print(binaryArray[j]);
		}
		System.out.println(" using simple algo");

	}

}
