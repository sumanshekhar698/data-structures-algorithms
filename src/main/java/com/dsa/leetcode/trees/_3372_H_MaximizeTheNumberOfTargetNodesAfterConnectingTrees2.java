package com.dsa.leetcode.trees;

import java.util.*;

public class _3372_H_MaximizeTheNumberOfTargetNodesAfterConnectingTrees2 {

    public static void main(String[] args) {

        int[][] edges1 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}};

        System.out.println(Arrays.toString(maxTargetNodes(edges1, edges2)));

    }

    private static int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int nodeCountForTree1 = edges1.length + 1;
        int nodeCountForTree2 = edges2.length + 1;
        int[] res = new int[0];


        Map<Integer, List<Integer>> adjMapTree1 = buildAdjacencyMap(edges1);
        Map<Integer, List<Integer>> adjMapTree2 = buildAdjacencyMap(edges2);

        //        Part 1: Doing pre-computation for Tree2
        Optional<Map.Entry<Integer, List<Integer>>> firstSourceNodeInTree2 = adjMapTree2.entrySet().stream().findFirst();

        int totalNodeAtEvenLevelForTree2 = 0;
        if (firstSourceNodeInTree2.isPresent()) {
            Map.Entry<Integer, List<Integer>> sourceNode = firstSourceNodeInTree2.get();
            totalNodeAtEvenLevelForTree2 = bfsWithNodeCountForEvenLevels(adjMapTree2, sourceNode.getKey());
        }

        int totalNodeAtOddLevelForTree2 = nodeCountForTree2 - totalNodeAtEvenLevelForTree2;//Observation
        int maxOptimalNodeCountForEvenTarversalTree2 = Math.max(totalNodeAtOddLevelForTree2, totalNodeAtEvenLevelForTree2);


        //        Part 2: Doing pre-computation for Tree1
        Optional<Map.Entry<Integer, List<Integer>>> firstSourceNodeInTree1 = adjMapTree1.entrySet().stream().findFirst();

        int totalNodeAtEvenLevelForTree1 = 0;
        if (firstSourceNodeInTree1.isPresent()) {
            Map.Entry<Integer, List<Integer>> sourceNode = firstSourceNodeInTree1.get();
            totalNodeAtEvenLevelForTree1 = bfsWithNodeCountForEvenLevels(adjMapTree1, sourceNode.getKey());
            int totalNodeAtOddLevelForTree1 = nodeCountForTree1 - totalNodeAtEvenLevelForTree1;//Observation
            res = computeBFSMaximalNodeCountForTree1(sourceNode.getKey(), adjMapTree1, totalNodeAtEvenLevelForTree1,
                    totalNodeAtOddLevelForTree1, maxOptimalNodeCountForEvenTarversalTree2);

        }

        return res;
    }

    private static int[] computeBFSMaximalNodeCountForTree1(Integer sourceEvenKey,
                                                            Map<Integer, List<Integer>> adjMap,
                                                            int totalNodeAtEvenLevelForTree1,
                                                            int totalNodeAtOddLevelForTree11,
                                                            int maxOptimalNodeCountForEvenTarversalTree2) {

        int[] res = new int[adjMap.size()];

        Set<Integer> visited = new HashSet<>();
        Queue<NodeWithDepth> queue = new LinkedList<>();

        visited.add(sourceEvenKey);
        queue.add(new NodeWithDepth(sourceEvenKey, 0)); // Depth starts from 1

        while (!queue.isEmpty()) {
            NodeWithDepth current = queue.poll();

            if (current.depth % 2 == 0) {
                res[current.node] = totalNodeAtEvenLevelForTree1 + maxOptimalNodeCountForEvenTarversalTree2;
            } else {
                res[current.node] = totalNodeAtOddLevelForTree11 + maxOptimalNodeCountForEvenTarversalTree2;
            }

            for (int neighbor : adjMap.getOrDefault(current.node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new NodeWithDepth(neighbor, current.depth + 1));
                }
            }

        }
        return res;
    }

    public static int bfsWithNodeCountForEvenLevels(Map<Integer, List<Integer>> adjMap, int startNode) {
        Set<Integer> visited = new HashSet<>();
        Queue<NodeWithDepth> queue = new LinkedList<>();
        int totalNodeCountForEvenLevels = 0;

        visited.add(startNode);
        queue.add(new NodeWithDepth(startNode, 0)); // Depth starts from 1

        while (!queue.isEmpty()) {
            NodeWithDepth current = queue.poll();

            if (current.depth % 2 == 0) {
                ++totalNodeCountForEvenLevels;
            }

//            System.out.println("Node: " + current.node + " at Depth: " + current.depth);

            for (int neighbor : adjMap.getOrDefault(current.node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new NodeWithDepth(neighbor, current.depth + 1));
                }
            }

        }
        return totalNodeCountForEvenLevels;
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
