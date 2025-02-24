package com.dsa.leetcode.arrays_numbers.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _30SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        _30SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new _30SubstringWithConcatenationOfAllWords();
        String s = "bcabbcaabbccacacbabccacaababcbb";
        String[] words = {"c", "b", "a", "c", "a", "a", "a", "b", "c"};
        List<Integer> list = substringWithConcatenationOfAllWords.findSubstring(s, words);
        System.out.println(list);
    }

    public List<Integer> findSubstring(String s, String[] words) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        HashMap<String, Integer> tempMap = (HashMap<String, Integer>) map.clone();

        int wordLength = words[0].length();
        int totalWords = words.length;
        int totalLength = wordLength * totalWords;

        outer:
        for (int i = 0; i < s.length(); i++) {
            if (i + totalLength > s.length()) {
                break;
            }
            String substring = s.substring(i, i + totalLength);
            for (int j = 0; j < substring.length(); j += wordLength) {
                String word = substring.substring(j, j + wordLength);
                if (tempMap.containsKey(word) && tempMap.get(word) > 0) {
                    tempMap.put(word, tempMap.get(word) - 1);
                } else {
                    tempMap = (HashMap<String, Integer>) map.clone();
                    continue outer;
                }
            }

            if (tempMap.values().stream().allMatch(value -> value == 0)) {
                list.add(i);
                tempMap = (HashMap<String, Integer>) map.clone();
            }
        }

        return list;


    }

    public List<Integer> findSubstringOPTIMIZED(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length();
        int noOfWords = words.length;
        int wordSize = words[0].length();


        HashMap<String, Integer> map = new HashMap<>();
        for (String x : words)// fREQ MAP
            map.put(x, map.getOrDefault(x, 0) + 1);


        for (int i = 0; i < wordSize; i++) {
            HashMap<String, Integer> temp = new HashMap<>();
            int count = 0;
            for (int j = i, k = i; j + wordSize <= sLen; j = j + wordSize) {
                String word = s.substring(j, j + wordSize);
                temp.put(word, temp.getOrDefault(word, 0) + 1);
                count++;

                if (count == noOfWords) {
                    if (map.equals(temp)) {
                        ans.add(k);
                    }
                    String remove = s.substring(k, k + wordSize);
                    temp.computeIfPresent(remove, (a, b) -> (b > 1) ? b - 1 : null);
                    count--;
                    k = k + wordSize;
                }
            }
        }
        return ans;
    }
}
