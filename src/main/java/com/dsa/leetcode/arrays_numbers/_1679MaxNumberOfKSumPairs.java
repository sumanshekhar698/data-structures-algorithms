package com.dsa.leetcode.arrays_numbers;

import java.util.Arrays;
import java.util.HashMap;

public class _1679MaxNumberOfKSumPairs {

    public static void main(String[] args) {

        int[] arr = {3, 1, 3, 4, 3};
        System.out.println(maxOperationsTIMELIMITEXCEEDS(arr, 6));//1
    }

    private static int maxOperations(int[] arr, int k) {//using sorting and 2 pointers
//        nlogn time and  1 space
        Arrays.sort(arr);


        int count = 0;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];//checking the end indices
            if (sum == k) {
                ++count;
                ++i;
                --j;
            } else if (sum < k) {//moving towards right for higher sum
                ++i;
            } else {//moving towards left for lower sum
                --j;
            }

        }
        return count;
    }

    static public int maxOperationsUsingHMap(int[] nums, int k) {

        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i : map.keySet()) {

            if (map.containsKey(i) && map.containsKey(k - i)) {
                if (i != k - i) {
                    count += Math.min(map.get(i), map.get(k - i));
                    map.put(i, 0);//wea re not using delete as it will give Concurrent Modification Exception
                    map.put(k - i, 0);
                } else {
                    count += map.get(i) / 2;
                    map.put(i, 0);
                }


            }

        }

        return count;

    }

    static public int maxOperationsTIMELIMITEXCEEDS(int[] nums, int k) {

        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i <= k / 2; i++) {

            if (map.containsKey(i) && map.containsKey(k - i)) {
                if (i != k - i) {
                    count += Math.min(map.get(i), map.get(k - i));
                    map.remove(k - i);
                    map.remove(i);

                } else {
                    count += map.get(i) / 2;
                    map.remove(i);
                }


            }

        }

        return count;


    }
}
