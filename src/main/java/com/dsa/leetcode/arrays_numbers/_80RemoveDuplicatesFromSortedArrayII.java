package com.dsa.leetcode.arrays_numbers;

import java.util.Arrays;

public class _80RemoveDuplicatesFromSortedArrayII {
    //    https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int x = removeDuplicates(nums);
        System.out.println(x);
        System.out.println(Arrays.toString(nums));


    }

    public static int removeDuplicates(int[] nums) {

//        We will use a token system here as each number will have max 2 token to use
//        Time O(n) = n
//        Space O(n) = 1
        int previous = nums[0];
        int counter = 1, token = 1;//counter =1, token =1 as we have already considered 1st element, so it exhausts one token

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == previous) {
                if (token > 0) {//this will ensure all the repetitive elements higher ocuring mopre than twice will be skipped
                    nums[counter++] = nums[i];
                    previous = nums[i];
                    --token;
                }
            } else {
                token = 1;//exhausted one token so 2-1 =1
                nums[counter++] = nums[i];
                previous = nums[i];
            }
        }
        return counter;

    }
}
