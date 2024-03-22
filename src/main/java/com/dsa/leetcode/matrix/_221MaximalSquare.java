package com.dsa.leetcode.matrix;

public class _221MaximalSquare {

    public static void main(String[] args) {

    }

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        int maxDimension = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = 1;
                        maxDimension = Math.max(maxDimension, dp[i][j]);//we are using max instead of directly 1 for preventing reversal of max to 1
                    }
                } else {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;//min from immediate 3 directions
                        maxDimension = Math.max(maxDimension, dp[i][j]);
                    }
                }
            }
        }
        return maxDimension * maxDimension;
    }
}
