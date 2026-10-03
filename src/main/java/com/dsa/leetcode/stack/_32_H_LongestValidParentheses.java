package com.dsa.leetcode.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class _32_H_LongestValidParentheses {

    public static void main(String[] args) {

        String str = ")()())";
        _32_H_LongestValidParentheses obj = new _32_H_LongestValidParentheses();
        System.out.println(obj.longestValidParentheses(str));

    }


    public int longestValidParentheses(String s) {
//        We will find indexes where the parentheses are not valid, and
//        then we will find the max length of valid parentheses between those indexes
        int maxLen = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<>();


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {

                if (stack.isEmpty() || s.charAt(stack.peek()) == ')') {//Invalid Parenthesis Cases
                    stack.push(i);
                } else {
                    stack.pop();//Open () Close Nullifying the last open parenthesis
                }
            }
        }

        if (stack.isEmpty()) {
            return s.length();
        }

        // Now we have the indexes of invalid parentheses in the stack
        ArrayList<Integer> invalidIndexes = new ArrayList<>();
        invalidIndexes.add(s.length());//Ending Boundary for Invalid parentheses
        while (!stack.isEmpty()) {
            invalidIndexes.add(stack.pop());
        }
        invalidIndexes.add(-1);//Starting Boundary for Invalid parentheses

        // Find the max length of valid parentheses between invalid indexes
        for (int i = 1; i < invalidIndexes.size(); i++) {
            int end = invalidIndexes.get(i - 1);
            int start = invalidIndexes.get(i);
            maxLen = Math.max(maxLen, end - start - 1);
        }

        return maxLen;


    }


    public int longestValidParenthesesUsingSimpleArrayStackJavaOptimized(String s) {//*
        int n = s.length();
        if (n <= 1) return 0;

        // Fast array-based primitive int stack (no Integer object allocation/boxing)
        int[] stack = new int[n];
        int top = -1;



        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack[++top] = i;
            } else {
                // Check if stack is empty or top element was also an unmatched ')'
                if (top == -1 || s.charAt(stack[top]) == ')') {
                    stack[++top] = i;
                } else {
                    top--; // Matched "()", pop the opening '('
                }
            }
        }

        // All characters formed valid pairs
        if (top == -1) {
            return n;
        }

        // Calculate max valid gap directly from stack elements:
        // Right boundary begins at n (equivalent to invalidIndexes.add(s.length()))
        int maxLen = 0;
        int end = n;

        while (top >= 0) {
            int start = stack[top--];
            maxLen = Math.max(maxLen, end - start - 1);
            end = start;
        }

        // Left boundary ends at -1 (equivalent to invalidIndexes.add(-1))
        maxLen = Math.max(maxLen, end - (-1) - 1);

        return maxLen;
    }


    public int longestValidParentheses2Pass(String s) {
        int maxLen = 0;
        int open = 0, close = 0;
        int n = s.length();

//        2 passes because of "(()" ==> will be not counted in the first pass, but will be counted in the second pass
        // Pass 1: Left to right
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') open++;
            else close++;

            if (open == close) {
                maxLen = Math.max(maxLen, 2 * close);
            } else if (close > open) {
                open = close = 0;//Resetting the counters when we have more closing brackets than opening brackets, as it indicates an invalid sequence
            }
        }

        open = close = 0;
        // Pass 2: Right to left (catches cases like "(()")
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') open++;
            else close++;

            if (open == close) {
                maxLen = Math.max(maxLen, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }

        return maxLen;
    }
}

