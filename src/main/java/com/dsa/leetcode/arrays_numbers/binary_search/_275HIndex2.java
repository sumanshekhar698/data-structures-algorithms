package com.dsa.leetcode.arrays_numbers.binary_search;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _275HIndex2 {
    public static void main(String[] args) {

        int arr[] = {0, 1, 3, 5, 6};//hIndex=3
        //ascending ✅ 0 < 1 < 3 < 5 < 6
        //non-decreasing ✅ 0 < 1 < [1] < 3 < 5 < 6
        int arr1[] = {1, 5, 6, 7, 8};//case 2: hIndex=4 but 4 is not in array
        int arr2[] = {1, 2, 6, 7, 8, 9};//hIndex=4

        int ans = hIndex2(arr);
        System.out.println(ans);

    }

    private static int hIndex2(int[] citations) {//Using Simple Binary Search
        //log n   time
        int i = 0, j = citations.length - 1, mid, citation = 0;

        while (i <= j) {
            mid = (i + j) / 2;

            if (citations[mid] == citations.length - mid) {//optimal case
                return citations[mid];

            } else if (citations[mid] < citations.length - mid) {//if you found a possible H-Index
                i = mid + 1;
            } else {
                j = mid - 1;
            }

        }

        return citations.length - i;//the optimal answer will be no of elements right to i

    }

}
