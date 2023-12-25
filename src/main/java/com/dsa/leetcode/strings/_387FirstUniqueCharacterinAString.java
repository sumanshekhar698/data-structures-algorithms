package com.dsa.leetcode.strings;

import java.util.*;
import java.util.stream.Collectors;

public class _387FirstUniqueCharacterinAString {

    public static void main(String[] args) {
        String s = "loveleetcode";
        int i = new Solution().firstUniqChar(s);
        System.out.println(i);

    }

    static class Solution {

        public static int firstUniqChar(String str) {
            // Convert the string to lowercase for case-insensitive comparison.
            String lowercaseStr = str.toLowerCase();

            // Create a hash map to store character counts.
            Map<Character, Integer> charCounts = new HashMap<>();

            // Count occurrences of each character in the string.
            lowercaseStr.chars().forEach(c -> charCounts.merge((char) c, 1, Integer::sum));//value->default value; if value is present then apply the mappingFn to the existing value

            // Find the first character with a count of 1 (unique).
            for (int i = 0; i < lowercaseStr.length(); i++) {
                char c = lowercaseStr.charAt(i);
                if (charCounts.get(c) == 1) {
                    return i;
                }
            }

            // No unique character found.
            return -1;
        }

            public int firstUniqCharUsingOptionsl (String str){
                // Convert the string to lowercase for case-insensitive comparison.
                String lowercaseStr = str.toLowerCase();

                // Create a linked hash map to maintain insertion order.
                LinkedHashMap<Character, Integer> charCounts = new LinkedHashMap<>();

                // Count occurrences of each character in the string.
                lowercaseStr.chars().forEach(c -> charCounts.put((char) c, charCounts.getOrDefault(c, 0) + 1));

                // Find the first character with a count of 1 (unique).
//            Optional<Character> firstUnique = charCounts.entrySet().stream()
//                    .filter(entry -> entry.getValue() == 1)
//                    .map(entry -> entry.getKey())
//                    .findFirst();

                Optional<Character> firstUnique = charCounts.entrySet().stream()
                        .filter(entry -> entry.getValue() == 1)
                        .map(entry -> entry.getKey())
                        .findFirst();

                // Return the index of the first unique character, or -1 if none found.
                return firstUnique.isPresent() ? lowercaseStr.indexOf(firstUnique.get()) : -1;
            }


        }


    }
