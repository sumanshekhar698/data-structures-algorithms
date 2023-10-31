package com.dsa.leetcode.hashing;

import java.util.HashMap;

public class _383RansomNote {

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));

    }

    static public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {//Enriching 1st map
            map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {//Deriching teh same map
            if (map.containsKey(magazine.charAt(i))) {
                if (map.get(magazine.charAt(i)) != 1) {
                    map.put(magazine.charAt(i), map.get(magazine.charAt(i)) - 1);
                } else {
                    map.remove(magazine.charAt(i));
                }
            }
        }

        return map.isEmpty();//isEmpty means true else false

    }
}
