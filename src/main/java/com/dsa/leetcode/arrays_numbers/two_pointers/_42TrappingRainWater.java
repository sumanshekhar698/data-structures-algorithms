package com.dsa.leetcode.arrays_numbers.two_pointers;

import java.util.Arrays;

public class _42TrappingRainWater {
    //    https://leetcode.com/problems/trapping-rain-water/
//    https://www.youtube.com/watch?v=ZI2z5pq0TqA&t=85s
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(height);
        System.out.println(trap);

    }


    //    Optimized via 2 pointers
    public static int trap(int[] height) {

        if (height == null || height.length <= 2)  //the extreme positions cannot hold any water
            return 0;


        int i = 0, j = height.length - 1,
                maxL = height[i], maxR = height[j], maxWater = 0;


        while (i < j) {//loop condition
            if (maxL <= maxR) {
                i++;//shifting i towards right at starting only as the extreme positions cannot hold any water
                int water = maxL - height[i];//here we just need to compare maxL as this is the bottleneck for our problem
                maxWater += (water > 0) ? water : 0;//if water is -ve then we don't need to add it
                maxL = Math.max(height[i], maxL);//update maxL before next iteration
            } else {
                j--;////shifting j towards left at starting only as the extreme positions cannot hold any water
                int water = maxR - height[j];
                maxWater += (water > 0) ? water : 0;
                maxR = Math.max(height[j], maxR);

            }
        }

        return maxWater;

    }

    public static int trapWithSpaceNotOptimized(int[] height) {
//        water logged at i will be
//        => min(L,R =height[i]) for every i position where is L,R are the max height in L,R

        //       Time O(n) =  3n = n
        //       Space O(n) = 3n = n
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];
        int[] minLR = new int[height.length];

        maxL[0] = 0;
        int max = 0;
        for (int i = 1; i < height.length; i++) {//enrich maxL
            if (height[i - 1] > max) {
                max = height[i - 1];
            }
            maxL[i] = max;
        }
        System.out.println(Arrays.toString(maxL));


        max = 0;
        maxR[maxR.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {//enrich maxL
            if (height[i + 1] > max) {
                max = height[i + 1];
            }
            maxR[i] = max;
        }
        System.out.println(Arrays.toString(maxR));


        for (int i = 0; i < minLR.length; i++) {//enrich maxL
            minLR[i] = Math.min(maxL[i], maxR[i]);
        }
        System.out.println(Arrays.toString(minLR));

        int maxWater = 0;
        for (int i = 0; i < height.length; i++) {
            int water = minLR[i] - height[i];
            maxWater += (water > 0) ? water : 0;
        }


        return maxWater;
    }
}
