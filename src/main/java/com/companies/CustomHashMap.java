package com.companies;

import java.util.HashMap;

public class CustomHashMap {

    long solution(String[] queryType, int[][] query) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
//        long keyDelta = 0, valueDelta = 0;  // Track cumulative additions to keys and values
        long sum = 0;

        for (int i = 0; i < queryType.length; i++) {
            String type = queryType[i];
            int[] params = query[i];

            switch (type) {
                case "insert": {
                    // Adjust for keyDelta and valueDelta before insertion
                    hashmap.put(params[0], params[1]);
                    break;
                }
                case "get": {
                    sum += hashmap.getOrDefault(params[0], 0);
                    break;
                }
                case "addToKey": {
                    int keyDelta = params[0];
                    // Efficiently update keys:
                    HashMap<Integer, Integer> updatedMap = new HashMap<>();
                    for (int key : hashmap.keySet()) {
                        updatedMap.put(key + keyDelta, hashmap.get(key));
                    }
                    hashmap = updatedMap;
                    break;
                }
                case "addToValue": {
                    int valueDelta = params[0];
                    for (int key : hashmap.keySet()) {
                        hashmap.put(key, hashmap.get(key) + valueDelta);
                    }
                    break;
                }
            }
        }

        return sum;


    }
}
