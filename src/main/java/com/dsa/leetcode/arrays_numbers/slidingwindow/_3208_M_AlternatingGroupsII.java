package com.dsa.leetcode.arrays_numbers.slidingwindow;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class _3208_M_AlternatingGroupsII {

    public static void main(String[] args) {

        int colors[] = {0, 1, 0, 0, 1, 0, 1}, k = 6;
        System.out.println(numberOfAlternatingGroupsTimeOptimized(colors, k));

    }

    static public int numberOfAlternatingGroupsSpaceAndTimeOptimized(int[] colors, int k) {
        int n = colors.length, i = 0, res = 0;

//        time : n; Space = 1
        for (int j = 1; j < n + k - 1; j++) {
            if (colors[j % n] == colors[(j - 1) % n]) {//modding to handle circularity
                i = j;
            }

            if (j - i + 1 > k) {//to converge the window to size of k
                i += 1;
            }

            if (j - i + 1 == k) {//as soon we hit the k window
                res += 1;
            }

        }

        return res;
    }

    static public int numberOfAlternatingGroupsTimeOptimized(int[] colors, int k) {

        int[] flatColors = new int[colors.length + k - 1];

        AtomicInteger index = new AtomicInteger(0);

        int x = 0;
        Arrays.stream(colors)
                .forEach(element -> flatColors[index.getAndIncrement()] = element);

//        Appending the circularity to make it flat
        Arrays.stream(colors).limit(k - 1)
                .forEach(element -> flatColors[index.getAndIncrement()] = element);


        int i = 0, res = 0;

        //        time : n + k; Space = n
        for (int j = 1; j < flatColors.length; j++) {
            if (flatColors[j] == flatColors[(j - 1)]) {//modding to handle circularity
                i = j;
            }

            if (j - i + 1 > k) {//to converge the window to size of k
                i += 1;
            }

            if (j - i + 1 == k) {//as soon we hit the k window
                res += 1;
            }

        }
        return res;


    }
}
