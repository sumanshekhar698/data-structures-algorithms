package com.dsa.leetcode.dp;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class _678_M_ValidParenthesis {

    public static void main(String[] args) {
        String s = "(*(*)";
        _678_M_ValidParenthesis solution = new _678_M_ValidParenthesis();
        System.out.println(solution.checkValidString(s));
    }


    public boolean checkValidString(String s) {
        return dfsMemoized(s, 0, 0);
    }


    public boolean checkValidStringGreedy(String s) {

        int minBalance = 0;
        int maxBalance = 0;
//        minBalance → smallest possible balance
//        maxBalance → largest possible balance

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                minBalance++;
                maxBalance++;

            } else if (ch == ')') {
                minBalance--;
                maxBalance--;

            } else { // '*'

                minBalance--; // '*' as ')'
                maxBalance++;  // '*' as '('
            }

            // Even the minimum balance cannot go below 0
            minBalance = Math.max(minBalance, 0);

            // No possible balance exists
            if (maxBalance < 0) {//VVI || helps where there are no stars and minBalance is 0,
                // but maxBalance is negative, which means we have more closing brackets than opening brackets,
                // which is not recoverable
                return false;
            }
        }

        return minBalance == 0;
        /*We keep minBalance as low as possible, but never below 0, across all possible interpretations of *.
          And at last min should be 0*/
    }

    Map<String, Boolean> memo = new HashMap<>();

    private boolean dfsMemoized(String s, int index, int balance) {
        // Multiple combination of valid Parentheses can exist
        // Two nodes at same level can have same balance, so we can use memoization to avoid recomputation of the same state in another branch of the recursion tree. We can use a HashMap to store the result of each state (index, balance) and return it if we encounter the same state again.

        if (balance < 0) {
            return false;
        }

        if (index == s.length()) {
            return balance == 0;
        }

        String key = index + "," + balance;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        char ch = s.charAt(index);

        boolean result;

        if (ch == '(') {
            result = dfsMemoized(s, index + 1, balance + 1);

        } else if (ch == ')') {
            result = dfsMemoized(s, index + 1, balance - 1);

        } else {
            result =
                    dfsMemoized(s, index + 1, balance + 1) ||  // '('
                            dfsMemoized(s, index + 1, balance - 1) ||  // ')'
                            dfsMemoized(s, index + 1, balance);       // ""
        }

        memo.put(key, result);
        return result;
    }


    private boolean dfsClean(String s, int index, int balance) {// 3 ^ n time complexity, n is the length of the string, because for each character we have 3 choices: '(', ')' or '*', and we can have at most n characters in the string.

        // Invalid branch
        if (balance < 0) {//Balance < 0 means we have more closing brackets than opening brackets,
            // which is not recoverable and cannot lead to a valid string. So we can prune this branch of the search tree.
            return false;
        }

        // Reached the end
        if (index == s.length()) {
            return balance == 0;//Balance == 0 means we have matched all opening and closing brackets,
            // which is a valid string. So we return true if balance is 0, otherwise false.
        }

        char ch = s.charAt(index);

        if (ch == '(') {

            // '(' increases balance
            return dfsClean(s, index + 1, balance + 1);

        } else if (ch == ')') {

            // ')' decreases balance
            return dfsClean(s, index + 1, balance - 1);

        } else {

            // '*' has 3 possible decisions

            // Decision 1: '*' -> '('
            if (dfsClean(s, index + 1, balance + 1)) {
                return true;
            }

            // Decision 2: '*' -> ')'
            if (dfsClean(s, index + 1, balance - 1)) {
                return true;
            }

            // Decision 3: '*' -> ''
            if (dfsClean(s, index + 1, balance)) {
                return true;
            }

            return false;
        }
    }


    private boolean dfs1(String s, int index, int balance) {

        // Invalid branch
        if (balance < 0) {//Balance < 0 means we have more closing brackets than opening brackets,
            // which is not recoverable and cannot lead to a valid string. So we can prune this branch of the search tree.
            return false;
        }

        // Reached the end
        if (index == s.length()) {
            return balance == 0;//Balance == 0 means we have matched all opening and closing brackets,
            // which is a valid string. So we return true if balance is 0, otherwise false.
        }

        char ch = s.charAt(index);

        if (ch == '(') {
            return dfs1(s, index + 1, balance + 1);
        }

        if (ch == ')') {
            return dfs1(s, index + 1, balance - 1);
        }

        // '*' has 3 choices

        // 1. '*' -> '('
        boolean asOpen = dfs1(s, index + 1, balance + 1);

        // 2. '*' -> ')'
        boolean asClose = dfs1(s, index + 1, balance - 1);

        // 3. '*' -> ""
        boolean asEmpty = dfs1(s, index + 1, balance);

        return asOpen || asClose || asEmpty;
    }
}
