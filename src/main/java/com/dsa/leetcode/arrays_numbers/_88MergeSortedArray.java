package com.dsa.leetcode.arrays_numbers;

import java.sql.SQLOutput;
import java.util.Arrays;

public class _88MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0;

        int larger = (m > n) ? m : n;

        int k =0;
        int [] result = new int[m];
        while(i<=m && j<=n){
            if (nums1[i] >= nums2[j]){
                result[k++]=nums1[i];
                ++i;
            }
            else{
                result[k++]=nums1[j];
                ++j;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
