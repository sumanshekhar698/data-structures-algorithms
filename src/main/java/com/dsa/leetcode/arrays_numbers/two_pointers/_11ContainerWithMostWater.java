package com.dsa.leetcode.arrays_numbers.two_pointers;

public class _11ContainerWithMostWater {
//    https://leetcode.com/problems/container-with-most-water
    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));

    }

    public static int maxArea(int[] height) {

        int maxArea = 0;

        int i = 0;
        int j = height.length - 1;

        while (i < j) {

            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }

        return maxArea;

    }
}