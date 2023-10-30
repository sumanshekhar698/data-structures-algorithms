package com.dsa.leetcode.arrays_numbers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _15ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> lists = threeSum(nums);
//        System.out.println(lists);
        List<List<Integer>> lists = threeSumBruteOptimized(nums);
        System.out.println(lists);
    }

    static public List<List<Integer>> threeSumBrute(int[] nums) {
//        Time O(n) = n^3
//        Space O(n) = Set of size n
        HashSet<List<Integer>> set = new HashSet<>();

        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

//                  CONDITION  nums[i] + nums[j] + nums[k] == 0.
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);//to avoid duplicates
                        set.add(temp);//unordered set so O(1) time
//                        for ordered set use TreeSet O(logn) time
                    }
                }
            }

        }
        List<List<Integer>> collect = set.stream().collect(Collectors.toList());

        return collect;


    }

    static public List<List<Integer>> threeSumBruteOptimized(int[] nums) {


//        Time O(n) = n^2
//        Space O(n) = Set of size n + hashset of size k + 1 list of size k where k is the number of unique triplets

//        nums[i] + nums[j] + nums[k] == 0.
//         nums[k] ==  - (nums[i] + nums[j])

//      =>  Converting nums to a set to avoid duplicates

//        HashSet<Integer> integers = new HashSet<>(Arrays.asList(1, 2, 3));//this will work
//        HashSet<int[]> ints = new HashSet<>(Arrays.asList(nums));//this will NOT work because int is not a primitive type
//        because primitive to wrapper coercion (ie. int[] to Integer[]) is not built into the language (not sure why they didn't do this, but they didn't).


//        SOLUTIONS
//        Integer[] boxedArray = IntStream.of(nums).boxed().toArray(Integer[]::new);// convert int[] to Integer[]
//        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());
//        HashSet<Integer> hashset = IntStream.of(nums).boxed().collect(Collectors.toCollection(HashSet::new)); //or if you need a HashSet specifically

//        HashSet<Integer> hashset = IntStream.of(nums).boxed().collect(Collectors.toCollection(HashSet::new)); //or if you need a HashSet specifically
//        we will not use this to avoid duplicate triplets


        HashSet<Integer> integers = new HashSet<>();
        HashSet<List<Integer>> records = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {//O(n^2) time
            integers.clear();//emptying the hashset
            for (int j = i + 1; j < nums.length; j++) {

                int third = -(nums[i] + nums[j]);
                if (integers.contains(third)) {//O(1) time for unordered set & O(logn) time for ordered set & for space O(n) [as worst case it will contain all the elements]for both
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);
                    Collections.sort(temp);//to avoid duplicates
                    records.add(temp);//unordered set so O(1) time
                }
                integers.add(nums[j]);
            }

        }


        List<List<Integer>> collect = records.stream().collect(Collectors.toList());
        return collect;

    }

    //BEST SOLUTION using 2 pointers
    static public List<List<Integer>> threeSum(int[] nums) {
        //        Time O(n) = nlogn +  n^2
        //        Space O(n) = k where k is unique triplets

        Arrays.sort(nums);//O(nlogn) in ascending order
        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());
        ArrayList<List<Integer>> list = new ArrayList<>();

//        i j k should be in the same order i < j < k
        for (int i = 0; i < nums.length; i++) {//O(n) = n
            if (i > 0 && nums[i] == nums[i - 1])// the first element has no previous, and we are checking the previous for all the non-1st element as we want unique triplets and this array we have already sorted.
                continue;
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {//to maintain the order O(n) = n^2
                int tempSum = nums[i] + nums[j] + nums[k];
                if (tempSum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
//                    Collections.sort(temp);// no need to sort as the main array is already sorted
                    list.add(temp);

                    //progresing loop
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1])//time for these 2 whiles can be ignored as they are extension of the outer while
                        j++;// boundary condition and duplicates skipping if there are
                    while (j < k && nums[k] == nums[k + 1])
                        k--;// boundary condition and duplicates skipping if there are
                } else if (tempSum < 0) {//we have to increase the sum
                    j++;//as the array is sorted in ascending order and going forward, will increase the sum
                } else {//(tempSum > 0)  | we have to decrease the sum
                    k--;//as the array is sorted in ascending order, and going backward will decrease the sum
                }

            }

        }
        return list;


    }
}
