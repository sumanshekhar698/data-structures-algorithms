package com.dsa.leetcode.arrays_numbers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _229MajorityElementII {

    //We can solve my HashMap butit will take extra space and two independent for loops
    public List<Integer> majorityElement(int[] nums) {// we can have at max 2 elements with frequency higher than n/3
        int targetSize = nums.length / 3;//[2,2,1,3]
        HashMap<Integer, Integer> map = new HashMap<>();// 2 most frequent element

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            if (map.size() > 2) {
                HashMap<Integer, Integer> tempMap = new HashMap<>();

                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > 1) {
                        tempMap.put(entry.getKey(), entry.getValue() - 1);
                    }
                }
                map = tempMap;
            }
        }

        //Checking Eligiblity of the keys in Map
        return map.entrySet().stream().filter(entry -> Arrays.stream(nums).filter(num -> num == entry.getKey()).count() > targetSize)
                .map(Map.Entry::getKey).collect(Collectors.toList());


    }
}
