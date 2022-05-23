package com.dsa.general;

public class _06MagicNumber {
//	Write a Java Program to check if any number is a magic number or not. A number is said to be a magic number if after doing sum of digits in each step and inturn doing sum of digits of that sum, the ultimate result (when there is only one digit left) is 1.
	public static void main(String[] args) {
		int num = 163;
		int sumOfDigits = seeForMagicLinear(num);
		sumOfDigits = seeForMagicOptimized(num);
		// If sum is 1, original number is magic number
		if (sumOfDigits == 1) {
			System.out.println("Magic number");
		} else {
			System.out.println("Not magic number");
		}
	}

	private static int seeForMagicOptimized(int num) {

		if (num == 0)
			return 0;

		int result = num % 9;
		if (result == 0)
			return 9;
		return result;

	}

	private static int seeForMagicLinear(int num) {

		int sumOfDigits = 0;// for num = 0 => sumOfDigits = 0
		while (num > 0 || sumOfDigits > 9) {
			if (num == 0) // after initial sum,
			{
				num = sumOfDigits;
				sumOfDigits = 0;
			}
			sumOfDigits += num % 10;
			num /= 10;
		}
		return sumOfDigits;
	}
}
