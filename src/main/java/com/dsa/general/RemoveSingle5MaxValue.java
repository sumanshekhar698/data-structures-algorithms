package com.dsa.general;

public class RemoveSingle5MaxValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(576575));
	}

	public static int solution(int N) {
		int ans = 0;
		int i = 5;

		while (N / i > 0) {
			int temp = (N / (i * 10)) * i + (N % i);
			i *= 10;
			if (temp > ans)
				ans = temp;
		}
		N = ans;

		return N;
	}

}
