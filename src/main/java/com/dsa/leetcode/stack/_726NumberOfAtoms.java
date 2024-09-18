package com.dsa.leetcode.stack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _726NumberOfAtoms {

    public static void main(String[] args) {

    }

    public String countOfAtoms(String formula) {

        TreeMap<String, Integer> intialCountMap = new TreeMap<>();

        ArrayDeque<Map<String, Integer>> stackOfMap = new ArrayDeque<>();
        // Dissove the Parantheses
        stackOfMap.addLast(intialCountMap);

        for (int i = 0; i < formula.length(); i++) {
            Character ch = formula.charAt(i);
            if (ch == '(') {
                stackOfMap.addLast(new HashMap<>());
            } else if (ch == ')') {
                Map<String, Integer> poppedMap = stackOfMap.removeLast();

                // Phase 1 : Frequency/Count Computation after bracket:: Minimum count will be 1
                // for every atomGroup
                StringBuilder tempSb = new StringBuilder("");// initial len = 0
                while ((i + 1 < formula.length()) && Character.isDigit(formula.charAt(i + 1))) {
                    tempSb.append(formula.charAt(i + 1));
                    ++i;
                }
                int count = tempSb.length() == 0 ? 1 : Integer.parseInt(tempSb.toString());// assign the value 1 if
                                                                                           // inner while loop didnt
                                                                                           // executed
                // Phase 2 : Multily the cound with the frequency of poppedMap elements
                for (Map.Entry<String, Integer> entry : poppedMap.entrySet()) {
                    entry.setValue(entry.getValue() * count);
                }

                // Phase 3 : Dissolve poppedMap elements with the previous map Elements
                Map<String, Integer> peekedMap = stackOfMap.peekLast();
                poppedMap.forEach((key, value1) -> peekedMap.merge(key, value1, Integer::sum));

            } else {
                StringBuilder tempSb = new StringBuilder("");// initial len = 0

                // case 1: Element Computation
                String element = "" + ch;// Handling element of single char
                if (i + 1 < formula.length() && Character.isLowerCase(formula.charAt(i + 1))) {// handling element of 2
                                                                                               // char
                    element += formula.charAt(i + 1);
                    ++i;
                }

                // case 2: Frequency/Count Computation :: Minimum count will be 1 for every atom
                while ((i + 1 < formula.length()) && Character.isDigit(formula.charAt(i + 1))) {
                    tempSb.append(formula.charAt(i + 1));
                    ++i;
                }
                int count = tempSb.length() == 0 ? 1 : Integer.parseInt(tempSb.toString());// assign the value 1 if
                                                                                           // inner while loop didnt
                                                                                           // executed

                Map<String, Integer> peekedMap = stackOfMap.peekLast();
                peekedMap.put(element, peekedMap.getOrDefault(element, 0) + count);//updating coresponding peeked map

            }
        }

        StringBuilder sb = new StringBuilder();
        intialCountMap.entrySet().stream()
                .map(entry -> entry.getValue() == 1 ? entry.getKey() : entry.getKey() + entry.getValue())
                .forEach(sb::append);

        return sb.toString();

    }


    

    public static int where;
    public static String countOfAtoms2ndVariation(String str) {// 3ms
        where = 0;
        StringBuilder ans = new StringBuilder();
        TreeMap<String, Integer> map = f(str.toCharArray(), 0);
        for (String key : map.keySet()) {
            ans.append(key);
            if (map.get(key) > 1) {
                ans.append(map.get(key));
            }
        }
        return ans.toString();
    }

    public static void fill(TreeMap<String, Integer> ans, StringBuilder name, TreeMap<String, Integer> pre, int cnt) {
        if (name.length() != 0 || pre != null) {
            cnt = cnt == 0 ? 1 : cnt;
            if (name.length() > 0) {
                String key = name.toString();
                ans.put(key, ans.getOrDefault(key, 0) + cnt); // 修正此处，不再循环 cnt 次
            } else {
                for (String key : pre.keySet()) {
                    ans.put(key, ans.getOrDefault(key, 0) + cnt * pre.get(key));
                }
            }
        }
    }

    public static TreeMap<String, Integer> f(char[] s, int i) {
        int cur = 0;
        TreeMap<String, Integer> ans = new TreeMap<>();
        StringBuilder name = new StringBuilder();
        TreeMap<String, Integer> pre = null;

        while (i < s.length && s[i] != ')') {
            if (s[i] == '(' || (s[i] >= 'A' && s[i] <= 'Z')) {
                fill(ans, name, pre, cur);
                cur = 0;
                pre = null;
                name.setLength(0);

                if (s[i] == '(') {
                    pre = f(s, i + 1);
                    i = where + 1;
                } else {
                    name.append(s[i++]);
                }

            } else if (s[i] - '0' >= 0 && s[i] - '0' <= 9) {
                cur = cur * 10 + s[i++] - '0';
            } else {
                name.append(s[i++]);
            }
        }
        where = i;
        fill(ans, name, pre, cur);
        return ans;
    }

}
