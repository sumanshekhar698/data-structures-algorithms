package com.dsa.leetcode.arrays_numbers;

public class _1524NumberOfSubArraysWithOddSum {

    public static void main(String[] args) {

        //we can use DP also to solve this problem as finding the sum of subarray might help to count for other arrays


    }


    // Using Math Property
    public int numOfSubarrays(int[] arr) {
        int oddPrefixCounter = 0;
        int evenPrefixCounter = 0;
        int res = 0;
        int currentSum = 0;
        final int MOD = 1_000_000_007;

        for (int num : arr) {
            currentSum += num;

            if (currentSum % 2 == 0) {// if the currentSum is even
                evenPrefixCounter++;
                res = (res + oddPrefixCounter) % MOD;//
                //applying the MOD as the sum can be large
            } else {// if the currentSum is odd
                oddPrefixCounter++;
                res = (res + evenPrefixCounter + 1) % MOD;// +1 for the current odd currentSum
            }
        }
        return res;
    }

    public int numOfSubarraysBrute(int[] arr) {

        int res = 0;
        int[] prefixOddCounter = new int[arr.length];


        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                prefixOddCounter[i] = arr[i] % 2 != 0 ? 1 : 0;
            } else {
                prefixOddCounter[i] = prefixOddCounter[i - 1] + (arr[i] % 2 == 0 ? 0 : 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int oddCounts = i == 0 ? prefixOddCounter[j] : prefixOddCounter[j] - prefixOddCounter[i - 1];
                if (oddCounts % 2 != 0) {// if odd number of odd numbers in the subarray then the sum is oddS
                    res++;
                }

            }
        }

        return res;

    }
}
