package com.gfg.arrays;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/who-has-the-majority/0/?track=DSASP-Arrays&batchId=154
public class _04HighestFrequencyElement {
	public static void main(String[] args) {

		int[] intArr = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5 };
		System.out.println("Array -> " + Arrays.toString(intArr));

		int x = 2;
		int y = 4;
		int occurrence = findElement(intArr, x, y);// Occurrence
		System.out.println("Highest Occurence -> " + occurrence);
	}

	private static int findElement(int[] intArr, int x, int y) {
		// TODO Auto-generated method stub
		int countX = 0;
		int countY = 0;
		for (int i = 0; i < intArr.length; i++) {
			if (intArr[i] == x) {
				countX++;
			} else if (intArr[i] == y) {
				countY++;
			}
		}
		if (countX == countY)
			return (x < y) ? x : y;
		if (countX > countY)
			return x;
		return y;
	}

	private static void elseif(boolean b) {
		// TODO Auto-generated method stub

	}

}
