package com.dsa.leetcode.strings;

public class _58LengthOfLastWord {
    //    https://leetcode.com/problems/length-of-last-word/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {

    }


    public static int lengthOfLastWord(String s) {
        String trimmedSTring = s.trim();

        int counter = 0;
        for (int i = trimmedSTring.length() - 1; i >= 0; i--) {
            if (trimmedSTring.charAt(i) != ' ') {
                counter++;
            } else {
                break;
            }
        }

        return counter;

    }
}
