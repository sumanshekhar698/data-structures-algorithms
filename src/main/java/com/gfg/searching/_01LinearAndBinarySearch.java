package com.gfg.searching;

import java.util.Arrays;

public class _01LinearAndBinarySearch {

	public static void main(String[] args) {

		int[] numbers = { 1, 45, 67, 2323, 22, 0, -1, -5, -999 };// Unsorted
		System.out.println("UNSORTED ARRAY ==> " + Arrays.toString(numbers));
		int element = 22;
		int index = linearSearch(numbers, element);
		System.out.println(index);
		System.out.println((index < 0) ? -1 : numbers[index]);

//		RECURSSION
		System.out.println("RECURS ->" + linearSearchRecurssive(numbers, element, 0, numbers.length - 1));

		int[] numberClone = numbers.clone();
		Arrays.sort(numberClone);// Sorted Array
		System.out.println("SORTED ARRAY ==> " + Arrays.toString(numberClone));
		int indexB = binarySearch(numberClone, element);
		System.out.println("BINARY ->" + indexB);
	}

	private static int binarySearch(int[] numbers, int element) {
		int l = 0, h = numbers.length - 1, m;
//		[-999, -5, -1, 0, 1, 22, 45, 67, 2323]
		while (l <= h) {
			m = (h + l) / 2;
			System.out.println("m-> " + numbers[m]);
			if (element == numbers[m])
				return m;
			else if (element < numbers[m])
				h = m - 1;
			else
				l = m + 1;
		}
		return -1;
	}

	private static int linearSearch(int[] numbers, int element) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == element) {
				return i;
			}
		}
		return -1;
	}

	private static int linearSearchRecurssive(int[] numbers, int element, int start, int end) {
		if (start > end)
			return -1;
		if (numbers[start] == element)
			return start;
		start += 1;
		return linearSearchRecurssive(numbers, element, start, end);

	}

}
