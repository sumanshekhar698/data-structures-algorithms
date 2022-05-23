package com.gfg.mathematics;

import java.util.Scanner;

public class _03Factorial {
//Beware of Integer overflow
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of to find its factorial");
		int x = scanner.nextInt();
		int result = factoialFinderIterative(x);
		System.out.println(result);
		result = factoialFinderRecursive(x);
		System.out.println(result);
		scanner.close();
	}

	private static int factoialFinderRecursive(int x) {
		// TODO Auto-generated method stub
		if (x == 0)
			return 1;
		return x * factoialFinderRecursive(x - 1);
	}

	private static int factoialFinderIterative(int x) {
		// TODO Auto-generated method stub
		int fact = 1;
		for (int i = 2; i <= x; i++)
			fact *= i;

		return fact;
	}

}
