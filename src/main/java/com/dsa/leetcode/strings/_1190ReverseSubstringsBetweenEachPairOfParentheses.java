package com.dsa.leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.ArrayDeque;

/**
 * _1190ReverseSubstringsBetweenEachPairOfParentheses
 */
public class _1190ReverseSubstringsBetweenEachPairOfParentheses {

    public String reverseParenthesesSuerOptimized(String s) { // Time n where | and n space

        // Precomupte Parentheses pairs
        ArrayDeque<Map.Entry<Character, Integer>> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.addLast(Map.entry(ch, i));
            } else if (ch == ')') {
                int value = stack.removeLast().getValue();
                map.put(value, i);//putting both pairs to handle direction change
                map.put(i, value);
            }
        }

        int i = 0, direction = 1;
        ArrayList<Character> finalReversedStringList = new ArrayList<>();

        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')') {
                i = map.get(i);
                direction = -direction;

            } else {// some other char
                finalReversedStringList.add(ch);
            }
            i += direction;

        }
        return finalReversedStringList.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();

    }

    public String reverseParentheses(String s) { // Time n*m where m is no of bracket pair | and n space

        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayList<Character> teamReversedStringList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                while (stack.peekLast() != '(') {
                    teamReversedStringList.add(stack.pollLast());
                }
                stack.pollLast();// removing '()'
                stack.addAll(teamReversedStringList);
                teamReversedStringList.clear();
            } else {
                stack.addLast(ch);
            }
        }
        return stack.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();

    }

    public String reverseParenthesesUSingStackOfStringBuilder(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        // need a base so that when c == ) can pop and append
        stack.push(new StringBuilder());

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(new StringBuilder());
            } else if (c == ')') {
                StringBuilder str = stack.pop().reverse();
                stack.peek().append(str);
            } else {
                stack.peek().append(c);
            }
        }
        return stack.peek().toString();
    }
}