package com.gfg.arrays;

import java.util.*;

public class MaxSumFromSubArraysinArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }

        int[] arr = {3, 4, 2, 1};

//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int max = Integer.MIN_VALUE;
//                int secondMax = Integer.MIN_VALUE;
//                for (int k = i; k <= j; k++) {
//                    if (a[k] > max) {
//                        secondMax = max;
//                        max = a[k];
//                    } else if (a[k] > secondMax) {
//                        secondMax = a[k];
//                    }
//                }
//                set.add(max - secondMax);
//            }
//        }
//
//        System.out.println(set.size());

        Stack<Integer> st = new Stack<Integer>();

        // Push first element into stack
        st.add(arr[0]);

        // For each element 'X' in arr,
        // pop the stack while top Element
        // is smaller than 'X' and form a pair.
        // If the stack is not empty after
        // the previous operation, create
        // a pair. Push X into the stack.

        HashMap<Integer, Integer> pairs = new HashMap<>();
        for (int i = 1; i < arr.length; ++i) {

            while (!st.isEmpty() && arr[i] > st.peek()) {
                pairs.put(st.peek(), arr[i]);
                st.pop();
            }
            if (!st.isEmpty()) {
                pairs.put(Math.min(st.peek(), arr[i]), Math.max(st.peek(), arr[i]));
            }
            st.add(arr[i]);
        }


        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e : pairs.entrySet()) {
            if (e.getKey() - e.getValue() > max)
                max = e.getKey() - e.getValue();

        }

        System.out.println(max);


//            return pairs;
    }

}