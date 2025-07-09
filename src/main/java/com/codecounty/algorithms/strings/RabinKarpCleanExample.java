package com.codecounty.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpCleanExample {

    // A prime number used as the base for the hash function.
    private static final int BASE = 256; 

    // A large prime number used as the modulus to keep hash values manageable
    private static final int PRIME_MODULUS = 101; 

    /**
     * Calculates the polynomial hash for a given string.
     * hash = (char0 * BASE^(length-1) + char1 * BASE^(length-2) + ... + char(length-1) * BASE^0) % PRIME_MODULUS
     *
     * @param str The string for which to calculate the hash.
     * @param length The number of characters to include in the hash calculation (from the beginning of the string).
     * @return The calculated hash value.
     */
    private static int calculateHash(String str, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (BASE * hash + str.charAt(i)) % PRIME_MODULUS;
        }
        return hash;
    }

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

        if (M == 0 || N == 0 || M > N) {
            return foundIndices;
        }


        // Precompute h = (BASE^(M-1)) % PRIME_MODULUS.
        // This value is used to remove the leading digit's contribution when sliding the window.
        // Using Math.pow() here. Note the cast to long for intermediate calculation
        // to prevent overflow before taking modulo.
        long h = 1;
        for (int i = 0; i < M - 1; i++) {
            h = (h * BASE) % PRIME_MODULUS;
        }
        // An alternative using Math.pow (less common in competitive programming due to double casting):
        // long h = (long) Math.pow(BASE, M - 1) % PRIME_MODULUS;


        // Calculate the hash value for the pattern and the first window of the text.
        int patternHash = calculateHash(pattern, M);
        int textWindowHash = calculateHash(text, M);

        // Slide the window across the text and compare hashes.
        for (int i = 0; i <= N - M; i++) {
            // If hash values match, it's a potential match. Verify with character-by-character comparison.
            if (patternHash == textWindowHash) {
                boolean match = true;
                for (int j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    foundIndices.add(i);
                }
            }

            // Calculate the hash for the next window using the rolling hash technique.
            if (i < N - M) {
                // Remove contribution of the leftmost character text.charAt(i)
                textWindowHash = (int) ((textWindowHash - text.charAt(i) * h) % PRIME_MODULUS);

                // Add contribution of the new rightmost character text.charAt(i + M)
                textWindowHash = (textWindowHash * BASE + text.charAt(i + M)) % PRIME_MODULUS;

                // Ensure the hash remains non-negative
                if (textWindowHash < 0) {
                    textWindowHash = (textWindowHash + PRIME_MODULUS);
                }
            }
        }
        return foundIndices;
    }

    public static void main(String[] args) {
        // Test Cases
        String text1 = "ababaabcabab";
        String pattern1 = "abc";
        System.out.println("Text: \"" + text1 + "\", Pattern: \"" + pattern1 + "\"");
        List<Integer> indices1 = search(text1, pattern1);
        System.out.println("Pattern found at indices: " + (indices1.isEmpty() ? "Not found." : indices1));
        System.out.println("------------------------------------------");

        String text2 = "aaaaa";
        String pattern2 = "aa";
        System.out.println("Text: \"" + text2 + "\", Pattern: \"" + pattern2 + "\"");
        List<Integer> indices2 = search(text2, pattern2);
        System.out.println("Pattern found at indices: " + (indices2.isEmpty() ? "Not found." : indices2));
        System.out.println("------------------------------------------");

        String text3 = "abcdefg";
        String pattern3 = "xyz";
        System.out.println("Text: \"" + text3 + "\", Pattern: \"" + pattern3 + "\"");
        List<Integer> indices3 = search(text3, pattern3);
        System.out.println("Pattern found at indices: " + (indices3.isEmpty() ? "Not found." : indices3));
        System.out.println("------------------------------------------");

        String text4 = "patternsearch";
        String pattern4 = "pattern";
        System.out.println("Text: \"" + text4 + "\", Pattern: \"" + pattern4 + "\"");
        List<Integer> indices4 = search(text4, pattern4);
        System.out.println("Pattern found at indices: " + (indices4.isEmpty() ? "Not found." : indices4));
        System.out.println("------------------------------------------");

        String text5 = "searchpattern";
        String pattern5 = "pattern";
        System.out.println("Text: \"" + text5 + "\", Pattern: \"" + pattern5 + "\"");
        List<Integer> indices5 = search(text5, pattern5);
        System.out.println("Pattern found at indices: " + (indices5.isEmpty() ? "Not found." : indices5));
    }
}