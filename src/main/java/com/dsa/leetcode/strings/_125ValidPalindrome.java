package com.dsa.leetcode.strings;

public class _125ValidPalindrome {
    //    https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("race a car"));

    }

    static class Solution {

        public boolean isPalindrome(String s) {
            s = s.toUpperCase();
            String reference = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            StringBuilder cleanedString = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (reference.contains("" + s.charAt(i))) {
                    cleanedString.append(s.charAt(i));
                }
            }
            System.out.println(cleanedString);
            String cleanedStringStored = cleanedString.toString();

            return cleanedString.reverse().toString().equals(cleanedStringStored);
        }


        public boolean isPalindromeUsingTwoPointers(String s) {
            s = s.toUpperCase();
            String reference = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            int left = 0, right = s.length() - 1;

            while (left < right) {
                while (left < right && !reference.contains("" + s.charAt(left))) {
                    left++;
                }
                while (left < right && !reference.contains("" + s.charAt(right))) {
                    right--;
                }

                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }


        public boolean isPalindromeSpaceOptimized1(String s) {
            if (s.isEmpty()) {
                return true;
            }
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                char currfirst = s.charAt(start);
                char currlast = s.charAt(end);
                if (!Character.isLetterOrDigit(currfirst)) {
                    start++;
                } else if (!Character.isLetterOrDigit(currlast)) {
                    end--;
                } else {
                    if (Character.toLowerCase(currfirst) != Character.toLowerCase(currlast)) {
                        return false;
                    }
                    start++;
                    end--;
                }
            }
            return true;
        }

        public boolean isPalindromeSpaceOptimized2(String s) {
            s = s.toUpperCase();
            String reference = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            int left = 0, right = s.length() - 1;

            while (left < right) {
                while (left < right && !reference.contains("" + s.charAt(left))) {
                    left++;
                }
                while (left < right && !reference.contains("" + s.charAt(right))) {
                    right--;
                }

                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }

                left++;
                right--;
            }

            return true;


        }

        public boolean isPalindromeSuperTimeOptimzed(String s) {
            int diff = 'A' - 'a';
            int left = 0, right = s.length() - 1;

            while (left < right) {
                char ll = s.charAt(left);
                char rl = s.charAt(right);

                if ('A' <= ll && ll <= 'Z') {
                    ll -= diff;
                }
                if ('A' <= rl && rl <= 'Z') {
                    rl -= diff;
                }

                if (!(('a' <= ll && ll <= 'z') || ('0' <= ll && ll <= '9'))) {
                    left++;
                } else if (!(('a' <= rl && rl <= 'z') || ('0' <= rl && rl <= '9'))) {
                    right--;
                } else {
                    if (ll == rl) {
                        left++;
                        right--;
                    } else {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}