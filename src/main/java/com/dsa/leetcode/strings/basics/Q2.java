package com.dsa.leetcode.strings.basics;

import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            int len = sc.nextInt();
            char[] arr = new char[len];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.next().charAt(0);
            }
            System.out.println(findError(arr));


        }


    }


    static String findError(char[] arr) {

        Set<Character> expectedChars = new HashSet<>();
        int expectedLength = arr.length;
        char duplicateChar = 'a', missingChar = 'a';

        for (char ch = 'a'; ch < 'a' + expectedLength; ch++) {
            expectedChars.add(ch);
        }

        Map<Character, Integer> charCounts = new HashMap<>();
        for (char temp : arr) {

            int count = charCounts.getOrDefault(temp, 0) + 1;
            charCounts.put(temp, count);
            if (count > 1) {
               duplicateChar = temp;
            }
            expectedChars.remove(temp);
        }

         missingChar = expectedChars.iterator().next();
        return "[" + duplicateChar + " " + missingChar + "]";
    }
}

