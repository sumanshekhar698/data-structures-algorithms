package com.dsa.leetcode.arrays_numbers;

public class _153FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(arr));

    }

    static public int findMin(int[] nums) {

        //        Time O(n) = n
        //        Space O(n) = 1
        
        if (nums.length == 1)
            return nums[0];

        int min = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (!(nums[i + 1] > nums[i])) {
                return nums[i + 1];
            }
        }

        return min;

    }
}
