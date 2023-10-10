package com.dsa.leetcode.hashing;

import java.util.HashMap;

public class _01TwoSum {

    public static void main(String[] args) {

        int[] nums = {3, 5, 1, 4, -8};
        int target = 5;
        int[] result = twoSumBrute(nums, target);
        System.out.println(result[0] + " " + result[1]);

        result = twoSumLinearTime(nums, target);
        System.out.println(result[0] + " " + result[1]);

    }

    private static int[] twoSumLinearTime(int[] nums, int target) {
        //        Time : O(n) | Space : O(1)
        int[] result = new int[2];//<Index1, Index2>
        HashMap<Integer, Integer> memory = new HashMap<>();//<Value : Index >

        int current;
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];
            if (memory.containsKey(target - current)) {
                result[0] = i;
                result[1] = memory.get(target - current);
                return result;
            } else {
                memory.put(current, i);

            }
        }
        return result;
    }

    private static int[] twoSumBrute(int[] nums, int target) {
//        Time : O(n^2) | Space : O(1)

        int[] result = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
