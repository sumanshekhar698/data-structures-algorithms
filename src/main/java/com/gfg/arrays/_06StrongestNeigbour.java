package com.gfg.arrays;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/who-has-the-majority/0/?track=DSASP-Arrays&batchId=154
public class _06StrongestNeigbour {
	public static void main(String[] args) {

		int[] intArr = new int[] { 89,  89, 60 };
		System.out.println("Array -> " + Arrays.toString(intArr));

		int x = 2;
		int y = 4;
		maximumAdjacent(intArr.length, intArr);// Occurrence
	}

	static void maximumAdjacent(int sizeOfArray, int arr[]) {

		/*********************************
		 * Your code here Function should print max adjacents for all pairs Use string
		 * buffer for fast output
		 ***********************************/
		long startTime = System.nanoTime();
		StringBuffer stringBuffer = new StringBuffer();
//		String stringBuffer = "";
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1])
				stringBuffer.append(arr[i] + " ");
//				stringBuffer += arr[i]+" ";
			else
				stringBuffer.append(arr[i + 1] + " ");
//				stringBuffer += arr[i]+" ";
		}
//		System.out.println(stringBuffer.deleteCharAt(stringBuffer.length() - 1));//15700ns
		System.out.println(stringBuffer.substring(0, stringBuffer.length() - 1));
//		System.out.println(stringBuffer.substring(0,stringBuffer.length() - 1));
		long endTime = System.nanoTime();
		System.out.println("Latency -> " + (endTime - startTime));

		for (int i = 0; i < sizeOfArray - 1; i++) {
			int max = Math.max(arr[i] , arr[i + 1]);
			System.out.print(max+" ");
		}
	}

}
