package com.dsa.leetcode.arrays_numbers.kadanes_algo;

import java.util.Arrays;
import java.util.OptionalInt;

public class _2419LongestSubarrayWithMaximumBitwiseAND {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3, 2, 2};
        System.out.println(longestSubarrayUsingProperty(arr));

    }



    /* & property
     * x&x  = x
     * a&b = c where a >b :: c < a
     * */

    static public int longestSubarrayUsingProperty(int[] nums) {

        int target = Arrays.stream(nums).max().getAsInt(), res = 0, size = 0;

        for (int num : nums) {
            if (num == target) {
                size += 1;
            } else {
                size = 0;
            }
            res = Math.max(res, size);
        }

        return res;

    }


    static public int longestSubarrayUsingProperty2(int[] nums) {

        int res = 0, size = 0, currMax = 0;

        for (int num : nums) {
            if (num > currMax) {
                currMax = num;
                size = 1;
            }

        }

        return res;

    }
}
