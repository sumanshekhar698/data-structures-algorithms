package com.gfg.arrays;

public class _01EquilibriumPointOptimized {

    public static void main(String[] args) {
        int nums[] = {4, 2, 3, 7, 5, 4};

//        findEquilibrium(nums);
        findEquilibriumOptimized(nums);

    }

    private static void findEquilibriumOptimized(int[] arr) {
        int requiredEIndex;
        int sum = 0;
        int leftSum = 0;

//		O(n) = 2n  = n = 2*6 = 12 loop iteration
        for (int i = 0; i < arr.length; i++) {// 6
            sum += arr[i];
        }

        System.out.println(sum);// 25

        for (int i = 0; i < arr.length; i++) {// 6
            sum -= arr[i];// calculating the right sum
            if (leftSum == sum) {
                requiredEIndex = i + 1;
                System.out.println("FOUND E index-> " + requiredEIndex);
            }
            leftSum += arr[i];

        }
    }

    private static void findEquilibrium(int[] arr) {
        int requiredEIndex;
        int leftSum, rightSum;

//		O(n) = n*n = n^2= 6^2=36 loop = n^2
        //Brute Force
        for (int i = 0; i < arr.length; i++) {// This will traverse through all the elements /indices // 6 times

            leftSum = 0;
            rightSum = 0;

            for (int j = 0; j < i; j++) {// find the sum left to i  | i =3 ; 3 times
                leftSum += arr[j];
            }

            for (int j = i + 1; j < arr.length; j++) {// find the sum right to i | i = 3 ;3 times
                rightSum += arr[j];
            }


//			6 times
            if (leftSum == rightSum) {// checking if the index is Eindex
                requiredEIndex = i + 1;
                System.out.println("FOUND E index-> " + requiredEIndex);
                break;
            }

        }
    }

}
