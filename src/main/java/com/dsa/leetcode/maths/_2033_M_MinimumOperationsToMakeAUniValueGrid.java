package com.dsa.leetcode.maths;

import java.util.Arrays;

public class _2033_M_MinimumOperationsToMakeAUniValueGrid {


    public int minOperations(int[][] grid, int x) {

//        the meeting point is a int value that eventually if possible, all the element which converge to
//        the meeting point will be anywhere in middle of all the numbers

        int remainder = grid[0][0] % x;// the remainder should be same for everyone

        int[] nums = Arrays.stream(grid)//open a stream of the 2D grid
                .flatMapToInt(Arrays::stream).filter(num -> num % x == remainder)//open a stream of individual 1D arrays along with filtyration
                .sorted().toArray();

        if (nums.length != grid.length * grid[0].length) {//if any filtration happened , that means all the elements will never converge
            return -1;
        }

//        Arrays.sort(nums);//for finding the mid point, we are sorting along the number line

        int medianNum = nums[nums.length / 2];//choosing a median num as that will be the easiest converging point

//        int steps = 0;
//        for (int num : nums) {
//            steps += Math.abs(num - medianNum) / x;
//        }
//
//
//        return steps;

        return Arrays.stream(nums)
                .map(num -> Math.abs(num - medianNum) / x)
                .sum();


    }
}
