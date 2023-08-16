package com.dsa.leetcode.arrays_numbers;

import java.util.Arrays;

public class Lec2_RotateTheArrayByDPosition {


    public static void main(String[] args) {
        int x[] = {
//                7, 6, 8, 2,    5, 8, 11//@3       5, 8, 11, 7, 6, 8, 2
//                7, 6, 8,  2, 5, 8, 11//@4       2, 5, 8, 11, 7, 6, 8

                7, 6, 8, 2, 5, 8, 11
        };


        //5,6,7,1,2,3,4]

        int steps = 10;

        System.out.println(Arrays.toString(x));
//        rotateTheArrayClockWiseBrute(x, steps);
        rotateTheArrayInRightDirectionLinearTime(x, steps);
        System.out.println(Arrays.toString(x));


    }

    private static void rotateTheArrayClockWiseLinearTimeHighestOptimization(int[] x, int n) {
//        Reversal
//        Step 1 - 12345 6789 ---> 54321 6789 n=5
//
//        Step 2 - 54321 6789 ---> 54321 9876
//
//        Step 3 - 54321 9876 ---> 678912345
    }

    private static void rotateTheArrayInRightDirectionLinearTime(int[] x, int b) {
//        O(n) =steps +  (n- steps) + steps = n+ steps = n
        b = b % x.length;//bifurcation index from end  of the final array


        int[] backupArray = new int[b];
        int j;

//       step 1
        int m = 0;
        for (int i = x.length - b; i < x.length; i++) {//Taking backup of last b elements  part from bifurcation
            backupArray[m++] = x[i];
        }

        System.out.println(Arrays.toString(backupArray));

//        step 2
        for (j = x.length - 1 - b; j >= 0; j--) {//shifting the second half of the bifurcation towards starting left
            x[j + b] = x[j];
        }


        for (int i = 0; i < backupArray.length; i++) {//copying the backup array towards right hand side of thr bifurcation
            x[i] = backupArray[i];
        }

    }


    private static void rotateTheArrayInRightDirectionLinearTimeX(int[] x, int steps) {
        int n = x.length;
//        O(n) =steps +  (n- steps) + steps = n+ steps = n
        steps = steps % x.length;//bifurcation index  of the final array steps-1


        int[] backupArray = new int[steps];
        int firstBackup = x[0], j;

        for (int i = 0; i < steps; i++) {//Taking backup of 1st  part from bifurcation
            backupArray[i] = x[i];

        }

        for (j = 0; j < x.length - steps; j++) {//shifting the second half of the bifurcation towards starting left
            x[j] = x[j + steps];
        }


        for (int i = 0; i < backupArray.length; i++, j++) {//copying the backup array towards right hand side of thr bifurcation
            x[j] = backupArray[i];
        }

    }

    private static void rotateTheArrayClockWiseBrute(int[] x, int steps) {

        steps = steps % x.length;
        int firstBackup;
        if (x.length > 0)
            for (int i = 0; i < steps; i++) {
                firstBackup = x[0];
                for (int j = 0; j < x.length - 1; j++) {
                    x[j] = x[j + 1];
                }
                x[x.length - 1] = firstBackup;
            }
    }

    private static void rotateTheArrayAntiCLockWIse(int[] x, int steps) {
    }


}
