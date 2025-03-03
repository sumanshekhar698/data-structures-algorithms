package com.dsa.leetcode.arrays_numbers;

import java.util.ArrayList;
import java.util.Arrays;

public class _2161PartitionArrayAccordingToGivenPivot {

    public static void main(String[] args) {

        int[] nums = {-3, 4, 3, 2};
        int[] res = pivotArray(nums, 2);
        System.out.println(Arrays.toString(res));
    }



    static public int[] pivotArray(int[] nums, int pivot) {//Wil not maintain order
        int i = 0, j = nums.length - 1;
        int i2 = 0, j2 = nums.length - 1;
        int[] res = new int[nums.length];
        while (i < nums.length) {
            if (nums[i] < pivot) {
                res[i2++] = nums[i];
            }

            if (nums[j] > pivot) {
                res[j2--] = nums[j];
            }
            i++;
            j--;
        }

        Arrays.fill(res, i2, j2 + 1, pivot);
        return res;
    }

    @Deprecated
    static public int[] pivotArrayWrongOrdered(int[] nums, int pivot) {//Wil not maintain order
        int i = 0, j = nums.length - 1;
        int i2 = 0, j2 = nums.length - 1;
        int[] res = new int[nums.length];
        while (i < j) {
            if (nums[i] < pivot) {
                res[i2++] = nums[i];
            } else if (nums[i] > pivot) {
                res[j2--] = nums[i];
            }

            if (nums[j] > pivot) {
                res[j2--] = nums[j];
            } else if (nums[j] < pivot) {
                res[i2++] = nums[j];
            }
            i++;
            j--;
        }

        Arrays.fill(res, i2, j2 + 1, pivot);
        return res;
    }

    static public int[] pivotArrayBrute(int[] nums, int pivot) {

        ArrayList<Integer> beforePivot = new ArrayList<>();
        ArrayList<Integer> pivots = new ArrayList<>();
        ArrayList<Integer> afterPivot = new ArrayList<>();


        for (int num : nums) {
            if (num < pivot) {
                beforePivot.add(num);
            } else if (num == pivot) {
                pivots.add(num);
            } else {
                afterPivot.add(num);
            }
        }


        int j = 0;
        for (Integer item : beforePivot) {
            nums[j++] = item;
        }
        for (Integer value : pivots) {
            nums[j++] = value;
        }
        for (Integer integer : afterPivot) {
            nums[j++] = integer;
        }


        return nums;

    }
}
