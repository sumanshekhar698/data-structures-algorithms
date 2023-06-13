package com.dsa.leetcode.maths;

import java.util.ArrayList;
import java.util.List;

public class _118PascalTriangle_E {

    public static void main(String[] args) {
        System.out.println(generateCompletePascalTriangle(5));
        System.out.println(generateNthPascalTriangleRow(5));
        System.out.println(generateCordinateValueForPascalTriangleRow(5,3));
    }


    public static List<List<Integer>> generateCompletePascalTriangle(int numRows) {
        int c = 1;
        List<List<Integer>> pascal = new ArrayList();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();//here temp is individual Nth row
            for (int j = 0; j <= i; j++) {//<= because we need to include the last element in the row as the row will have one more element
                if (j == i || j == 0) {//j==0 for left 1s and j==i for right ones
                    c = 1;
                    temp.add(c);
                } else {
                    c = c * (i - j + 1) / j;//j is the denominator and i-j+1 is the numerator
                    temp.add(c);
                }
            }
            pascal.add(temp);
        }
        return pascal;
    }


    public static List<Integer> generateNthPascalTriangleRow(int rowIndex) {
        int c = 1;
        List<List<Integer>> pascal = new ArrayList();

        int i = rowIndex - 1;
        ArrayList<Integer> temp = new ArrayList<Integer>();//here temp is individual n the row
        for (int j = 0; j <= i; j++) {
            if (j == i || j == 0) {//j==0 for left 1s and j==i for right ones
                c = 1;
                temp.add(c);
            } else {
                c = c * (i - j + 1) / j;//j is the denominator and i-j+1 is the numerator
                temp.add(c);
            }
        }
        pascal.add(temp);
        return temp;
    }

    public static int generateCordinateValueForPascalTriangleRow(int rowIndex, int columnIndex) {
        int n = rowIndex-1;
        int r = columnIndex-1;
        return fact(n) /
                (fact(r) * fact(n - r));
    }

    // Returns factorial of n
    static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }

}
