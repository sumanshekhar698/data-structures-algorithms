package com.dsa.leetcode.backtracking;

public class _1780CheckIfNumberIsASumOfPowersOfThree {

    public static void main(String[] args) {

        boolean b = new _1780CheckIfNumberIsASumOfPowersOfThree().checkPowersOfThreeUsingBackTracking(12);
        System.out.println(b);

    }

    public boolean checkPowersOfThree(int n) {

        int i = 0;

//        1. Find largest i such that 3^1 <= n
        while (n >= (int) (Math.pow(3, i))) {
            i++;
        }
        --i;// as 'i' is incremented one extra time after the above while loops breaks

//        2. Greedy, Remove Largest Powers
        int n$ = n;
        while (i >= 0) {// wea re going from i to 0 as we cannot form the number without including the tha largest number
            int pow = (int) (Math.pow(3, i));
            if (pow <= n$) {
                n$ -= pow;// we are substring on a possibility to reach 0
            }
            if (pow <= n$) {//side trick to speed up algo
                return false;// if n$ is still higher than pow or Equal
                // (a sum of all the remaining power will still be less than pow, so it wil never reach equality): return false
            }

            --i;
        }

        return n$ == 0;


    }

    public boolean checkPowersOfThreeUsingBackTracking(int n) {

        class Check {
            boolean check(int i, int currSum) {
                if (currSum == n) {//this condition should be above the second if condition as is currSum = n then also (currSum + Math.pow(3, i)) > n) =>  true
                    return true;
                }

                if (currSum > n || (int) (currSum + Math.pow(3, i)) > n) {
                    //1st condition checks for is sum exceeds n
                    //2nd condition checks not to go further if 3^i exceeds n as there is no possibility going further to reach a sum of n
                    return false;
                }

                int newSum = (int) (currSum + Math.pow(3, i));

                //1. including the newSum in the decision tree
                if (check(i + 1, newSum))
                    return true;

                //2. NOT including the newSum in the decision tree
                return check(i + 1, currSum);


            }
        }

        return new Check().check(0, 0);//starting with i=0 level and currSum = 0

    }


}
