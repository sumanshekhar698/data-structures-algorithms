package com.dsa.leetcode.arrays_numbers.binary_search;

public class GFG_CountTheNumberOf1sInABinarySortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 0, 0, 0};
        System.out.println(countOnes(nums));

    }

    private static int countOnes(int[] nums) {

        int i = 0;
        int j = nums.length - 1;
        int target = 1;


        while (i <= j) {
//            int mid = (i + j) / 2;
            int mid = i + (j - i) / 2;//to avoid integer overflow
            if (target == nums[mid]) {
                int start = mid;
                int end = mid;

//                while (start >= 0 && nums[start] == target) {//boundary condition and till target is found
//                    start--;
//                }
                while (end < nums.length && nums[end] == target) {////boundary condition and till target is found
                    end++;//end will be nums.length if target is not found
                }
                return end;// as this will

            } else if (nums[mid] < target)
                i = mid + 1;
            else
                j = mid - 1;
        }

        return -1;
    }
}
