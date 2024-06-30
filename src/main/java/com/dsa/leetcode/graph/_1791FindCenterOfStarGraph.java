package com.dsa.leetcode.graph;

import java.util.*;

public class _1791FindCenterOfStarGraph {
    public static void main(String[] args) {

    }

    public int findCenter(int[][] edges) {
        //evey number in the 1D array is a node

        Set<Integer> nodesTraversed = new HashSet<Integer>();
//        Set<Integer> nodesTraversed = new HashSet<Integer>();

        for (int[] edge : edges) {

            if (nodesTraversed.contains(edge[0])) {
                return edge[0];
            }
            nodesTraversed.add(edge[0]);

            if (nodesTraversed.contains(edge[1])) {
                return edge[1];
            }
            nodesTraversed.add(edge[1]);
        }

        return -1;


    }

    public int findCenterUsingHashMap(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.putIfAbsent(edges[i][0], new ArrayList<>());
            map.putIfAbsent(edges[i][1], new ArrayList<>());

            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        for (int ans : map.keySet()) {
            int n = map.keySet().size() - 1;
            int noOfVertices = map.get(ans).size();
            if (noOfVertices == n)
                return ans;
        }
        return 0;
    }
}
