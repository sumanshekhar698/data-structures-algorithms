package com.dsa.leetcode.arrays_numbers.intervals;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _57InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] interval = {2, 5};

        int[][] intervals2 = {};
        int[] interval2 = {5, 7};


        int[][] result = insert(intervals, interval);

        for (int[] nums : result)
            System.out.println(Arrays.toString(nums));

    }

    static public int[][] insert(int[][] intervals, int[] newInterval) {

//     if not sorted, Sort the data using Arrays.sort with a custom comparator based on starting index

//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));//ASC
//        Arrays.sort(intervals, (a, b) -> -Integer.compare(a[0], b[0]));//DSC
//        Arrays.sort(intervals, (a, b) -> Integer.compare(b[0], a[0]));//DSC

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));//ASC
//        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]).reversed()); //ERROR
//        Arrays.sort(intervals, Comparator.comparingInt(a -> -a[0]));//DSC


        LinkedList<int[]> resultList = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {

            if (newInterval[1] < intervals[i][0]) {//if the newInterval can be inserted before the current intervals[i]
                resultList.add(newInterval);
//                resultList.addAll(Stream.of(intervals).skip(i).collect(Collectors.toList()));
//                Stream.of(intervals).skip(i).forEach(resultList::addLast);

                for (int j = i; j < intervals.length; j++) {//most performant
                    resultList.add(intervals[j]); // Add each subarray from the desired slice
                }
                return resultList.toArray(new int[resultList.size()][]);

            } else if (newInterval[0] > intervals[i][1]) {//if the newInterval is towards right after the current intervals[i]
                resultList.add(intervals[i]);//dont return
            } else {//OVERLAP so merging an updating newInterval;once merge starts this will go till all the 1D arrays are merged
                newInterval[0] = Integer.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Integer.max(newInterval[1], intervals[i][1]);
            }
        }


        resultList.addLast(newInterval);

        return resultList.toArray(new int[resultList.size()][]);
//        return resultList.stream()
//                .collect(Collectors.collectingAndThen(
//                        Collectors.toList(), list1 -> list1.toArray(int[][]::new)
//                ));


    }

    static private class Solution {
        public int[][] insertUsingSorting(int[][] intervals, int[] newInterval) {
            List<int[]> intervalList = new ArrayList<>();
            for (int[] interval : intervals) {
                intervalList.add(interval);
            }
            intervalList.add(newInterval);

            intervalList.sort(Comparator.comparingInt(a -> a[1]));

            List<int[]> res = new ArrayList<>();
            res.add(intervalList.get(0));

            for (int i = 1; i < intervalList.size(); i++) {
                int currEnd = intervalList.get(i)[1];
                int currStart = intervalList.get(i)[0];
                while (res.size() > 0 && res.get(res.size() - 1)[1] >= currStart) {
                    currEnd = Math.max(res.get(res.size() - 1)[1], currEnd);
                    currStart = Math.min(res.get(res.size() - 1)[0], currStart);
                    res.remove(res.size() - 1);
                }
                res.add(new int[]{currStart, currEnd});
            }

            return res.toArray(new int[res.size()][]);
        }


        public int[][] insert(int[][] intervals, int[] newInterval) {
            //Empty arraylist to store the answer
            ArrayList<int[]> answer = new ArrayList<int[]>();
            //rename the insert variables
            int a = newInterval[0];
            int b = newInterval[1];
            //find where a new interval falls
            int i = 0;
            while (i < intervals.length && intervals[i][1] < a) {
                answer.add(intervals[i]);
                i++;
            }
            if (i >= intervals.length - 1)
                i = intervals.length - 1;
            //start building the insert array
            int[] insert = new int[2];
            if (intervals.length == 0 || intervals[i][0] > a || intervals[i][1] < a) {
                insert[0] = a;
            } else {
                insert[0] = intervals[i][0];
            }
            //find where the insert ends:
            while (i < intervals.length - 1 && intervals[i][1] < b) {
                i++;
            }
            if (intervals.length == 0 || b < intervals[i][0] || b > intervals[i][1]) {
                insert[1] = b;
                if (intervals.length != 0 && b <= intervals[i][1])
                    i--;
            } else {
                insert[1] = intervals[i][1];
            }
            answer.add(insert);
            //Complete the answer array
            i++;
            while (i < intervals.length) {
                answer.add(intervals[i]);
                i++;
            }
            //convert answer from ArrayList to array
            int[][] answerA = new int[answer.size()][2];
            for (int[] e : answer) {
                answerA[answer.indexOf(e)] = e;
            }
            return answerA;
        }

    }

}
