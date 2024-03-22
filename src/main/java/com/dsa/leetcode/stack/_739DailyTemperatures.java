package com.dsa.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class _739DailyTemperatures {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};//[2,3,4,-1,4]
        int[] num2 = {73, 74, 75, 71, 69, 72, 76, 73};//[1,1,4,2,1,1,0,0]
        int[] result = dailyTemperatures(num2);
        System.out.println(Arrays.toString(result));
    }


    public static int[] dailyTemperatures(int[] temperatures) {//monotonic stack
        Stack<Pair> stack = new Stack<>();
        int[] nge = new int[temperatures.length];
        int n = temperatures.length;

        for (int i = n - 1; i >= 0; i--) {//not using circular logic as we dont have to see in past

            while (!stack.isEmpty() && temperatures[i % n] >= stack.peek().temperature)
                stack.pop();// we are popping until we get nge for current nums2[i] until the stack has some value

            // assigning the nge
            nge[i % n] = stack.isEmpty() ? 0 : stack.peek().index - (i % n);//ngl index - current index = days

            stack.push(new Pair(i % n, temperatures[i % n]));// pushing the current element in the stack
            // stack will always remain in increasing order

        }
        return nge;
    }

    static class Pair {//instead of Pair we can also us index in the stack instead of the element value
        int index;
        int temperature;

        public Pair(int index, int temperature) {
            this.index = index;
            this.temperature = temperature;
        }
    }
}
