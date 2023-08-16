package com.dsa.leetcode.hashing;

import java.util.*;

public class _49GroupAnagrams {
    //    https://leetcode.com/problems/group-anagrams/
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagramsSimplifiedCoding(strs);
        System.out.println(list);

    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList();
        HashMap<String, List<String>> map = new HashMap<>();


        String key;
        for (int i = 0; i < strs.length; i++) {

            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            key = new StringBuilder().append(charArray).toString();
            int finalI = i;// effectively final
//            map.put(key, map.getOrDefault(key, new ArrayList<>(){//JDK 9
//            map.put(key, map.getOrDefault(key, new ArrayList() {
//                {
//                    add(strs[finalI]);
//                }
//            }));

            if (map.containsKey(key)) {
                map.get(key).add(strs[finalI]);
            } else {
                map.put(key, new ArrayList() {
                    {
                        add(strs[finalI]);
                    }
                });
            }


        }

        map.forEach((k, v) -> {
            list.add(v);
        });

        return list;
    }


    public static List<List<String>> groupAnagramsSimplifiedCoding(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

//        Collection<List<String>> values = map.values();


        return new ArrayList<>(map.values());
    }
}

