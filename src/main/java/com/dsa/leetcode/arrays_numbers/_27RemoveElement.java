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

        public int removeElementWRONG(int[] nums, int val) {

            int counter = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    ++counter;
                    nums[i] = -1;
                }

            }


            int ans = counter;


            for (int i = 0; i < nums.length; ) {
                if (nums[i] == -1 && i != nums.length - 1) {
                    int j = i;
                    while (j < nums.length - 1) {
                        nums[j] = nums[j + 1];
                        nums[j + 1] = -1;
                        ++j;
                    }
                }
                if (nums[i] == -1 && i < nums.length - counter) {
                    continue;
                }
                i++;
            }

            return ans;
        }
    }

}

