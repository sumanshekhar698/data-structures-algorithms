package com.dsa.company.microsoft;

public class _01Insert5ToMaximise {
//	https://leetcode.com/discuss/interview-question/1329949/microsoft-online-assessment-question
	public static void main(String[] args) {
		int input = 268;
		System.out.println(solution(input));
		System.out.println(solution(-input));
		System.out.println(solution(0));
	}

	public static int solution(int no) {
		String number = "" + no;
		System.out.println("N0 = "+no);
		
		boolean isNeg = no < 0;
		number = isNeg ? number.substring(1) : number;
		System.out.println("NUMBER = "+number);
		int i = 0;
//		If number is positive: find the first index in number N which is smaller than the inserting-digit
//		If number is negative: find the first index in number N which is larger than the inserting-digit
		for (; i < number.length(); i++) {
			int digit = Integer.parseInt("" + number.charAt(i));
			if ((isNeg) ? digit > 5 : digit < 5)
				break;
		}
		number = number.substring(0, i) + "5" + number.substring(i);
		number = isNeg ? "-" + number : number;
		return Integer.parseInt(number);
	}

}
