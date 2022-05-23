package com.gfg.live.simple_maths;

public class LoopsAndIfCondition {

	public static void main(String[] args) {
		// SUM of 1st n natural numbers
		int n = 10000;
		int sum = 0;
		
//		Solution 1 [For iteration]
		for (int i = 1; i <= n; i++) {
			sum = sum + i;
		}
		System.out.println("SUM 1 ~> "+sum);
		
		
//		Solution 2 [Maths]
		long start = System.nanoTime();
		sum = n*(n+1)/2;
		long end = System.nanoTime();
		System.out.println("SUM 2 ~> "+sum);
		System.out.println("TIME ~> "+(end-start));	
	}
}
