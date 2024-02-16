package company.leadsquared;

import java.util.Arrays;

public class MaxProductOfThreeNumbersInAnArray {
    public static void main(String[] args) {
        Integer[] arr = {3, 55, 6, 75, 76, 7, -8, -200, -100};
//        Integer[] result = new Integer[3];

//        int[] nums = {1, -2, -3, 4, 5, 6};
        int[] nums2 = {3, 55, 6, 75, 76, 7, -8, -200, -100};
        System.out.println(findMaxProductOfThree(nums2));
        ;
/*        Arrays.sort(arr, (x, y) -> {
            int xAbs = Math.abs(x);
            int yAbs = Math.abs(y);

            return -Integer.compare(xAbs, yAbs);

        });*/


    }

    public static int findMaxProductOfThree(int[] nums) {
        // Initialize variables to track min/max values and their products
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            // Update minimum values and their product
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }

            // Update maximum values and their product
            if (num >= max3) {
                max1 = max2;
                max2 = max3;
                max3 = num;
            } else if (num >= max2) {
                max2 = max3;
                max3 = num;
            } else if (num >= max1) {
                max1 = num;
            }
        }

        // Return the maximum product based on min/max values
        return Math.max(min1 * min2 * max3, max1 * max2 * max3);
    }

}
