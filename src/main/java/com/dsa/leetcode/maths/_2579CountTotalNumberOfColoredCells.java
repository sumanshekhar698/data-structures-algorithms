package com.dsa.leetcode.maths;

public class _2579CountTotalNumberOfColoredCells {

    public static void main(String[] args) {

    }

    public long coloredCells(int n) {

//        Pattern Recognition
//        1 + 4 + 8 + 12 ...
//        1 + 4*1 + 4*2 + 4*3 ==> we can use a while loop here that goes from 1 to n-1 to compute this
//        1 + 4(1 + 2 + 3 ..) ==> But we can use simple Maths :)
//        1 + 4(m(m+1)/2)


        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        long m = n - 1L;
        return 1 + 4 * (m * (m + 1) / 2);
    }
}
