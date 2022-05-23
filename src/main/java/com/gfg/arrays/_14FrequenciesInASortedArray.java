package com.gfg.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class _14FrequenciesInASortedArray {

	public static void main(String[] args) {
//idea - we shouldn't have a smaller element on the right sector of the given element
		int[] input = { 7, 18, 18, 10, 4, 10, 3, 3, 0, 0, 0, 0, -4, -4, 6, 5, 2 };
		Arrays.sort(input);
		System.out.println("Original ==> " + Arrays.toString(input));
		System.out.println("TOTAL " + input.length);
		HashMap<Integer, Integer> frequencyMap = getFrequenciesNaiveLinear(input);
		System.out.println("FREQUENCIES for Sorted==>" + frequencyMap);
		System.out.println("FREQUENCIES==> " + getFrequenciesForAny(input));

	}

	private static HashMap<Integer, Integer> getFrequenciesNaiveLinear(int[] input) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int frequency = 1;
		int i = 1;
		int total = 0;
		for (; i < input.length; i++) {
			if (input[i] == input[i - 1])
				++frequency;
			else {
				total += frequency;
				hashMap.put(input[i - 1], frequency);
				frequency = 1;
			}
		}
		total += frequency;
		System.out.println("TOTAL " + total);
		hashMap.put(input[i - 1], frequency);// i-1 to prevent the outbound
		return hashMap;
	}

	private static HashMap<Integer, Integer> getFrequenciesForAny(int[] input) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < input.length; i++) {
			if (hashMap.containsKey(input[i]))
				hashMap.put(input[i], hashMap.get(input[i]) + 1);
			else
				hashMap.put(input[i], 1);
		}
		return hashMap;
	}

}
