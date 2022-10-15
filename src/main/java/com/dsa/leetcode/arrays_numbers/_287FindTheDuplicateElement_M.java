package com.dsa.leetcode.arrays_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class _287FindTheDuplicateElement_M {
    /*
     * https://leetcode.com/problems/find-the-duplicate-number/
     * https://www.youtube.com/watch?v=32Ll35mhWg0
     */

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // 		Constraint if [ n = array.length  => array has elements in range of [1, n-1] and one repeating, so total n elements
        int sample[] = {1, 2, 6, 5, 9, 7, 6, 8, 3, 4};

        int[] sample1 = sample.clone();
        int[] sample2 = sample.clone();
        int[] sample3 = sample.clone();
        int[] sample4 = sample.clone();
        int[] sample5 = sample.clone();

        int answer1 = finderNaive(sample1);
        System.out.println(answer1);

        int answer2 = finderOptimisedWithCustomHashing(sample2);
        System.out.println(answer2);

        int answer3 = finderOptimisedUsingSet(sample3);
        System.out.println(answer3);

        int answer4 = finderOptimisedWithSignFlip(sample4);
        System.out.println(answer4);

        int answer5 = finderTotalOptimizationFloydTortoiseAndHare(sample5);
        System.out.println(answer5);

    }

    private static int finderTotalOptimizationFloydTortoiseAndHare(int... sample) {
        // TODO Auto-generated method stub
//        Floyd's Tortoise and Hare (Cycle Detection)
        /*
         * Linked List Cycle method O(n)=n | for Space O(n)=1 But its only for special
         * case Constraint if [ n = array.length => array has elements in range of [1,
         * n-1] and one repeating, so total n elements
         *
         */

        // initialize the tortoise
        int slow = sample[0];
        int fast = sample[0];

        // unleashing the tortoise
        do {
            slow = sample[slow];// slow moving tortoise
            fast = sample[sample[fast]];// double fast moving tortoise

        } while (slow != fast);// wait for until the collision

        // preparing for 2nd collision
        fast = sample[0];//puting fast at start
        while (slow != fast) {
            slow = sample[slow];// constant moving tortoise
            fast = sample[fast];// speed matched to slow tortoise

        }

        // return the point of 2nd collision
        return slow;// slow=fast
    }

    private static int finderOptimisedWithCustomHashing(int[] sample) {
//		  We can use hashing and O(2n) Space in O(n) time

/*		int max = sample[0];
		for (int i = 0; i < sample.length - 1; i++) {
			if (sample[i + 1] > sample[i]) {
				max = sample[i + 1];
			}
		}*/

        int[] hashedArray = new int[sample.length];

        for (int i = 0; i < sample.length; i++) {
            hashedArray[sample[i]]++;
            if (hashedArray[sample[i]] > 1) {
                return sample[i];
            }
        }
        return -1;
    }

    private static int finderOptimisedWithSignFlip(int[] sample) {
//		  We can use hashing and O(2n) Space in O(n) time

        for (int i = 0; i < sample.length; i++) {
            int current = sample[i];
//            if (sample[i] < 0)
//                return sample[i];
            sample[sample[i]] *= -1;
        }
        return -1;
    }


    public static int finderOptimisedUsingSet(int[] sample) {
        //		O(n) Space and O(n) time
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : sample) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }


    private static int finderNaive(int[] sample) {
        // TODO Auto-generated method stub
        /*
         * Sort the array and traverse for finding the 2 consecutive duplicate elements
         * O(n)=n^2 + n + Space O(1) [Bubble Sort] ; nlog(n) + Space O(1) [Merge Sort]
         * Also this will distort the array
         */
        Arrays.sort(sample);
        for (int i = 0; i < sample.length - 1; i++) {
            if (sample[i] == sample[i + 1]) {
                return sample[i];
            }
        }
        return -1;
    }
}
