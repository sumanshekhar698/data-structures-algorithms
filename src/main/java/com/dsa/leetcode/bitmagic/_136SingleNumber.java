package com.dsa.leetcode.bitmagic;

public class _136SingleNumber {
    //    https://leetcode.com/problems/single-number/description/
//    https://leetcode.com/problems/single-number/solutions/3832636/simple-java-solution-with-o-n-time-complexity-using-xor-gate/
    public static void main(String[] args) {


        int[] nums = {4, 1, 2, 1, 2};
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }


        System.out.println(ans);
    }
}
