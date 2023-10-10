package com.dsa.leetcode.arrays_numbers;

import java.sql.SQLOutput;
import java.util.Arrays;

public class _88MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

//        {1, 2, 3, 0, 0, 0};
//        {2, 5, 6};
//
//        {2, 2, 3, 0, 0, 0};
//        {1, 5, 6};

//        int i = 0, j = 0;
//        while (i < m && j < n) {
//            if (nums1[i] <= nums2[j]) {
//                ++i;//no change as its already in descending order
//            } else {
//                int temp = nums1[i];
//                nums1[i] = nums2[j];
//                nums2[j] = temp;
//                i++;
//            }
//        }
//
//        if (i == m) {
//            while (i < nums1.length) {
//                nums1[i++] = nums2[j++];
//            }
//        }

//        we will start adding from the back
        int i = m - 1, j = n - 1;
        int k = nums1.length - 1;//at teh last of nums1 array from where we will start filling it

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {

                nums1[k] = nums1[i];
                --i;
            } else {
                nums1[k] = nums2[j];
                --j;
            }

            --k;

        }

        while (j >= 0) {//filling all the elements left in nums2
            nums1[k] = nums2[j];
            --j;
            --k;
        }


    }

    public static void mergeWithExtraSapce(int[] nums1, int m, int[] nums2, int n) {

//        {1, 2, 3, 0, 0, 0};
//        {2, 5, 6};

        int i = 0, j = 0;
        int k = 0;
        int[] result = new int[m + n];//as m consists of the total merged length
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];

            } else {
                result[k++] = nums2[j++];
            }
        }

        if (i == m) {//adding the rest elements
            while (k < result.length) {
                result[k++] = nums2[j++];
            }

        } else if (j == n) {
            while (k < result.length) {
                result[k++] = nums1[i++];
            }

        }

//        System.out.println(Arrays.toString(result));
    }
}
