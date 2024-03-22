package com.dsa.leetcode.arrays_numbers;

import java.util.Arrays;

public class _561ArrayPartition {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);//min to max to mak the maxsum highest
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += Integer.min(nums[i], nums[i + 1]);
        }

        return sum;

    }
}
