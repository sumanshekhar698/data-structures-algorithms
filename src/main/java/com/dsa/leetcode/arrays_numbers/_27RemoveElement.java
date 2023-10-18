package com.dsa.leetcode.arrays_numbers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _27RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = new Solution().removeElementOptimized(nums, 2);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public int removeElementOptimized(int[] nums, int val) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[count] = nums[i];
                    count++;
                }
            }
            System.out.println(count);
            return count;
        }

      

}

}

