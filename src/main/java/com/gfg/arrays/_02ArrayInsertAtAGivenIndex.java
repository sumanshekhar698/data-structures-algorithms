package com.gfg.arrays;

import java.util.Arrays;

public class _02ArrayInsertAtAGivenIndex {
//	https://practice.geeksforgeeks.org/problems/array-insert-at-index/0/?track=DSASP-Arrays&batchId=154
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int size = 6;
		int[] myIntArray1 = new int[3];
		int[] myIntArray2 = { 1, 2, 3 };
		int[] myIntArray3 = new int[] { 1, 2, 3 };
		int[] myIntArray4 = new int[] { 11, 22, 33, 44, 57, 0 };
		System.out.println("Before -> " + Arrays.toString(myIntArray4));// [11, 22, 33, 44, 57, 0]

		insertAtIndex(myIntArray4, size, 2, 90);
		System.out.println("After -> " + Arrays.toString(myIntArray4));// [11, 22, 90, 33, 44, 57]

	}

	public static void insertAtIndexTry1(int arr[], int sizeOfArray, int index, int element) {
//		Space Complexity = 2 variables
		int temp;
		int temp2;
		temp = arr[index];
		arr[index] = element;
		for (int i = index + 1; i < sizeOfArray - 1; i++) {
			temp2 = arr[i];
			arr[i] = temp;
			temp = temp2;

		}
		arr[sizeOfArray - 1] = temp;// deadly code

//		The first test case where your code failed:
//			Input:
//			5
//			7 7 1 1
//			4 3
//			Its Correct output is:
//			7 7 1 1 3
//			And Your Code's output is:
//			7 7 1 1 0
	}

	public static void insertAtIndex(int arr[], int sizeOfArray, int index, int element) {
//		Space Complexity = 2 variables
		int temp;
		int temp2;
		temp = arr[index];
		arr[index] = element;
		for (int i = index + 1; i < sizeOfArray - 1; i++) {
			temp2 = arr[i];
			arr[i] = temp;
			temp = temp2;
		}
		if (index != sizeOfArray - 1)
			arr[sizeOfArray - 1] = temp;
	}

	public static void insertAtIndexOptimized(int arr[], int sizeOfArray, int index, int element) {
//		Space Complexity = 0 temp variables
		for (int i = sizeOfArray - 1; i > index; i--) {
			arr[i] = arr[i - 1];
		}
		arr[index] = element;
	}

}
