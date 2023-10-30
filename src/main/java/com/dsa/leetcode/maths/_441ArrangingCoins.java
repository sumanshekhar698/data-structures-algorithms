package com.dsa.leetcode.maths;

public class _441ArrangingCoins {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
    }

    public static int arrangeCoins(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input Number is invalid. Only positive numbers are allowed");
        }
        int i = 1;
        for (; i <= n; i++) {
            n -= i;
        }


        return --i;

    }

    /**
     * Math: Using Sum of Integers Formula
     * <p>
     * This problem can be reduced down to:
     * (K * (K+1))/2 <= N
     * K^2 + K <= 2*N
     * (K + 1/2)^2 <= 2*N + 1/4
     * K <= sqrt(2*N + 1/4) - 1/2
     * <p>
     * Since we want the row that has full levels, we just need to return the floor of the above result.
     * Thus, K = floor(sqrt(2*N + 1/4) - 1/2)
     * <p>
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */

    public int arrangeCoinsUsingMaths(int n) {//BEST
        if (n < 0) {
            throw new IllegalArgumentException("Input Number is invalid. Only positive numbers are allowed");
        }
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }


    /**
     * Optimized binary search
     * <p>
     * Time Complexity: O(log(N/2)). In case of Int.MAX, time complexity can maximum
     * be O(30) = O(1)
     * <p>
     * Space Complexity: O(1)
     * <p>
     * N = Input number
     */

    public int arrangeCoinsUsingBinarySearch(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input Number is invalid. Only positive numbers are allowed");
        }
        if (n <= 1) {
            return n;
        }
        if (n <= 3) {
            return n == 3 ? 2 : 1;
        }

        // Binary Search space will start from 2 to n/2.
        long start = 2;
        long end = n / 2;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long coinsFilled = mid * (mid + 1) / 2;
            if (coinsFilled == n) {
                return (int) mid;
            }
            if (coinsFilled < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Since at this point start > end, start will start pointing to a value greater
        // than the desired result. We will return end as it will point to the correct
        // int value.
        return (int) end;
    }

}
