package com.dsa.leetcode.arrays_numbers.sorting;

import java.util.Arrays;

public class _179LargestNumber {

    public static void main(String[] args) {

        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }

    static public String largestNumber(int[] nums) {

//        String[] strNums = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            strNums[i] = String.valueOf(nums[i]);
//        }
//
//        Arrays.sort(strNums, (a, b) -> {
//            String order1 = a + b;
//            String order2 = b + a;
//            return order2.compareTo(order1);
//        });
//
//        if (strNums[0].equals("0")) return "0";
//
//        StringBuilder sb = new StringBuilder();
//        for (String strNum : strNums) {
//            sb.append(strNum);
//        }
//
//        return sb.toString();

//        Arrays.stream(nums).boxed().map(String::valueOf).sorted((a, b) -> (b + a).compareTo(a + b)).forEach(System.out::println);

        String res = Arrays.stream(nums).mapToObj(String::valueOf).
                sorted((a, b) -> (b + a).compareTo(a + b)).
                collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();

        if (res.charAt(0) == '0') return "0";
        else return res;


    }
}
