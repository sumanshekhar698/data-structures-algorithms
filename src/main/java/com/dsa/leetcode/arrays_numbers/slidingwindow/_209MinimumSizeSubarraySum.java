package com.dsa.leetcode.arrays_numbers.slidingwindow;

public class _209MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};// t=7
        int[] arr2 = {1, 4, 4};//4
        System.out.println(minSubArrayLen(4, arr2));

    }

    public static int minSubArrayLen(int target, int[] nums) {

        //        Time O(n) = n
        //        Space O(n) = 1

        int i = 0;
        int sum = 0, result = Integer.MAX_VALUE;

        // [{2, 3, 1, 2, 4, 3]
        for (int j = 0; j < nums.length; j++) {//this loop wil kep on extending the right side of a window in the hope we find a smaller window size
            sum += nums[j];

            //we have a loop there as going forward in the arrays we can found a window with far shorter size
            while (sum >= target) {//it will get triggered for the 1st time once we get atleast one window sum > = target
                result = Integer.min(result, j - i + 1);
                sum -= nums[i];//this will save the computation which we already did
                ++i;
            }

        }

        return result == Integer.MAX_VALUE ? 0 : result;


    }

    public static int minSubArrayLenBrute(int target, int[] nums) {

        //        Time O(n) = n^2
        //        Space O(n) = 1

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= target) {//there can be a single element with value >= target
                min = 1;
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = Integer.min(min, j - i + 1);
                    break;
                }
            }
        }


        return min == Integer.MAX_VALUE ? 0 : min;

    }
}
