package com.dsa.leetcode.dp;

public class Pepcoding_MaximumSumSubarrayWithAtLeastSizeK {

    public static void main(String[] args) {
        int arr[] = {1, 15, 7, 9, 2, 5, 10}, k = 3;
        System.out.println(maxSum(arr, k));
    }

    private static int maxSum(int[] arr, int k) {

        int res = Integer.MIN_VALUE;
        int dp[] = new int[arr.length];

        int currentSum = arr[0];
        dp[0] = currentSum;

        for (int i = 1; i < arr.length; i++) {//1st window of atleast size k
            if (currentSum > 0)
                currentSum += arr[i];
            else
                currentSum = arr[i];

            dp[i] = currentSum;//max sum of prev window + curr element OR curr element
        }


        int exactKSum = 0;//this will be used to calculate the exact k sum
        for (int i = 0; i < k; i++) {
            exactKSum += arr[i];
        }
        res = Integer.max(res, exactKSum);//checking if an exact k sum is greater than a prev max sum

        for (int i = k; i < arr.length; i++) {
//            moving the k window one step towards the right
            exactKSum += arr[i];
            exactKSum -= arr[i - k];

            res = Integer.max(res, exactKSum);//checking if an exact k sum is greater than a prev max sum

            int atleastK = dp[i - k] + exactKSum;
            res = Integer.max(res, atleastK);//checking if an atleast k sum is greater than a prev max sum
        }
        return res;
    }
}
