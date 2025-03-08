package com.dsa.leetcode.arrays_numbers.slidingwindow;

import java.util.Set;

public class _345ReverseVowelsOfAString {

    public static void main(String[] args) {
        String str = "IceCreAm";

        StringBuilder sb = new StringBuilder(str);


        int i = 0, j = str.length() - 1;

        Set<Character> set = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');

        while (i <= j) {
            if (set.contains(sb.charAt(i))) {
                while (j >= i) {
                    if (set.contains(sb.charAt(j))) {
                        swapCharacters(sb, i, j);
                        j--;
                        break;
                    }
                    j--;
                }
            }
            i++;


        }

        System.out.println(sb);//AceCreIm
    }


    public static void swapCharacters(StringBuilder sb, int i, int j) {
        if (sb == null || i < 0 || j < 0 || i >= sb.length() || j >= sb.length()) {
            throw new IllegalArgumentException("Invalid input or indices.");
        }

        if (i == j) {
            return; // No need to swap if indices are the same
        }

        char charI = sb.charAt(i);
        char charJ = sb.charAt(j);

        sb.replace(i, i + 1, String.valueOf(charJ));
        sb.replace(j, j + 1, String.valueOf(charI));
    }


    public String reverseVowels(String s) {
        boolean[] vowel = new boolean[128];
        char[] vowels = "aeiouAEIOU".toCharArray();
        for (char c : vowels)
            vowel[c] = true;

        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;

        while (i < j) {
            if (vowel[arr[i]]) {
                while (!vowel[arr[j]])
                    j--;
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j--;
            }
            i++;
        }

        return new String(arr);
    }
}
