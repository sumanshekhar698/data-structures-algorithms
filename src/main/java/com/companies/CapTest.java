package com.companies;

import java.util.HashMap;
import java.util.Map;

public class CapTest {

    public static void main(String[] args) {

//        find duplicate elements from the below 2 array
        int arr1[] = {1, 2, 2, 3, 4, 5};
        int arr2[] = {3, 4, 5, 6, 7};

        HashMap<Integer, Integer> map = new HashMap<>();//K:freq

        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : arr2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > 1)
//                System.out.println(entry.getKey());
//        }

        map.entrySet().stream().filter(x -> x.getValue() > 1).forEach(x->{
            System.out.println(x.getKey());
        });
    }
}
