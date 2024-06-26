package com.dsa.leetcode.medium.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _945MinimumIncrementToMakeArrayUnique {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 1, 7};
        System.out.println(minIncrementForUnique(arr.clone()));//6
        System.out.println(minIncrementForUniqueApproach2UsingCountingSort(arr.clone()));//6
        System.out.println(minIncrementForUniqueApproach2UsingCountingSortTweaked(arr.clone()));//6

    }

    public static int minIncrementForUnique(int[] nums) {

//        Time: n logn + n  = n log n
        Arrays.sort(nums);//n logn
        // 1 1 2 2 3 7
        int res = 0;
        for (int i = 1; i < nums.length; i++) {//n

            if (nums[i - 1] >= nums[i]) {
                res += 1 + nums[i - 1] - nums[i];// updating res
                nums[i] = nums[i - 1] + 1;//updating nums to make it unique
            }

        }
        return res;
    }

    public static int minIncrementForUniqueApproach2UsingCountingSort(int[] nums) {

        int maxNum = Arrays.stream(nums).max().getAsInt();//n

        Map<Integer, Integer> map = IntStream.rangeClosed(0, maxNum + nums.length).boxed().collect(Collectors.toMap(key -> key, value -> 0));//n + max(nums)


        for (Integer num : nums) {//freq map  n
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        int res = 0;
        for (int i = 0; i < map.size(); i++) {//n + max(nums)
            if (map.get(i) > 1) {
                int extras = map.get(i) - 1;
                map.put(i + 1, map.get(i + 1) + extras);//passing the extras
                res += extras;
            }
        }
        return res;


    }

    public static int minIncrementForUniqueApproach2UsingCountingSortTweaked(int[] nums) {

        int maxNum = Arrays.stream(nums).max().getAsInt();//n

//        Map<Integer, Integer> map = IntStream.rangeClosed(0, maxNum + nums.length).boxed().collect(Collectors.toMap(key -> key, value -> 0));//n + max(nums)

        HashMap<Integer, Integer> map = new HashMap<>();


        for (Integer num : nums) {//freq map  n
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        int res = 0;
        for (int i = 0; i < maxNum + nums.length; i++) {//n + max(nums)
            if (map.containsKey(i) && map.get(i) > 1) {
                int extras = map.get(i) - 1;
                map.put(i + 1, map.getOrDefault(i + 1, 0) + extras);//passing the extras to the next bucket
                res += extras;
            }
        }
        return res;


    }
}
