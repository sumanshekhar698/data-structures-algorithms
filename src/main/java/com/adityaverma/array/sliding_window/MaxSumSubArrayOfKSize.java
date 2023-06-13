package com.adityaverma.array.sliding_window;

public class MaxSumSubArrayOfKSize {

//    identification ---> repetitive work | subarray max/min sum | k |

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] arr = {16, 47, 75, 46, 72, 64, 76, 38, 22, 78, 28, 97, 5};

        int[] arr1 = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int ans = maxSumNaive(arr1, 4);
        System.out.println(ans+"\n");

        ans = maxSumOptimizedLinearSlidingWindow(arr1, 4);
        System.out.println(ans);

        ans = maxSumOptimizedLinearSlidingWindow(arr1, 4);
        System.out.println(ans);

    }

    private static int maxSumOptimizedLinearSlidingWindow(int[] arr, int windowSize) {
        // TODO Auto-generated method stub

        int sum = 0;
        if (arr.length < windowSize)
            return -1;

        for (int i = 0; i < windowSize; i++) {
            sum += arr[i];
        }
//        System.out.println(sum);

        int maxSum = sum;
        for (int i = 1; i < arr.length - windowSize; i++) {
            maxSum = Integer.max(sum - arr[i - 1] + arr[i + windowSize - 1], maxSum);
//            System.out.println(maxSum);
        }

        return maxSum;
    }

    private static int maxSumNaive(int[] arr, int windowSize) {
//		int windowSize = 3;
        int sum;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length - windowSize; i++) {

            int j = i;
            int count = 0;
            sum = 0;
            while (count < windowSize) {
                sum += arr[j++];
                ++count;
            }
            maxSum = Integer.max(sum, maxSum);

        }
        return maxSum;
    }

}
