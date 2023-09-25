package com.dsa.leetcode.stack;

import java.util.Stack;

public class _20ValidParentheses {

    public static void main(String[] args) {

    }

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(' || ch == '{' || ch == '[')
                    stack.push(ch);// push every opening bracket to the stack
                else {
                    if (stack.isEmpty())
                        return false;// for a closing bracket if the stack is empty return unbalanced
                    char top = stack.pop();
                    if ((top == '(' && ch == ')') || (top == '[' && ch == ']') || (top == '{' && ch == '}'))// matching ossible correct pairs
                        continue;
                    else
                        return false;
                }
            }

            return stack.isEmpty();// if yes : balanced else unbalanced
        }
    }
}
