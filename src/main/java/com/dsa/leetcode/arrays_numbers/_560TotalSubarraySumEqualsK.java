package com.dsa.leetcode.arrays_numbers;

import java.util.Collections;
import java.util.HashMap;

public class _560TotalSubarraySumEqualsK {

    public static void main(String[] args) {
        int arr[] = {4, 5, 1, 3, 2, 3, 4}, k = 9;
        int ans = subarraySum(arr, k);
        System.out.println(ans);
    }


    static public int subarraySum(int[] nums, int k) {//prefix SUM will bring it to n^2
        int numberOfSubArrays = 0;
        int curSum = 0;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();//prefixSum : Count
        prefixSumMap.put(0, 1);//there is an empty prefix with curSum 0

        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;

            numberOfSubArrays += prefixSumMap.getOrDefault((diff), 0);
            prefixSumMap.put(curSum, prefixSumMap.getOrDefault(curSum, 0) + 1);

        }

        return numberOfSubArrays;



    }
}
