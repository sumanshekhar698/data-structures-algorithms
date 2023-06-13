package com.dsa.leetcode.arrays_numbers;

import java.util.Arrays;

public class _31NextPermutation_M {

    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 4, 2};
        int[] arr1_1 = {1, 3, 5, 4, 2};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {5, 4, 3, 2, 1};
        int[] arr4 = {5, 4, 3, 2, 1};

        nextPermutation(arr1_1);
        System.out.println(Arrays.toString(arr1_1));

        nextPermutation(arr1);
        System.out.println(Arrays.toString(arr1));


    }

    public static void nextPermutation(int[] nums) {
//        O(3n) ~ O(n) time
//        O(1) space

        if (nums == null || nums.length == 1)
            return;

        int index1 = -1, index2 = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index1 = i - 1;
//                System.out.println(nums[index1]);
                break;
            }
        }

        if (index1 != -1)
            for (int i = nums.length - 1; i > index1; i--) {
                if (nums[i] > nums[index1]) {
                    index2 = i;
//                System.out.println(nums[index2]);
                    break;
                }
            }

//        System.out.println(index1 + "  | " + index2);
        if (index1 != -1)
            swap(nums, index1, index2);

        if (index1 != -1)
            reverse(nums, index1 + 1, nums.length - 1);
        else
            reverse(nums, 0, nums.length - 1);


    }


    public static void nextPermutationUsingWhileLoop(int[] nums) {
//        O(3n) ~ O(n) time
//        O(1) space
        if (nums == null || nums.length == 1)
            return;

        int index1 = nums.length - 2;
        while (index1 >= 0 && nums[index1] >= nums[index1 + 1])
            index1--;//for index1 ; if there is no break point index1 will be negative
        if (index1 >= 0) {//if you have a break point
            int index2 = nums.length - 2;
            while (nums[index2] <= nums[index1]) index2--;
            swap(nums, index1, index2);
        }

        reverse(nums, index1 + 1, nums.length - 1);//reverse it [if no breakpoint the starr will be -1 +1 = 0
        // else it will be right mountain edge

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
