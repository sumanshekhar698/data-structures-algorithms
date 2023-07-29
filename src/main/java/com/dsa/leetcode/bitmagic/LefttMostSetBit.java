package com.dsa.leetcode.bitmagic;

public class LefttMostSetBit {

    public static void main(String[] args) {

        int n = 12, bit = 0;
        int ans = n & (-n);
        System.out.println(ans);

        for (int i = 0; i <= 31; i++) {

            bit = (n >> i) & 1;
            if (bit == 1) {
                System.out.println(i);
                break;
            }

        }
        if (bit == 0)
            System.out.println(-1);
    }

    public static int Last_set_bit(int n) {
        int p = 1;

        // Iterate till n>0
        while (n > 0) {

            // Checking if last bit is set
            if ((n & 1) > 0) {
                return p;
            }

            // Increment position and
            // right shift number
            p++;
            n = n >> 1;
        }

        // set bit not found.
        return -1;
    }
}
