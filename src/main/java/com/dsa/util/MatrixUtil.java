package com.dsa.util;

public class MatrixUtil {


   public static void print2DMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println();
    }

    public static int[][] clone2DMatrix(int[][] matrix) {
        int [ ][ ] clonedArray = new int[matrix.length][];
        // Copying elements of arr1[ ] to arr2[ ] using the clone() method
        for(int i = 0; i < matrix.length; i++)
            clonedArray[i] =  matrix[i].clone();

        return clonedArray;
    }



}
