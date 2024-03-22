package company.accolite;

import java.util.Arrays;

public class EquilibriumPoint {
    public static void main(String[] args) {

        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        int res = findEquilibriumPoint(arr);
        System.out.println(res);
        res = findEquilibrium(arr);
        System.out.println(res);
    }

    private static int findEquilibrium(int[] arr) {//-7, 1, 5, 2, -4, 3, 0]


        int n = arr.length;
        int[] prefixSumArray = new int[arr.length];
        prefixSumArray[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + arr[i];
        }

        System.out.println(Arrays.toString(prefixSumArray));//[-7, -6, -1, 1, -3, 0, 0]

        for (int i = 1; i < arr.length; i++) {
            int leftSum = prefixSumArray[i - 1];
            int rightSum = prefixSumArray[n - 1] - prefixSumArray[i];
//            System.out.println( Math.abs(leftSum)+" "+Math.abs(rightSum));
            if (leftSum == rightSum)
                return i;
        }


        return -1;


    }

    public static int findEquilibriumPoint(int[] arr) {
        int n = arr.length;

        // Calculate the sum of the entire array.
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // Iterate through the array and check for equilibrium point.
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            // Current element is part of both left and right sum, so exclude it.
            int rightSum = sum - arr[i] - leftSum;

            if (leftSum == rightSum) {
                return i; // Equilibrium point found!
            }

            leftSum += arr[i];
        }

        // If no equilibrium point is found, return -1.
        return -1;
    }
}
