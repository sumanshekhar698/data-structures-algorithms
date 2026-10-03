package com.dsa.leetcode.greedy;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class _M_1733_MinimumNumberOfPeopleToTeach {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        HashSet<Integer> setOfUsersWhoCannotCommunicate = new HashSet<>();

        boolean canCommunicate;
        for (int[] friendship : friendships) {
            canCommunicate = false;


            int u = friendship[0];
            int v = friendship[1];


            int[] languageU = languages[u - 1];
            int[] languageV = languages[v - 1];

            canCommunicate = hasCommonLanguage(languageU, languageV);

            if (!canCommunicate) {
                setOfUsersWhoCannotCommunicate.add(u - 1);
                setOfUsersWhoCannotCommunicate.add(v - 1);
            }


        }

        if (setOfUsersWhoCannotCommunicate.isEmpty()) {
            return 0;
        }

        int[] count = new int[n + 1];
        for (Integer user : setOfUsersWhoCannotCommunicate) {
            for (int lang : languages[user]) {
                count[lang]++;
            }
        }


        int maxCount = Arrays.stream(count).max().getAsInt();

        return setOfUsersWhoCannotCommunicate.size() - maxCount;


    }

    /**
     * Checks if there is a common number between two integer arrays using Java Streams.
     *
     * @param arr1 The first integer array.
     * @param arr2 The second integer array.
     * @return true if a common number is found, false otherwise.
     */
    public static boolean hasCommonLanguage(int[] arr1, int[] arr2) {
        // First, collect all elements from the first array into a HashSet.
        // The `boxed()` method is used to convert the primitive `int` stream to an `Integer` stream,
        // as `Set` requires object types.
        Set<Integer> set1 = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.toSet());

        // Then, use the `anyMatch` stream operation on the second array.
        // It returns true as soon as it finds an element that is present in `set1`,
        // and short-circuits (stops processing) immediately.
        return Arrays.stream(arr2)
                .boxed()
                .anyMatch(set1::contains);
    }


    public int minimumTeachingsUsingBitSet(int n, int[][] L, int[][] F) {
        BitSet[] bit = new BitSet[L.length];
        Arrays.setAll(bit, o -> new BitSet(n + 1));
        for (int i = 0; i < L.length; i++) {
            for (int l : L[i]) {
                bit[i].set(l);
            }
        }
        Set<Integer> teach = new HashSet<>();
        for (int[] f : F) {
            BitSet t = (BitSet) bit[f[0] - 1].clone();
            t.and(bit[f[1] - 1]);
            if (t.isEmpty()) {
                teach.add(f[0] - 1);
                teach.add(f[1] - 1);
            }
        }
        int[] count = new int[n + 1];
        for (int person : teach) {
            for (int l : L[person]) {
                count[l]++;
            }
        }

        return teach.size() - Arrays.stream(count).max().getAsInt();
    }
}
