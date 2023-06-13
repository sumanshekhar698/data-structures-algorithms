package com.dsa.leetcode.matrix;

import com.dsa.util.MatrixUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class _73SetMatrixZero_M {
//    https://leetcode.com/problems/set-matrix-zeroes/
    public static void main(String[] args) {

        _73SetMatrixZero_M setMatrixZero = new _73SetMatrixZero_M();
        int[][] matrix1 = {
                {1, 1, 1}, {1, 0, 1}, {1, 1, 1}
        };

//        int[][] matrix2 = matrix1.clone();//not a true deep copy
        int[][] matrix2 = MatrixUtil.clone2DMatrix(matrix1);
        int[][] matrix3 = MatrixUtil.clone2DMatrix(matrix1);

        setMatrixZero.setZeroesNaive(matrix1);
        setMatrixZero.setZeroesBetter(matrix2);
        setMatrixZero.setZeroesSpaceOptimized(matrix3);
        MatrixUtil.print2DMatrix(matrix1);
        MatrixUtil.print2DMatrix(matrix2);
        MatrixUtil.print2DMatrix(matrix3);


    }


    public void setZeroesNaive(int[][] matrix) {

//        O(m + n) space | when every row and columns are considered
//        O(2mn) = O(mn) time | 2 times traversal
        HashSet<Integer> iSet = new HashSet<>();
        HashSet<Integer> jSet = new HashSet<>();

//        Enrich i,j Set
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    iSet.add(i);
                    jSet.add(j);
                }
            }
        }

//        Transform to Zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (iSet.contains(i) || jSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }


    public void setZeroesBetter(int[][] matrix) {
        ArrayList<ArrayList<Integer>> records = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    records.add(temp);
                }
//                final int finalI = i;
//                final int finalJ = j;
//                records.add(new ArrayList<Integer>() {
//                    {
//                        add(finalI, finalJ);
//                    }
//                });

            }
        }
//        System.out.println("RECORD " + records);
        transformZero(matrix, records);
    }


    public void transformZero(int[][] matrix, ArrayList<ArrayList<Integer>> records) {

        for (ArrayList<Integer> a : records) {
            int i = a.get(0);
            int j = a.get(1);

            //setting i th row to zeros
//            Arrays.fill(matrix[i], 0);
            Arrays.fill(matrix[i], 0, matrix[i].length, 0);

//            setting j th column to zeros
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][j] = 0;
            }
        }
    }

    public void setZeroesSpaceOptimized(int[][] matrix) {
//        The idea is that we can use the first cell of every row and column as a flag.

//        O(1) space | no extra DS required
//        O(2mn) = O(mn) time | 2 times traversal

        boolean isCol = false;//to compensate [0][0] as this is common for 1st row and 1st column
        // So isCol wil mark the 0th column

//        Marking i,j Boundary
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0)
                isCol = true;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;//setting upper column boundary to zero
                    matrix[i][0] = 0;//setting left row boundary to zero
                }
            }
        }


        //        Transform to Zero
        for (int i = 1; i < matrix.length; i++) {//not touching the marking rows and columns
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

//        checking for 1st row if eligible for zero
        if (matrix[0][0] == 0)//for row
            Arrays.fill(matrix[0], 0, matrix[0].length, 0);

//        checking for 1st column if eligible for zero
        if (isCol)//for row
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }


    }

}
