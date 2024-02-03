package com.dsa.leetcode.maths;

import java.util.ArrayList;
import java.util.List;

public class _1291SequentialDigits {

    public static void main(String[] args) {

        List<Integer> integers = sequentialDigits(100, 300);
        System.out.println(integers);


    }

    public static List<Integer> sequentialDigits(int low, int high) {

        ArrayList<Integer> numbers = new ArrayList<>();
        int numberOfDigitsInLow = (int) Math.log10(low) + 1;
        int numberOfDigitsInHigh = (int) Math.log10(high) + 1;


        for (int i = numberOfDigitsInLow; i <= numberOfDigitsInHigh; i++) {//check for all the numbers with i digits

            for (int j = 1; j <= 9 - i + 1; j++) {//check for all the numbers starting from 1 to 9-i+1 because say i = 3, we canot start with 8 or 9

                int num = 0;
//                for (int k = 0; k < i; k++) {
//                    num = num * 10 + (j + k);
//                }
                for (int k = j; k < j + i; k++) {
                    num = num * 10 + k;//this is the correct way to do it
                }
                if (inRange(low, high, num)) {
                    numbers.add(num);
//                    System.out.println(num);
                }
            }
        }

        return numbers;

    }

    static boolean inRange(int low, int high, int num) {
        return num >= low && num <= high;
    }
}
