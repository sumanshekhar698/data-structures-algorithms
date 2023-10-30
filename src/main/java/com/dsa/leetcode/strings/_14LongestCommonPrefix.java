package com.dsa.leetcode.strings;

public class _14LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(arr));
    }

    static public String longestCommonPrefix(String[] strs) {
//        String res = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {//taking the 1st string as reference as it can be a potential answer
            char ch = strs[0].charAt(i);//for each ith character ch of 1st String

            for (String m : strs) {//comparing it with ith character of every String
                if (m.length() == i || ch != m.charAt(i)) {//whenever if there is a shorter length check OR it breaks the rule of inequality
                    return sb.toString();
                }

            }

            sb.append(ch);

        }

        return sb.toString();

    }
}
