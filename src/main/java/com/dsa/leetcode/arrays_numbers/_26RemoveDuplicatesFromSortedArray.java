package com.dsa.leetcode.arrays_numbers;

import java.util.Arrays;

public class _26RemoveDuplicatesFromSortedArray {
    //    https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};//sorted array
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));

    }

    static public int removeDuplicates(int[] nums) {
//        if (nums.length == 0) //commented this line as the question says there will be ATLEAST one element
//            return 0;

//        Time O(n) = n
//        Space O(n) = 1
        int counter = 1;//as a single element is always unique and hence the answer will be 1
        int previous = nums[0];//storing the 1st element in the previous

        for (int i = 1; i < nums.length; i++) {
            if (previous != nums[i]) {
                nums[counter++] = nums[i];
                previous = nums[i];
            }
        }
        return counter;
    }

}
