package com.dsa.leetcode.arrays_numbers.binary_search;

public class _162FindPeakElement {

    public static void main(String[] args) {
        int nums[] = {1, 2, 1, 3, 5, 6, 4};
        int peak = findPeakElement(nums);
        System.out.println(peak);

    }

    static public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;//to avoid integer overflow

            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))
                return mid;

            if (nums[mid] > nums[mid + 1])//if mid is greater than mid+1 then peak will be in left side
                high = mid;
            else
                low = mid + 1;
        }

        return 0;//for the case if the array is having only one element


    }

    public int findPeakElementUsingBinarySimpleBinarySearch(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            else if (nums[mid] > nums[mid - 1]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }


    static public int findPeakElementBrute(int[] nums) {

        if (nums.length >= 2 && nums[0] > nums[1])
            return 0;
        else if (nums.length >= 2 && nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;


        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i == nums.length - 1)
                continue;
            else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        }

        return 0;

    }
}
