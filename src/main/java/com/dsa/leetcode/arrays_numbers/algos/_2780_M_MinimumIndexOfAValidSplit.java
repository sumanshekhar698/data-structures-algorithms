package com.dsa.leetcode.arrays_numbers.algos;

import java.util.List;

public class _2780_M_MinimumIndexOfAValidSplit {

    public int minimumIndex(List<Integer> nums) {

//      1.  implementing Edward F. Moore, Boyer–Moore Voting Algo for getting the majorElement
        /*The Boyer-Moore voting algorithm is one of the popular optimal algorithms
        which is used to find the majority element among the given elements
         that have more than N/ 2 occurrences. */

        final int n = nums.size();
        int majorElement = getMajorityElementUsingMooresVotingAlgo(nums);

        int finalMajorElement = majorElement;
        long countOfFinalMajorElement = nums.stream().filter(num -> num == finalMajorElement).count();
        int leftFreqOfMajorElement = 0;

//        2. Finding the min split
        for (int i = 0; i < n - 1; i++) {//n-1 bcz last element cannot be the split

            if (nums.get(i) == finalMajorElement) {
                leftFreqOfMajorElement++;
                countOfFinalMajorElement--;
            }

            if (leftFreqOfMajorElement > (i + 1) / 2 && countOfFinalMajorElement > (n - (i + 1)) / 2) {
                return i;
            }


        }

        return -1;
    }

    private int getMajorityElementUsingMooresVotingAlgo(List<Integer> nums) {
        int majorElement = nums.get(0);//assuming the 1st is the majority element
        int majorElementFreq = 1;

        for (int num : nums) {
            if (num == majorElement) {
                majorElementFreq++;
            } else {
                majorElementFreq--;
                if (majorElementFreq == 0) {
                    majorElement = num;
                    majorElementFreq = 1;//majorElementFreq will always be >= 0
                }
            }

        }

        return majorElement;//there has to be a majority element so not going for the 2nd pass
    }
}
