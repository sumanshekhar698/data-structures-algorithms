package com.dsa.leetcode.arrays_numbers;

import java.util.Arrays;

public class _122BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        int[] inputPrice_1 = {7, 1, 5, 3, 6, 4};
        int [] inputPrice ={1, 5, 3, 8, 12};
//		A single day price will  not give you any profit
        // A descending array will always give us LOSS So profit = 0
        // A ascending array will always give us PROFIT = final-initial

        System.out.println("Original ==> " + Arrays.toString(inputPrice));
        int profit = maxProfitNaive(inputPrice, 0, inputPrice.length - 1);
        System.out.println("PROFIT ==> " + profit);
        profit = maxProfitOptimizedLinear(inputPrice);
        System.out.println("PROFIT ==> " + profit);
    }

    private static int maxProfitOptimizedLinear(int[] inputPrice) {
        // buy at cheapest and sell at highest
        int profit = 0;
        for (int i = 1; i < inputPrice.length; i++) {
            if (inputPrice[i] > inputPrice[i - 1])
                profit += (inputPrice[i] - inputPrice[i - 1]);
            // ultimately, we will be adding the diff of peak and trough
        }
        return profit;
    }

    private static int maxProfitNaive(int[] inputPrice, int start, int end) {
        // recursive solution
        if (end <= start)
            return 0;
        int profit = 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (inputPrice[j] > inputPrice[i]) {
                    int currentProfit = inputPrice[j] - inputPrice[i] + maxProfitNaive(inputPrice, start, i - 1)
                            + maxProfitNaive(inputPrice, j + 1, end);
                    profit = Integer.max(profit, currentProfit);
                }
            }
        }
        return profit;

    }
}
