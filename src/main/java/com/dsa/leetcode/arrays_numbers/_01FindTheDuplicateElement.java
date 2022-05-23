package com.dsa.leetcode.arrays_numbers;

import java.util.Arrays;

public class _01FindTheDuplicateElement {
	/*
	 * https://leetcode.com/problems/find-the-duplicate-number/
	 * https://www.youtube.com/watch?v=32Ll35mhWg0
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sample[] = { 1, 2, 6, 5, 9, 22, 22, 31, 100 };
		int answer = finderNaive(sample);
		System.out.println(answer);

		int answer1 = finderNaiveOptimised(sample);
		System.out.println(answer1);

//		Constraint if [ n = array.length  => array has elements in range of [1, n-1] and one repeating, so total n elements
		int specialSample[] = { 1, 2, 6, 5, 9, 7, 6, 8, 3, 4 };
		int answer3 = finder(specialSample);
		System.out.println(answer3);

	}

	private static int finder(int... specialSample) {
		// TODO Auto-generated method stub
		/*
		 * Linked List Cycle method O(n)=n | for Space O(n)=1 But its only for special
		 * case Constraint if [ n = array.length => array has elements in range of [1,
		 * n-1] and one repeating, so total n elements
		 * 
		 */

		// initialize the tortoise
		int slow = specialSample[0];
		int fast = specialSample[0];

		// unleashing the tortoise
		do {
			slow = specialSample[slow];// slow and constant moving tortoise
			fast = specialSample[specialSample[fast]];// double fast moving tortoise

		} while (slow != fast);// wait for until the collision

		// preparing for 2nd collision
		fast = specialSample[0];
		while (slow != fast) {
			slow = specialSample[slow];// constant moving tortoise
			fast = specialSample[fast];// speed matched to slow tortoise

		}

		// return the point of 2nd collision
		return slow;// slow=fast
	}

	private static int finderNaiveOptimised(int[] sample) {
		// TODO Auto-generated method stub
		/*
		 * We can use hashing O(n)=2n+Space O(max) ; No distortion to array
		 * 
		 */

		int max = sample[0];
		for (int i = 0; i < sample.length - 1; i++) {
			if (sample[i + 1] > sample[i]) {
				max = sample[i + 1];
			}
		}
//		System.out.println(max);

		int[] frequency = new int[max + 1];
		for (int i = 0; i < sample.length; i++) {
			frequency[sample[i]]++;
			if (frequency[sample[i]] > 1) {
				return sample[i];
			}
		}
		return -1;
	}

	private static int finderNaive(int[] sample) {
		// TODO Auto-generated method stub
		/*
		 * Sort the array and traverse for finding the 2 consecutive duplicate elements
		 * O(n)=n^2 + n + Space O(1) [Bubble Sort] ; nlog(n) + Space O(1) [Merge Sort]
		 * Also this will distort the array
		 */
		Arrays.sort(sample);
		for (int i = 0; i < sample.length - 1; i++) {
			if (sample[i] == sample[i + 1]) {
				return sample[i];
			}
		}
		return -1;
	}
}
