package com.dsa.leetcode.stack;

import java.util.ArrayDeque;

public class _84LargestRectangleInHistogram {

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3};//10
        int arr2[] = {4, 2, 0, 3, 2, 4, 3, 4};//10
        int ans = largestRectangleArea(arr2);
        System.out.println(ans);

    }

    static public int largestRectangleArea(int[] heights) {

//            O(n) time = n
//            O(n) space = n
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        int maxArea = 0;


        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && heights[i] < stack.peekLast().val) {
                Pair pop = stack.pollLast();
                maxArea = Integer.max(maxArea, pop.val * (i - pop.index));
                start = pop.index;//since we know that the current element is smaller than a popped element, we can extend out start little backward to the popped index
            }
            stack.add(new Pair(start, heights[i]));

        }


        //Some elements might remain in the stack, and they can be extended till the end
        while (!stack.isEmpty()) {
            Pair pop = stack.pollLast();
            maxArea = Integer.max(maxArea, pop.val * (heights.length - pop.index));//because this element will be extended till the end

        }

        return maxArea;
    }

    static class Pair {
        int index, val;//index is the index from where the area can be calculated and itcan also go in reverse direction

        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}
