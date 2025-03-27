package com.dsa.leetcode.arrays_numbers.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class _3394_M_CheckIfGridCanBeCutIntoSections {


    public static void main(String[] args) {
        int[][] rectangles = {{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}};
        System.out.println(checkValidCuts(5, rectangles));
    }

    static public boolean checkValidCuts(int n, int[][] rectangles) {
//        we just  need 3  intervals from 2 cuts vertically or horizontally that don't overlap

        int[][] xCordsPair = Arrays.stream(rectangles).map(cords -> new int[]{cords[0], cords[2]})//getting all the xCords
                .sorted(Comparator.comparingInt(pair -> pair[0])) // Sort by the first element
                .toArray(int[][]::new);


        int[][] yCordsPair = Arrays.stream(rectangles).map(cords -> new int[]{cords[1], cords[3]})//getting all the yCords
                .sorted(Comparator.comparingInt(pair -> pair[0])) // Sort by the first element
                .toArray(int[][]::new);


        class IntervalChecker {

            public static boolean hasMinimumThreeNonOverlapping(int[][] cordsPair) {
                if (cordsPair == null || cordsPair.length < 3) {
                    return false;
                }

//                Arrays.sort(cordsPair, Comparator.comparingInt(pair -> pair[0])); // Sort by start

                int nonOverlappingCount = 0;
//                int lastEnd = cordsPair[0][1];
                int lastEnd = -1;//when teh loop runs it wil always have at least 1 non overlapping interval, as the 1st rectangle will have its first end line for the cut

                for (int[] pair : cordsPair) {
                    if (pair[0] >= lastEnd) { // Non-overlapping, we wil always have atleast 1 non overlapped cut
                        nonOverlappingCount++;
                    }
                    lastEnd = Math.max(lastEnd, pair[1]); //Update to the max end in overlapping intervals

                    if (nonOverlappingCount >= 3) {
                        return true;
                    }
                }

                return false;
            }
        }


        return IntervalChecker.hasMinimumThreeNonOverlapping(yCordsPair) || IntervalChecker.hasMinimumThreeNonOverlapping(xCordsPair);

    }
}


