package com.dsa.leetcode.arrays_numbers;

import com.dsa.util.ArrayUtil;

import java.util.Arrays;

public class _75SortColors_DutchNationalFlagAlgo_M {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums1 = {2, 0, 2, 1, 1, 0};
//        Arrays.sort(nums);//brute
        sortUsingCountingSort(nums);
        System.out.println(Arrays.toString(nums));

        sortUsingDutchNationalFlagAlgoSinglePass(nums1);
        System.out.println(Arrays.toString(nums1));


    }

    private static void sortUsingCountingSort(int[] nums) {
        int noOfZeros = 0, noOfOnes = 0, noOfTwos = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    noOfZeros++;
                    break;
                case 1:
                    noOfOnes++;
                    break;
                case 2:
                    noOfTwos++;
                    break;
            }
        }

        int i = 0;
        for (int j = 1; j <= noOfZeros; j++) {
            nums[i++] = 0;
        }

        for (int j = 1; j <= noOfOnes; j++) {
            nums[i++] = 1;
        }

        for (int j = 1; j <= noOfTwos; j++) {
            nums[i++] = 2;
        }
    }

    /*
        Dutch National Flag (DNF) - It is a programming problem proposed by Edsger Dijkstra.
        The flag of the Netherlands consists of three colors: white, red, and blue.
        The task is to randomly arrange balls of white, red, and blue in such a way that balls of the same color are placed together.
        For DNF (Dutch National Flag), we sort an array of 0, 1, and 2's in linear time that does not consume any extra space.
    */
    private static void sortUsingDutchNationalFlagAlgoSinglePass(int[] nums) {

//        Initially we take three variables l,m,h
//        l,m=0 th index h - a.len-1 index
//        This algo starts wih a belief on two statements
//        1. After sorting all the element left to l (0 -> till l-1)will be 0
//        2. All the element right to h (from h+1 -> len -1) will be 1


        int l = 0, m = 0, h = nums.length - 1;
        while (m <= h) {
            switch (nums[m]) {
                case 0: {
                    ArrayUtil.swap(nums, m, l);
                    m++;
                    l++;//At the end l will be at starting of 1 sequence
                    break;
                }
                case 1: {
                    m++;//m will walk over all the ones
                    break;
                }
                case 2: {
                    ArrayUtil.swap(nums, m, h);
                    h--;//At the end h will be at last of 1 series
                    break;//*** here we are not incrementing m as h might hold 0 which needs to be again processed as case 0
                }
            }
        }

    }


}
