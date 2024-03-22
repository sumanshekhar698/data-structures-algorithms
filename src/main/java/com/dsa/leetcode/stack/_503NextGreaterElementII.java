package com.dsa.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class _503NextGreaterElementII {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};//[2,3,4,-1,4]
        int[] result = nextGreaterElement(nums);
        System.out.println(Arrays.toString(result));

    }


    public static int[] nextGreaterElement(int[] nums) {//monotonic stack
        Stack<Integer> stack = new Stack<Integer>();
        int[] nge = new int[nums.length];
        int n = nums.length;

        for (int i = 2 * n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums[i % n] >= stack.peek())
                stack.pop();// we are popping until we get nge for current nums2[i] until the stack has some value

            // assigning the nge
            nge[i % n] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i % n]);// pushing the current element in the stack
            // stack will always remain in increasing order

        }
        return nge;
    }
}
