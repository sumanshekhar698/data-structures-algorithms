package com.dsa.leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _76MinimumWindowSubstring {

    public static void main(String[] args) {
        String str1 = "ADOBECODEBANCD", str2 = "ABC";//BANC
        str1 = "aa";
        str2 = "aa";
        System.out.println(minWindow(str1, str2));

    }

    static String minWindowBrute(String str1, String str2) {//TODO
        //for every window we will have a map of all the windows
        return "";

    }

    static String minWindow(String str1, String str2) {

        String result = str1;
        boolean flag = false;

        if (str2.length() == 0 || str2.length() > str1.length())
            return result;


//        HashSet<Character> set = (HashSet) str2.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        Map<Character, Long> targetCharFrequency = str2.chars()
                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));


        long have = 0L, need = targetCharFrequency.entrySet().stream().mapToLong(e -> e.getValue()).sum();
        need = str2.length();//target characters



//        Map<Character, Long> currentMap = new HashMap<>(targetCharFrequency);
//        currentMap.replaceAll((k, v) -> 0L);


        Map<Character, Long> windowMap = new HashMap<>();

        int l = 0;
        for (int r = 0; r < str1.length(); r++) {//right side of a window
            char ch = str1.charAt(r);
            windowMap.merge(ch, 1L, Long::sum);//frequency update

            if (targetCharFrequency.containsKey(ch) && windowMap.get(ch) <= targetCharFrequency.get(ch)) {//incrementing have conditional
                have += 1;
            }

            while (have == need) {//found the eligible candidate
                flag = true;//we found atleast for one time
                if ((r - l + 1) < result.length()) {
                    result = str1.substring(l, r + 1);
                }

                ch = str1.charAt(l++);//increasing l to make the window shorter
                windowMap.put(ch, windowMap.get(ch) - 1);//updating the frequency after decreasing l pointer
                if (targetCharFrequency.containsKey(ch) && windowMap.get(ch) < targetCharFrequency.get(ch)) {//comparing the new short window
                    have -= 1;
                }
            }
        }


        return (flag == true) ? result : "";

    }
}
