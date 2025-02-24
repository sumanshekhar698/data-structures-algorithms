package com.dsa.leetcode.strings;

public class _214ShortestPalindrome_HARD {


    public static void main(String[] args) {
        _214ShortestPalindrome_HARD obj = new _214ShortestPalindrome_HARD();
        String s = "aacecaaa";
        System.out.println(obj.shortestPalindromeRabibnKarp(s));
    }

    public String shortestPalindromeBRUTE(String s) {


        class PalindromeChecker {
            boolean isPalindrome(String s) {
                int i = 0;
                int j = s.length() - 1;
                while (i < j) {
                    if (s.charAt(i) != s.charAt(j)) {
                        return false;
                    }
                    i++;
                    j--;
                }
                return true;
            }
        }

        PalindromeChecker palindromeChecker = new PalindromeChecker();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (palindromeChecker.isPalindrome(s.substring(0, i + 1))) {// Check if the substring is palindrome
                return new StringBuilder(s.substring(i + 1)).reverse().toString() + s;//Reversing from i+1 because we need to add the reverse of the remaining string
            }

        }
        return "";
    }


    public static String shortestPalindromeRabibnKarp(String s) {//recursion

        int prefix = 0;
        int suffix = 0;
        int base = 29;//atleast 2
        int lastIndexOfS = 0;
        int mod = 1000000007;

        for (int i = 0; i < s.length(); i++) {
//            a -> 1 b -> 2 c -> 3  ... z -> 26
//            We are mapping a as 1 and not 0 it's hard to distinguish the default 0 and 0 of a
            int ch = s.charAt(i) - 'a' + 1;//assuming the string is lowercase

            //We are adding from right in case of prefix
            prefix = (prefix + base) % mod;// shifting the bits in [base i] to left
            prefix = (prefix + ch) % mod;// adding the value of the character to the prefix at ith position

            //We are adding from left in case of suffix
            suffix = (suffix + (ch * (int) Math.pow(base, i))) % mod;

            if (prefix == suffix) {
                lastIndexOfS = i;
            }
        }
        return new StringBuilder(s.substring(lastIndexOfS + 1)).reverse() + s;
    }

    public String shortestPalindromeRECURSIVE(String s) {//recursion

        int n = s.length();
        if (n <= 1) {
            return s;
        }

        int i = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }

        if (i == n) {
            return s;
        }

        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindromeRECURSIVE(s.substring(0, i));
        return prefix + mid + suffix;

    }
}
