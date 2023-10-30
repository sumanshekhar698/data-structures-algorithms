package com.dsa.leetcode.arrays_numbers;

public class _268MissingNumber {

    public static void main(String[] args) {

        int[] arr = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int i = new Solution().missingNumber(arr);
        System.out.println(i);

    }

    static class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int totalSumTillN = n * (n + 1) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum = sum + nums[i];
            }
            return totalSumTillN - sum;
        }

        public int missingNumberUsingXOR(int[] nums) {
            int x = 0;

            for (int i = 0; i <= nums.length; i++) {
                x ^= i;

            }

            for (int i = 0; i < nums.length; i++) {
                x = x ^ nums[i];
            }
            return x;
        }
    }
}
