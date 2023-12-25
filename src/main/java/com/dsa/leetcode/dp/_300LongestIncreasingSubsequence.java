package com.dsa.leetcode.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _300LongestIncreasingSubsequence {
    public static void main(String[] args) {

        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};//4
        int[] arr2 = {0, 1, 0, 3, 2, 3};//4
        System.out.println(lengthOfLIS(arr2));

    }

    static public int lengthOfLIS(int[] nums) {

        int dpCache[] = new int[nums.length], maxLen = 1;
        Arrays.fill(dpCache, 1);//The Longest Increasing SubSequence from all the positions in the worst case can be 1


//        Time N^2
//        Space N
        for (int i = nums.length - 1; i >= 0; i--) {//reverse
            for (int j = i + 1; j < nums.length; j++) {//straight iteration from the current ith element
                if (nums[i] < nums[j]) {//We will only consider nums[j] cache if this condition matches thus extending the current sequence
                    dpCache[i] = Integer.max(dpCache[i], 1 + dpCache[j]);//Adding one because considering the current ith element
                }


            }
            maxLen = Integer.max(maxLen, dpCache[i]);//maintaining and updating a maxLen variable

        }

        return maxLen;
    }


    public static int lengthOfStrictLIS(int[] ints) {
        int n = ints.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initialize dp array with 1s

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ints[i] > ints[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int maxLISLength = 0;
        for (int length : dp) {
            maxLISLength = Math.max(maxLISLength, length);
        }
        return maxLISLength;
    }


}


