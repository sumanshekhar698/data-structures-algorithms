package com.dsa.leetcode.arrays_numbers.sorting;

import java.util.Arrays;
import java.util.HashMap;

class _1547MinimumCostCutAStick {


    public int minCostRecursive(int n, int[] cuts) {

//        Arrays.sort(cuts);// IF THE CUTS ARE NOT SORTED
        int[][] dp = new int[n + 1][n + 1];//i, j :: left, right cache

        HashMap<String, Integer> cacheMap = new HashMap<>();
//        return dfs(0, n, cuts, dp);
        return dfs(0, n, cuts, cacheMap);

    }

    int dfs(int left, int right, int[] cuts, HashMap<String, Integer> dp) {

//        if (left == right) // no need to cut further as there is only one stick

        if (right - left == 1) // no need to cut further as there are only two sticks
            return 0;

        String key = left + "," + right;
        if (dp.containsKey(key)) return dp.get(key);//using cache to avoid recomputation

        int minCost = Integer.MAX_VALUE;
        for (int slice : cuts) {
            if (slice > left && slice < right) {
                int cost = (right - left) + dfs(left, slice, cuts, dp) + dfs(slice, right, cuts, dp);
                minCost = Math.min(minCost, cost);
            }
        }

        int minCostChecked = minCost == Integer.MAX_VALUE ? 0 : minCost;
        dp.put(key, minCostChecked);
        return minCostChecked;
    }

    private int cost(int i, int j, int[] arr, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int len = arr[j + 1] - arr[i - 1];
            int totalCost = cost(i, k - 1, arr, dp) + cost(k + 1, j, arr, dp) + len;
            min = Math.min(min, totalCost);
        }
        return dp[i][j] = min;
    }

    public int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length + 2];
        int i;
        for (i = 0; i < cuts.length; i++) {
            arr[i] = cuts[i];
        }
        arr[i++] = 0;
        arr[i] = n;
        Arrays.sort(arr);
        int m = cuts.length;
        int[][] dp = new int[m - 1][m - 1];
        for (i = 0; i < m - 1; i++)
            for (int j = 0; j < m - 1; j++)
                dp[i][j] = -1;
        return cost(1, arr.length - 2, arr, dp);
    }
}