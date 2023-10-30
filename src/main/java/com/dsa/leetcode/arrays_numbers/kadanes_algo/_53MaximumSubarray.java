package com.dsa.leetcode.arrays_numbers.kadanes_algo;

public class _53MaximumSubarray {


    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    }

    public int maxSubArray(int[] nums) {

        int sum = nums[0];//will have atleast one element
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = Integer.max(nums[i], sum + nums[i]);// max of current element + previous max + current element
            max = Integer.max(sum, max);

        }
        return max;

    }
}
