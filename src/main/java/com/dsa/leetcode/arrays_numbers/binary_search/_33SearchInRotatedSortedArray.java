package com.dsa.leetcode.arrays_numbers.binary_search;

public class _33SearchInRotatedSortedArray {

    public static void main(String[] args) {

        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(arr, 0));

    }

    static public int search(int[] nums, int target) {

//        If an array is rotated, it wil have 2 sorted parts

//        0,1,2     4,5,6,7
//        4, 5, 6, 7,     0, 1, 2
//     LSP 4 5 6 7     RSP 0 1 2

        int i = 0, j = nums.length - 1, mid;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == target)
                return mid;

//            Thing in terms of 1st iteration
            if (nums[mid] >= nums[i]) {//LSP
                if (target > nums[mid] || target < nums[i]) {//2 cases for Search the Right portion
                    i = mid + 1;
                } else {//Search the Left portion
                    j = mid - 1;
                }
            } else {//RSP
                if (target < nums[mid] || (target > nums[mid] && target > nums[j])) {//Search the Left portion
                    j = mid - 1;
                } else {//it means the target is > nums[mid[ BUT smaller than nums[j]
                    i = mid + 1;
                }
            }
        }

        return -1;


    }
}
