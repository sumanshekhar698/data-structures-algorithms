package com.dsa.leetcode.arrays_numbers;

import java.util.HashMap;

public class _494TargetSum {
    public static void main(String[] args) {

        int targetSum = findTargetSumWaysMemoized(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSum);

    }

    public static int findTargetSumRecursive(int[] nums, int target) {

        class BackTrack {
            int backtrack(int i, int currentSum) {
                if (i == nums.length) {
                    return currentSum == target ? 1 : 0;
                }
                return backtrack(i + 1, currentSum + nums[i])
                        + backtrack(i + 1, currentSum - nums[i]);


            }

        }

        return new BackTrack().backtrack(0, 0);//stating index 0, curent sum 0

    }

    public static int findTargetSumWaysMemoized(int[] nums, int target) {


        int[][] dp = new int[nums.length][1000];//1000 because of condition

        class BackTrack {
            int backtrack(int i, int currentSum) {



                if (dp[i][currentSum] != 0) {
                    return dp[i][currentSum];
                }

                if (i == nums.length) {
                    return currentSum == target ? 1 : 0;
                }

                dp[i][currentSum] = backtrack(i + 1, currentSum + nums[i])
                        + backtrack(i + 1, currentSum - nums[i]);

                return dp[i][currentSum];
            }

        }


        return new BackTrack().backtrack(0, 0);//stating index 0, curent sum 0

    }
}
