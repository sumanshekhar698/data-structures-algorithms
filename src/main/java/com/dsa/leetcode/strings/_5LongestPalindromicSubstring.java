package com.dsa.leetcode.strings;

public class _5LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str = "cbbd";
        System.out.println(longestPalindrome(str));


    }

    //Brute n^3 for all the possible substrings
    //center explosion n * n =n*2 Easier
    //center implosion n * n =n*2

    static public String longestPalindrome(String str) {
        String res = "";
        int n = str.length();
        for (int i = 0; i < n; i++) {

            //ODD length palindrome
            int left = i, right = i;//left and right at a center
            while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                if ((right - left + 1) > res.length()) {
                    res = str.substring(left, right + 1);
                }
                --left;
                ++right;

            }

            //EVEN length palindrome
            left = i;//left at a center
            right = i + 1;// right at a center +1 ; So by default the len is 2
            while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                if ((right - left + 1) > res.length()) {
                    res = str.substring(left, right + 1);
                }
                --left;
                ++right;

            }


        }

        return res;


    }

}
