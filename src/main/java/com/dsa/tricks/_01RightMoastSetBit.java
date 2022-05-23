package com.dsa.tricks;

public class _01RightMoastSetBit {

	/*
	 * Most efficient way O(1) for finding Right Most Bit No (i.e, integer whose
	 * binary representation has that bit 'ON' i.e, set to 1) Formula is a) num &
	 * ~(num-1) or can also be written as b) num & (num * -1) // lets understand
	 * with a) and example below num = 5 in binary (0000 0101) num-1 = 4 in binary
	 * (0000 0100) ~(num-1) = -5 in binary (1111 1011) // Negation results in all
	 * bits changing to opposite values 0 to 1 and 1 to 0 num & ~(num-1) = (0000
	 * 0101) & (1111 1011) = (0000 0001) = 1 in Decimal system
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sample = 24;// b100
		binaryConvertorAlgoBasedBitWise(sample);
		findBrute(sample);

	}

	private static void findBrute(int sample) {
		// TODO Auto-generated method stub
		int answer1 = sample & (-sample);
		int answer2 = sample & ~(sample - 1);
		System.out.println(answer1);
		System.out.println(answer2);

	}
	
	private static void binaryConvertorAlgoBasedBitWise(int sample) {
		// TODO Auto-generated method stub
		String binary = "";
		for (int i = 31; i >= 0; i--) {
			int k = sample >> i;
			if ((k & 1) > 0)
				binary += 1;
			else
				binary += 0;
		}
		System.out.println(binary + " using bit wise");

	}

}
