package com.dsa.leetcode.dp;

import java.util.Arrays;

public class _1143LongestCommonSubsequence {

    public static void main(String[] args) {

        String text1 = "abcde", text2 = "ace";
        int i = longestCommonSubsequence(text1, text2);
        System.out.println(i);
        System.out.println(longestCommonSubsequenceString(text1, text2));
    }

    static public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];//Bottom Up approach DP
        //So we're adding one extra row column to look diagonally if the last car matches


//        O(n) Time and Space = n*n  text1.length * test2.length
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];//when the char matches we look diagonal
                } else {
                    dp[i][j] = Integer.max(dp[i][j + 1], dp[i + 1][j]);

                }

            }
        }


        return dp[0][0];

    }

    static public String longestCommonSubsequenceString(String text1, String text2) {
        String[][] dp = new String[text1.length() + 1][text2.length() + 1];//Bottom Up approach DP
        //So we're adding one extra row column to look diagonally if the last car matches
        Arrays.fill(dp[dp.length - 1], "");//filling the last row with empty strings
        for (int i = 0; i < dp.length - 1; i++) {//filling the last column with empty strings
            dp[i][dp[0].length - 1] = "";
        }

//        O(n) Time and Space = n*n  text1.length * test2.length
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = "" + text1.charAt(i) + dp[i + 1][j + 1];//when the char matches we look diagonal
                } else {
                    dp[i][j] = dp[i][j + 1].length() > dp[i + 1][j].length() ? dp[i][j + 1] : dp[i + 1][j];//when the char does not match we look for the max length string

                }

            }
        }


        return dp[0][0];

    }
}
