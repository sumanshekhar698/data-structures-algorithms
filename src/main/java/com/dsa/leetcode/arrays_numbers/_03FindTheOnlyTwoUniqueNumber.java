package com.dsa.leetcode.arrays_numbers;

public class _03FindTheOnlyTwoUniqueNumber {
//https://leetcode.com/problems/single-number-iii/submissions/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] sample = { 1, 2, 1, 3, 2, 5 };
		int[] finder = finder(sample);
		for (int i : finder) {
			System.out.print(i+" ");
		}
	}

	private static int[] finder(int[] nums) {
		// TODO Auto-generated method stub

		int[] sample = nums;
		int start = 0;
		int bit = 0;

		int i;
		for (i = 0; i < sample.length; i++) {
			start ^= sample[i];// XORing the elements
		}

		bit = start & ~(start - 1);

		i = 0;
		int num1 = 0;
		int num2 = 0;
		for (int num : nums) {
			if ((num & bit) > 0) {
				num1 ^= num;
			} else {
				num2 ^= num;
			}
		}
		int[] answer = { num1, num2 };
		return answer;

	}

}
