package com.dsa.leetcode.strings;

public class _242ValidAnagram {
//    https://leetcode.com/problems/valid-anagram/
    public static void main(String[] args) {

        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    private static boolean isAnagram(String s, String t) {
        int[] hashArray = new int[123];

        if(s.length() != t.length())
            return false;


        //track the count of each character in s
        for (int i = 0; i < s.length(); i++) {//O(n) = n
            hashArray[s.charAt(i)]++;
        }

         for (int i = 0; i < t.length(); i++) {
             hashArray[t.charAt(i)]--;
         }

         for (int i = 0; i < hashArray.length; i++) {
             if(hashArray[i] != 0)
                 return false;
         }

        return true;
    }

    private static boolean isAnagramSpaceOptimized(String s, String t) {
        int[] hashArray = new int[26];

        if(s.length() != t.length())
            return false;


        //track the count of each character in s
        for (int i = 0; i < s.length(); i++) {//O(n) = n
            hashArray[s.charAt(i)-97]++;
        }

         for (int i = 0; i < t.length(); i++) {
             hashArray[t.charAt(i)-97]--;
         }

         for (int i = 0; i < hashArray.length; i++) {
             if(hashArray[i] != 0)
                 return false;
         }

        return true;
    }
}
