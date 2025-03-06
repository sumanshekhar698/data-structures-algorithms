package com.dsa.leetcode.matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class _2965_E_FindMissingAndRepeatedValues {


    public static void main(String[] args) {
        int[][] grid = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        int[] missingAndRepeatedValues = findMissingAndRepeatedValuesUsingArray(grid);
        System.out.println(Arrays.toString(missingAndRepeatedValues));

    }


    static public int[] findMissingAndRepeatedValuesUsingArray(int[][] grid) {//Best Perfomant


        int n = grid.length;
        int totalCells = n * n;
        int missing = -1, duplicate = -1;
        int[] counterArr = new int[totalCells + 1];


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                counterArr[grid[i][j]]++;
            }
        }

        for (int i = 0; i < counterArr.length; i++) {
            if (counterArr[i] == 2) {
                duplicate = i;
            }

            if (counterArr[i] == 0) {
                missing = i;
            }

        }

        return new int[]{duplicate, missing};

    }

    public static int[] findDuplicateAndMissing(int[][] grid) {
        int n = grid.length;
        int totalCells = n * n;
        int[] counterArr = new int[totalCells + 1];

        Arrays.stream(grid)
                .flatMapToInt(Arrays::stream)
                .forEach(num -> counterArr[num]++);

        int duplicate = -1, missing = -1;

        for (int i = 1; i <= totalCells; i++) {
            if (counterArr[i] == 2) {
                duplicate = i;
            } else if (counterArr[i] == 0) {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }


    static public int[] findMissingAndRepeatedValuesUsingHashSet(int[][] grid) {

        HashSet<Integer> set = new HashSet<>();
        int n = grid.length;

        int missing = 0;
        int duplicate = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (set.contains(grid[i][j])) {
                    duplicate = grid[i][j];
                }
                set.add(grid[i][j]);
            }
        }


        for (int num : set) {
            missing ^= num;
        }

        for (int i = 1; i <= n * n; i++) {
            missing ^= i;
        }

        return new int[]{duplicate, missing};

    }

    static public int[] findMissingAndRepeatedValuesUsingHashMap(int[][] grid) {


        int n = grid.length;
        int totalCells = n * n;
        int missing = 0, duplicate = 0;
        HashMap<Integer, Integer> map = IntStream.rangeClosed(1, totalCells)
                .boxed()
                .collect(HashMap::new, (hashMap, key) -> hashMap.put(key, 0), HashMap::putAll);

        // Use ConcurrentHashMap for thread safety in parallel streams
/*        IntStream.rangeClosed(1, totalCells)
                .parallel() // Enable parallel processing
                .boxed()
                .collect(ConcurrentHashMap::new, (cHashMap, key) -> cHashMap.put(key, 0), ConcurrentHashMap::putAll);*/

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                duplicate = entry.getKey();
            }

            if (entry.getValue() == 0) {
                missing = entry.getKey();
            }

        }

        return new int[]{duplicate, missing};

    }


}
