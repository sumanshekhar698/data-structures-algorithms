package com.dsa.leetcode.arrays_numbers;

import java.util.Arrays;

public class _88MergeSortedArray_E {

    public static void main(String[] args) {


        //Variation 1
        int nums1[] = {1, 2, 3, 8, 9};
        int nums2[] = {2, 5, 6, 14};

//        mergeAndFillVariationNaive(nums1, nums2);
//        mergeAndFillVariationUsingInsertionSort(nums1, nums2);
        mergeAndFillVariationOptimizedViaGAPAlgo(nums1, nums2);

    }


    /*You are given two integer arrays nums1 and nums2,
    sorted in non-decreasing order, and two integers m and n,
    representing the number of elements in nums1 and nums2 respectively.
    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    The final sorted array should not be returned by the function,
    but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
    and the last n elements are set to 0 and should be ignored. nums2 has a length of n.*/
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

//        len nums1 = m+n


    }


    public static void mergeAndFillVariationNaive(int[] nums1, int[] nums2) {//variation

        //O(nlogn + n + n ) = O(nlogn) time | O(n) space
//        First merge and the fill form nums1 and then nums2
        System.out.println(Arrays.toString(nums1) + Arrays.toString(nums2));
        int i = 0;
        int[] result = new int[nums1.length + nums2.length];
        for (int num : nums1) {
            result[i++] = num;
        }
        for (int num : nums2) {
            result[i++] = num;
        }

        Arrays.sort(result);

        int j = 0;
        for (; j < nums1.length; j++) {
            nums1[j] = result[j];
        }

        for (int k = 0; k < nums2.length; k++) {
            nums2[k] = result[j++];
        }
        System.out.println(Arrays.toString(nums1) + Arrays.toString(nums2));
    }

    //TO DO
    public static void mergeAndFillVariationUsingInsertionSort(int[] nums1, int[] nums2) {//variation

        //O( m + n ) = time m for traversal and say n for reordering nums2 (conditoned all the elements in nums1 are greater than nums2)| O(1) space
//        First merge and the fill form nums1 and then nums2
        System.out.println(Arrays.toString(nums1) + Arrays.toString(nums2));

        int temp;
        int j = 0;//this will point to nums2 later
        for (int i = 0; i < nums1.length; i++) {//traversing on any array say 1st
            if (nums1[i] > nums2[0]) {//modification required
                // we will compare with the oth element of nums2 as all the element in num1 will come before num2[0]
                temp = nums1[i];//swapping
                nums1[i] = nums2[0];
                nums2[0] = temp;

                //
                int first = nums2[0], k;
                for (k = 1; k < nums2.length && nums2[k] < first; k++) {//reordering nums2[] via insertion sort
                    //the loop will run till the array is unsorted ; means it will run till the moment such
                    // that  before index k ~ that will hold $first  element and after that everything is is in order
                    nums2[k - 1] = nums2[k];
                }
                nums2[k - 1] = first;//adding the $first to its position
            }
        }

        System.out.println(Arrays.toString(nums1) + Arrays.toString(nums2));
    }

    public static void mergeAndFillVariationOptimizedViaGAPAlgo(int[] nums1, int[] nums2) {//variation

        int m = nums1.length;
        int n = nums2.length;

        System.out.println(Arrays.toString(nums1) + Arrays.toString(nums2));

//        int gap = (int) Math.ceil((nums1.length + nums2.length) / 2.0);//setting initial gap value CEIL
        int gap = m + n;//will be used in gap evaluation

        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {//setting the gap traversal

            System.out.println(gap);
//            Traversal in num1


//            Traversal in num2 and num3



//            Traversal in num 2



        }

        System.out.println(Arrays.toString(nums1) + Arrays.toString(nums2));


    }

    // Function to find next gap.
    private static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);//clever way of getting the ceil value
    }

}
