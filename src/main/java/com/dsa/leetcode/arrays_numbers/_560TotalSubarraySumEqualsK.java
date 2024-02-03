package com.dsa.leetcode.arrays_numbers;

import java.util.Collections;
import java.util.HashMap;

public class _560TotalSubarraySumEqualsK {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3}, k = 3;
        int ans = subarraySum(arr, k);
        System.out.println(ans);
    }


    static public int subarraySum(int[] nums, int k) {//prefix SUM will bring it to n^2

        int numberOfSubArrays = 0;
        int curSum = 0;
        HashMap<Integer, Integer> prefixesMap = new HashMap<>();//prefixSum : Count
        prefixesMap.put(0, 1);//there is an empty prefix with curSum 0

        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;

                numberOfSubArrays += prefixesMap.getOrDefault((diff),0);
                prefixesMap.put(curSum, prefixesMap.getOrDefault(curSum, 0) + 1);

        }

        return numberOfSubArrays;

//        Collections.sort()

    }
}
