package com.dsa.leetcode.arrays_numbers;

import com.dsa.util.MatrixUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import static java.util.Arrays.*;

public class _56MergeIntervals_M {
    //    https://leetcode.com/problems/merge-intervals/solution/
    public static void main(String[] args) {
        int[][] intervals0 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals1 = {{1, 3}, {8, 10}, {2, 6}, {9, 9}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {0, 2}, {3, 5}};
        int[][] intervals3 = MatrixUtil.clone2DMatrix(intervals1);

        int[][] mergedArray = mergeCustom(intervals1);
        System.out.println(mergedArray.length);
        MatrixUtil.print2DMatrix(mergedArray);
        mergedArray = mergeCustomUsingArayList(intervals3);
        System.out.println(mergedArray.length);
        MatrixUtil.print2DMatrix(mergedArray);


    }

    private static int[][] mergeCustom(int[][] intervals) {
        //O(nlogn + n) = O(nlogn) time | O(n) space

        if (intervals == null || intervals.length == 0)
            return new int[0][];

        //1. Sorting the intervals - We are sorting because if there are intervals which are bound to merge,
        // we are putting them in a consecutive order
//        MatrixUtil.print2DMatrix(intervals);//Before sorting
        sort(intervals, (x, y) -> x[0] - y[0]);

//        Arrays.sort(intervals, (x, y) -> {
//            return x[0] - y[0];
//        });

//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//       Comparator.comparing();
//        System.out.println(Arrays.stream(intervals1).collect(Collectors.toList()));

//        MatrixUtil.print2DMatrix(intervals);//After sorting


        int nullCounter = 0;

        //2. Merging the intervals
        for (int i = 0; i <= intervals.length - 2; i++) {
            int j = i + 1;//will merge till all eligible j
            while (j <= intervals.length - 1 && intervals[i][1] >= intervals[j][0]) {//Checking If merge-able
//                System.out.println("RUN " + ++run);
                intervals[i][1] = Integer.max(intervals[i][1], intervals[j][1]);//merging (checking what should be end index of the merged)
                intervals[j] = null;//making it null to skip later
                nullCounter++;//maintaining counter to construct the new array later
                ++j;//move the while loop
            }
            i = j - 1;//VVI it is to ensure the i variable is on track | in while it will help to return to normal
            // , if no while it will neutralise line 45
        }


        //3. Copying transformed array into the newly formed array and returning it
        int[][] mergedArray = new int[intervals.length - nullCounter][2];
        int j = 0;
        for (int[] interval : intervals) {
            if (interval != null)
                mergedArray[j++] = interval.clone();
        }

        return mergedArray;


    }

    private static int[][] mergeCustomUsingArayList(int[][] intervals) {

        ArrayList<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0)
            return res.toArray(new int[0][]);

        sort(intervals,
                Comparator.comparingInt(a -> a[0]));//for every element 'a' of intervals Array the 1st integer of the Array will be taken as for reference

        int firstOfPair = intervals[0][0];
        int secondOfPair = intervals[0][1];

        for (int[] i : intervals) {
            if (i[0] <= secondOfPair) {//if mergeable
                secondOfPair = Math.max(secondOfPair, i[1]);
            } else {
                res.add(new int[]{firstOfPair, secondOfPair});
                firstOfPair = i[0];
                secondOfPair = i[1];
            }
        }
//        int[][] intervals0 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        res.add(new int[]{firstOfPair, secondOfPair});
//        return (int[][]) res.toArray();
        return res.toArray(new int[0][]);//using the overloaded toArray to match the type

    }


    public int[][] mergeCustomUsingLinkedList(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
