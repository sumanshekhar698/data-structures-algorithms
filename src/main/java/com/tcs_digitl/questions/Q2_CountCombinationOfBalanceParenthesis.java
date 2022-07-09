package com.tcs_digitl.questions;

import java.util.Scanner;

class Q2_CountCombinationOfBalanceParenthesis {
	static int count = 0;

	// Function to find all strings of length `n` containing
	// balanced parentheses
	public static void balParenthesis(String str, int n, int open) {
		// if `n` is odd with no open parentheses, balanced parentheses
		// cannot be formed
		if ((n & 1) == 1 && open == 0) {
			return;
		}

		// base case: length `n` is reached
		if (n == 0) {
			// if the output string contains all balanced parenthesis, print it
			if (open == 0) {
				System.out.println(str);
				count++;

			}
			return;
		}

		// Optimization: return if we cannot close all open parentheses
		// with left characters
		if (open > n) {
			return;
		}

		// recur with open parentheses
		balParenthesis(str + "(", n - 1, open + 1);

		// recur with closed parentheses only if the output string has
		// at least one unclosed parentheses
		if (open > 0) {
			balParenthesis(str + ")", n - 1, open - 1);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number to check for balance, P&C");
		int n = scanner.nextInt();
		scanner.close();

		if (n % 2 == 1) {
			System.out.println("Invalid Input");
			System.exit(0);
		}

		String str = "";
		balParenthesis(str, n, 0);
		System.out.println("COUNT => " + count);

	}
}