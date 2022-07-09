package com.tcs_digitl.questions;

import java.util.Scanner;

public class Q1_SubstringMaxOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String first = scanner.nextLine();
		int second = scanner.nextInt();
		int max = counting(first, second);
		System.out.println(max);
		scanner.close();
	}

	static int counting(String b, int a) {
		int max = 0;
		for (int i = 0; i < b.length(); i++) {
			String s = subpart(b, i, i + a);// subpart is just a custom substring()
			int count = 0;
			for (int j = 0; i < i + a; j++) {
				if (s.charAt(j) == 1)
					count++;
			}
			if (count > max)
				max = count;
		}
		return max;
	}

	static String subpart(String x, int i, int j) {
		String result = "";
		for (int k = i; k < j; k++) {
			result += x.charAt(k);
		}
		return result;
	}

}
