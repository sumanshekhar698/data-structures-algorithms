package com.dsa.general;

public class BinarySearchRecursive {
	public static void main(String[] args) {
		int[] arr1 = { 0, 1, 2, 3, 4, 5, 6, 7 };
		int key = 7;
		System.out.println(binarySearch(arr1, key, 0, arr1.length - 1));

	}

	public static int binarySearch(int[] arr, int key, int l, int r) {
		if (l <= r) {
			int mid = (l + r) / 2;
//			System.out.println(mid);
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] > key)
				return binarySearch(arr, key, l, (mid - 1));
			else
				return binarySearch(arr, key, (mid + 1), r);
		}
		return -1;
	}

}