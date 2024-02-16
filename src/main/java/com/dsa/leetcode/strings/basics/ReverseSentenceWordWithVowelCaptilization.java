package com.dsa.leetcode.strings.basics;

import java.util.Arrays;

public class ReverseSentenceWordWithVowelCaptilization {

    public static void main(String[] args) {
        String input = "I love my India";
//        Output: - IndIA my lOvE I

        String output = transform(input);
        System.out.println(output);
    }

    private static String transform(String input) {


        String vowels = "aeiou";
        String[] words = input.split(" ");
        System.out.println(Arrays.toString(words));

        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {

            String word = words[i];
            String tempWord = "";
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (vowels.contains(("" + ch).toLowerCase())) {
                    tempWord += ("" + ch).toUpperCase();
                } else {
                    tempWord += "" + ch;
                }


            }
            result += tempWord + " ";

        }

        return result.trim();
    }
}
