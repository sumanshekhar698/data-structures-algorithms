package com.dsa.leetcode.strings;

import java.util.Arrays;

public class _443StringCompression {

    public static void main(String[] args) {

        char[] charArray0 = {'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        char[] charArray = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b',};
        System.out.println(compress(charArray));
        System.out.println(Arrays.toString(charArray));
    }


    static public int compress(char[] chars) {

        if (chars.length <= 1)//edge case
            return chars.length;

        char temp = chars[0];
        StringBuilder sb = new StringBuilder();
        int freq = 1;
        for (int i = 1; i < chars.length; i++) {
            char ch = chars[i];

            if (ch == temp) {
                ++freq;
            } else {
                if (freq <= 1) {
                    sb.append(temp);
                } else {
                    sb.append(temp).append(freq);
                }
                temp = ch;
                freq = 1;

            }
        }

        if (freq <= 1) {//spillovers handling
            sb.append(temp);
        } else {
            sb.append(temp).append(freq);
        }

//        System.out.println(sb);
//        System.out.println(sb.length());
//        System.out.println(chars.length);

        for (int j = 0; j < sb.length(); j++) {//sb contents to charArray
            chars[j] = sb.charAt(j);
        }

        return sb.length();

    }

    public int compressOptimized(char[] chars) {
        int ans = 0; // keep track of current position in compressed array

        // iterate through input array using i pointer
        for (int i = 0; i < chars.length; ) {
            final char letter = chars[i]; // current character being compressed
            int count = 0; // count of consecutive occurrences of letter

            // count consecutive occurrences of letter in input array
            while (i < chars.length && chars[i] == letter) {
                ++count;
                ++i;
            }

            // write letter to compressed array
            chars[ans++] = letter;

            // if count is greater than 1, write count as string to compressed array
            if (count > 1) {
                // convert count to string and iterate over each character in string
                for (final char c : String.valueOf(count).toCharArray()) {
                    chars[ans++] = c;
                }
            }
        }

        // return length of compressed array
        return ans;
    }
}
