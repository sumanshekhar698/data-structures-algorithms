package com.codecounty.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpStringMatching {

    // A prime number used as the base for the hash function.
    // Choose a value greater than the largest character value (e.g., 256 for ASCII).
    private static final int BASE = 256;

    // A large prime number used as the modulus to keep hash values manageable
    // and reduce collisions. Choosing a good prime is important for performance.
    private static final int PRIME_MODULUS = 101;

    /**
     * Searches for occurrences of a pattern within a text using the Rabin-Karp algorithm.
     *
     * @param text    The main text string to search within.
     * @param pattern The pattern string to find.
     * @return A list of starting indices in the text where the pattern is found.
     */
    public static List<Integer> search(String text, String pattern) {
        int N = text.length();    // Length of the text
        int M = pattern.length(); // Length of the pattern
        List<Integer> foundIndices = new ArrayList<>();

        // If a pattern is longer than a text, it cannot be found.
        if (M == 0 || N == 0 || M > N) {
            return foundIndices;
        }

        // ---------------------------------------------------------------------
        // Step 1: Precompute the highest power of BASE (BASE^(M-1) % PRIME_MODULUS)
        // This 'h' value is used to effectively "remove" the contribution of
        // the leftmost character when sliding the window.
        // For pattern "abc" (M=3), h will be (BASE^2) % PRIME_MODULUS
        // ---------------------------------------------------------------------
        int h = 1;
        for (int i = 0; i < M - 1; i++) {
            h = (h * BASE) % PRIME_MODULUS;
        }

        // ---------------------------------------------------------------------
        // Step 2: Calculate the hash value for the pattern and the first window
        // of the text (substring of text with length M).
        // ---------------------------------------------------------------------
        int patternHash = 0;
        int textWindowHash = 0;

        for (int i = 0; i < M; i++) {
            // Polynomial hash function: (current_hash * BASE + character_value) % PRIME_MODULUS
            patternHash = (BASE * patternHash + pattern.charAt(i)) % PRIME_MODULUS;
            textWindowHash = (BASE * textWindowHash + text.charAt(i)) % PRIME_MODULUS;
        }

        // ---------------------------------------------------------------------
        // Step 3: Slide the window across the text and compare hashes.
        // The loop runs from i = 0 to N - M, covering all possible starting
        // positions for the pattern in the text.
        // ---------------------------------------------------------------------
        for (int i = 0; i <= N - M; i++) {


            if (patternHash == textWindowHash) {  // If the hash values match, it's a potential match (could be a collision).
                boolean match = true;
                for (int j = 0; j < M; j++) {// Perform a character-by-character comparison to confirm.
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break; // Mismatch found, not an actual match
                    }
                }
                if (match) {
                    foundIndices.add(i); // Actual pattern found at index i
                }
            }

            // -----------------------------------------------------------------
            // Step 4: Calculate the hash for the next window (rolling hash)
            // This is the most critical and efficient part.
            // Only perform this if there's a next window to consider.
            // -----------------------------------------------------------------
            if (i < N - M) {
                // Remove the hash contribution of the character leaving the window:
                // text.charAt(i) is the character leaving. Its contribution was text.charAt(i) * BASE^(M-1).
                // We use 'h' for BASE^(M-1) % PRIME_MODULUS.
                textWindowHash = (textWindowHash - text.charAt(i) * h) % PRIME_MODULUS;

                // Shift the remaining hash left (multiply by BASE) to make room for the new character.
                textWindowHash = (textWindowHash * BASE) % PRIME_MODULUS;

                // Add the hash contribution of the new character entering the window:
                // text.charAt(i + M) is the character entering. Its contribution is text.charAt(i + M) * BASE^0.
                textWindowHash = (textWindowHash + text.charAt(i + M)) % PRIME_MODULUS;

                // Handle potential negative hash values (due to modulo operations with subtraction).
                // If textWindowHash becomes negative, add PRIME_MODULUS to make it positive.
                if (textWindowHash < 0) {
                    textWindowHash = (textWindowHash + PRIME_MODULUS);
                }
            }
        }
        return foundIndices;
    }

    public static void main(String[] args) {
        // Test Case 1
        String text1 = "ababaabcabab";
        String pattern1 = "abc";
        System.out.println("Text: \"" + text1 + "\", Pattern: \"" + pattern1 + "\"");
        List<Integer> indices1 = search(text1, pattern1);
        if (indices1.isEmpty()) {
            System.out.println("Pattern not found.");
        } else {
            System.out.println("Pattern found at indices: " + indices1); // Expected: [5]
        }
        System.out.println("------------------------------------------");

        // Test Case 2: Multiple occurrences
        String text2 = "aaaaa";
        String pattern2 = "aa";
        System.out.println("Text: \"" + text2 + "\", Pattern: \"" + pattern2 + "\"");
        List<Integer> indices2 = search(text2, pattern2);
        if (indices2.isEmpty()) {
            System.out.println("Pattern not found.");
        } else {
            System.out.println("Pattern found at indices: " + indices2); // Expected: [0, 1, 2, 3]
        }
        System.out.println("------------------------------------------");

        // Test Case 3: Pattern not found
        String text3 = "abcdefg";
        String pattern3 = "xyz";
        System.out.println("Text: \"" + text3 + "\", Pattern: \"" + pattern3 + "\"");
        List<Integer> indices3 = search(text3, pattern3);
        if (indices3.isEmpty()) {
            System.out.println("Pattern not found."); // Expected: Pattern not found.
        } else {
            System.out.println("Pattern found at indices: " + indices3);
        }
        System.out.println("------------------------------------------");

        // Test Case 4: Pattern at the beginning
        String text4 = "patternsearch";
        String pattern4 = "pattern";
        System.out.println("Text: \"" + text4 + "\", Pattern: \"" + pattern4 + "\"");
        List<Integer> indices4 = search(text4, pattern4);
        if (indices4.isEmpty()) {
            System.out.println("Pattern not found.");
        } else {
            System.out.println("Pattern found at indices: " + indices4); // Expected: [0]
        }
        System.out.println("------------------------------------------");

        // Test Case 5: Pattern at the end
        String text5 = "searchpattern";
        String pattern5 = "pattern";
        System.out.println("Text: \"" + text5 + "\", Pattern: \"" + pattern5 + "\"");
        List<Integer> indices5 = search(text5, pattern5);
        if (indices5.isEmpty()) {
            System.out.println("Pattern not found.");
        } else {
            System.out.println("Pattern found at indices: " + indices5); // Expected: [6]
        }
    }
}