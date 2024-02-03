package com.dsa.leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _438FindAllAnagramsInAString {

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));

    }

    static public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Character, Long> collectS = new HashMap();
        if (s.length() < p.length())
            return list;


        Map<Character, Long> collectP = p.chars().mapToObj(c -> (char) c)             // Convert int characters to Character objects
                .collect(Collectors.groupingBy(      // Group characters by their identity
                        Character::charValue,          // Key: Character itself
                        Collectors.counting()          // Value: Count occurrences
                ));
//        System.out.println(collect);

        int j = 0;
        for (; j < p.length(); j++) {
            collectS.put(s.charAt(j), collectS.getOrDefault(s.charAt(j), Long.valueOf(0)) + 1);

        }

        if (areMapsEqual(collectS, collectP))
            list.add(0);


        int i = 0;
        while (j < s.length()) {//window size of length p
//            char ch = s.charAt(j);
            collectS.put(s.charAt(j), collectS.getOrDefault(s.charAt(j), Long.valueOf(0)) + 1);
            collectS.put(s.charAt(i), collectS.getOrDefault(s.charAt(i), Long.valueOf(1)) - 1);

            if (collectS.get(s.charAt(i)) == 0)//remove any the left most key with value 0
                collectS.remove(s.charAt(i));


            i++;
            j++;


            if (areMapsEqual(collectS, collectP))
                list.add(i);

        }


        return list;
    }

    public static <K, V> boolean areMapsEqual(Map<K, V> map1, Map<K, V> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }
        for (K key : map1.keySet()) {
            if (!map2.containsKey(key) || !map1.get(key).equals(map2.get(key))) {
                return false;
            }
        }
        return true;
    }

    public static boolean areMapsEqual1(Map<Character, Long> map1, Map<Character, Long> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }
        for (Character key : map1.keySet()) {
            if (!map2.containsKey(key) || !map1.get(key).equals(map2.get(key))) {
                return false;
            }
        }
        return true;
    }
}
