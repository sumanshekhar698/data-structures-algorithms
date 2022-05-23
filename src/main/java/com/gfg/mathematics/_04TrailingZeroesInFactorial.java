package com.gfg.mathematics;

import java.util.Scanner;

public class _04TrailingZeroesInFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of to find thr trailing zeroes in factorial");
		int x = scanner.nextInt();
		int result;
//		result = factoialTrailingZeroesNaive(x);
//		System.out.println(result);
		result = factoialTrailingMaths(x);
		System.out.println(result);
		result = factoialTrailingMathsOptimized(x);
		System.out.println(result);
		scanner.close();
	}

	private static int factoialTrailingMathsOptimized(int x) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 5; i <= x; i *= 5) {
			count += x / i;
		}
		return count;
	}

	private static int factoialTrailingMaths(int x) {
		// TODO Auto-generated method stub
//		We will search for all 5s, 5,10,15,20,*25
		int count = 0;
		int temp = 0;
		if (x < 0)
			return -1;
		else if (x < 5)
			return 0;
		else if (x == 5)
			return 1;
		else {
			for (int i = 5; i <= x; i += 5) {
				temp = i;
				while (temp % 5 == 0) {
					count++;
					temp /= 5;
				}
			}
		}
		return count;
	}

	private static int factoialTrailingZeroesNaive(int x) {
		// TODO Auto-generated method stub
		int fact = 1;
		for (int i = 2; i <= x; i++)
			fact *= i;
		int result = 0;
		while (fact % 10 == 0) {
			result++;
		}
		return result;
	}

}
