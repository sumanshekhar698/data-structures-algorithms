package com.dsa.leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class _295FindMedianFromDataStream {

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.log();
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        medianFinder.log();
        System.out.println(medianFinder.findMedian());
    }

    static class MedianFinder {

        //the max element of the maxHeap should be less than or equal to themin value of MinhEap
        PriorityQueue<Integer> maxHeap;//Left Smaller Part
        PriorityQueue<Integer> minHeap;//Right Greeater Part

        public MedianFinder() {
            this.maxHeap = new PriorityQueue(Collections.reverseOrder());
            this.minHeap = new PriorityQueue();
        }

        public void addNum(int num) {//TODO

            //Offiring to two Heap
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.add(num);//ony adding to minHeap if the current element is higher than peak of minheap
            } else
                maxHeap.add(num);//adding the current number by default to maxHeap


            //Balancing the size of heaps such that their differnce does not exceed 2 and beyond
            if (maxHeap.size() - minHeap.size() > 1) {//ie difference 2 and onwards
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() - maxHeap.size() > 1) {//ie difference 2 and onwards
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {//TODO
            if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            } else if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                double a = maxHeap.peek();
                double b = minHeap.peek();
                return (a + b) / 2;
            }
        }

        void log() {
            System.out.println(maxHeap);
            System.out.println(minHeap);
        }

    }
}
