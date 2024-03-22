package com.dsa.leetcode.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class _516LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String str = "aabcdabbadi";
        System.out.println(longestPalindromeSubseqUsingLCS(str));
        System.out.println(longestPalindromeSubseqUsingLCS(str));


    }

    static public int longestPalindromeSubseqUsingDPandDFS(String str) {//TODO

        class Pair {
            int i, j;

            public Pair(int i, int j) {
                this.i = i;
                this.j = j;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pair pair = (Pair) o;
                return i == pair.i && j == pair.j;
            }

            @Override
            public int hashCode() {
                return Objects.hash(i, j);
            }
        }

        HashMap<Pair, Integer> cache = new HashMap<>();


        class DFS {
            int dfs(int i, int j) {
                if (i < 0 || j == str.length()) {
                    return 0;//longest cpss is 0
                }
                if (cache.containsKey(i) || cache.containsKey(j)) {
                    return 0;
                }
                if (str.charAt(i) == str.charAt(j)) {

                } else {
                    return Integer.max(dfs(i - 1, j), dfs(i, j + 1));
                }
                return -1;
            }
        }


        DFS dfsObj = new DFS();
        for (int k = 0; k < str.length(); k++) {
            dfsObj.dfs(k, k);//odd len palindromes
            dfsObj.dfs(k, k + 1);//even len palindromes

        }


        return 0;
    }


    static public int longestPalindromeSubseqUsingLCS(String s) {
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString());//str and reverse str over LCS will always be a palindrome
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
                    dp[i][j] = dp[i][j + 1].length() > dp[i + 1][j].length() ? dp[i][j + 1] : dp[i + 1][j];//when the char does not match, we look for the max length string

                }

            }
        }


        return dp[0][0];

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
}
