package com.dsa.leetcode.arrays_numbers;

import java.util.Arrays;
import java.util.HashSet;

public class _217ContainsDuplicate {
    //    https://leetcode.com/problems/contains-duplicate/
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        boolean ans = containsDuplicateBrute(nums);
        System.out.println(ans);
    }

    private static boolean containsDuplicateLinear(int[] nums) {
        HashSet set = new HashSet();

        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }

        }
        return false;

    }

    private static boolean containsDuplicateBrute(int[] nums) {

//        Time O(n) = n^2
//        Space O(n) = 1
        for (int i = 0; i < nums.length; i++) {
            int count = 1;//counting the current element
            for (int j = i + 1; j < nums.length; j++) {

                    if (nums[i] == nums[j]) {
                        count++;
                    }

            }
            if (count >= 2) {
                return true;
            }
        }

        return false;

    }

    private static boolean containsDuplicateBruteWithSort(int[] nums) {

//        Time O(n) = nlogn + n = nlogn (sorting + linear search)
//        Space O(n) = 1

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1]){
                return true;
            }
        }

        return false;

    }


}
