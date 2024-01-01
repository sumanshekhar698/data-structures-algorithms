package com.dsa.leetcode.dp;

import java.util.Arrays;

public class _70ClimbingStairs {

    public static void main(String[] args) {

        int x = 5;
        int i = climbStairs(5);
        System.out.println(i);
        i = climbStairsInFibonnacci(5);
        System.out.println(i);
    }

    static public int climbStairs(int n) {

//        Time 2^n As if we are doing Recursive DFS in Binary Tree, We will use DP with a Bottom Up approach to make it efficient

        int[] dp = new int[n + 1];

        dp[dp.length - 1] = 1;//At the last n; thers is only 1 way, 0 steps
        dp[dp.length - 2] = 1;//At second last there is only 1 way 1 step of 1 unit

        for (int i = dp.length - 3; i >= 0; i--) {//Bottom Approach fpr DP
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        System.out.println(Arrays.toString(dp));//[8, 5, 3, 2, 1, 1] Basically its a fibonacci, we can further space
        return dp[0];

    }

    static public int climbStairsInFibonnacci(int n) {

//
        int fibo = 0;
        if (n == 1 || n == 0) {
            return 1;
        }
        int x = 0, y = 1;

        for (int i = 1; i <= n; i++) {//Bottom Approach for DP
            fibo = x + y;
            x = y;
            y = fibo;
        }

        return fibo;

    }
}
