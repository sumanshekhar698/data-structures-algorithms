package com.gfg.mathematics;

import java.util.Scanner;

public class _02NumberPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of Palindromacy check");
		int x = scanner.nextInt();
		boolean result = palindromacyCheck(x);
		System.out.println(result);
		scanner.close();
	}

	private static boolean palindromacyCheck(int x) {
		// TODO Auto-generated method stub

		int temp = x;
		int reverse = 0;
		while (temp != 0) {
			reverse = (reverse * 10) + (temp % 10);
			temp /= 10;
		}
		return (x == reverse);
	}

}
