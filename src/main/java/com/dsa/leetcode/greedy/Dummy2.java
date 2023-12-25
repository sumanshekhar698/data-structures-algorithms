package com.dsa.leetcode.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dummy2 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        int partition = 2;

        ArrayList<ArrayList<Integer>> arrayLists = performPartition(arr, partition);
        System.out.println(arrayLists);


    }

    private static ArrayList<ArrayList<Integer>> performPartition(int[] arr, int partition) {

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();


        if (partition > arr.length) {

            ArrayList<Integer> numList = new ArrayList<>();
            for (int num : arr
            ) {
                numList.add(num);
            }
            resultList.add(numList);
            return resultList;
        }

        int i = 0;
        for (; i < arr.length; i += partition) {
            ArrayList<Integer> numList = new ArrayList<>();
            for (int j = i; j < i + partition; j++) {
                numList.add(arr[j]);
            }
            resultList.add(numList);

        }


        i -= partition;
        ArrayList<Integer> numList = new ArrayList<>();
        boolean flag = false;
        for (; i < arr.length; i++) {
            numList.add(arr[i]);
            flag = true;
        }

        if (flag == true)
            resultList.add(numList);


        return resultList;
    }


}
