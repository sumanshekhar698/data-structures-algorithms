package com.dsa.leetcode.arrays_numbers.binary_search;

public class _2529_E_MaximumCountOfPositiveIntegerAndNegativeInteger {


    public static void main(String[] args) {
        int[] nums1 = {-3, -2, -1, 0, 0, 1, 2};
        int[] nums2 = {-2, -1, -1, 1, 2, 3};
        int[] nums3 = {-2, -1, -1, 0, 0, 0};
        System.out.println(maximumCount(nums3));
    }

    static public int maximumCount(int[] nums) {

        int i = 0, j = nums.length - 1;


//        Edge Cases
        if (nums.length == 0) {// 0 length array
            return 0;
        } else if (nums[0] > 0 || nums[j] < 0) {// all the elements are either positive or negative
            return nums.length;
        } else if (nums[0] == 0 && nums[j] == 0) {// all the elements are 0
            return 0;
        }

        int flippingIndex = nums.length - 1;// flippingIndex is the point where the first positive index starts
//        we are assuming it's the last index which will help in 2nd for loop to get to the last negative integer if it is


//        Binary Search
        while (i <= j) {
            int mid = (i + j) / 2;

            if (mid - 1 < nums.length && (nums[mid] > 0 && nums[mid - 1] <= 0)) {// checking is mid is the flippingIndex
                flippingIndex = mid;
                break;// breaking the loop if we have found the flippingIndex
            } else if (nums[mid] > 0) {//decreasing j to mid - 1 in a hope that the flippingIndex is towards left
                j = mid - 1;
            } else if (nums[mid] <= 0) {//increasing i to mid + 1 in a hope that the flippingIndex is towards right
                i = mid + 1;
            }
        }

        int positiveStartingIndex = flippingIndex;
        int findingLastNegativeIndex = flippingIndex;
        while (findingLastNegativeIndex >= 0 && nums[findingLastNegativeIndex] >= 0) {//this loop skips all the zeroes
            // to ensure that findingLastNegativeIndex is the last negative integer if there is
            findingLastNegativeIndex--;
        }

        return Math.max(findingLastNegativeIndex + 1, nums.length - positiveStartingIndex);//return max count of (negative integers, positive integers)
    }


    public int maximumCount2ndVar(int[] nums) {
        int endNegative = binarySearch(nums, 0), startPositive = binarySearch(nums, 1);
        System.gc();
        return Math.max(endNegative, (nums.length - startPositive));
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
