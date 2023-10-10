package com.dsa.leetcode.hashing;

import java.util.HashMap;

public class _205IsomorphicStrings {

    public static void main(String[] args) {
        boolean isomorphic = isIsomorphicOptimizedViaOneHashMap("paper", "title");
        System.out.println(isomorphic);
    }

    private static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> st = new HashMap<>();
        HashMap<Character, Character> ts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if ((st.containsKey(ch1) && st.get(ch1) != ch2) || (ts.containsKey(ch2) && ts.get(ch2) != ch1)) {
                return false;
            }

            st.put(ch1, ch2);
            ts.put(ch2, ch1);
        }

        return true;//they are isomorphic
    }

    public static boolean isIsomorphicOptimizedViaOneHashMap(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            if (!hm.containsKey(original)) {
                if (!hm.containsValue(replacement)) {
                    hm.put(original, replacement);
                } else {
                    return false;
                }
            } else {
                if (hm.get(original) != replacement)
                    return false;
            }
        }
        return true;
    }

    static boolean isIsomorphicWrongApproach(String s, String t) {
        HashMap<Character, Character> st = new HashMap<>();
//         HashMap<Character, Character> ts = new HashMap<>();

        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            char sAtIChar = s.charAt(i);

            if (st.containsKey(sAtIChar)) {

                if (st.get(sAtIChar) != t.charAt(i))
                    return false;

            } else {
                if (st.containsKey(t.charAt(i)))
                    return false;
                st.put(sAtIChar, t.charAt(i));
            }
        }

        return true;

    }
}
