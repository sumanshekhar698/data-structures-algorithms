package com.dsa.leetcode.arrays_numbers;

public class _53MaximumSubarray_Kanadanes_M {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int i = maxSubArrayBrute(nums);
        System.out.println(i);

        i = maxSubArrayOptimizedUsingKadanes(nums);
        System.out.println(i);


    }

    static public int maxSubArrayBrute(int[] nums) {
//        O(n^2) time
//        O(1) space
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                result = Integer.max(sum, result);
            }
        }
        return result;
    }


    static public int maxSubArrayOptimizedUsingKadanes(int[] nums) {
//        O(n) time
//        O(1) space
//        https://www.youtube.com/watch?v=86CQq3pKSUw&t=2s
        int sum = nums[0];//will have least one element
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = Integer.max(nums[i], sum + nums[i]);// max of current element + previous max + current elemment
            max = Integer.max(sum, max);
        }
        return max;
    }
}
