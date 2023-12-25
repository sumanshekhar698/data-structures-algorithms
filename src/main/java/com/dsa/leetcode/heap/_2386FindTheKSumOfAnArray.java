package com.dsa.leetcode.heap;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class _2386FindTheKSumOfAnArray {//kth number in the descending sorted sequence of all the possible sums

    public static void main(String[] args) {
        int[] arr1 = {2, 4, -2}, arr2 = {1, -2, 3, 4, -10, 12};
        int k1 = 5, k2 = 16;//2,10
        System.out.println(new _2386FindTheKSumOfAnArray().kSum(arr2, k2));

    }


    public long kSum(int[] nums, int k) {
        long sum = 0;
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((a, b) -> Long.compare(b.getKey(), a.getKey()));
        for (int i = 0; i < nums.length; i++) {//sum up positive nums
            sum += Math.max(0, nums[i]);
        }


        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        System.out.println(Arrays.toString(nums));


        Arrays.sort(nums);
        long result = sum;
        pq.offer(new Pair<>(sum - nums[0], 0));
        while (--k > 0) {
            Pair<Long, Integer> pair = pq.poll();
            result = pair.getKey();
            int index = pair.getValue();
            if (index < nums.length - 1) {
                pq.offer(new Pair<>(result + nums[index] - nums[index + 1], index + 1));
                pq.offer(new Pair<>(result - nums[index + 1], index + 1));
            }
        }
        return result;
    }

    public class Pair<K, V> {

        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }


    public static long kSumOld(int[] nums, int k) {

        //find the largest sum from nums; it will be the sum of all non-negative ints
        int sum = Arrays.stream(nums).filter(x -> x > 0).sum();// we can say the sum is ans for k =1
        System.out.println(sum);

        return sum;


    }


    public static long kSumForSubArraysGFG(int[] nums, int k) {


//        {1, -2, 3, 4, -10, 12};

        //create a prefix sum

        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;//{0, 0, 0,0, 0, 0};
        prefixSum[1] = nums[0];//{0, 1, 0,0, 0, 0};
        for (int i = 2; i < prefixSum.length; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }

        System.out.println(Arrays.toString(prefixSum));
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = i; j < prefixSum.length; j++) {
                int x = prefixSum[j] - prefixSum[i - 1];//end - (start - 1)


                if (pQueue.size() < k) {
                    pQueue.add(x);
                } else {
                    if (pQueue.peek() < x) {
                        pQueue.poll();
                        pQueue.add(x);
                    }
                }
            }
        }


        return pQueue.poll();

    }
}
