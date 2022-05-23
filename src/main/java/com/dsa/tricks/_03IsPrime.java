package com.dsa.tricks;

public class _03IsPrime {
//https://www.techiedelight.com/measure-elapsed-time-execution-time-java/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long sample = 10000079;
		sample = 5;
		boolean result;
		long startTime = System.nanoTime();
		/* … The code being measured starts … */

//		result = isPrimeSchool(sample);
//		result = isPrimeSchoolOptimised(sample);
		result = isPrimeOptimised(sample);
//		result = isPrimeVicky(sample);

		/* … The code being measured ends … */
		long endTime = System.nanoTime();

		
		long timeElapsed = endTime - startTime;

		System.out.println(result);
		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);

	}

	private static boolean isPrimeOptimised(long sample) {
		// TODO Auto-generated method stub
		/*
		 * We can improve this method further. Observe that all primes greater than 3
		 * are of the form 6k ± 1, where k is any integer greater than 0. This is
		 * because all integers can be expressed as (6k + i), where i = −1, 0, 1, 2, 3,
		 * or 4. Note that 2 divides (6k + 0), (6k + 2), and (6k + 4) and 3 divides (6k
		 * + 3). So, a more efficient method is to test whether n is divisible by 2 or
		 * 3, then to check through all numbers of the form. This is 3 times faster than
		 * testing all numbers up to √n.
		 */

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

	private static boolean isPrimeSchool(long sample) {
		// TODO Auto-generated method stub
		for (int i = 2; i < sample; i++) {
			if (sample % i == 0)
				return false;
		}
		return true;
	}

	private static boolean isPrimeSchoolOptimised(long n) {
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
	
	 public static boolean isPrimeVicky(long n)
	   {
	      if(n == 1)
	        return false;

	      if(n == 2 || n == 3)
	        return true;

	      if(n%2 == 0 || n%3 == 0)
	        return false;

	      for(int i=5 ; i*i <= n ; i += 6)
	      {
	         if(n%i ==0 || n%(i+2) == 0)
	           return false;

	      }

	      return true;
	   }
	
	
	
	

}
