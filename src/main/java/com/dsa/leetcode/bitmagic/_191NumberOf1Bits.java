package com.dsa.leetcode.bitmagic;

public class _191NumberOf1Bits {
//    https://leetcode.com/problems/number-of-1-bits/?envType=study-plan-v2&envId=top-interview-150
//    https://leetcode.com/problems/number-of-1-bits/solutions/3832027/easy-optimal-solution-in-java-in-o-1-time-and-space/
    public static void main(String[] args) {
        int x = 9, bit, count = 0;

        for (int i = 0; i <= 31; i++) {// 32 bits in an integer and starting from i=0

            bit = (x >> i) & 1;//shifting the bits of temp to right by i places and then AND with 1 to get the last bit
            if (bit == 1)
                count++;
        }

        System.out.println(count);//hammingWeight



//        int count=0;
//        while(n!=0){
//            int last_bit= n & 1; //Stores the value of the last bit of the number n i.e.(1 or 0)
//            count+= last_bit; // adds 0 if last bit is 0 and adds 1 if last bit is 1
//            n = n>>>1;  //Dropping the last bit of the binary number n
//        }
//        return count;


    }

}
