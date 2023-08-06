package com.dsa.leetcode.strings;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class _151ReverseWordsInAString {
//https://leetcode.com/problems/reverse-words-in-a-string/
    public static void main(String[] args) {
        String s = "the sky is blue";

        String reveresed = reverseWordsUsingForLoop(s);
        System.out.println(reveresed);
//        String[] s1 = s.split(" ");


//        // Trim the input string to remove leading and trailing spaces
//        String[] str = s.trim().split("\\s+");
//
//        // Initialize the output string
//        String out = "";
//
//        // Iterate through the words in reverse order
//        for (int i = str.length - 1; i > 0; i--) {
//            // Append the current word and a space to the output
//            out += str[i] + " ";
//        }
//
//        // Append the first word to the output (without trailing space)
//        return out + str[0];
    }

    String reverseWordsUsingStringBuilder(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }

    String reverseWordsUsingCollectionsReversal(String s) {
        String[] s1 = s.split("\\s+");
        int [] arr = new int [5];
        List<String> list = Arrays.asList(s1);
        Collections.reverse(list);
        return String.join(" ", list);

    }

    public static String reverseWordsUsingForLoop(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length(), last = n;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                sb.append(s.substring(i, last));
                last = i;
            }
        }
        System.out.println(sb);
        sb.append(' ' + s.substring(0, last));
        return sb.toString().replaceAll("\\s+", " ").trim();
    }

}
