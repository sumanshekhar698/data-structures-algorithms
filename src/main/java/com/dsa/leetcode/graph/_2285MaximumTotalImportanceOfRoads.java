package com.dsa.leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _2285MaximumTotalImportanceOfRoads {

    public static void main(String[] args) {

        int n = 5, roads[][] = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
        System.out.println(maximumImportanceSuperOptimized(n, roads));
    }

//    public static long maximumImportanceUsingStreams(int n, int[][] roads) {
//        Map<Integer, Integer> cityDegrees = new HashMap<>();
//        for (int[] road : roads) {
//            cityDegrees.put(road[0], cityDegrees.getOrDefault(road[0], 0) + 1);
//            cityDegrees.put(road[1], cityDegrees.getOrDefault(road[1], 0) + 1);
//        }
//
//        long sum = 0;
//        for (int[] road : roads) {
//            sum += cityDegrees.get(road[0]) + cityDegrees.get(road[1]);
//        }
//        return sum;
//    }

    public static long maximumImportance(int n, int[][] roads) {
        //Using Greedy

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] road : roads) {
            int city1 = road[0];
            int city2 = road[1];
            map.put(city1, map.getOrDefault(city1, 0) + 1);
            map.put(city2, map.getOrDefault(city2, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).collect(Collectors.toList());
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : collect) {
            valueMap.put(entry.getKey(), n--);// becoming greedy as giving the highest value to the highest connections

        }


        long sum = 0;
        for (int[] road : roads) {
            int city1 = road[0];
            int city2 = road[1];

            sum += valueMap.get(city1);
            sum += valueMap.get(city2);

        }
        return sum;


    }

    public long maximumImportanceUsingArrays(int n, int[][] roads) {
        //nlogn
        long ans = 0;
        long[] count = new long[n];

        for (int[] road : roads) {
            final int u = road[0];
            final int v = road[1];
            ++count[u];
            ++count[v];
        }

        Arrays.sort(count);
        for (int i = 0; i < n; ++i)
            ans += (i + 1) * count[i];//value[least to high] * node_connections[low to high]

        return ans;
    }

    public static long maximumImportanceSuperOptimized(int n, int[][] roads) {
        int[] connections = new int[n];
        for(int[] r : roads){
            connections[r[0]]++;
            connections[r[1]]++;
        }

        int[] cnt = new int[n];
        for(int b : connections){
            cnt[b]++;
        }

        long sum = 0;
        long val = 1;
        for(long i = 0; i < n; i++){
            for(int j = 0; j < cnt[(int)i]; j++){
                sum += i*val++;
            }
        }
        return sum;
    }
}
