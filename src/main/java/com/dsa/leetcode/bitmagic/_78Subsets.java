package com.dsa.leetcode.bitmagic;

import java.util.ArrayList;
import java.util.List;

public class _78Subsets {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(subsetsOLD(nums));

    }

    public static List<List<Integer>> subsets(int[] nums) {

        return null;

    }


    public static List<List<Integer>> subsetsOLD(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int total = (1 << n);//2^n

        for (int i = 0; i < total; i++) {//Each iteration represents a different subset.
            List<Integer> list = new ArrayList<>();

            for (int bitIdx = 0; bitIdx < n; bitIdx++) {//Each iteration represents a bit position in the binary representation of the current subset.

                int mask = (1 << bitIdx);
                if ((i & mask) != 0) {
                    list.add(nums[bitIdx]);
                }

            }
            ans.add(list);
        }
        return ans;
    }
}


