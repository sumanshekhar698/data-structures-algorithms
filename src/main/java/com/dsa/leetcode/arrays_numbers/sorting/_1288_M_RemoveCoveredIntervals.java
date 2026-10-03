package com.dsa.leetcode.arrays_numbers.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class _1288_M_RemoveCoveredIntervals {

    public static void main(String[] args) {

//        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
//        int[][] intervals = {{1, 2}, {1, 4}, {3, 4}};
        int[][] intervals = {{1, 2}, {1, 4}, {3, 4}, {1, 3}, {2, 3}};
        System.out.println(removeCoveredIntervals(intervals));

    }

    static public int removeCoveredIntervals(int[][] intervals) {
//        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
//        Sort such; like the smallest starting point appears first and then the largest ending point
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//        System.out.println(Arrays.deepToString(intervals));

        // 1st priority: ascending for a[0]
        // 2nd priority: descending for a[1]
        Arrays.sort(intervals, Comparator
                .comparingInt((int[] a) -> a[0])
                .thenComparing((a, b) -> Integer.compare(b[1], a[1]))
        );
        System.out.println(Arrays.deepToString(intervals));


        int count = 0;


//        for (int i = 1; i < intervals.length; i++) {
//            //ERRONEOUS code as a big interval can be a sub interval of a smaller intervals and this code will skip
////            if (intervals[i][0] >= intervals[i + 1][0] && intervals[i][1] <= intervals[i + 1][1]) {
//            //Reversing the polarity of the condition cause, we have sorted ASC, so i can be a sub interval of i+1
//            if (intervals[i][0] >= intervals[i - 1][0] &&
//                    intervals[i][1] >= intervals[i - 1][1]) {
//
//                count++;
//            }
//        }


        // Track the rightmost end point of the current covering interval
        int prevEnd = intervals[0][1];

        // Start from index 1
        for (int i = 1; i < intervals.length; i++) {
            // Since intervals[i][0] >= previous start is guaranteed by sorting,
            // we only need to check if the current end fits inside prevEnd
            if (intervals[i][1] <= prevEnd) {
                count++; // It's covered!
            } else {
                // Not covered, so this interval now becomes the new baseline
                prevEnd = intervals[i][1];
            }
        }

        return intervals.length - count;

    }


    //same logic but simplified
    public int removeCoveredIntervalsSimple(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int count = 0, maxEnd = 0;
        for (int[] interval : intervals) {
            if (interval[1] > maxEnd) {
                count++;
                maxEnd = interval[1];
            }
        }
        return count;
    }

}
