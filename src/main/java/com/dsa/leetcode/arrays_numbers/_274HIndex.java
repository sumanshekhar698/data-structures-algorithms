package com.dsa.leetcode.arrays_numbers;

import java.util.*;
import java.util.stream.Collectors;

public class _274HIndex {
    public static void main(String[] args) {

        int arr[] = {3, 0, 6, 1, 5};
        int ans = hIndex(arr);
        System.out.println(ans);

    }

    public static int hIndex(int[] citations) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : citations) {
            for (int i = 0; i <= num; i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        System.out.println(map);

// Find the key with the maximum value using streams and Optional handling:
//        Optional<Integer> maxKey = map.entrySet().stream()
//                .max(Comparator.comparingInt(Map.Entry::getValue))
//                .map(Map.Entry::getKey);


        // Find keys with the maximum value using streams and grouping:
//        int maxValue = map.values().stream().mapToInt(v -> v).max().getAsInt();

//        int maxValue = map.entrySet().stream().max((x, y) -> x.getValue() - y.getValue()).get().getValue();
        int maxValue = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getValue();


        // Find the maximum value
//        int maxValue = map.values().stream().mapToInt(Integer::intValue).max().orElse(0);

//        System.out.println(maxValue);
        // Collect entries with the maximum value
//        Map<Integer, Integer> maxEntries = map.entrySet().stream()
//                .filter(entry -> entry.getValue() == maxValue)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//
//
//        List<Integer> maxKeys = map.entrySet().stream()
//                .filter(e -> e.getValue() == maxValue)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//
//        if (maxKeys.isEmpty()) {
//            System.out.println("Map is empty or all values are equal.");
//        } else {
//            System.out.println("Keys with maximum value: " + maxKeys);
//        }


        return 0;


    }
}
