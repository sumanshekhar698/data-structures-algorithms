package com.dsa.leetcode.arrays_numbers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//    https://leetcode.com/problems/relative-sort-array/description/
public class _1122RelativeSortArray {

    public static void main(String[] args) {

        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
        //[2,2,2,1,4,3,3,9,6,7,19]

    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : arr1) {//generating freq map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for (int num : arr2) {//enriching the arr1 itself, you can aslo use a fresh new array
            Integer freq = map.get(num);
            for (int i = 0; i < freq; i++) {
                arr1[index++] = num;
            }
            map.remove(num);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {//enriching the arr1 with the remaining elements
            Integer freq = entry.getValue();
            Integer num = entry.getKey();
            for (int i = 0; i < freq; i++) {
                arr1[index++] = num;
            }

        }

        return arr1;

    }

}
