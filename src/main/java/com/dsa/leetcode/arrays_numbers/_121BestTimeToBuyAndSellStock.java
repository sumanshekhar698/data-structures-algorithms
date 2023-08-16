package com.dsa.leetcode.arrays_numbers;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
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
//            Update min to the minimum of min and the current price of the stock.
//            min shows the minimum price till today.
//            This ensures that we are always tracking the lowest price of the stock that we have seen so far.
            min = Integer.min(min, nums[i]);
            //Calculate the potential profit for today, which is the current price of the stock minus [min].

            maxProfit = Integer.max(maxProfit, nums[i] - min);
        }
        return maxProfit;
    }
}
