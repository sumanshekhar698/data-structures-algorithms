package com.dsa.leetcode.bitmagic.basics;

public class LefttMostSetBit {

    public static void main(String[] args) {

        int n = 5, bit = 0;
        int position = leftMostFirstSetBit(n);
        System.out.println(position);
    }

    public static int leftMostFirstSetBit(int n) {
        int position = 0;
        int operator = 1 << 31;

        // Iterate till n>0
        while (n > 0) {
            n = n >> 1;
            position++;
        }

        return position;
    }
}
