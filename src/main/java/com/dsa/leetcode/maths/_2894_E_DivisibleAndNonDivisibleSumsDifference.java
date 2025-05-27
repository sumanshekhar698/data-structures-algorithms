package com.dsa.leetcode.maths;

public class _2894_E_DivisibleAndNonDivisibleSumsDifference {

    public static void main(String[] args) {

    }


    /**/
    public int differenceOfSumsOptimizedsSimplified(int n, int m) {
        int k = n / m;
        int divisibleSum = k * (k + 1) / 2 * m;

        int res = (n * (n + 1) / 2) - (2 * divisibleSum);//Simplfied Formula
        return res;

    }


    public int differenceOfSumsOptimized(int n, int m) {

        /*m + 2m + 3m + km
         * (1 + 2 + 3 +4 ..k)m
         * k(k+1)/2   * m
         *
         * k = n/m :: no of multiples of m till k
         * */

        int k = n / m;
        int divisibleSum = k * (k + 1) / 2 * m;


        /*all the rest sum will be non divisible
         * so total sum - divisible sum*/
        int nonDivisibleSum = n * (n + 1) / 2 - divisibleSum;

        return nonDivisibleSum - divisibleSum;

    }

    public int differenceOfSumsIterative(int n, int m) {


        int divisbleSum = 0;
        int nonDivisibleSum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                divisbleSum += i;
            } else {
                nonDivisibleSum += i;
            }

        }

        return nonDivisibleSum - divisbleSum;

    }
}
