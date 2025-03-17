package com.dsa.leetcode.arrays_numbers.binary_search;

import java.util.Arrays;

public class _2594MinimumTimeToRepairCars {

    public static void main(String[] args) {

//        int ranks[] = {4, 2, 3, 1}, cars = 10;
//        System.out.println(repairCars(ranks, cars));

        int ranks2[] = {9, 13, 15, 9, 5, 2, 15, 12, 9, 9, 9, 18, 9, 22, 28, 15, 4, 21, 17, 23, 10, 25, 10, 12, 24, 30, 13, 13, 24, 29, 18, 5, 28, 16, 1, 15, 15, 30, 31, 21, 15, 21, 18, 10, 23, 27, 27, 2, 6, 4, 12, 26, 17, 24, 6, 31, 29, 31, 29, 12, 24, 27, 7, 15, 14, 22, 18, 23, 27, 6, 6, 18, 19, 15, 9, 1, 3, 31, 24, 16, 14, 27, 6, 19, 9, 2, 16, 8, 9, 24, 9, 1, 14, 12, 3, 18, 18, 21, 28, 11, 15, 15, 23, 26, 4, 23, 12, 18, 20, 19, 9, 23, 3, 7, 21, 21, 27, 25, 29, 11, 19, 1, 16, 29, 25, 16, 20, 21, 17, 17, 20, 18, 8, 15, 27, 17, 21, 20, 23, 14, 31, 9, 29, 21, 10, 3, 13, 24, 3, 12, 19, 14, 9, 20, 25, 18, 30, 8, 2, 14, 3, 14, 7, 23, 4, 12, 26, 14, 6, 3, 28, 20, 8, 30, 10, 19, 8, 14, 3, 19, 6, 12, 4, 25, 28, 20, 7, 19, 7, 30, 17, 31, 19, 19, 1, 31, 26, 2, 22, 13, 5, 25, 31, 10, 17, 24, 12, 26, 23, 7, 13, 22, 22, 11, 29, 22, 12, 7, 27, 10, 26, 3, 8, 4, 29, 13, 4, 1, 1, 24, 23, 1, 13, 4, 23, 26, 2, 16, 25, 23, 3, 25, 15, 21, 1, 25, 5, 25, 21, 31, 14, 31, 30, 21, 7, 12, 2, 31, 23, 20, 19, 14, 28, 23, 10, 18, 30, 25, 3, 2, 25, 14, 27, 16, 18, 27, 3, 25, 20, 19, 29, 1, 10, 18, 13, 28, 14, 2, 12, 5, 10, 17, 4, 20, 3, 14, 26, 31, 30, 19, 17, 6, 15, 22, 28, 18, 3, 11, 24, 19, 7, 16, 25, 28, 26, 6, 7, 25, 3, 28, 6, 18, 9, 29, 31, 9, 29, 1, 23, 14, 22, 17, 21, 15, 14, 30, 23, 12, 31, 26, 25, 31, 29, 28, 10, 29, 2, 8, 21, 24, 11, 18, 24, 26, 7, 12, 16, 21, 13, 2, 22, 9, 19, 5, 7, 19, 2, 22, 4, 8, 19, 26, 5, 13, 4, 19, 27, 3, 31, 22, 2, 25, 30, 29, 5, 7, 18, 18, 18, 22, 9, 5, 22, 23, 25, 23, 14, 5, 9, 9, 31, 2, 21, 12, 7, 26, 6, 7, 16, 19, 29, 16, 25, 16, 6, 19, 22, 12, 21, 5, 16, 20, 28, 4, 27, 10, 29, 27, 23, 20, 17, 3, 21, 15, 29, 10, 19, 13, 19, 15, 15, 16, 20, 28, 16, 17, 29, 21, 12, 2, 15, 22, 11, 28, 4, 26, 29, 4, 6, 11, 5, 1, 27, 19, 10, 15, 19, 14, 5, 27, 19, 22, 14, 24, 27, 11, 30, 25, 12, 19, 25, 23, 7, 9, 20, 27, 26, 25, 4, 16, 19, 2, 16, 13, 11, 11, 13, 25, 7, 23, 1, 29, 18, 11, 15, 16, 14, 1, 21, 2, 22, 31, 21, 8, 19, 17, 2, 3, 22, 11, 8, 12, 24, 16, 21, 18, 7, 27, 9, 12, 14, 4, 14, 20, 13, 16, 5, 9, 1, 13, 8, 2, 27, 1, 17, 23, 3, 30, 27, 6, 17, 14, 4, 3, 28, 4, 13, 28, 7, 29, 24, 21, 27, 4, 19, 16, 31, 18, 15, 27, 12, 25, 20, 23, 21, 17, 1, 6, 6, 10, 10, 25, 20, 14, 4, 12, 7, 17, 18, 24, 1, 18, 11, 30, 21, 21, 13, 1, 24, 7, 14, 11, 13, 31, 13, 20, 11, 11, 8, 29, 22, 21, 18, 21, 11, 16, 30, 23, 3, 5, 18, 15, 19, 18, 17, 6, 22, 17, 10, 15, 25, 10, 4, 6, 29, 7, 14, 26, 29, 23, 5, 6, 2, 1, 9, 18, 17, 11, 30, 27, 1, 21, 17, 14, 9, 16, 5, 20, 3, 7, 16, 14, 18, 17, 21, 10, 21, 30, 18, 12, 28, 16, 8, 6, 28, 25, 8, 23, 25, 27, 11, 28, 7, 13, 24, 31, 3, 27, 11, 18, 3, 8, 25, 10, 8, 18, 8, 16, 28, 27, 27, 14, 25, 31, 10, 6, 11, 5, 17, 27, 27, 9, 2, 30, 18, 2, 16, 6, 21, 6, 10, 24, 17, 20, 1, 7, 20, 16, 10, 17, 15, 16, 22, 24, 4, 5, 1, 12, 27, 3, 14, 10, 10, 24, 27, 6, 5, 29, 10, 11, 30, 15, 3, 23, 17, 19, 4, 1, 8, 20, 25, 11, 1, 31, 26, 19, 11, 25, 8, 14, 26, 24, 27, 23, 14, 22, 17, 11, 17, 15, 9, 3, 9, 10, 30, 1, 12, 30, 11, 29, 18, 19, 13, 17, 19, 17, 20, 2, 14, 11, 7, 17, 10, 14, 15, 18, 31, 22, 25, 31, 13, 4, 26, 22, 20, 27, 13, 17, 19, 24, 20, 1, 15, 1, 19, 21, 30, 18, 5, 23, 29, 10, 24, 26, 12, 30, 22, 12, 2, 26, 16, 7, 25, 17, 12, 22, 27, 4, 26, 5, 17, 25, 20, 12, 15, 14, 6, 12, 1, 16, 27, 12, 15, 23, 29, 17, 5, 6, 23, 25, 28, 14, 21, 14, 30, 23, 10, 22, 5, 6, 21, 20, 24, 17, 25, 18, 5, 12, 15, 30, 28, 14, 28, 9, 31, 15, 17, 26, 6, 19, 20, 24, 28, 19, 4, 22, 2, 17, 13, 15, 3, 26, 29, 6, 7, 24, 16, 27, 7};
        int cars2 = 292126;
        System.out.println(repairCars(ranks2, cars2));

    }

