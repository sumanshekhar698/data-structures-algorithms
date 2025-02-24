package com.dsa.leetcode.arrays_numbers.sorting;

import java.util.Random;

public class _912SortAnArray {

    public static void main(String[] args) {
        _912SortAnArray sortAnArray = new _912SortAnArray();
        int[] nums = {5, 2, 3, 1};
        int[] result = sortAnArray.sortArray(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums, low, high);
            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);

        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];// Choose the last element as the pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    class ImprovedQuickSort {
        private final Random random = new Random();

        private void quickSort(int[] nums, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(nums, low, high,
                        choosePivot(nums, low, high));
                quickSort(nums, low, pivotIndex - 1);
                quickSort(nums, pivotIndex + 1, high);
            }
        }

        private int partition(int[] nums, int low, int high, int pivot) {
            int pivotValue = nums[pivot];
            swap(nums, pivot, high); // Move pivot to the end
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (nums[j] <= pivotValue) {
                    i++;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, high);
            return i + 1;
        }

        private int choosePivot(int[] nums, int low, int high) {
            // Random pivot selection
            //   return random.nextInt(high - low + 1) + low;

            // Median-of-three pivot selection
            int mid = low + (high - low) / 2;
            if (nums[low] > nums[mid]) {
                swap(nums, low, mid);
            }
            if (nums[mid] > nums[high]) {
                swap(nums, mid, high);
            }
            if (nums[low] > nums[mid]) {
                swap(nums, low, mid);
            }
            return
                    mid;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    class MergeSort {

        public int[] sortArray(int[] nums) {
            int[] temp = new int[nums.length];
            mergeSort(nums, temp, 0, nums.length - 1);
            return nums;
        }

        private void mergeSort(int[] nums, int[] temp, int left, int right) {
            if (left < right) {
                int mid = left + (right - left) / 2;
                mergeSort(nums, temp, left, mid);
                mergeSort(nums, temp, mid + 1, right);
                merge(nums, temp, left, mid, right);
            }
        }

        private void merge(int[] nums, int[] temp, int left, int mid, int
                right) {
            System.arraycopy(nums, left, temp, left, right - left + 1);
            int i = left;
            int j = mid + 1;
            int k = left;

            while (i <= mid && j <= right) {
                if (temp[i] <= temp[j]) {
                    nums[k++] = temp[i++];
                } else {
                    nums[k++] = temp[j++];
                }
            }

            while (i <= mid) {
                nums[k++] = temp[i++];
            }

            while (j <= right) {
                nums[k++] = temp[j++];

            }
        }
    }

    class CountingSort {
        public int[] sortArray(int[] nums) {
            int max = nums[0];
            int min = nums[0];

            for (int num : nums) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }

            // since we are using counting sort, we want an array in which count of each element can be incremented, so k + 1 would be the lowest possible size for the array.
            int k = max - min;
            int[] arr = new int[k + 1];

            // now increment the count of each element relative to the min value
            for (int num : nums) {
                arr[num - min]++;
            }

            int ind = 0;

            // populate the nums array by putting values from sorted array arr
            for (int i = 0; i <= k; i++) {
                while (arr[i] > 0) {
                    nums[ind] = min;
                    ind++;
                    arr[i]--;
                }

                min++;
            }

            return nums;
        }
    }
}


