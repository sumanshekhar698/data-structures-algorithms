package com.dsa.leetcode.arrays_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _1509MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    public static void main(String[] args) {
        int arr[] = {1, 5, 0, 10, 14};
        System.out.println(minDifference(arr.clone()));
        System.out.println(minDifferenceUsingHeap(arr));
    }

    public static int minDifference(int[] nums) {

        if (nums.length == 3)
            return 0;
        Arrays.sort(nums);//nlogn   0 1 5 10 14
        int windowSize = nums.length - 3;

        int diff = Integer.MAX_VALUE;
        for (int i = 0, j = nums.length - 3 - 1; j <= nums.length - 1; j++) {//we will use all of our 3 moves
            diff = Math.min(diff, nums[j] - nums[i++]);
        }

        return diff;


    }

    public static int minDifferenceUsingHeap(int[] nums) {

        if (nums.length <= 4) {
            return 0;
        }

        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> maxList = new ArrayList<>();
        ArrayList<Integer> minList = new ArrayList<>();

        for (int num : nums) {
            minPq.add(num);
            maxPq.add(num);
        }

        for (int i = 0; i < 4; i++) {
            minList.add(minPq.poll());
            maxList.add(maxPq.poll());

        }

        Collections.sort(maxList);
//        Collections.sort(minList); // no need to sort minList


        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            diff = Math.min(maxList.get(i) - minList.get(i), diff);
        }
        return diff;
    }

    private static int[] findMinFour(int[] nums) {
        // Use a min-heap (priority queue with smallest element on top)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add first four elements to the min-heap
        for (int i = 0; i < 4 && i < nums.length; i++) {
            minHeap.add(nums[i]);
        }

        // Loop through the remaining elements
        for (int i = 4; i < nums.length; i++) {
            // If the current element is less than the root (smallest element) of the min-heap
            if (nums[i] < minHeap.peek()) {
                // Remove the root element (smallest) and add the current element
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        // Convert the min-heap to an array (smallest elements first)
        int[] minFourArray = new int[minHeap.size()];
        int idx = minFourArray.length - 1;
        while (!minHeap.isEmpty()) {
            minFourArray[idx--] = minHeap.poll();
        }

        return minFourArray;
    }

    private static int[] findMaxFour(int[] nums) {
        // Use a max-heap (priority queue with largest element on top)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add first four elements to the max-heap
        for (int i = 0; i < 4 && i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        // Loop through the remaining elements
        for (int i = 4; i < nums.length; i++) {
            // If the current element is greater than the root (largest element) of the max-heap
            if (nums[i] > maxHeap.peek()) {
                // Remove the root element (largest) and add the current element
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        // Convert the max-heap to an array (largest elements first)
        int[] maxFourArray = new int[maxHeap.size()];
        int idx = 0;
        while (!maxHeap.isEmpty()) {
            maxFourArray[idx++] = maxHeap.poll();
        }

        return maxFourArray;
    }
    public int minDifferenceUsing4Cases(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        int[] min4 = new int[4];
        int[] max4 = new int[4];

        Arrays.fill(min4, Integer.MAX_VALUE);
        Arrays.fill(max4, Integer.MIN_VALUE);

        for (int num : nums) {
            boolean added = false;
            for (int j = 0; j < min4.length; j++) {
                if (num < min4[j]) {
                    shift(min4, j);
                    min4[j] = num;
                    added = true;
                    break;
                }
            }
            if (!added && min4[min4.length - 1] == Integer.MAX_VALUE) {
                min4[min4.length - 1] = num;
            }
        }

        for (int num : nums) {
            boolean added = false;
            for (int j = 0; j < max4.length; j++) {
                if (num > max4[j]) {
                    shift(max4, j);
                    max4[j] = num;
                    added = true;
                    break;
                }
            }
            if (!added && max4[max4.length - 1] == Integer.MIN_VALUE) {
                max4[max4.length - 1] = num;
            }
        }

        int ans = max4[0] - min4[0];
        for (int i = 0; i <= 3; i++) {
            ans = Math.min(ans, max4[3 - i] - min4[i]);
        }
        return ans;
    }

    private void shift(int[] a, int start) {
        int last = a[a.length - 1];
        for (int j = a.length - 1; j > start; j--) {
            a[j] = a[j - 1];
        }
        if (a.length < 4) {
            a[a.length - 1] = last;
        }
    }




}
