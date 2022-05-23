package com.gfg.arrays;

import java.util.ArrayList;

public class _07LargestandSecondLargestElement {

	public static void main(String[] args) {
		int[] inputArray1 = { 4, 76, 34, 67, -1, 78, -213 };
		int[] inputArray2 = { 4, 4, 4, 4, 4, 4, 4 };
		int[] inputArray3 = { -4, -4, -34, -67, -78, -213 };
		int[] inputArray4 = { -4, -4, -4 };
//		Naive Approach - To traverse the array to find if the given element is the largest one or not - O(n^2)
//		Best Case when Array Descending sorted (n)
//		Worst Case when Array ascending sorted  (n^2)

		int largestIndex = findLargestNaive(inputArray1);
		System.out.println("LARGEST >> " + inputArray1[largestIndex]);
		largestIndex = findLargestOptimized(inputArray1);// O(n)
		System.out.println("LARGEST >> " + inputArray1[largestIndex]);
		int secondLargestIndex = findSecondLargestNaive(inputArray1);
		System.out.println("SECOND LARGEST >> " + inputArray1[secondLargestIndex]);
		ArrayList<Integer> largestAndSecondLargest = largestAndSecondLargest(inputArray4);
		System.out.println("***LARGEST >> " + largestAndSecondLargest.get(0));
		System.out.println("***SECOND LARGEST >> " + largestAndSecondLargest.get(1));
	}

	private static int findSecondLargestOptimized(int[] inputArray1) {

		return 0;
	}

	private static int findSecondLargestNaive(int[] inputArray) {
		int result = -1;// if there is no 2nd largest element; then -1
		int largestIndex = findLargestOptimized(inputArray);// O(n)
		for (int i = 0; i < inputArray.length; i++) {// O(n)
			if (inputArray[i] != inputArray[largestIndex]) {
				if (result == -1)
					result = i;// assigning 1st non largest element as result
				else if (inputArray[i] > inputArray[result]) {
					result = i;// updating the 2nd largest element throughout this loop
				}
			}
		}
		return result;
	}

	private static int findLargestOptimized(int[] inputArray) {
		int largestIndex = 0;
//		int largest = inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] > inputArray[largestIndex])
				largestIndex = i;
		}
		return largestIndex;
	}

	private static int findLargestNaive(int[] inputArray) {

		for (int i = 0; i < inputArray.length; i++) {
			boolean flag = true;
			for (int j = 0; j < inputArray.length; j++) {
				if (inputArray[j] > inputArray[i]) {
					flag = false;
					break;
				}
			}
			if (flag == true)
				return i;
		}
		return -1; // DEAD code for safety return
	}

	public static ArrayList<Integer> largestAndSecondLargest(int arr[]) {
		int sizeOfArray = arr.length;
		int largest = 0;
		int sLargest = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (sizeOfArray < 2) {
			sLargest = -1;
			largest = arr[0];
		} else {// checking the condition of the 1st two elements
			if (arr[0] > arr[1]) {
				largest = arr[0];
				sLargest = arr[1];
			} else if (arr[0] < arr[1]) {
				largest = arr[1];
				sLargest = arr[0];
			} else if (arr[0] == arr[1]) {
				largest = arr[0];
				sLargest = Integer.MIN_VALUE;
			}

			for (int i = 2; i < sizeOfArray; i++) {// Traversing the remaining array , while keeping an eye on largest
													// and SLargest
				if (arr[i] < sLargest)
					continue;
				else if (arr[i] > largest) {
					sLargest = largest;
					largest = arr[i];

				} else if (arr[i] > sLargest && arr[i] < largest) {
					sLargest = arr[i];
				}
			}
		}
		result.add(largest);
		result.add(sLargest);
		return result;
	}
}
