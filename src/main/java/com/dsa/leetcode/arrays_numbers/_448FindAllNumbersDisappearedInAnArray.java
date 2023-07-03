package com.dsa.leetcode.arrays_numbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _448FindAllNumbersDisappearedInAnArray {
    //    https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
    public static void main(String[] args) {
        int nums[] = {4, 3, 2, 7, 8, 2, 3, 1};
        new Solution().findDisappearedNumbersOptimized(nums);
    }


    static class Solution {
        public List<Integer> findDisappearedNumbersNice(int[] nums) {
            //O(n) time & space
            //O(n log n) is sorting is used
            HashSet hashSet = new HashSet();
            int n = nums.length;
            for (int num : nums) {
                hashSet.add(num);
            }

            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 1; i <= nums.length; i++) {
                if (!hashSet.contains(i)) {
                    result.add(i);
                }
            }
            return result;
        }

        public List<Integer> findDisappearedNumbersOptimized(int[] nums) {
            //O(n) time & space O(1)

            ArrayList<Integer> result = new ArrayList<>();


            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] > 0)
                    nums[index] *= -1;
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    result.add(i + 1);
                }
            }
            return result;
        }
    }
}
