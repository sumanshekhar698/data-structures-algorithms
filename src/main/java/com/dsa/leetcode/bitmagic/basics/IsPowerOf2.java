package com.dsa.leetcode.bitmagic.basics;

public class IsPowerOf2 {
    public static void main(String[] args) {

        int n = 8;

        // 1st Approach using log
        double a = Math.log(n) / Math.log(2);// This calculates the logarithm of n in base 2.
        if (Math.ceil(a) == Math.floor(a))// This checks if the two rounded values of a are equal.
            System.out.println("Power of 2");
        else
            System.out.println("Not a power of 2");
//        Math.log(4);//

        // 44
//		2^n = 256


        //2nd Approach using bit manipulation
        int temp = n, count = 0;
        int result;


//        count will hold the number of set bits
        while (temp > 0) {// O(log n) because we are dividing the number by 2
            count += temp & 1;// using bitwise AND operator with 1 to check if the last bit is set or not
            temp = temp >> 1;//shifting the bits toward right by one place by using signed-right-shift-operator
        }

        if (count == 1)//any number that is power of 2 will have only and only ONE set bit
            System.out.println("Power of 2");
        else
            System.out.println("Not a power of 2");


    }
}
