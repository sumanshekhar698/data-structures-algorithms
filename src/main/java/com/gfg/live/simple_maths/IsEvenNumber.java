package com.gfg.live.simple_maths;

import java.util.Scanner;

public class IsEvenNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Enter a number for even check");
			int num = scanner.nextInt();

			boolean ans = isEven5(num);
			System.out.println(ans);
		}

	}

	private static boolean isEven1(int num) {
		if (num % 2 == 0)
			return true;
		else if (num % 2 != 0)
			return false;

		return false;
	}

	private static boolean isEven2(int num) {
		if (num % 2 == 0)
			return true;
		else
			return false;
	}

	private static boolean isEven3(int num) {
		if (num % 2 == 0)
			return true;
		return false;
	}

	private static boolean isEven4(int num) {
		return (num % 2 == 0);
	}

	private static boolean isEven5(int num) {
		if ((num & 1) == 0)
			return true;
		else
			return false;
	}

	private static boolean isEven6(int num) {
		return (num % 2 != 0) ? false : true;// ternary operator
	}

}
