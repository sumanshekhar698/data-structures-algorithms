package com.codecounty.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the Knuth-Morris-Pratt (KMP) String Pattern Matching algorithm.
 * KMP improves upon the naive algorithm by avoiding re-matching characters
 * that have already been matched, by pre-processing the pattern to create
 * a Longest Proper Prefix which is also a Suffix (LPS) array.
 */
public class KMPStringMatcher {

    /**
     * Finds all occurrences of a given pattern in a text using the KMP algorithm.
     *
     * @param text    The main text in which to search for the pattern.
     * @param pattern The pattern to search for.
     * @return A list of starting indices where the pattern is found in the text.
     * Returns an empty list if no occurrences are found or if inputs are invalid.
     */
    public List<Integer> search(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();

        // Handle edge cases for invalid inputs, similar to the naive matcher
        if (text == null || pattern == null) {
            System.out.println("Text or pattern cannot be null.");
            return occurrences;
        }
        if (pattern.isEmpty()) {
            System.out.println("Pattern is empty. An empty pattern is considered to match at every position in the text.");
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

        // Pre-process the pattern to compute the LPS (Longest Prefix Suffix) array (also known as pi table or failure function)
        int[] lps = computeLPSArray(pattern);

        int i = 0; // index for text (n)
        int j = 0; // index for pattern (m)

        // Iterate through the text
        while (i < n) {
            // If characters match, advance both text and pattern indices
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            // If the entire pattern is matched
            if (j == m) {
                // An occurrence is found at (i - j)
                occurrences.add(i - j);
                // After finding a match, we use the LPS array to determine
                // where to continue searching in the pattern for the next potential match.
                // This is the core optimization of KMP.
                j = lps[j - 1];
            }
            // If characters do not match after incrementing i and j (or initially do not match)
            else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                // Do not match lps[j-1] characters, just use the value from the LPS array
                // If j is not 0, it means we have a partial match that just failed.
                // We use the LPS array to shift the pattern.
                if (j != 0) {
                    j = lps[j - 1];
                }
                // If j is 0, it means the first character of the pattern didn't match.
                // We just advance the text pointer.
                else {
                    i++;
                }
            }
        }

        return occurrences;
    }



    /*The statement "LPS for the first character is always 0" refers to the Longest Proper Prefix which is also a Suffix (LPS) array in the KMP algorithm.
    Here's why it's always 0:

    LPS Definition: The LPS array at index i ( lps[i] ) stores the length of the longest proper prefix of the pattern pattern[0...i] that is also a suffix of pattern[0...i].

   => A proper prefix of a string is any prefix of the string except the string itself.
   => A proper suffix of a string is any suffix of the string except the string itself.
    Consider the first character (index 0): Let the pattern be P.

    The string pattern[0...0] is just P[0].
    The only prefix of P[0] is P[0].
    The only suffix of P[0] is P[0].
    Since a proper prefix/suffix explicitly excludes the entire string, P[0] has no proper prefixes or proper suffixes.
    Conclusion: Because there are no proper prefixes of pattern[0] that can also be proper suffixes of pattern[0], the length of the longest such match is 0. Therefore, lps[0] is always initialized to 0.
*/

    /**
     * Computes the Longest Proper Prefix which is also a Suffix (LPS) array for the given pattern.
     * The LPS array is crucial for the KMP algorithm, as it helps to avoid redundant comparisons
     * by telling us the length of the longest proper prefix of `pattern[0...j]` that is also a suffix of `pattern[0...j]`.
     * O(n) = n
     * @param pattern The pattern string.
     * @return An integer array representing the LPS array.
     */
    private int[] computeLPSArray(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];// create an array of exact length n

/*         *** each index of lps corresponds to the subsequent subarrays,
         and its value corresponds to the length of longest prefix == suffix *** */


        int prevLPS_Length = 0; // Length of the previous longest prefix suffix
//        lps[0] = 0;
        lps[0] = prevLPS_Length; // LPS for the first character is always 0
        int i = 1;//we will start from i =1

        // The loop calculates lps[i] for i = 1 to n-1
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(prevLPS_Length)) {
                prevLPS_Length++;// A=B :: B=C => A=C
                lps[i] = prevLPS_Length;
                i++;
            } else { // (pattern.charAt(i) != pattern.charAt(prevLPS_Length)) // DOES NOT MATCH
                if (prevLPS_Length == 0) {
                    // If prevLPS_Length is 0, it means there's no common prefix/suffix,
                    // so lps[i] is 0.
                    lps[i] = 0;
                    i++;

                }
                // This is tricky. When characters don't match,
                // we move 'prevLPS_Length' back using the LPS array.
                // We do not decrement 'i' here.
                else { // if (length != 0)
                    prevLPS_Length = lps[prevLPS_Length - 1];
                }
            }
        }
        return lps;
    }

    // Main method for testing the KMPStringMatcher
    public static void main(String[] args) {
        KMPStringMatcher matcher = new KMPStringMatcher();

        String samplePattern = "AAACAAAA";
        String needle = "AAAA";
        String haystack = "AAAXAAAAAX";
        List<Integer> result0 = matcher.search(haystack, needle);
        System.out.println("Occurrences found at indices: " + result0); // Expected: [10]



        // Test Case 1: Simple match (same as naive)
        String text1 = "ABABDABACDABABCABAB";
        String pattern1 = "ABA";
        System.out.println("Text: \"" + text1 + "\", Pattern: \"" + pattern1 + "\"");
        List<Integer> result1 = matcher.search(text1, pattern1);
        System.out.println("Occurrences found at indices: " + result1); // Expected: [10]
        System.out.println("---");

        // Test Case 2: Multiple matches (same as naive)
        String text2 = "AAAAAA";
        String pattern2 = "AA";
        System.out.println("Text: \"" + text2 + "\", Pattern: \"" + pattern2 + "\"");
        List<Integer> result2 = matcher.search(text2, pattern2);
        System.out.println("Occurrences found at indices: " + result2); // Expected: [0, 1, 2, 3, 4]
        System.out.println("---");

        // Test Case 3: No match (same as naive)
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

        // KMP Specific Test Case: Self-overlapping pattern
        String text9 = "ABABCABABABABCABAB";
        String pattern9 = "ABABCABAB";
        System.out.println("Text: \"" + text9 + "\", Pattern: \"" + pattern9 + "\"");
        List<Integer> result9 = matcher.search(text9, pattern9);
        System.out.println("Occurrences found at indices: " + result9); // Expected: [0, 9]
        System.out.println("---");
    }
}
