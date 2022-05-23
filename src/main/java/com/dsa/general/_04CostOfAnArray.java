package com.dsa.general;

import java.util.Scanner;

public class _04CostOfAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of to find thr trailing zeroes in factorial");
		int inputs = scanner.nextInt();
		int[] sample = new int[inputs];
		int max = 1;
		for (int i = 0; i < sample.length; i++) {
			sample[i] = scanner.nextInt();
			if (sample[i] > max)
				max = sample[i];
		}

		int min = 0;
		int temp = 0;

		for (int i = 0; i < sample.length; i++) {
			if (sample[i] % max == 0)
				temp += sample[i] / max;
			else
				temp += sample[i];
		}
		max--;
		min = temp;
		temp = 0;

		while (max > 0) {
			for (int i = 0; i < sample.length; i++) {
				if (sample[i] % max == 0)
					temp += sample[i] / max;
				else
					temp += sample[i];
			}
			if (temp < min)
				min = temp;
			max--;
			temp = 0;
		}
		System.out.println(min);
		scanner.close();
	}

}
