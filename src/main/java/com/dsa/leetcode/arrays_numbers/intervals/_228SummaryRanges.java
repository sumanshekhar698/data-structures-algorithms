package com.dsa.leetcode.arrays_numbers.intervals;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class _228SummaryRanges {


    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 4, 5, 7};
        List<String> ranges = summaryRanges(arr);
        System.out.println(ranges);

    }

    static public List<String> summaryRanges(int[] nums) {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            int end = start;

            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                end = nums[++i];
            }
            if (start == end)
                list.add("" + start);
            else
                list.add("" + start + "->" + end);


        }

        return list;

    }
}
