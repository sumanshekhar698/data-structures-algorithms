package com.dsa.leetcode.strings;

class _392IsSubsequence {
    public static void main(String[] args) {
        System.out.println();

    }

    static boolean isSubsequence(String s, String t) {

//        Input: s = "abc", t = "ahbgdc"
//        Output: true

        if (s.length() > t.length())//corner case
            return false;

        int j = 0;
        for (int i = 0; i < t.length() && j < s.length(); i++) {// traversing on it while checking the chracters of
//            the condition in the loopenables us to exit as soon as s.length completes a positive checking OR t.length is checked
            if (s.charAt(j) == t.charAt(i))
                j++;
        }
        //for the sample input the loops stop after j becomes 3 which is also the length of s

        return (j == s.length());//if j equals the the length of s, we can say its a sbstring
    }
};