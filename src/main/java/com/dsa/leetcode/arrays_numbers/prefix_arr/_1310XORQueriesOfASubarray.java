package com.dsa.leetcode.arrays_numbers.prefix_arr;

import java.util.Arrays;

public class _1310XORQueriesOfASubarray {

    public static void main(String[] args) {

        int arr[] = {1, 3, 4, 8}, queries[][] = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(xorQueries(arr, queries)));


    }


//    XOR is associative a^(b^c)  = (a^b)^c
//    a^a = 0
//    a^0 = a
    static public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];


        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        // fill the prefix xor array
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if (left == 0) {//Boundary Condition
                res[i] = prefix[right];
            } else {//
                res[i] = prefix[left - 1] ^ prefix[right];
                //prefix[left - 1]  will cancel out the previous effectively making them 0
            }
        }

        return res;

    }
}
