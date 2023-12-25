package com.dsa.leetcode.arrays_numbers.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class _452MinimumNumberOfArrowsToBurstBalloons {
    //    https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};//2
        int[][] points2 = {{4, 16}, {2, 8}, {1, 6}, {5, 12}};//1

        int minArrowShots = new Solution().findMinArrowShots(points);
        System.out.println(minArrowShots);

    }

    static class Solution {
        public int findMinArrowShots(int[][] points) {

            if (points.length == 0)//corner case
                return 0;
            Arrays.sort(points, (p1, p2) -> {//nlogn good
                if (p1[1] == p2[1]) {
                    return 0;
                } else if (p1[1] > p2[1]) {
                    return 1;

                } else return
                        -1;
            });

//            Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));//better
//            Arrays.sort(points, Comparator.comparingInt(a -> a[1]));//best



            int arrows = 1;//we will need atleast 1 arrow
            int end = points[0][1];//x end of the 1st element [Leftmost baloon]

            for (int i = 0; i < points.length; i++) {
                System.out.println(Arrays.toString(points[i]));
            }

            for (int i = 1; i < points.length; i++) {
//                if (points[i][0] <= points[i - 1][1]) {//overlap check
                if (points[i][0] > end) {//check if it's not overlap with the 1st balloon end
                    ++arrows;
                    end = points[i][1];//updates the balloon end
                }
            }
            return arrows;
        }
    }
}
