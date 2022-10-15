package com.dsa.leetcode.arrays_numbers;

public class _121BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
//        you can buy and sell only once
        int[] nums = {7, 1, 5, 3, 6, 4};
        int profit = maxProfitNaive(nums);
        System.out.println(profit);
        profit = maxProfitOptimized(nums);
        System.out.println(profit);
    }

    private static int maxProfitNaive(int[] nums) {
//        O(n^2) time ;
        int maxProfit = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                maxProfit = Integer.max(nums[j] - nums[i], maxProfit);
            }
        }
        return maxProfit;
    }


    private static int maxProfitOptimized(int[] nums) {
//        O(n) time ;

        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Integer.min(min, nums[i]);
            maxProfit = Integer.max(maxProfit, nums[i] - min);
        }
        return maxProfit;
    }
}
