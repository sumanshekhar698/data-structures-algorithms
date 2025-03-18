package com.dsa.leetcode.bitmagic;

public class _2401LongestNiceSubarray {

    public static void main(String[] args) {

    }

    public int longestNiceSubarray(int[] nums) {

        int maxWindowSize = 0;
        int currentSum = 0, xorSum = 0;
        int i = 0, j = 0;

//        while (i < nums.length && j < nums.length) {
        while (j < nums.length) {
            currentSum += nums[j];
            xorSum ^= nums[j];

            while (xorSum != currentSum) {//window shrinking logic
                //if Xor Sum == Current Sum :: the numbers doesn't have a set bit have set a bit at the same position ::
                currentSum -= nums[i];
                xorSum ^= nums[i];//xoring again to remove the nums[i] impact :: x^x = 0
                ++i;
            }

            maxWindowSize = Math.max(maxWindowSize, j - i + 1);
            j++;
        }

        return maxWindowSize;
    }
}
