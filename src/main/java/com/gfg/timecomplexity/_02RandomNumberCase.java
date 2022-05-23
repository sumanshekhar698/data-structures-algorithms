package com.gfg.timecomplexity;

import java.util.Random;

import com.dsa.utils.Util;

public class _02RandomNumberCase {

	public static void main(String[] args) {
		int n = (int) (Math.random() * 100);

		System.out.println("N =>" + n);
		System.out.println("!= ->");
		randomProbabiltyComplexity1(n);// P[1-1/n] greater the n : greater the chances of getting !=
		System.out.println("== ->");
		randomProbabiltyComplexity2(n);// P[1/n] greater the n : lesser the chances of getting ==
	}

	private static void randomProbabiltyComplexity2(int n) {
		Random rand = new Random();

		// Obtain a number between [0 - 49].
		for (int i = 0; i < n; i++) {
			int r = rand.nextInt(n);
			System.out.println(i);
			if (i == r) {

				break;
			}
		}

	}

	static void randomProbabiltyComplexity1(int n) {
		Random rand = new Random();

		// Obtain a number between [0 - 49].
		for (int i = 0; i < n; i++) {
			int r = rand.nextInt(n);
			System.out.println(i);
			if (i != r) {

				break;
			}
		}

	}

}
