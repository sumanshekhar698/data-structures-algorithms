package com.dsa.leetcode.greedy;
//https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/
//https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description/

public class _2874_M_MaximumValueOfAnOrderedTripletII {

    public long maximumTripletValue(int[] nums) {//Using Greedy

        // i < j < k
        long result = 0;//result is (nums[i] - nums[j]) * nums[k] and is bound to have the least value as 0


        long maxDiff = 0;//maxDiff = (nums[i] - nums[j])
        long prefixMax = nums[0];

        for (int k = 1; k < nums.length; k++) {//my base will be k, as I will know all the past i, j values
            result = Math.max(result, nums[k] * maxDiff);//starting with 1 will still be valid for i < j < k ,
            // as initially maxDiff will be 0, & this should be the 1st statement

            prefixMax = Math.max(prefixMax, nums[k]);
            maxDiff = Math.max(maxDiff, prefixMax - nums[k]);

        }


        return result;

    }


    public long maximumTripletValueBRUTE(int[] nums) {//Using Greedy

        // i < j < k
        long result = 0;//result is (nums[i] - nums[j]) * nums[k] and is bound to have the least value as 0


        for (int i = 0; i < nums.length; i++) {//time : n^3
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] > nums[i]) {//we are skipping because  (nums[i] - nums[j]) is becoming -ve
                    i = j;
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    result = Math.max(result, (nums[i] - nums[j]) * nums[k]);
                }
            }

        }

        return result;

    }

    public long maximumTripletValueBRUTETweaked(int[] nums) {//Using Greedy

        // i < j < k
        long result = 0;//result is (nums[i] - nums[j]) * nums[k] and is bound to have the least value as 0
        long left = nums[0];//left wil keep track of nums[i]


        for (int j = 1; j < nums.length; j++) {//time : n^2

            if (nums[j] > left) {//we are skipping because  (nums[i] - nums[j]) is becoming -ve
                left = nums[j];
                continue;
            }

            for (int k = j + 1; k < nums.length; k++) {//k moving towards right to see potential higher res val;ues
                result = Math.max(result, (left - nums[j]) * nums[k]);
            }
        }


        return result;

    }
}
