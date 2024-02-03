package com.dsa.leetcode.dp;

import java.util.Arrays;

public class _1043PartitionArrayForMaximumSum {

    public static void main(String[] args) {
        int arr[] = {1, 15, 7, 9, 2, 5, 10}, k = 3;
        System.out.println(maxSumAfterPartitioning(arr, k));
    }

    private static int maxSumAfterPartitioning(int[] arr, int k) {

        int[] dp = new int[arr.length + 1];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i] = Integer.max(dp[i-1] + arr[i], arr[i]);
        }
        System.out.println(Arrays.toString(dp));

        return 0;


    }



}
