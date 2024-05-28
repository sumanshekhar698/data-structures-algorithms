package com.dsa.leetcode.strings.basics;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        int leftRange = sc.nextInt();
        int rightRange = sc.nextInt();

        int[] arr = new int[testCases];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        //TODO
        int count = 0;
        int[] xorFreq = new int[1024];  // Initialize an array to store frequency of XOR values (0 to 1023)

        for (int num : arr) {
            // Update the frequency of XOR values for the current element
            for (int prevXor = 0; prevXor < 1024; prevXor++) {
                int xorVal = prevXor ^ num;
                // Check if the sum of the current element and a previous element falls within the range
                if (leftRange <= xorVal + num && xorVal + num <= rightRange) {
                    count += xorFreq[prevXor];
                }
            }
            // Update the frequency for the current element's XOR value
            xorFreq[num]++;
        }

        System.out.println(--count);


    }
}
