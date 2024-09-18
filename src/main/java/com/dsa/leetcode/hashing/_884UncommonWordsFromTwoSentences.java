package com.dsa.leetcode.hashing;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class _884UncommonWordsFromTwoSentences {

    public static void main(String[] args) {

        String s1 = "this apple is sweet", s2 = "this apple is sour";
        System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));

    }

    static public String[] uncommonFromSentences(String s1, String s2) {
        return Arrays.stream((s1 + " " + s2).split(" "))
                // Convert words to lowercase to make comparisons case-insensitive
                .map(String::toLowerCase)
                // Group words and count their occurrences
                .collect(Collectors.groupingBy(word -> word, Collectors.counting())).entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);


    }
}
