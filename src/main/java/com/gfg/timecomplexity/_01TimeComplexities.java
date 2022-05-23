package com.gfg.timecomplexity;

public class _01TimeComplexities {

	public static void main(String[] args) {
		int n = 5;

		linearLoop(n);
		quadraticLoop(n);
		exponentialLoop(n * 1000);

	}

	private static void quadraticLoop(int n) {
//		O = (n^2)
//		QUADRATIC
		System.out.println("\n QUADRATIC\n");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "\t");

			}
			System.out.println();
		}
//		number of operations
//		1 2 3 4 5 6 7  => SUM = n(n+1)/2 ~> ORDER n^2

	}

	private static void exponentialLoop(int n) {
//		O = log(n)
		System.out.println("\n EXPONENTIAL\n");
		for (int i = 1; i <= n; i *= 2) {
			System.out.print(i + "\t");
		}
//		1	2	4	8	16	32	64	128	256	512	1024	2048	4096	
//		2^0 2^1 2^2 2^3
//		2^i = n
//		i log 2 = log n
//		i = log n

	}

	private static void linearLoop(int n) {
//		O = (n)
		System.out.println("\n LINEAR\n");
		for (int i = 1; i <= n; i++) {
			System.out.print(i + "\t");
		}
	}

}
