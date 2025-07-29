package com.dsa.leetcode.heap;

import java.math.BigInteger;
import java.util.Collections;
import java.util.PriorityQueue;

public class _1985FindTheKthLargestIntegerInTheArray {


    public String kthLargestUsingBigInt(String[] nums, int k) {
        PriorityQueue<BigInteger> pq = new PriorityQueue(Collections.reverseOrder());
        for (String num : nums) {
            pq.add(new BigInteger(num));
        }

        BigInteger res = BigInteger.valueOf(0);
        for (int i = 0; i < k; i++) {
            res = pq.poll();
        }

        return String.valueOf(res);
    }


    public String kthLargestNumberERROR(String[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue(Collections.reverseOrder());
        for (String num : nums) {
            pq.add(Long.parseLong(num));
        }

        long res = 0;
        for (int i = 0; i < k; i++) {
            res = pq.poll();

        }

        return String.valueOf(res);
    }


    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            } else {
                return b.compareTo(a);
            }
        });

        for (String i : nums) {
            pq.offer(i);
        }

        for (int i = 1; i <= k - 1; i++) {
            pq.poll();
        }

        return pq.peek();
    }


}


