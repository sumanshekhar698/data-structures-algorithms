package company.walmart;

public class MaxSumSubarray {

    public static void findMaxSumSubarray(int[] arr) {
        // Handle empty array case
        if (arr.length == 0) {
            System.out.println("The array is empty.");
            return;
        }

        // Initialize variables
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int currentSum = 0;
        int currentStart = 0;

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Add the current number to the current sum
            currentSum += arr[i];

            // If the current sum is greater than the maximum sum, update the maximum sum and its starting and ending indices
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = currentStart;
                end = i;
            }

            // If the current sum is negative, reset it and its starting index
            if (currentSum < 0) {
                currentSum = 0;
                currentStart = i + 1;
            }
        }

        System.out.println(maxSum);
        // Print the results
        System.out.printf("Maximum sum subarray: [");
        for (int i = start; i <= end; i++) {
            System.out.printf("%d, ", arr[i]);
        }
        System.out.println("\b]");
        System.out.println("Starting index: " + start + ", Ending index: " + end);
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, -2, 3, -7, 0, 1, 8};
        int[] arr2 = {1, 7, -2, -7, 0, 1, 8};
        findMaxSumSubarray(arr2);
    }
}