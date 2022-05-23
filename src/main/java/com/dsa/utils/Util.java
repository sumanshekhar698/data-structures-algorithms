package com.dsa.utils;

import java.util.Random;

public class Util {

	public static int randomGeneratorRange(int low, int high) {

		int n = (int) (Math.random() * 100);
		Random r = new Random();
//		int low = 10;
//		int high = 100;
		int result = r.nextInt(high - low) + low;// incrementing of 10 to the range
		return result;
	}

	public static int randomGeneratorFromZero(int n) {
		Random rand = new Random();

		return rand.nextInt(n);

	}

}
