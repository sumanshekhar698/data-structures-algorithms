package com.dsa.leetcode.trees;

import java.util.*;

public class _3372_M_MaximizeTheNumberOfTargetNodesAfterConnectingTreesI {

    public static void main(String[] args) {

        int[][] edges1 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}};
        int k = 2;

        System.out.println(Arrays.toString(maxTargetNodes(edges1, edges2, k)));

    }

    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {


        int nodeCountForTree1 = edges1.length + 1;
        int nodeCountForTree2 = edges2.length + 1;
        int[] res = new int[nodeCountForTree1];


        Map<Integer, List<Integer>> adjMapTree1 = buildAdjacencyMap(edges1);
//        System.out.println(adjMapTree1);
        Map<Integer, List<Integer>> adjMapTree2 = buildAdjacencyMap(edges2);
//        System.out.println(adjMapTree2);


        //        Part 1: Doing pre computation for Tree2
        int k_ = k - 1;
        int maxReachablityForTree2For_K = Integer.MIN_VALUE;

        for (Map.Entry<Integer, List<Integer>> nodeNeighbours : adjMapTree2.entrySet()) {
            Integer sourceNode = nodeNeighbours.getKey();
            int nodeCountTillLevel_K = bfsWithDepthLimit(adjMapTree2, sourceNode, k_);
            System.out.println("" + sourceNode + " | " + nodeCountTillLevel_K);
            maxReachablityForTree2For_K = Math.max(maxReachablityForTree2For_K, nodeCountTillLevel_K);
        }

        //        Part 2: Doing pre-computation for Tree1
        System.out.println("\nTree 2");
        for (Map.Entry<Integer, List<Integer>> nodeNeighbours : adjMapTree1.entrySet()) {
            Integer sourceNode = nodeNeighbours.getKey();
            int nodeCountTillLevelK = bfsWithDepthLimit(adjMapTree1, sourceNode, k);
            res[sourceNode] = nodeCountTillLevelK + maxReachablityForTree2For_K;
        }


        return res;
    }

    public static int bfsWithDepthLimit(Map<Integer, List<Integer>> adjMap, int startNode, int k) {
        Set<Integer> visited = new HashSet<>();
        Queue<NodeWithDepth> queue = new LinkedList<>();
        int nodeCountTillLevel_K = 0;

        visited.add(startNode);
        queue.add(new NodeWithDepth(startNode, 0)); // Depth starts from 1

        while (!queue.isEmpty()) {
            NodeWithDepth current = queue.poll();

            if (current.depth > k) {
                break; // Stop processing nodes beyond depth k
            }

            System.out.println("Node: " + current.node + " at Depth: " + current.depth);

            for (int neighbor : adjMap.getOrDefault(current.node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new NodeWithDepth(neighbor, current.depth + 1));
                }
            }
            ++nodeCountTillLevel_K;
        }
        return nodeCountTillLevel_K;
    }

    // Helper class to store node with depth
    static class NodeWithDepth {
        int node;
        int depth;

        NodeWithDepth(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static void bfs(Map<Integer, List<Integer>> adjMap, int startNode) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startNode);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int current = queue.poll();
//            System.out.print(current + " ");

            for (int neighbor : adjMap.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    static Map<Integer, List<Integer>> buildAdjacencyMap(int[][] edges) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjMap.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjMap.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        return adjMap;

    }
}
