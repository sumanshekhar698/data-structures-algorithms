package com.dsa.leetcode.hashing;

import java.util.HashMap;

public class _290WordPattern {

    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));


    }

    static public boolean wordPattern(String pattern, String s) {


        HashMap<Character, String> map = new HashMap<>();

        String[] split = s.split(" ");//splitting the s
        if (split.length != pattern.length())//edge case checking
            return false;

        for (int i = 0; i < pattern.length(); i++) {//traversing via all the pattern chars
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(split[i]))//If a char is mapped to some other String
                    return false;
            } else if ((map.containsValue(split[i]))) {//if the current String is already mapped to a char
                return false;
            } else {//else create an entry of K:V
                map.put((pattern.charAt(i)), (split[i]));
            }

        }
        return true;


    }
}
