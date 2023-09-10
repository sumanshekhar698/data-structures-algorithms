package com.dsa.leetcode.arrays_numbers.binary_search;

public class _704BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 2));

    }

    static public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;


        while (i <= j) {
            int mid = (i + j) / 2;
            if (target == nums[mid])
                return mid;
            else if (nums[mid] < target)
                i = mid + 1;
            else
                j = mid - 1;
        }

        return -1;
    }
}
