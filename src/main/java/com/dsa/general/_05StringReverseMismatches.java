package com.dsa.general;

import java.util.Scanner;

public class _05StringReverseMismatches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.nextLine();
		while (input > 0) {
			String x = sc.nextLine();

			int ans = checkOptimized(x);
			System.out.println(ans);
			ans = check(x);
			System.out.println(ans);
			input--;
		}
	}

	private static int checkOptimized(String x) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = x.length() - 1;
		int count = 0;
		while (i < j) {
			if (x.charAt(i) != x.charAt(j))
				count += 2;
			i++;
			j--;
		}
		return count;

	}

	private static int check(String x) {
		// TODO Auto-generated method stub
		String r = "";
		int count = 0;
		for (int i = x.length() - 1; i >= 0; i--) {
			r += x.charAt(i);
		}
		for (int i = x.length() - 1; i >= 0; i--) {
			if (x.charAt(i) != r.charAt(i))
				count++;
		}
		return count;
	}

}
