package com.dsa.leetcode.graph.directed;

import java.util.*;

public class _1857_H_LargestColorValueInADirectedGraph {

    public static void main(String[] args) {

        _1857_H_LargestColorValueInADirectedGraph ques = new _1857_H_LargestColorValueInADirectedGraph();

        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {3, 4}};

        String colors = "abaca";
        int res = ques.largestPathValue(colors, edges);
        System.out.println(res);


    }


    /*Find the path in the graph that Maximizes the most frequent colors
     * Intution 1: We can run a DFS on every node
     * Intution 2: We can run a DFS on every node with memoization
     * O(n) n nodes+ m edges
     * */

    public int largestPathValue(String colors, int[][] edges) {
        int numberOfNodes = colors.length();
        int res = 0;

        // Adjacency List
        Map<Integer, List<Integer>> adjacencylist = buildAdjacencyList(edges, numberOfNodes);
        HashSet<Integer> visit = new HashSet<>();
        HashSet<Integer> path = new HashSet<>();
        int[][] countTable = new int[numberOfNodes][26];//[node][color] = maxFreqColor among all the neighbors
        // 26 because there are total 26 small case letters denoting colors in this case


        class DFS {

            int dfs(int node) {
                if (path.contains(node))// this if condition should be 1st
                    return Integer.MAX_VALUE;
                if (visit.contains(node))
                    return 0;
//                if(path.contains(node))
//                    return -1;

                visit.add(node);
                path.add(node);

                /* a -> 0
                 * b -> 1 ...
                 * z -> 25*/
                int colorIndex = colors.charAt(node) - 'a';
                countTable[node][colorIndex] = 1;

                List<Integer> neighbours = adjacencylist.get(node);
                for (int neighbour : neighbours) {
                    if (dfs(neighbour) == Integer.MAX_VALUE) {//populated countTable
                        return Integer.MAX_VALUE;
                    }
                    for (int c = 0; c < 26; c++) {
                        countTable[node][c] = Math.max(countTable[node][c],
                                (c == colorIndex ? 1 : 0) + countTable[neighbour][c]);
                    }

                }

                // we will not remove from teh visited, as we dont want to visit ever again
                path.remove(node);
                return findMax(countTable[node]);
            }
        }

        DFS dfsObj = new DFS();


        for (int i = 0; i < numberOfNodes; i++) {// i is node Index
            res = Math.max(dfsObj.dfs(i), res);
        }

        return res == Integer.MAX_VALUE ? -1 : res;


    }


    /**
     * Builds an adjacency list from a given array of edges.
     * Each edge is represented as an array of two integers: [source, destination].
     *
     * @param edges A 2D array where each inner array represents a directed edge.
     * @return A HashMap representing the adjacency list, where keys are source vertices
     * and values are lists of their direct neighbors (destinations).
     */
    public Map<Integer, List<Integer>> buildAdjacencyListDirected(int[][] edges) {
        // Initialize the HashMap to store the adjacency list.
        // Using Map interface for the variable type is generally good practice.
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        // Iterate through each edge in the input array.
        for (int[] edge : edges) {
            int source = edge[0];      // The starting vertex of the directed edge.
            int destination = edge[1]; // The ending vertex of the directed edge.

            // The computeIfAbsent method is used here for conciseness and elegance.
            // It checks if 'source' (edge[0]) is already a key in the adjacencyList.
            // If 'source' is NOT present, it creates a new ArrayList (using the lambda 'k -> new ArrayList<>()')
            // and associates it with 'source', then returns this new list.
            // If 'source' IS present, it simply returns the existing List associated with 'source'.
            // In either case, the returned List (either new or existing) is then used to add the 'destination' (edge[1]).
            adjacencyList.computeIfAbsent(source, keySource -> new ArrayList<>()).add(destination);
        }

        return adjacencyList;
    }

    public int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            // Handle empty or null array case.
            // You can throw an IllegalArgumentException, return a specific value
            // like Integer.MIN_VALUE, or handle it as per your application's logic.
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        int max = arr[0]; // Assume the first element is the maximum
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // Update max if a larger element is found
            }
        }
        return max;
    }

    /**
     * Builds an adjacency list from a given array of edges.
     * Each edge is represented as an array of two integers: [source, destination].
     *
     * @param edges A 2D array where each inner array represents a directed edge.
     * @return A HashMap representing the adjacency list, where keys are source vertices
     * and values are lists of their direct neighbors (destinations).
     */
    public Map<Integer, List<Integer>> buildAdjacencyList(int[][] edges, int n) {
        // Initialize the HashMap to store the adjacency list.
        // Using Map interface for the variable type is generally good practice.
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        // Iterate through each edge in the input array.
        for (int[] edge : edges) {
            int source = edge[0];      // The starting vertex of the directed edge.
            int destination = edge[1]; // The ending vertex of the directed edge.

            // The computeIfAbsent method is used here for conciseness and elegance.
            // It checks if 'source' (edge[0]) is already a key in the adjacencyList.
            // If 'source' is NOT present, it creates a new ArrayList (using the lambda 'k -> new ArrayList<>()')
            // and associates it with 'source', then returns this new list.
            // If 'source' IS present, it simply returns the existing List associated with 'source'.
            // In either case, the returned List (either new or existing) is then used to add the 'destination' (edge[1]).
            adjacencyList.computeIfAbsent(source, keySource -> new ArrayList<>()).add(destination);
        }


        // After processing all edges, ensure all 'n' nodes (from 0 to n-1) are present.
        // If a node was not a source in any edge, it won't be in the map yet.
        // putIfAbsent will add it with an empty list only if it's not already present.
        for (int i = 0; i < n; i++) {
            adjacencyList.putIfAbsent(i, new ArrayList<>());
        }

        return adjacencyList;
    }
}
