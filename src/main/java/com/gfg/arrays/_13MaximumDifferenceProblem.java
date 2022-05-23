package com.gfg.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class _13MaximumDifferenceProblem {

	public static void main(String[] args) {
//idea - we shouldn't have a smaller element on the right sector of the given element
		int[] input = { 7, 18, 10, 4, 10, 3, 6, 5, 2 };
		System.out.println("Original ==>" + Arrays.toString(input));
		ArrayList<Integer> leaders = findLeadersNaive(input);
		System.out.println("LEADERS ==> " + leaders);
		System.out.println("Original ==>" + Arrays.toString(input));
		ArrayList<Integer> leadersO = findLeadersOptimizedLinear(input);
		System.out.println("LEADERS ==> " + leadersO);

	}

	private static ArrayList<Integer> findLeadersOptimizedLinear(int[] input) {
		int currentLeader = input[input.length - 1];
		ArrayList<Integer> leaders = new ArrayList<Integer>();
		leaders.add(currentLeader);
		for (int i = input.length - 2; i >= 0; i--) {
			if (input[i] > currentLeader) {
				currentLeader = input[i];
				leaders.add(currentLeader);
			}
		}
		return leaders;
	}

	private static ArrayList<Integer> findLeadersNaive(int[] input) {
		ArrayList<Integer> leaders = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			boolean flag = true;
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] <= input[j]) {
					flag = false;
					break;
				}
			}
			if (flag)
				leaders.add(input[i]);
		}
		return leaders;
	}

}
