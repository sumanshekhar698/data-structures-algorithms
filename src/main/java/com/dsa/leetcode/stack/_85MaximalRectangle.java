package com.dsa.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class _85MaximalRectangle {

    public static void main(String[] args) {

        char[][] matrix = {
                {'1', '0', '1', '0', '0' },
                {'1', '0', '1', '1', '1' },
                {'1', '1', '1', '1', '1' },
                {'1', '0', '0', '1', '0' }};

        char[][] matrix2 = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}};

        System.out.println(maximalRectangle(matrix));

    }

    static public int maximalRectangle(char[][] matrix) {

        int max = 0;

        int[][] intMatrix = new int[matrix.length][matrix[0].length];

        //Creating a temp 2D array starting with the 1st row only
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == '1')
                intMatrix[0][j] = 1;
        }


        //now rewriting the intMatrix such that each row is histogram data of the previous row
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == '0') {
                    continue;
                } else if (intMatrix[i - 1][j] != 0)
                    intMatrix[i][j] = (1 + intMatrix[i - 1][j]);
                else
                    intMatrix[i][j] = 1;
            }
        }

        //Area Maximization using Histogram question
        for (int i = 0; i < intMatrix.length; i++) {
//            System.out.println(Arrays.toString(intMatrix[i]));
            max = Integer.max(max, largestRectangleArea(intMatrix[i]));
        }


        return max;

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
        int index, val;//index is the index from where the area can be calculated, and it can also go in reverse direction

        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}

