package com.gfg.arrays;

import java.util.Arrays;


public class _18MaximumSubArrayNoRestriction_KadaneAlgorithm2 {

    public static void main(String[] args) {
        int[] intArr2 = new int[]{1, 2, 3, -2, 5};// {-1,-2,-3,-4}
        int[] intArr = new int[]{2, 3, -8, 7, -1, 2, 3};// 11
        System.out.println(intArr);
        System.out.println("Array -> " + Arrays.toString(intArr));
        int ans = maximumSubArraySumNaive(intArr);// Occurrence
        System.out.println(ans);
        ans = maximumSubArraySumOptimized(intArr);// Occurrence
        System.out.println(ans);
    }

    private static int maximumSubArraySumNaive(int[] intArr) {
        // TODO Auto-generated method stub
        int res = intArr[0];// we are starting our brute force
        for (int i = 0; i < intArr.length; i++) {
            int current = 0;
            for (int j = i; j < intArr.length; j++) {
                current += intArr[j];
                res = Math.max(current, res);
            }
        }
        return res;
    }

    private static int maximumSubArraySumOptimized(int[] intArr) {
        // KANADANE's Algorithm
//		O(n) = n
        int globalMax = intArr[0], currentMax = intArr[0];
        for (int i = 1; i < intArr.length; i++) {
            currentMax = Math.max(intArr[i], currentMax + intArr[i]);
            if (currentMax > globalMax)
                globalMax = currentMax;
//			globalMax = Math.max(currentMax, globalMax);
        }
        return globalMax;
    }
}
