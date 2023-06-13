package com.gfg.arrays;

import java.util.*;

public class MaxSumFromSubArraysinArrayGFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }

        int[] arr = {3, 4, 2, 1};
        HashSet<Pair> allPairs = findPairs(arr);

//        System.out.println(allPairs);
        int max = Integer.MIN_VALUE;
        for (Pair p : allPairs) {
            if (p.second - p.first > max)
                max = p.second - p.first;

        }

        System.out.println(max);

    }


    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + first;
            result = prime * result + second;
            return result;
        }

        @Override
        public String toString() {
            return "pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;

            Pair other = (Pair) obj;
            if (first != other.first)
                return false;
            if (second != other.second)
                return false;
            return true;
        }
    }

    // Function to return the set of pairs
    static HashSet<Pair> findPairs(int[] arr) {
        Stack<Integer> st = new Stack<Integer>();
        HashSet<Pair> pairs = new HashSet<Pair>();

        // Push first element into stack
        st.add(arr[0]);

        // For each element 'X' in arr,
        // pop the stack while top Element
        // is smaller than 'X' and form a pair.
        // If the stack is not empty after
        // the previous operation, create
        // a pair. Push X into the stack.
        for (int i = 1; i < arr.length; ++i) {
            while (!st.isEmpty() && arr[i] > st.peek()) {
                pairs.add(new Pair(st.peek(),
                        arr[i]));
                st.pop();
            }
            if (!st.isEmpty()) {
                pairs.add(new Pair(Math.min(st.peek(),
                        arr[i]),
                        Math.max(st.peek(),
                                arr[i])));
            }
            st.add(arr[i]);
        }
        return pairs;
    }


}