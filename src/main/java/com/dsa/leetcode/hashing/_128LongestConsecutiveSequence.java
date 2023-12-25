package com.dsa.leetcode.hashing;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _128LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        int[] arr2 = {0};
        int i = new Solution().longestConsecutive(arr2);//1,2,3,4  => 4
        System.out.println(i);
    }

    static class Solution {
        public int longestConsecutive(int[] nums) {//one way is sorting, but it will be nlogn, so we will use Hashing
            Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());

            int maxSubSequence = nums.length >= 1 ? 1 : 0;//1 will be the least length if the arrray size is 1 and above
            for (int num : nums) {
                if (!set.contains(num - 1)) {//we will start with only the start of the sequence point
                    int sequence = 1;
                    while (set.contains(++num)) {
                        ++sequence;
                    }
                    maxSubSequence = Integer.max(sequence, maxSubSequence);

                }
            }

            return maxSubSequence;

        }
    }
}
