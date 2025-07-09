package com.codecounty.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the Naive String Pattern Matching algorithm using a sliding window.
 * This algorithm checks every possible alignment of the pattern within the text.
 */
public class NaiveStringMatcher {

    /**
     * Finds all occurrences of a given pattern in a text using the naive string matching algorithm.
     *
     * @param text The main text in which to search for the pattern.
     * @param pattern The pattern to search for.
     * @return A list of starting indices where the pattern is found in the text.
     * Returns an empty list if no occurrences are found or if inputs are invalid.
     */
    public List<Integer> search(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();

        // Handle edge cases for invalid inputs
        if (text == null || pattern == null) {
            System.out.println("Text or pattern cannot be null.");
            return occurrences; // Return an empty list
        }
        if (pattern.isEmpty()) {
            System.out.println("Pattern is empty. An empty pattern is considered to match at every position in the text.");
            // Depending on strictness, an empty pattern might match at every position.
            // For simplicity, we'll treat it as no specific match for non-empty text,
            // or a match at index 0 for empty text.
            if (text.isEmpty()) {
                occurrences.add(0);
            }
            return occurrences;
        }
        if (text.isEmpty()) {
            System.out.println("Text is empty. No pattern can be found.");
            return occurrences;
        }
        if (pattern.length() > text.length()) {
            System.out.println("Pattern length is greater than text length. No match possible.");
            return occurrences;
        }

        int n = text.length();    // Length of the text
        int m = pattern.length(); // Length of the pattern

        // Outer loop: Iterate through all possible starting positions for the pattern in the text.
        // The loop runs from i = 0 up to (n - m), because after this point,
        // the pattern would extend beyond the end of the text.
        for (int i = 0; i <= n - m; i++) {
            boolean match = true; // Assume a match until a mismatch is found for the current window

            // Inner loop: Compare characters of the pattern with the characters
            // in the current window of the text.
            for (int j = 0; j < m; j++) {
                // If a character mismatch is found, set match to false and break the inner loop.
                // This moves the sliding window to the next starting position in the text.
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }

            // If the inner loop completes without any mismatches, it means
            // the pattern was found starting at index 'i' in the text.
            if (match) {
                occurrences.add(i);
            }
        }

        return occurrences;
    }

    // Main method for testing the NaiveStringMatcher
    public static void main(String[] args) {
        NaiveStringMatcher matcher = new NaiveStringMatcher();

        // Test Case 1: Simple match
        String text1 = "ABABDABACDABABCABAB";
        String pattern1 = "ABA";
        System.out.println("Text: \"" + text1 + "\", Pattern: \"" + pattern1 + "\"");
        List<Integer> result1 = matcher.search(text1, pattern1);
        System.out.println("Occurrences found at indices: " + result1); // Expected: [10]
        System.out.println("---");

        // Test Case 2: Multiple matches
        String text2 = "AAAAAA";
        String pattern2 = "AA";
        System.out.println("Text: \"" + text2 + "\", Pattern: \"" + pattern2 + "\"");
        List<Integer> result2 = matcher.search(text2, pattern2);
        System.out.println("Occurrences found at indices: " + result2); // Expected: [0, 1, 2, 3, 4]
        System.out.println("---");

        // Test Case 3: No match
        String text3 = "ABCDEFG";
        String pattern3 = "XYZ";
        System.out.println("Text: \"" + text3 + "\", Pattern: \"" + pattern3 + "\"");
        List<Integer> result3 = matcher.search(text3, pattern3);
        System.out.println("Occurrences found at indices: " + result3); // Expected: []
        System.out.println("---");

        // Test Case 4: Pattern at the beginning
        String text4 = "HELLO WORLD";
        String pattern4 = "HELLO";
        System.out.println("Text: \"" + text4 + "\", Pattern: \"" + pattern4 + "\"");
        List<Integer> result4 = matcher.search(text4, pattern4);
        System.out.println("Occurrences found at indices: " + result4); // Expected: [0]
        System.out.println("---");

        // Test Case 5: Pattern at the end
        String text5 = "GOODBYE CRUEL WORLD";
        String pattern5 = "WORLD";
        System.out.println("Text: \"" + text5 + "\", Pattern: \"" + pattern5 + "\"");
        List<Integer> result5 = matcher.search(text5, pattern5);
        System.out.println("Occurrences found at indices: " + result5); // Expected: [14]
        System.out.println("---");

        // Test Case 6: Pattern longer than text
        String text6 = "SHORT";
        String pattern6 = "LONGER_PATTERN";
        System.out.println("Text: \"" + text6 + "\", Pattern: \"" + pattern6 + "\"");
        List<Integer> result6 = matcher.search(text6, pattern6);
        System.out.println("Occurrences found at indices: " + result6); // Expected: [] (with message)
        System.out.println("---");

        // Test Case 7: Empty pattern
        String text7 = "ANYTEXT";
        String pattern7 = "";
        System.out.println("Text: \"" + text7 + "\", Pattern: \"" + pattern7 + "\"");
        List<Integer> result7 = matcher.search(text7, pattern7);
        System.out.println("Occurrences found at indices: " + result7); // Expected: [] (with message)
        System.out.println("---");

        // Test Case 8: Null inputs
        String text8 = null;
        String pattern8 = "test";
        System.out.println("Text: \"" + text8 + "\", Pattern: \"" + pattern8 + "\"");
        List<Integer> result8 = matcher.search(text8, pattern8);
        System.out.println("Occurrences found at indices: " + result8); // Expected: [] (with message)
        System.out.println("---");
    }
}