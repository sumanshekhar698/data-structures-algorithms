package com.gfg.live.simple_maths;

import java.util.Scanner;

public class _00AverageOfTwoNumbersWhereNumeOneSmallerThanNumTwo {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Input 1st num");
		int numOne = 8;
		System.out.println("Input 2nd num");
		int numTwo = Integer.MAX_VALUE;

		int averageSimran = (numOne + numTwo) / 2;// Works but has flaws
		int average = numOne + (numTwo - numOne) / 2;// flawless with safety check
		System.out.println("AVERAGE : " + average);
	}

}
