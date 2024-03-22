package company.samsung;

import java.util.Arrays;

public class Sort012 {

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 0, 2, 1, 2, 1, 2, 1, 0, 1, 2, 1}, arr2 = arr.clone();

        sortArrayCounting(arr);
        System.out.println(Arrays.toString(arr));

        sortArrayDutchFlag(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public static void sortArrayCounting(int[] arr) {// (Efficient for Smaller Arrays)
        int n = arr.length;
        int[] count = new int[3]; // 0s, 1s, 2s

        // Count occurrences of each element
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Fill the array with sorted elements
        int index = 0;//global index
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[index++] = i;
            }
        }
    }



    /*You're absolutely right! In the Dutch National Flag (DNF) algorithm for sorting arrays of 0s, 1s, and 2s, we don't increment mid when we encounter a 2 (case 2 in the switch statement). Here's why:

Understanding the Roles of the Pointers:

low: Points to the last processed element that is either 0 or 1, effectively separating the "0s" and "1s" partition.
mid: Points to the currently processed element.
high: Points to the last element in the unsorted partition.
Handling 2s:

When we encounter a 2 at mid:

Swap it with the element at high: This places the 2 in its correct position at the end of the unsorted partition (rightmost section).
Decrement high: Since the swapped element is no longer relevant to the ongoing processing, we shrink the unsorted partition.
Why not increment mid?

The swapped element at the original mid-position might still be unknown (0, 1, or 2). We need to process it further to determine its correct placement.
Incrementing mid prematurely would skip its processing, potentially leading to errors in the sorting.
Key Points:

The mid-pointer stays in place to ensure all elements after swapping with a 2 are eventually examined.
Once all unknown elements are processed (when mid reaches high), the algorithm terminates, and all elements are correctly sorted.
Additional Notes:

This behavior is specific to the case of handling 2s. When encountering 0s and 1s, the mid pointer might be incremented depending on the situation.
The DNF algorithm is efficient for sorting arrays with a limited number of unique values (in this case, 0, 1, and 2) in linear time (O(n)).
I hope this explanation clarifies why mid isn't incremented in case 2!*/

    public static void sortArrayDutchFlag(int[] arr) {
//        {1, 0, 0, 0, 2, 1, 2, 1, 2, 1, 0, 1, 2, 1}
        int low = 0;//for 0
        int mid = 0;//for 1
        int high = arr.length - 1;
        /*low: Points to the last processed element that is either 0 or 1, effectively separating the "0s" and "1s" partition.
        mid: Points to the currently processed element.
        high: Points to the last element in the unsorted partition.*/

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }


    // Helper function for swapping elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
