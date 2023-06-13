package com.dsa.leetcode.arrays_numbers;

import java.util.Arrays;
import java.util.HashMap;

public class _169E_MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int result = naiveBruteTimeOptimized(arr);
        System.out.println(result);
    }

    private static int naiveBruteTimeOptimized(int[] arr) {

//        Space : O(n) = n
//        Time : O(n) = n

        if (arr.length == 1)
            return arr[0];
        int freqCap = arr.length / 2;
        HashMap<Integer, Integer> freqTable = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (freqTable.containsKey(arr[i]) && freqTable.get(arr[i]) > freqCap)
                return arr[i];
            freqTable.merge(arr[i], 1, Integer::sum);
        }

        return -1;
    }

    public static int naiveBruteSpaceOptimized(int[] nums) {

        //        Space : O(n) = 1
        //        Time : O(n) = n^2
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }

        return -1;
    }

    public static int naiveUsingSorting(int[] nums) {
        //the answer will be the middle element of the sorted array

        //        Space : O(n) = n (if cloned)
        //        Time : O(n) = nlogn (considering DualPivot QuickSort)
        int[] clone = nums.clone();
        Arrays.sort(clone);
        return clone[clone.length / 2];
    }

    public static int naiveUsingBitManipulation(int[] nums) {

        int n = nums.length;
        //        Space : O(n) = n (if cloned)
        //        Time : O(n) = nlogn (considering DualPivot QuickSort)

        int majorElement = 0;//setting all the bit to 0

        for (int i = 0; i < 32; i++) {//int has 4 bytes and i is the bit position
//            Set Bit check
            int bit = 1 << i;// 1 2 4 8 16 32 64

            // Count how many numbers have this bit set. ths indexing for set starts from 1 and that too from right
            int bit_count = 0;
            for (int num : nums) {
                if ((num & bit) != 0) {//check if the bit is set(1) or not
                    bit_count++;
                }
            }

            if (bit_count > n / 2) {
//                majorElement = majorElement + (1 << i);
                majorElement |= bit;//bitwise addition
            }

        }

//        can also do a verification by calculating the frequency of the majorElement to be sure cause
//        if there are no majorElement this will just give a candidate element
        return majorElement;
    }

    public static int optimizedUsingMVA(int[] nums) {
//        Boyer-Moore Voting Algorithm

        //        Space : O(1)
        //        Time : O(n)
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
