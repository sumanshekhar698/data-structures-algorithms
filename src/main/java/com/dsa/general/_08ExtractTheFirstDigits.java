package com.dsa.general;

public class _08ExtractTheFirstDigits {
	public static void main(String[] args) {
		int n = 1554538760;
		n=5460000;
		n=5460987;
		printDigits(n);
//		printDigitsRecurssion(n);
		
	}

	private static void printDigitsRecurssion(int n) {
		if(n/10==0)
			return;
			System.out.println(n);
		
		n/=10;
		
		
	}

	private static void printDigits(int n) {
//		Math.log(n);
		if(n==0) {
			System.out.println(0);
			System.exit(0);
		}
		int digitsMinus1 =(int)(Math.log10(n));
		System.out.println("DIGITS -> "+digitsMinus1);
		int number;
		int tens;
		int i=0;
		while (n>0) {
		tens=(int)Math.pow(10, digitsMinus1--);
			number=n/tens;
			n%=tens;
			System.out.println(++i+"th DIGIT =>"+number);
		}
		
	}



}
