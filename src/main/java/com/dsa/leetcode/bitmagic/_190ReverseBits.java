package com.dsa.leetcode.bitmagic;

public class _190ReverseBits {
    //    https://leetcode.com/problems/reverse-bits/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {


        int n = 11;// 00000000 00000000 00000000 00001011

        int temp = n, bit;
        // Approach 1: Using AND OR bitwise operator


        int result = 0;//O(1)
        for (int i = 0; i <= 31; i++) {// 32 bits in an integer and starting from i=0
            // because in the first iteration we are checking the last bit withour shifting the bits of temp

            bit = (temp >> i) & 1;//shifting the bits of temp to right by i places and then AND with 1 to get the last bit
            result = result | (bit << (31 - i));//shifting the bit to left by 31-i places and then OR with result


//            result = result << 1;//shifting the result to left by 1 place
//            if ((temp & 1) == 1)//checking if the last bit is set or not
//                result = result ^ 1;//if set then XOR with 1 to set the last bit of result
//            temp = temp >> 1;//shifting the bits of temp to right by 1 place

        }
        System.out.println(result);


//        result = 0;
//        temp = n;
//        while (n > 0) {
//            result = result << 1;
//            if ((n & 1) == 1)
//                result = result ^ 1;
//            n = n >> 1;
//        }
//
//        System.out.println(result);
    }
}
