package com.dsa.leetcode.greedy;

public class _45JumpGameII {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {1, 1, 1, 1};
        int[] nums4 = {3, 4, 3, 2, 5, 4, 3};

        int b = canJump(nums1);
        System.out.println(b);


    }

    private static int canJump(int[] nums3) {//using 1D BFS OR kinda sliding window

        if (nums3.length == 1)
            return 0;
        int res = 0;
        int left = 0, right = 0;
        while (right < nums3.length - 1) {//the right part of the current window should be less than len -1
            // AS the loops should stop when the right is at the last index OR highe than last index, that's why substracting by 1
            int farthestPosition = 0;
            for (int i = left; i <= right; i++) {//left to right window | find the largest element
                farthestPosition = Math.max(farthestPosition, i + nums3[i]);//we are greedy about the max distance we will cover
            }
            left = right + 1;
            right = farthestPosition;
            ++res;
        }

        return res;

    }

    private static int canJumpCheck(int[] nums3) {//using 1D BFS OR kinda sliding window TODO

        if (nums3.length == 1)
            return 0;
        int res = 0;
        int left = 0, right = 0;
        while (right < nums3.length) {//the right part of the current window should be less than len
            int farthest = 0;
            for (int i = left; i <= right; i++) {//left to right window | find the largest element
                farthest = Math.max(farthest, nums3[i]);//this line is WRONG as we cannot caluclae max ditance, we have t get fathestPosn
            }
            left = right + 1;
            right = left + farthest - 1;
            if (right > nums3.length - 1)
                right = nums3.length - 1;
            ++res;
        }

        return res;

    }

//     can be used DP here but its n^2
}
