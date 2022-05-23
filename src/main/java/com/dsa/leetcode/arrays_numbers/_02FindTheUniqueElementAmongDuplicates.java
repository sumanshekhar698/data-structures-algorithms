package com.dsa.leetcode.arrays_numbers;

public class _02FindTheUniqueElementAmongDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] sample = { 1, 1, 9, 2, 4, 4, 5, 9, 2, 8, 8 };
		int answer1 = finderSimple(sample);
		System.out.println(answer1);

		// the sample is sorted in ascending
		int[] specialSample = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		int answer2 = finderSpecialCase(specialSample);
		System.out.println(answer2);

	}

	private static int finderSpecialCase(int[] specialSample) {
		// TODO Auto-generated method stub

		int l = 0;
		int h = specialSample.length - 1;
		int m;

//		Sanity checks
//		#1 boundary conditions
		if (h == 0)
			return specialSample[0];
		else if (specialSample[0] != specialSample[1])
			return specialSample[0];
		else if (specialSample[h] != specialSample[h - 1])
			return specialSample[h];

		while (h >= l) {
			m = (l + h) / 2;
//			m = l + ((h - l) / 2);

//			#2 Unique Element Property -> m-1 ; m ; m+1 >>> All are unique
			if (specialSample[m - 1] != specialSample[m] && specialSample[m + 1] != specialSample[m])
				return specialSample[m];

//			#3 Pairwise Property gives the direction 
			/*
			 * => If mid pair starts with even >>> then the number is not in the left side
			 */ 
			if ((m % 2 == 0 && specialSample[m] == specialSample[m + 1])
					|| (m % 2 == 1 && specialSample[m] == specialSample[m - 1]))

				l = m + 1;
//			 #4 Partition Property -> the item will be in right direction

			else
//				#4 Partition Property -> the element is on left side
				h = m - 1;
		}
		return -1;
	}

	private static int finderSimple(int[] sample) {
		// TODO Auto-generated method stub
		/*
		 * we will XOR O(n)=n | Space O(n)=1
		 */
		int answer = sample[0];
		for (int i = 1; i < sample.length; i++) {
			answer = answer ^ sample[i];
		}
		return answer;
	}

}
