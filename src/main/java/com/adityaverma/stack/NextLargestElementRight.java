package com.adityaverma.stack;

import java.util.Arrays;

public class NextLargestElementRight {

    public static void main(String[] args) {

        // i/p  1 3 2 4
        // i/p  1 3 2 4
        // o/p  3 4 4 -1

        int[] arr = {1, 3, 2, 4};
        int[] ans = bruteNGLR(arr);
        System.out.println(Arrays.toString(ans));


    }

    private static int[] bruteNGLR(int[] arr) {

        int[] result = new int[arr.length];
        boolean flag = false;

        int i = 0;
        for (; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }

                if (j == arr.length) {
                    flag = true;
                }
                if (flag)
                    result[i] = -1;
            }

        }
        result[i] = -1;


        return result;
    }
}
