package com.dsa.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class _347TopKFrequentElements {


    public int[] topKFrequentOtimzedViaPriorityQueue(int[] nums, int k) {
        Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();

        // Count the frequency of each number
        for (int i = 0; i < nums.length; i++) {
            m1.put(nums[i], m1.getOrDefault(nums[i], 0) + 1);
        }


//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
//            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
//                return b.getValue() - a.getValue();
//            }
//        });


        // Create a priority queue with custom comparator to priotiize the entry with maximum value
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());


        // Add all map entries to the priority queue
        for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {
            pq.add(entry);
        }

        // Get the top k frequent elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();//fetching the key from the entry
        }

        return result;
    }

    public int[] topKFrequent(int[] nums, int k) {
        // Time O(n) =  n + nlogn + k = nlogn (linear traversal + sorting)
//       Space O(n) =  n + n + k = n (2 hashmap  + array of size k)

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {//Enriching O(n) time
            if (map.containsKey(nums[i])) {
                int freq = map.get(nums[i]);
                freq++;
                map.put(nums[i], freq);
            } else {
                map.put(nums[i], 1);
            }
        }

        int arr[] = new int[k];
        int j = 0;
        //O(k * n) time
        for (int i = 0; i < k; i++) {//O(k) time
            int freq = 0;
            int iThMax = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {//O(n) time
                if (entry.getValue() > freq) {// entry.getValue() returns the frequency of the key
                    freq = entry.getValue();
                    iThMax = entry.getKey();
                }
            }
            map.put(iThMax, 0);//making the frequency of the maximum occurred element as 0
            arr[i] = iThMax;
//            j++;
        }
        return arr;
    }
}