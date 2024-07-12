package com.dsa.leetcode.strings;

import java.util.ArrayDeque;

class _1717MaximumScoreFromRemovingSubstrings {

    StringBuilder sb;

    public int maximumGain(String s, int x, int y) {// Space n(Stack and Sb), Time n
        this.sb = new StringBuilder(s);

        int result = 0;

        String pair1, pair2;
        if (x > y) {// setting pair1 for phase 1
            pair1 = "ab";
            pair2 = "ba";

        } else {
            pair1 = "ba";
            pair2 = "ab";
        }

        // We will be greedy
        result += removePairs(pair1, Integer.max(x, y));// phase 1 remove all the ab/ba whicherevr has higher score
        result += removePairs(pair2, Integer.min(x, y));// phase 2 remove all the ba/ab whicherevr has lower score

        return result;
    }

    int removePairs(String pair, int score) {
        int result = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            // looking for possible pair match
            if ((ch == pair.charAt(1)) && !stack.isEmpty() && stack.peekLast() == pair.charAt(0)) {
                stack.pollLast();
                result += score;
            } else {
                stack.addLast(ch);
            }

        }

        this.sb = stack.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        // updating sb for phase 2 of algo if its phase 1

        return result;

    }

    public static void main(String... args) {

    }

}