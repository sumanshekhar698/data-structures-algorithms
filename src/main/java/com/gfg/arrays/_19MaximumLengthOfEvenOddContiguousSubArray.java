package com.gfg.arrays;

import java.util.Arrays;


public class _19MaximumLengthOfEvenOddContiguousSubArray {

    public static void main(String[] args) {
        int[] intArr2 = new int[]{1, 2, 3, -2, 5};// {-1,-2,-3,-4}
        int[] intArr = new int[]{5, 10, 20, 6, 3, 8};// 11
        System.out.println(intArr);
        System.out.println("Array -> " + Arrays.toString(intArr));
        int ans = maximumSubArrayNaive(intArr);// Occurrence
        System.out.println(ans);
        ans = maximumSubArrayOptimized(intArr);// Occurrence
        System.out.println(ans);
    }

    private static int maximumSubArrayNaive(int[] intArr) {
//		O(n) = n^2
        int resLength = 1;// we are starting our brute force

        for (int i = 0; i < intArr.length; i++) {
            int current = 1;// A single element
            for (int j = i + 1; j < intArr.length; j++) {// for every subarray beginning with i
                if ((intArr[j] % 2 == 0 && intArr[j - 1] % 2 != 0) || (intArr[j] % 2 != 0 && intArr[j - 1] % 2 == 0))
                    current++;
                else
                    break;
            }
            resLength = Math.max(current, resLength);
        }
        return resLength;
    }

    private static int maximumSubArrayOptimized(int[] intArr) {
        // KANADANE's algorithm
//		O(n) = n
        int globalMaxLength = 1, currentMaxLength = 1;

        for (int i = 1; i < intArr.length; i++) {// subarray ending with i
            /* 2 CASES */
//			case1: We extend the previous sub array
            if ((intArr[i] % 2 == 0 && intArr[i - 1] % 2 != 0) || (intArr[i] % 2 != 0 && intArr[i - 1] % 2 == 0)) {
                currentMaxLength++;
                globalMaxLength = Math.max(currentMaxLength, globalMaxLength);
            }
//			case 2: start a new subarray count
            else
                currentMaxLength = 1;
        }
        return globalMaxLength;
    }
}
