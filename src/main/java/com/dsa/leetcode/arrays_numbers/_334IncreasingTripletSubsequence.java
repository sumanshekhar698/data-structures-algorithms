package com.dsa.leetcode.arrays_numbers;

public class _334IncreasingTripletSubsequence {

    public static void main(String[] args) {

        int[] nums = {2, 1, 5, 0, 4, 6};

    }

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= first) {
                first = n; // smallest number at any time
            } else if (n <= second) {
                second = n; // at this posn secon smallest
            } else {
                return true; // a number higher than second so found a triplet :)
            }
        }

        return false;
    }
}
