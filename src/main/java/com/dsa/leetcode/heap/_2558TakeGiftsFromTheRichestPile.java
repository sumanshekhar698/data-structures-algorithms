package com.dsa.leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class _2558TakeGiftsFromTheRichestPile {

    public static void main(String[] args) {

    }

    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (long giftCount : gifts) {
            pq.add(giftCount);
        }


        for (int i = 1; i <= k; i++) {
            long giftVal = (int) Math.floor(Math.sqrt(pq.poll()));
            pq.add(giftVal);
        }

        return pq.stream().mapToLong(Long::longValue).sum();

    }
}