    static public long repairCars(int[] ranks, int cars) {

        long lowerBoundTime = 1L;//it will take least 1 min
        long upperBoundTime = 1L * ranks[0] * cars * cars;//Max Time possible, from formula, multiplying by 1L to make everything long


        class TimeValidator {
            boolean checkTime(long time) {//check if the passed time suffices the condition

                long totalCars = Arrays.stream(ranks)
                        .mapToDouble(rank -> Math.sqrt((double) time / rank)).mapToLong(d -> (long) d)//!!! converting to long as many doubles decimal part can add up to make a whole number
                        .sum();


                return totalCars >= cars;
            }

            long repairedCarsInGivenTime(long time) {//return the max no of cars one can process in the given time

                return Arrays.stream(ranks)
                        .mapToDouble(rank -> Math.sqrt((double) time / rank)).mapToLong(d -> (long) d)//!!! converting to long as many doubles decimal part can add up to make a whole number
                        .sum();
            }
        }

        TimeValidator timeValidator = new TimeValidator();

        long res = -1L;

//        Applying Binary Search as the range is sorted in ASC
        while (lowerBoundTime <= upperBoundTime) {
            long midValueTime = (lowerBoundTime + upperBoundTime) / 2;
            long repairedCars = timeValidator.repairedCarsInGivenTime(midValueTime);

//            if (timeValidator.checkTime(midValueTime)) {
            if (repairedCars >= cars) {
                upperBoundTime = midValueTime - 1;
                res = midValueTime;

            } else {
                lowerBoundTime = midValueTime + 1;
            }

        }

        return res;//At last the binary search will convex to the result
    }


    public boolean timeIsSuff(int[] ranks, int cars, long minGiven) {
        long carsDone = 0;
        for (int r : ranks) {
            long c2 = minGiven / r;
            long c = (long) Math.sqrt(c2);
            carsDone += c;
        }
        return carsDone >= cars;
    }

    public long repairCars2(int[] ranks, int cars) {
        long l = 1, r = (long) 1e14;
        while (l < r) {
            long mid = (l + r) / 2;
            if (timeIsSuff(ranks, cars, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


}
