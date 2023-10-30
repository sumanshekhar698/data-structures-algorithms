package com.dsa.leetcode.arrays_numbers.slidingwindow;

//https://www.geeksforgeeks.org/sum-of-all-subarrays/
public class _GFG_02CalculateSumOfAllSubArrays {

    public static void main(String[] args) {
        int[] in = {1, 46, 32, 56, 22, 66, 7, 84,};
        int[] i1 = {1, 2, 3};
        int[] in2 = {1000000, 5000, 512901, 316398, 379803, 543671, 705174, 10528, 524584, 236109, 915447, 713197, 505484, 824238, 541733, 336239, 138433, 947529, 918556, 939387, 775606, 486996, 91619, 191092, 323710, 341791, 124463, 888259, 147394};

        long sum = findSumBruteUsingFor(in2);
        System.out.println(sum);
        sum = findSumOptimized_Linear(in2);
        System.out.println(sum);
    }

    private static long findSumOptimized_Linear(int[] in) {

        int n = in.length;
        long sum = 0;
        for (int i = 0; i <n ; i++)
            sum += (in[i]*(n-i)*(i+1));
        return sum;

    }

    private static long findSumBruteUsingFor(int[] in) {
        long result = 0, temp = 0;
        int n = in.length;

        for (int i = 0; i < n; i++) {
            temp = 0;

            for (int j = i; j < n; j++) {
                temp += in[j];
                result += temp;
            }
        }
        return result;
    }

    private static long findSumSlidingWindow(int[] in, int windowSize) {
//        O(n)=n;
//        O(s)=1;


//      structure and initiate the window
        int i = 0, j = 0;

//        adverse condition check
        if (in.length < windowSize) {
            return -1;
        }

        long max = Long.MIN_VALUE;
        long sum = 0;
        while (j < in.length) {

            sum += in[j];
            if ((j - i + 1) < windowSize) {
                j++;
            } else if ((j - i + 1) == windowSize) {
//                max = Long.max(sum, max);
                max = Math.max(sum, max);
                sum -= in[i];
                i++;
                j++;
            }
        }
        return max;

    }
}
