package com.dsa.leetcode.strings.basics;

public class StringRotation {

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false; // Different lengths, cannot be rotations
        }

        // Concatenate s2 with itself to create a pattern
        String pattern = s2 + s2;

        // Check if s1 is a substring of the pattern
        return pattern.contains(s1);
    }

    public static void main(String[] args) {
        String s1 = "apple";
        String s2 = "pleap";

        if (isRotation(s1, s2)) {
            System.out.println(s1 + " is a rotation of " + s2);
        } else {
            System.out.println(s1 + " is not a rotation of " + s2);
        }
    }
}
