package com.dsa.leetcode.dp;

import java.util.Arrays;

public class _518CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int variation = coinChange(coins, 5);
//        int[] coins = {2};
//        int min = coinChange(coins, 3);
        System.out.println(variation);

    }

    static public int coinChange(int[] coin, int amount) {
//        coins^amount
        int variation = 0;
        int[] dp = new int[amount + 1];//0->amount
        int[] variations = new int[amount + 1];//0->amount
        Arrays.fill(dp, Integer.MAX_VALUE - 1);//default values Integer.MAX_VALUE - 1 {-1 to prevent Integer rotation once we add a number to it}
//        Arrays.fill(dp, amount +1);//or simple take amount +1
        dp[0] = 0;//BASE Case
        variations[0] = 0;//BASE Case

//       O Time : O(amount*len(coins))
//       O Space : O(amount)
        for (int i = 1; i <= amount; i++) {
            for (int coinValue : coin) {
                if (i - coinValue >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coinValue]);//means min(current coins, 1 coin+dp[amount - currentCoinValue])
                }//if a coin array is sorted, we can use break here to further optimize
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];

    }
}
