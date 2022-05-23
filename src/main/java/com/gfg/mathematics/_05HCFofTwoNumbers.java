package com.gfg.mathematics;

import java.util.Scanner;

public class _05HCFofTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of to find thr trailing zeroes in factorial");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int result;
		
		result = HCFfinderBrute(x, y);
		result = HCFfinderEuclidAlgorithm(x, y);

		System.out.println(result);

		scanner.close();
	}

	private static int HCFfinderEuclidAlgorithm(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int HCFfinderBrute(int x, int y) {
		// TODO Auto-generated method stub
//		O(n)=min(x,y)
		int min = Math.min(x, y);
		while (min > 0) {
			if (x % min == 0 && y % min == 0) {
				break;
			}
			min--;
		}
		return min;
	}

}
