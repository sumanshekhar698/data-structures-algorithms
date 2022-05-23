package com.dsa.general;
/* Read input from STDIN. Print your output to STDOUT*/

import java.util.Scanner;

public class _02CovidCognizant {
	public static void main(String args[]) throws Exception {

		// Write code here
		Scanner scanner = new Scanner(System.in);
		String strain = scanner.nextLine();
		int n = scanner.nextInt();
		scanner.nextLine();
		String[] samples = new String[n];
		for (int i = 0; i < samples.length; i++) {
			samples[i] = scanner.nextLine();
		}
		scanner.close();
		int[] result = test(strain, samples);
		for (int i = 0; i < result.length; i++) {
			if (result[i] == 1)
				System.out.println("POSITIVE");
			else
				System.out.println("NEGATIVE");
		}

	}

	private static int[] test(String strain, String[] samples) {
		// TODO Auto-generated method stub
		int[] result = new int[samples.length];
		boolean out;
		for (int i = 0; i < samples.length; i++) {
			out = check(strain, samples[i]);
			if (out)
				result[i] = 1;
			else
				result[i] = 0;

		}
		return result;
	}

	private static boolean check(String strain, String sample) {

		// TODO Auto-generated method stub

		int p = 0;
		for (int i = 0; i < strain.length(); i++) {
			if (strain.charAt(i) == sample.charAt(p) && p < sample.length())
				p++;

		}
		if (p == sample.length())
			return true;
		return false;
	}

}
