package com.dsa.leetcode.hashing;

import java.util.HashSet;

public class _202HappyNumber {

    public static void main(String[] args) {

        System.out.println(isHappy(19));

    }

    static public boolean isHappy(int n) {

        HashSet<Integer> memory = new HashSet<>();
        while (n != 1) {


            int sum = 0;
            int temp = n;
            while (temp > 0) {
                int digit = temp % 10;
                sum += digit * digit;
                temp = temp / 10;
            }
            if (memory.contains(sum)) {
                return false;
            }

            n = sum;
            memory.add(n);
        }

        return true;


    }

    static int squaringDigits(int x) {
        return x * x;
    }
}
