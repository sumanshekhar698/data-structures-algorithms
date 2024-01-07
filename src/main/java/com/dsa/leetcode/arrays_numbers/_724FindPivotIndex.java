package com.dsa.leetcode.arrays_numbers;

public class _724FindPivotIndex {

    public static void main(String[] args) {


    }


    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum -= nums[i];
            if (leftSum == totalSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public int pivotIndexUsingPrefixArray(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];  // Include an extra element for convenience

        // Calculate prefix sums (note: prefixSum[0] = 0)
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // Find the pivot index
        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == prefixSum[n] - prefixSum[i + 1]) {  // Right sum = totalSum - leftSum
                return i;
            }
        }

        return -1;
    }


}
