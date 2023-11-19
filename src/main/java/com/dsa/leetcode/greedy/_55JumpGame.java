package com.dsa.leetcode.greedy;

public class _55JumpGame {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {2, 0, 0};

        boolean b = canJump(nums3);
        System.out.println(b);


    }

    public static boolean canJump(int[] nums) {//Best Using Greedy
        int goalIndex = nums.length - 1;

//        Time = O(n)
        for (int i = nums.length - 1; i >= 0; i--) {//greedy about the goal post as we keep shifting towards us
            if (i + nums[i] >= goalIndex) {
                goalIndex = i;
            }
        }

//        return goalIndex == 0 ? true : false;
        return goalIndex == 0;
    }

    public static boolean canJumpBrute(int[] nums) {//TODO
        return jump(nums, 0);


    }

    private static boolean jump(int[] nums, int i) {//TODO
        if (i == nums.length - 1)
            return true;
        if (1 == nums.length && nums[0] == 0)
            return true;
        for (int j = 1; i < nums.length && j <= nums[i]; j++) {
            int jumps = i;
            jumps += j;
            return jump(nums, jumps);
        }

        return false;


    }

}
