package com.dsa.leetcode.arrays_numbers.two_pointers;

import java.util.Arrays;

public class _167TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] ints = twoSum(arr, 9);
        System.out.println(Arrays.toString(ints));


    }

    public static int[] twoSum(int[] numbers, int target) {

        int i = 0, j = numbers.length - 1;
        int[] result = new int[2];
        int temp, temp2, sum;
        //        Time : O(n) | Space : O(1)

        while (i < j) {
            temp = numbers[i];
            temp2 = numbers[j];
            sum = temp + temp2;
            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            } else if (sum > target) {
                j--;//as we have to decrease the sum to meet target
            } else {//sum < target
                i++;//as we have to increase the sum to meet target
            }
        }
        return result;
    }

    public static int[] twoSumBrute(int[] numbers, int target) {

        int[] result = new int[2];
        //        Time : O(n^2) | Space : O(1)
        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;//as the indexing starts form 1 according to question
                    result[1] = j + 1;
                    return result;
                } else if (numbers[i] + numbers[j] > target) {
                    break;//As the Array is sorted

                }
            }
        }

        return result;

    }
}
