package com.dsa.leetcode.arrays_numbers;

public class _06MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sample = { 10, 0, -5, 22, 55, 0, 6, 0, 63, 86 };
//		int[] dummy = shiftNaive(sample);
//		for (int i = 0; i < dummy.length; i++) {
//			System.out.print(dummy[i] + " ");
//		}
//		System.out.println();
		shiftPro(sample);
		for (int i = 0; i < sample.length; i++) {
			System.out.print(sample[i] + " ");
		}

	}

	private static int[] shiftNaive(int[] sample) {
		// TODO Auto-generated method stub
		int dummy[] = new int[sample.length];
		int counter = 0;
		for (int i = 0; i < sample.length; i++) {
			if (sample[i] != 0)
				dummy[counter++] = sample[i];
		}
		return dummy;
	}

	private static void shiftPro(int[] sample) {
		// TODO Auto-generated method stub
		int n = sample.length;
		if (n == 0 || n == 1)
			return;

		int i = 0, j = 0;
		int temp;

		while (j < n) {
			if (sample[j] == 0)
				j++;
			else {
//				sample[j] += sample[i];
//				sample[i] = sample[j] - sample[i];
//				sample[j] -= sample[i];

				temp = sample[j];
				sample[j] = sample[i];
				sample[i] = temp;
				i++;// i will always try to point at the first '0' element
				j++;
			}
		}
	}

	public void moveZeroes(int[] nums) {

		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[index] = nums[i];
				index++;
			}
		}

		while (index < nums.length) {
			nums[index] = 0;
			index++;
		}

	}

}
