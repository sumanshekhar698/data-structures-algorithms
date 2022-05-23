package com.gfg.arrays;

import java.util.ArrayList;
import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/array-insert-at-end/0/?track=DSASP-Arrays&batchId=154
public class _01BasicInsertAtEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Insert insert = new Insert();
		int size = 6;
		int[] myIntArray1 = new int[3];
		int[] myIntArray2 = { 1, 2, 3 };
		int[] myIntArray3 = new int[] { 1, 2, 3 };
		int[] myIntArray4 = new int[] { 1, 2, 3, 77, 88, 0 };
		ArrayList arrayList = new ArrayList<Integer>(3);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(1);
		arrayList.add(4);
		System.out.println(arrayList);
		
//		int arr[] = new int[size];
		System.out.println("Before -> " + Arrays.toString(myIntArray4));// [1, 2, 3, 77, 88, 0]
		insert.insertAtEnd(myIntArray4, size, 100);
		System.out.println("After -> " + Arrays.toString(myIntArray4));// [1, 2, 3, 77, 88, 100]

	}

}

class Insert {
	// You only need to insert the given element at
	// the end, i.e., at index sizeOfArray - 1. You may
	// assume that the array already has sizeOfArray - 1
	// elements.
	public void insertAtEnd(int arr[], int sizeOfPositionInArray, int element) {
		// Your code here
		arr[sizeOfPositionInArray - 1] = element;
	}
}