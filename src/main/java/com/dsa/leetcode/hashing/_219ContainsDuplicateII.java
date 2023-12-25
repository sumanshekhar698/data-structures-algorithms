package com.dsa.leetcode.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class _219ContainsDuplicateII {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 1, 2, 3}, k = 2;
        int arr2[] = {1, 2, 3, 1}, k2 = 3;
        boolean ans = containsNearbyDuplicate(arr2, k2);
        System.out.println(ans);

    }

    private static boolean containsNearbyDuplicate(int[] arr, int k) {
        HashSet<Integer> set = new HashSet();
        int i = 0;//window left side

        for (int j = 0; j < arr.length; j++) {//j right side of a window
            if (j - i > k) {//for k the max-acceptable window size is k+1, think of a flexible window with size[1,k+1]
                // ++i;
                // set.remove(arr[i]);
                set.remove(arr[i]);//because for this the max window limit is exhausted
                ++i;//shift left side of window
            }
            if (set.contains(arr[j])) {
                return true;
            }
            set.add(arr[j]);
        }
        return false;
    }


    static public boolean containsNearbyDuplicateWRONG(int[] nums, int k) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {//map enrichment
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                int finalI = i;
                map.put(nums[i], new ArrayList<>() {{
                    add(finalI);
                }});
            }

        }


        for (int num : nums) {
            if (map.get(num).size() >= 2) {
                ArrayList<Integer> indexes = map.get(num);
                if (Math.abs(indexes.get(0) - indexes.get(1)) <= k) {//CANNOT CHECK ALL THE CASES IN CASE OF MRE THAN 2 occurrence
                    return true;
                }
            }


        }
        return false;

    }
}
