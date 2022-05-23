package com.gfg.arrays;

import java.util.Arrays;

public class _16TrappingRainWater {

	public static void main(String[] args) {
		int[] inputWalls = { 3, 0, 1, 2, 5 };
		// calculate total volume by walls
		// In Ascending or Descending => Zero Water
		// No water can be stored on end walls
		// The idea is to what height of water will be at the top of each wall

		System.out.println("Original Walls==> " + Arrays.toString(inputWalls));
		int waterQuantity = totalRainWaterTrappedNaive(inputWalls);
		System.out.println("Total Water ==> " + waterQuantity);
		waterQuantity = totalRainWaterTrappedOptimizedLinear(inputWalls);
		System.out.println("Total Water after Optimization==> " + waterQuantity);

	}

	private static int totalRainWaterTrappedOptimizedLinear(int[] inputWalls) {
//		O(n) = n & extra SPACE O(n) = n
		int totalWater = 0;
		int[] lMaxes = new int[inputWalls.length];
		int[] rMaxes = new int[inputWalls.length];
		lMaxes[0] = inputWalls[0];
		for (int i = 1; i < inputWalls.length; i++)// lMax Array enrichment
			lMaxes[i] = Integer.max(inputWalls[i], lMaxes[i - 1]);
		rMaxes[inputWalls.length - 1] = inputWalls[inputWalls.length - 1];
		for (int i = inputWalls.length - 2; i >= 0; i--)
			rMaxes[i] = Integer.max(inputWalls[i], rMaxes[i + 1]);// rMax Array enrichment

		for (int i = 0; i < inputWalls.length; i++) {// calculating the total water on each wall
			totalWater += (Integer.min(lMaxes[i], rMaxes[i]) - inputWalls[i]);
		}

		return totalWater;
	}

	private static int totalRainWaterTrappedNaive(int[] inputWalls) {
//		O(n) = n^2
		int totalWater = 0;
		for (int i = 1; i < inputWalls.length - 1; i++) {// Neglecting the boundary walls
			int lMax = inputWalls[i];
			for (int j = 0; j < i; j++)
				lMax = Integer.max(lMax, inputWalls[j]);
			int rMax = inputWalls[i];
			for (int k = i + 1; k < inputWalls.length; k++)
				rMax = Integer.max(rMax, inputWalls[k]);

			totalWater += (Integer.min(lMax, rMax) - inputWalls[i]);
			// in case of a peak . it will be the LHS will be ZERO
		}
		return totalWater;
	}

}
