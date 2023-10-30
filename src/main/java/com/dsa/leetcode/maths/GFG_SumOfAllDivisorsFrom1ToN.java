package com.dsa.leetcode.maths;

public class GFG_SumOfAllDivisorsFrom1ToN {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(divisorSum(n));
        n = 5;
        System.out.println(divisorSum(n));
    }

    static int divisorSum(int n) {
        int sum = 0;

        for (int i = 1; i <= n; ++i) {

            // Find all divisors of i
            // and add them
            for (int j = 1; j * j <= i; ++j) {
                if (i % j == 0) {//for the square root case we will count only once
                    if (i / j == j)
                        sum += j;
                    else
                        sum += j + (i / j);//summing up both the divisor pairs
                }
            }
        }
        return sum;
    }

    static int divisorSumOptimized(int n) {
        int sum = 0;

        for (int i = 1; i <= n; ++i) {
            sum += i * (n / i);//number * frequency
        }
        return sum;
    }

}
