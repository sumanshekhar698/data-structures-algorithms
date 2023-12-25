package com.dsa.leetcode.arrays_numbers;

public class _28FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }

    public static int strStr(String haystack, String needle) {

        int i = 0, position = 0, finalPosition = -1;
        int needleLen = needle.length();

        outer:
        for (int j = 0; j < haystack.length(); j++) {
            if (haystack.charAt(j) == needle.charAt(i)) {
                position = j;

                while ((j < haystack.length()) && (haystack.charAt(j) == needle.charAt(i))) {
                    if (i == needleLen - 1) {
//                        finalPosition = position;
                        break outer;
                    }
                    ++j;
                    ++i;
                }

                //resetting indexes
                j = position;
                i = 0;
                position = -1;


            }

        }

//        return finalPosition;
        return position;

    }


    public int strStrCleanCode(String haystack, String needle) {
        int hayStackLength = haystack.length();
        int needleLength = needle.length();


        for (int i = 0; i <= hayStackLength - needleLength; i++) {//trick to minimize computation

            int j;
            for (j = 0; j < needleLength; j++) {

                if (haystack.charAt(i + j) != needle.charAt(j)) {//trick to preserve i
                    break;
                }
            }

            if (j == needleLength) {
                return i;//if match found
            }
        }

        return -1;// if no match found

    }

}
