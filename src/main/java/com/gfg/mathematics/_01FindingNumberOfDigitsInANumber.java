package com.gfg.mathematics;

public class _01FindingNumberOfDigitsInANumber {

	//https://www.geeksforgeeks.org/convert-double-to-integer-in-java/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long x = 9853623569896l;// 13
		System.out.println(countNoob(x));
		System.out.println(countRecursive(x));
		System.out.println(countProLograthmic(x));

		System.out.println((Integer) null);

	}

	private static int countProLograthmic(long x) {
		// TODO Auto-generated method stub
		return (int) Math.floor(Math.log10(x) + 1);
	}

	private static int countRecursive(long x) {
		// TODO Auto-generated method stub
		if (x == 0)
			return 0;
		return 1 + countRecursive(x / 10);

	}

	private static int countNoob(long x) {
		// TODO Auto-generated method stub
		int count = 0;
		while (x != 0) {
			x = x / 10;
			count++;
		}
		return count;

	}

}
