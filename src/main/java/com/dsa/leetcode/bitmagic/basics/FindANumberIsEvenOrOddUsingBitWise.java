package com.dsa.leetcode.bitmagic.basics;

import java.util.Scanner;

public class FindANumberIsEvenOrOddUsingBitWise {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

//		if(n%2==0)// no use of %
//			System.out.println("Even");
//		else
//			System.out.println("Odd");

//		n  =233;

//		Time: O(1)
//		Space: O(1)

        if ((n & 1) == 0)//binary representation of 1 is 00000000000000000000000000000001,
            // and the binary representation of any even number ends in a 0.
            System.out.println("Even");
        else
            System.out.println("Odd");

    }

}
