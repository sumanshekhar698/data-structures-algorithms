package com.dsa.leetcode.arrays_numbers;

public class _05SetMatrixElementsInCrossHairAsZeroes {
//https://leetcode.com/problems/set-matrix-zeroes/submissions/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] sample = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		int[][] sample1 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
//		int sample11[][] = sample1.clone();
		
//		setterOptimized(sample1);

//		print2dArray(sample1);
//		System.out.println();
//		print2dArray(sample11);

		
		
		int[][] sample2 = { { -2147483648 }, { 2 }, { 3 } };
//		int[][] result = setterBrute(sample2);
//		setterOptimized(sample1);
		setterSuperSpaceOptimized(sample1);
		print2dArray(sample1);

	}

	private static void setterSuperSpaceOptimized(int[][] sample11) {
		// TODO Auto-generated method stub
		// We will not use the other two 1D arrays for storing the records

		boolean col0 = false;
		int rows=sample11.length;
		int cols=sample11[0].length;

		
		for (int i = 0; i < rows; i++) {
			if (sample11[i][0] == 0)// checking the first column
				col0 = true;
			for (int j = 1; j < cols; j++) {
				if (sample11[i][j] == 0) {
					sample11[i][0] = sample11[0][j] = 0;
				}
			}
		}

		for (int i = rows-1; i >=0; i--) {
			for (int j = cols-1; j >=1; j--) {

				if (sample11[i][0] == 0 || sample11[0][j] == 0) {
					sample11[i][j] = 0;
					if (col0 == true)
						sample11[i][0] = 0;

				}
			}
		}

	}

	private static void setterOptimized(int[][] sample) {
		// TODO Auto-generated method stub
		int[] row = new int[sample.length];
		int[] column = new int[sample[0].length];

		for (int i = 0; i < sample.length; i++) {
			for (int j = 0; j < sample[i].length; j++) {
				if (sample[i][j] == 0) {
					row[i] = 1;
					column[j] = 1;
				}

			}
		}

		for (int i = 0; i < sample.length; i++) {
			for (int j = 0; j < sample[i].length; j++) {
				if (row[i] == 1 || column[j] == 1) {
					sample[i][j] = 0;
				}

			}

		}
		return;
	}

	private static int[][] setterBrute(int[][] sample) {
		// TODO Auto-generated method stub
		// if the code will have MIN value then it will throw error
		// O(n) = 2(i*j) ; O(s)=s+s
		for (int i = 0; i < sample.length; i++) {
			for (int j = 0; j < sample[i].length; j++) {
				if (sample[i][j] == 0) {

					// Row transform
					for (int k = 0; k < sample[i].length; k++) {
						if (sample[i][k] != 0)
							sample[i][k] = Integer.MIN_VALUE;

					}

					// Column Transform
					for (int l = 0; l < sample.length; l++) {
						if (sample[l][j] != 0)
							sample[l][j] = Integer.MIN_VALUE;
					}
				}
			}
		}

		for (int i = 0; i < sample.length; i++) {
			for (int j = 0; j < sample[i].length; j++) {
				if (sample[i][j] == Integer.MIN_VALUE)
					sample[i][j] = 0;
			}
		}
		return sample;
	}

	private static void print2dArray(int[][] result) {
		// TODO Auto-generated method stub

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

}
