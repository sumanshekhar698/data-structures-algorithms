package com.dsa.leetcode.arrays_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _350IntersectionOfTwoArraysII {

	public static void main(String[] args) {

	}

	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map1 = new HashMap();
		HashMap<Integer, Integer> map2 = new HashMap();
		ArrayList<Integer> list = new ArrayList();
		for (int num : nums1) {
			map1.put(num, map1.getOrDefault(num, 0) + 1);

		}

		for (int num : nums2) {
			map2.put(num, map2.getOrDefault(num, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
			Integer key = entry.getKey();

			int diff = 0;
			if (map2.containsKey(key)) {
				diff = Math.min(map1.get(key), map2.get(key));

				for (int i = 0; i < diff; i++) {
					list.add(key);
				}
			}

		}

		// Create an int array with the same size as the list
		int[] array = new int[list.size()];

		// Loop through the list and copy elements to the array
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}

		return array;

	}

	public int[] intersectOptimized(int[] nums1, int[] nums2) {
		int[] arr = new int[1001];
		int[] result = new int[1001];

		for (int num : nums1) {// frequency array
			arr[num]++;
		}

		int index = 0;
		for (int num : nums2) {
			if (arr[num] > 0) {// checking for match
				result[index++] = num;// feeding or result array if its a match
				arr[num]--;// updating freq array
			}
		}

		return Arrays.copyOfRange(result, 0, index);//returning ranged copy of original array
	}

}
