package com.dsa.leetcode.arrays_numbers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _349IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int arr1[] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};
        int[] intersection = new Solution().intersection(arr1, arr2);
        System.out.println(Arrays.toString(intersection));

    }

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {//Using Set and Streams
            Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            return IntStream.of(nums2)
                    .filter(element -> set.contains(element)) // Filter elements present in the set
                    .distinct() // Remove duplicates
                    .boxed() // Convert int stream to stream of Integer objects
                    .collect(Collectors.toList()) // Collect elements into a list
                    .stream() // Convert list stream back to int stream
                    .mapToInt(Integer::intValue) // Convert Integer objects back to int primitives
                    .toArray(); // Convert stream to an int array


        }

        public int[] intersectionLC(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i : nums1) {
                hashMap.put(i, 0);
            }

            int size = 0;
            for (int i : nums2) {
                Integer num = hashMap.get(i);
                if (num != null && num != 1) {
                    size++;
                    hashMap.put(i, ++num);
                }
            }
            int count = 0;
            int[] res = new int[size];
            for (Integer i : hashMap.keySet()) {
                Integer num = hashMap.get(i);
                if (count == size) return res;
                if (num == 1)
                    res[count++] = i;
            }
            return res;
        }
    }
}
