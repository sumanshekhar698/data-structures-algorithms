package com.dsa.leetcode.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dummy {
    public static void main(String[] args) {

        int[] arr = {5, -5, 2, 6, 9, -6, 3, -2, 1, -1};
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(map);

        for (Map.Entry<Integer, Integer> e :
                map.entrySet()) {

            if (e.getKey() > 0 && map.containsKey(-e.getKey())) {
                if (e.getValue() == 1 && map.get(-e.getKey()) == 1) {
                    result.add(e.getKey());
                }
            }

        }

        System.out.println(result);


    }


}
