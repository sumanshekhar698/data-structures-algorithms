package com.dsa.leetcode.stack;

import java.util.ArrayList;
import java.util.Stack;

public class _155MinStack {

    public static void main(String[] args) {

    }

    static class MinStack {


        Stack<Pair> stack;

        public MinStack() {
            this.stack = new Stack<>();

        }

        public void push(int val) {


            if (stack.isEmpty())
                stack.add(new Pair(val, val));
            else {
                int min = stack.peek().min;
                if (val < min) {
                    stack.add(new Pair(val, val));
                } else {
                    stack.add(new Pair(val, min));

                }
            }


        }

        public void pop() {

            if (!this.stack.empty())
                stack.pop();

        }

        public int top() {
            if (!this.stack.isEmpty())
                return this.stack.peek().value;
            return -1;
        }

        public int getMin() {
            if (!this.stack.isEmpty())
                return this.stack.peek().min;
            return -1;

        }

        class Pair {
            int value;
            int min;

            public Pair(int value, int min) {
                this.value = value;
                this.min = min;
            }
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
