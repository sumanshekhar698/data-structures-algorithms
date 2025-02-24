package com.companies;

import java.util.HashMap;

public class GoMotiveLongestSubArrayWithEquals1n0 {

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int ans = longestSubArrayWithEquals1n0(arr);//longest subarray with equal 1s and 0s is 8
        System.out.println(ans);
    }

    private static int longestSubArrayWithEquals1n0(int[] arr) {

        // Creates an empty hashMap map
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//sum : ending index

        // Initialize sum of elements
        int sum = 0;

        // Initialize result
        int max_len = 0;
        int ending_index = -1;

        for (int i = 0; i < n; i++) {//replace 0 with -1 changes the problem to find the longest subarray with sum 0
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }

            if (map.containsKey(sum)) {// there is a subarray with sum 0
                if (max_len < i - map.get(sum)) {//if the current subarray is longer than the previous one
                    max_len = i - map.get(sum);//update the max_len
                    ending_index = i;//update the ending index as we have a longer subarray
                    // NOTE : we are NOT updating the map because we want to maximize the length of the subarray
                }
            } else { // Else put this sum in hash table
                map.put(sum, i);
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int start = ending_index - max_len + 1;
        System.out.println(start + " to " + ending_index);

        return max_len;
    }


    private static int subarraySum(int[] nums, int k) {
        int numberOfSubArrays = 0;

        int curSum = 0;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();//prefixSum : Count
        prefixSumMap.put(0, 1);//there is an empty prefix with curSum 0

        for (int num : nums) {
            curSum += num;
            int diff = curSum - k;

            numberOfSubArrays += prefixSumMap.getOrDefault((diff), 0);
            prefixSumMap.put(curSum, prefixSumMap.getOrDefault(curSum, 0) + 1);

        }

        return numberOfSubArrays;
    }
}
