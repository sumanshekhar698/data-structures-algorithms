package com.dsa.leetcode.bitmagic;

public class MaxAndValue {

    public static int maxANDValue(int[] arr) {
        int result = 0;

        for (int bit = 31; bit >= 0; bit--) {
            int candidate = result | (1 << bit);
            int count = countWithBitPrefix(arr, candidate);
            if (count >= 2) {
                result = candidate;
            }
        }

        return result;
    }

    private static int countWithBitPrefix(int[] arr, int prefix) {
        int count = 0;
        for (int num : arr) {
            if ((num & prefix) == prefix) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 12, 16};
        System.out.println(maxANDValue(arr));  // Output: 8
    }
}
