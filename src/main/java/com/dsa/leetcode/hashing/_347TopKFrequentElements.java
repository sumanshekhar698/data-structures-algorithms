package com.dsa.leetcode.hashing;

import java.util.*;
import java.util.stream.Collectors;

public class _347TopKFrequentElements {
    //    https://leetcode.com/problems/top-k-frequent-elements
    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] topKElements = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(topKElements));
    }

    public static int[] topKFrequent(int[] nums, int k) {

//       Time O(n) =  n + mlogm + k = mlogm (linear traversal + sorting + result array traversal)
//       Space O(n) =  m + m + k = n (2 hashmap  + array of size k)
//       =| where m is the number of unique elements in the array and n is total element of nums array

        HashMap<Integer, Integer> frequencyTable = new HashMap<>();//O(n) space
        for (int num : nums) {//O(n) time in making frequency table
            frequencyTable.put(num, frequencyTable.getOrDefault(num, 0) + 1);
//            frequencyTable.putIfAbsent(num, 0);
        }


//        Sorting the frequency table in descending order of the values and storing it in a LinkedHashMap to maintain the order of the keys
        HashMap<Integer, Integer> temp
                = frequencyTable.entrySet()
                .stream()
                .sorted((i1, i2)//O(mlogm) time
                        -> -i1.getValue().compareTo(// negative sign to sort in descending order
                        i2.getValue()))//and returns 1 if the value of i1 is greater than the value of i2, -1 if the value of i1 is less than the value of i2, and 0 if the values of i1 and i2 are equal.
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));// e1, e2 -> e1 is used to resolve the conflict if the keys are same O(m) space
        //LinkedHashMap::new is used to maintain the order of the keys in the map

//        HashMap<Integer, Integer> temp2
//                = frequencyTable.entrySet()
//                .stream()
//                .sorted(Comparator.comparing(Map.Entry::getValue))//Will not sort in Descending order
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));


//        HashMap<Integer, Integer> temp3
//                = frequencyTable.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));


//                HashMap<Integer, Integer> temp4
//                = frequencyTable.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));


//                HashMap<Integer, Integer> temp5
//                = frequencyTable.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue((a, b) -> -a.compareTo(b)))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));


//        System.out.println(frequencyTable.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()));
//        frequencyTable.entrySet().stream().sorted((e1, e2)->{
//            e1.getValue().compareTo(e2.getValue());
//        });

        int[] topKElements = new int[k];//O(k) space
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {//O(k) time
            if (i >= k)
                break;
            topKElements[i++] = entry.getKey();
        }

        return topKElements;

    }

    public int[] topKFrequentCustomLogic(int[] nums, int k) {

//       Time O(n) =  n + k * m = k * m (linear traversal + two nested loops)
//       Space O(n) = m + k = n (1 hashmap  + array of size k)
//       =| where m is the number of unique elements in the array and n is total element of nums array

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
        //O(k * m) time
        for (int i = 0; i < k; i++) {//O(k) time
            int freq = 0;
            int iThMax = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {//O(m) time
                if (entry.getValue() > freq) {// entry.getValue() returns the frequency of the key
                    freq = entry.getValue();
                    iThMax = entry.getKey();
                }
            }
            map.put(iThMax, 0);//making the frequency of the maximum occurred element as 0
            arr[i] = iThMax;
        }

        return arr;
    }


    public int[] topKFrequentUsingPriorityQueue(int[] nums, int k) {//BEST Solution

//       Time O(n) =  n + m + k  (linear traversal + priority queue enrichment + result array traversal)
//       Space O(n) = m + m + k = n (1 hashmap + 1 priority queue  + array of size k)
//       =| where m is the number of unique elements in the array and n is total element of nums array


        Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();

        // Count the frequency of each number
        for (int i = 0; i < nums.length; i++) {//O(n) time
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
        for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {//O(m) time
            pq.add(entry);
        }

        // Get the top k frequent elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {//O(k) time
            result[i] = pq.poll().getKey();//fetching the key from the entry
        }

        return result;
    }
}
