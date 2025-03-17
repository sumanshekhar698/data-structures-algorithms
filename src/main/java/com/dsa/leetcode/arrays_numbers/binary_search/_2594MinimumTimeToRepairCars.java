package com.dsa.leetcode.arrays_numbers.binary_search;

import java.util.Arrays;

public class _2594MinimumTimeToRepairCars {

    public static void main(String[] args) {

        int ranks[] = {4, 2, 3, 1}, cars = 10;
        System.out.println(repairCars(ranks, cars));


    }

    static public long repairCars(int[] ranks, int cars) {

        int lowerBoundTime = 1;//it will take atleast 1 min
        int upperBoundTime = ranks[ranks.length - 1] * cars * cars;//from formula


        class TimeValidator {
            boolean checkTime(int time) {

                double totalCars = Arrays.stream(ranks)
                        .mapToDouble(rank -> Math.sqrt((double) time / rank))
                        .sum();


                return totalCars >= cars;
            }
        }

        TimeValidator timeValidator = new TimeValidator();

        int res = -1;

        while (lowerBoundTime <= upperBoundTime) {
            int midValueTime = (lowerBoundTime + upperBoundTime) / 2;
            if (timeValidator.checkTime(midValueTime)) {
                upperBoundTime = midValueTime - 1;
                res = midValueTime;

            } else {
                lowerBoundTime = midValueTime + 1;
            }

        }

        return res;


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
