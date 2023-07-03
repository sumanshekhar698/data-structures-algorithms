package com.dsa.leetcode.matrix;

import java.util.HashMap;

public class _2352EqualRowAndColumnPairs {
//https://leetcode.com/problems/equal-row-and-column-pairs/

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        };
        System.out.println(solution.equalPairs(matrix));
    }

    static class Solution {
        public int equalPairs(int[][] grid) {
            //O(n^2) time
            //O(n) space
            HashMap<String, Integer> record = new HashMap<>();//it will store the rows with its frequency

            int rows = grid.length;
            String temp = "";

            for (int i = 0; i < rows; i++) {//storing all the rows in our record in a string format num1_num2_ ..
                temp = "";
                for (int j = 0; j < rows; j++) {
                    temp += grid[i][j] + "_";
                }
                record.put(temp, record.getOrDefault(temp, 0) + 1);//if key already existing update the value by 1 else initialize the value of 1
            }

            int count = 0;
            for (int i = 0; i < rows; i++) {
                temp = "";
                for (int j = 0; j < rows; j++) {
                    temp += grid[j][i] + "_";
                }
                if (record.containsKey(temp)) {//checking num of intersections with rows and columns
                    count += record.get(temp);
                }
            }

            return count;


        }
    }
}
