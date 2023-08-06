package com.dsa.leetcode.arrays_numbers;

import java.util.Arrays;

public class _238ProductOfArrayExceptSelf {
//    https://leetcode.com/problems/product-of-array-except-self/

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] nums3 = {3, 6, 5, 2, 1};

        int[] ints = new Solution().productExceptSelfLinear(nums);
        System.out.println(Arrays.toString(ints));
    }


    static class Solution {

        public int[] productExceptSelf(int[] nums) {

//            time O(n)
//            space O(n)

            int tempProduct = 1;
            int n = nums.length;
            int result[] = new int[n];
            result[0] = 1;

//            Nums   {5, 2, 6, 4}
//            Result {1, 5, 10, 60}

            //left pass
            for (int i = 1; i < n; i++) {
                tempProduct *= nums[i - 1];
                result[i] = tempProduct;
            }

            tempProduct = 1;
            //right pass
            for (int i = n - 2; i >= 0; i--) {
                tempProduct *= nums[i + 1];
                result[i] *= tempProduct;
            }

            return result;
        }


        public int[] productExceptSelfLinear(int[] nums) {

//            time O(n)*3
//            space O(n)*3

            //{1, 2, 3, 4};
            int n = nums.length;
            int prefix[] = new int[n];//prefix Multiple
            int suffix[] = new int[n];//suffix multiple
            int result[] = new int[n];

            //Prefix   {1,2,6,24}
            //Nums     {2,3,4,5}
            //Suffix   {60,20,5,1}

            prefix[0] = 1;
            suffix[n - 1] = 1;

            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] * nums[i - 1];
            }

            System.out.println("MUL PRE=> " + Arrays.toString(prefix));


            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] * nums[i + 1];
            }

//            System.out.println("MUL SUF=> " + Arrays.toString(suffix));

            for (int i = 0; i < n; i++) {
                result[i] = prefix[i] * suffix[i];
            }



            System.out.println("PRE => " + Arrays.toString(prefix));
            System.out.println("SUF => " + Arrays.toString(suffix));
            System.out.println("MUL RES=> " + Arrays.toString(result));

            return result;
        }

        public int[] productExceptSelfERROR(int[] nums) {


            int[] result = new int[nums.length];
            int product = 1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)
                    continue;
                product *= nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)
                    result[i] = product;
                else
                    result[i] = product / nums[i];
            }

            return result;

        }
    }
}
