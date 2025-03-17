package com.dsa.leetcode.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _2206DivideArrayIntoEqualPairs {

    public boolean divideArrayOptimizedUsingSet(int[] nums) {


        HashSet<Integer> oddSet = new HashSet<>();

        for (int num : nums) {
            if (!oddSet.contains(num)) {
                oddSet.add(num);
            } else {
                oddSet.remove(num);
            }

        }

        return oddSet.isEmpty();


    }


    public boolean divideArrayUsingArrayAsConditionPreDefined(int[] nums) {
        int[] freq = new int[501];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        for (int i = 0; i < 501; i++) {
            if (freq[i] % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean divideArray(int[] nums) {

        Map<Integer, Long> map =
                Arrays.stream(nums)
                        .boxed() // Convert int stream to Integer stream
                        .collect(Collectors.groupingBy(
                                Function.identity(), // Group by the element itself
                                Collectors.counting() // Count occurrences
                        ));


        return map.values().stream().allMatch(count -> count % 2 == 0);


    }
}
