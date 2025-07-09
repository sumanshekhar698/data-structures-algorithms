package com.dsa.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

public class _28_E_FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        List<Integer> occurrences = new ArrayList<>();

        // Handle edge cases for invalid inputs
        if (haystack == null || needle == null) {
            System.out.println("Text or needle cannot be null.");
            return -1; // Return an empty list
        }
        if (needle.isEmpty()) {
            System.out.println("Pattern is empty. An empty needle is considered to match at every position in the haystack.");
            // Depending on strictness, an empty needle might match at every position.
            // For simplicity, we'll treat it as no specific match for non-empty haystack,
            // or a match at index 0 for empty haystack.
            if (haystack.isEmpty()) {
                occurrences.add(0);
            }
            return -1;
        }
        if (haystack.isEmpty()) {
            System.out.println("Text is empty. No needle can be found.");
            return -1;
        }
        if (needle.length() > haystack.length()) {
            System.out.println("Pattern length is greater than haystack length. No match possible.");
            return -1;
        }

        int n = haystack.length();    // Length of the haystack
        int m = needle.length(); // Length of the needle

        // Outer loop: Iterate through all possible starting positions for the needle in the haystack.
        // The loop runs from i = 0 up to (n - m), because after this point,
        // the needle would extend beyond the end of the haystack.
        for (int i = 0; i <= n - m; i++) {
            boolean match = true; // Assume a match until a mismatch is found for the current window

            // Inner loop: Compare characters of the needle with the characters
            // in the current window of the haystack.
            for (int j = 0; j < m; j++) {
                // If a character mismatch is found, set match to false and break the inner loop.
                // This moves the sliding window to the next starting position in the haystack.
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }

            // If the inner loop completes without any mismatches, it means
            // the needle was found starting at index 'i' in the haystack.
            if (match) {
                occurrences.add(i);
            }
        }

        return !occurrences.isEmpty() ? occurrences.getFirst() : -1;

    }


    public int searchTweaked(String haystack, String needle) {

        int defaultIndex = -1;

        // Handle edge cases for invalid inputs
        if (haystack == null || needle == null) {
            System.out.println("Text or needle cannot be null.");
            return defaultIndex; // Return an -1
        }
        if (needle.isEmpty()) {
            System.out.println("Pattern is empty. An empty needle is considered to match at every position in the haystack.");
            // Depending on strictness, an empty needle might match at every position.
            // For simplicity, we'll treat it as no specific match for non-empty haystack,
            // or a match at defaultIndex 0 for empty haystack.
            if (haystack.isEmpty()) {
                return defaultIndex; // Return an -1
            }
            return defaultIndex; // Return an -1
        }
        if (haystack.isEmpty()) {
            System.out.println("Text is empty. No needle can be found.");
            return defaultIndex; // Return an -1
        }
        if (needle.length() > haystack.length()) {
            System.out.println("Pattern length is greater than haystack length. No match possible.");
            return defaultIndex; // Return an -1
        }

        int n = haystack.length();    // Length of the haystack
        int m = needle.length(); // Length of the needle

        // Outer loop: Iterate through all possible starting positions for the needle in the haystack.
        // The loop runs from i = 0 up to (n - m), because after this point,
        // the needle would extend beyond the end of the haystack.
        for (int i = 0; i <= n - m; i++) {
            boolean match = true; // Assume a match until a mismatch is found for the current window

            // Inner loop: Compare characters of the needle with the characters
            // in the current window of the haystack.
            for (int j = 0; j < m; j++) {
                // If a character mismatch is found, set match to false and break the inner loop.
                // This moves the sliding window to the next starting position in the haystack.
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }

            // If the inner loop completes without any mismatches, it means
            // the needle was found starting at defaultIndex 'i' in the haystack.
            if (match) {
                return i; // Return the first found
            }
        }

        return defaultIndex;//-1
    }


}
