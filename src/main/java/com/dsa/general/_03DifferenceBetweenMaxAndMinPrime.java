package com.dsa.general;

import java.util.ArrayList;
import java.util.Scanner;

public class _03DifferenceBetweenMaxAndMinPrime {
//	static ArrayList<Integer> primeList = new ArrayList<Integer>();

	public static void main(String args[]) throws Exception {

		// Write code here
		int answer;
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] samples = new String[n];
		scanner.nextLine();
		for (int i = 0; i < samples.length; i++) {
			samples[i] = scanner.nextLine();
		}
		scanner.close();

		for (int i = 0; i < samples.length; i++) {
			answer = maxDiff(samples[i]);
			System.out.println(answer);
		}

	}

	private static int maxDiff(String sample) {
		// TODO Auto-generated method stub

		String[] split = sample.split(" ");
		int start = Integer.parseInt(split[0]);
		int end = Integer.parseInt(split[1]);
//		System.out.println(start +" "+end);
		String result = "";

		for (int i = start; i <= end; i++) {
//			if (primeList.contains(i)) {
//				result += i + " ";
//				primeList.add(i);
//			} else if (isPrime(i)) {
//				result += i + " ";
//				primeList.add(i);
//			}
			
			 if (isPrime(i)) {
					result += i + " ";
//					primeList.add(i);
				}
		}

		if (result.length() == 0)
			return -1;

		String[] split2 = result.split(" ");
		System.out.println(split2.length);
		System.out.println(result);
		if (split2.length == 1)
			return 0;
		else {
			int smallest = Integer.parseInt(split2[0]);
			int biggest = Integer.parseInt(split2[split2.length - 1]);
//			int temp;
//			for (int i = 0; i < split2.length; i++) {
//				temp = Integer.parseInt(split2[i]);
//				if (temp > biggest)
//					biggest = temp;
//				else if (temp < smallest)
//					smallest = temp;
//				System.out.println(smallest + " " + biggest + " " + temp + " ");
//
//			}

			return biggest - smallest;

		}

//		System.out.println(result);

	}

	private static boolean isPrime(long sample) {
		// TODO Auto-generated method stub
		//6k+-1 tech which is 3 times faster than traditional way

		if (sample == 2 || sample == 3 || sample == 5 || sample == 7)
			return true;
		if (sample % 2 == 0)
			return false;

		if (sample % 3 == 0)
			return false;
		int endLimit = (int) Math.sqrt(sample);
		int para1, para2;
		int k = 1;

		do {
			para1 = (6 * k) + 1;
			para2 = para1 - 2;
//			System.out.println(para1 + " " + para2);
			if (sample % para1 == 0 || sample % para2 == 0)
				return false;
			k++;

		} while (para1 <= endLimit && para2 <= endLimit);

		return true;
	}

	private static boolean isPrimeSchool(int n) {
		// TODO Auto-generated method stub

		if (n <= 1)
			return false;

		else if (n == 2)
			return true;

		else if (n % 2 == 0)
			return false;

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
