package com.dsa.company.microsoft;

public class _02Delete5ToMaximise {
	public static void main(String[] args) {
		int input = 5268586;
//		BRUTE
		System.out.println("*************BRUTE***************");
		calculateTimeBrute(input);
		calculateTimeBrute(-input);
		calculateTimeBrute(0);

//		OPTIMIZED
		System.out.println("*************OPTIMIZED***************");
		calculateTimeOptimized(input);
		calculateTimeOptimized(-input);
		calculateTimeOptimized(0);
	}

	private static int solutionOptimized(int input) {
		int element, elementBefore, elementAfter;
		String numberString;
		StringBuilder sb = new StringBuilder(input);
		

//		POSITIVE case
		if (input == 0)
			return 0;
		else if (input > 0) {
			numberString = "" + input;
			element = Integer.parseInt("" + numberString.charAt(0));
			elementAfter = Integer.parseInt("" + numberString.charAt(1));
			if (element == 5 && elementAfter > element) {// Analyzing the 1st digit
				return Integer.parseInt(numberString.substring(1));
			}
			for (int i = 1; i < numberString.length() - 1; i++) {

				element = Integer.parseInt("" + numberString.charAt(i));
				if (element == 5) {
					elementBefore = Integer.parseInt("" + numberString.charAt(i - 1));
					if (elementBefore > element)
						return Integer.parseInt(numberString.substring(0, i) + numberString.substring(i + 1));

				}
			}

		} else {
			numberString = ("" + input).substring(1);
			element = Integer.parseInt("" + numberString.charAt(0));
			elementAfter = Integer.parseInt("" + numberString.charAt(1));
			if (element == 5 && elementAfter < element)
				return -Integer.parseInt(numberString.substring(1));// deleting the 1st digit

			for (int i = 1; i < numberString.length(); i++) {
				element = Integer.parseInt("" + numberString.charAt(i));
				if (element == 5) {
					elementBefore = Integer.parseInt("" + numberString.charAt(i - 1));
					if (elementBefore < element)
						return -Integer.parseInt(numberString.substring(0, i) + numberString.substring(i + 1));

				}
			}
		}

		return input;
	}

	public static int solutionBrute(int no) {

		boolean isNegative = false;
		boolean initiate = false;
		int temp, element;
		int tempMax = no;
		String number;
		if (no >= 0)
			number = "" + no;
		else {
			number = ("" + no).substring(1);
			isNegative = true;
		}

//		StringBuilder sb = new StringBuilder(number);

		for (int i = 0; i < number.length(); i++) {
			element = Integer.parseInt("" + number.charAt(i));

			if (!initiate && element == 5) {
//				temp = Integer.parseInt(sb.deleteCharAt(i).toString());
				temp = Integer.parseInt(number.substring(0, i) + number.substring(i + 1));
				tempMax = temp;
//				System.out.println("TEMP initiated ==> " + tempMax);
				initiate = true;
			}

			if (initiate && !isNegative && element == 5) {
//				temp = Integer.parseInt(sb.deleteCharAt(i).toString());
				temp = Integer.parseInt(number.substring(0, i) + number.substring(i + 1));
				tempMax = Integer.max(tempMax, temp);
//				System.out.println("TempMax ==> " + tempMax);
			}

			if (initiate && isNegative && element == 5) {
//				temp = Integer.parseInt(sb.deleteCharAt(i).toString());
				temp = Integer.parseInt(number.substring(0, i) + number.substring(i + 1));
				tempMax = Integer.min(tempMax, temp);
//				System.out.println("TempMax ==> " + tempMax);
			}
		}
		return isNegative ? -tempMax : tempMax;
	}

	static void calculateTimeBrute(int input) {
		long nanoTimeStart = System.nanoTime();
		System.out.println(solutionBrute(input));
		long nanoTimeEnd = System.nanoTime();
		System.out.println("Delta t ==>" + (nanoTimeEnd - nanoTimeStart));

	}

	static void calculateTimeOptimized(int input) {
		long nanoTimeStart = System.nanoTime();
		System.out.println(solutionOptimized(input));
		long nanoTimeEnd = System.nanoTime();
		System.out.println("Delta t ==>" + (nanoTimeEnd - nanoTimeStart));

	}
}
