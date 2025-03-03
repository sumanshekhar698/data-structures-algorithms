package com.dsa.leetcode.trees;

import java.util.*;

public class _2467MostProfitablePathInATree {
    public static void main(String[] args) {
        _2467MostProfitablePathInATree mostProfitablePathInATree = new _2467MostProfitablePathInATree();
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int bob = 3;
        int[] amount = {-2, 4, 2, -4, 6};
        int result = mostProfitablePathInATree.mostProfitablePath(edges, bob, amount);
        System.out.println(result);
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {


//      1. Building Adjacency Map
//        HashMap<Integer, Set<Integer>> adjacencyMap = new HashMap<Integer, Set<Integer>>();
        HashMap<Integer, List<Integer>> adjacencyMap = new HashMap<>();

//        for (int[] edge : edges) {
//            adjacencyMap.putIfAbsent(edge[0], new HashSet<>());
//            adjacencyMap.putIfAbsent(edge[1], new HashSet<>());
//
//            adjacencyMap.get(edge[0]).add(edge[1]);
//            adjacencyMap.get(edge[1]).add(edge[0]);
//        }

//        for (int[] edge : edges) {
//            adjacencyMap.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
//            adjacencyMap.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
//        }

        for (int[] edge : edges) {
            adjacencyMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjacencyMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

//        2. Bob Simulation first as bob has no choices
        HashMap<Integer, Integer> bobTimings = new HashMap<>();//node on a root path: time

        class DFS {
            boolean dfs(int srcNode, int previous, int time) {

                if (srcNode == 0) {
                    bobTimings.put(srcNode, time);
                    return true;
                }

                for (int neighbour : adjacencyMap.get(srcNode)) {// For each neighbor
                    if (neighbour == previous) {// Skip the previous nodeIndex as we are going back to previous
                        continue;
                    }

                    if (dfs(neighbour, srcNode, time + 1)) {// neighbor will become source nodeIndex
                        // and srcNode will become previous with time+1
                        bobTimings.put(srcNode, time);
                        return true;
                    }
                }
                return false;
            }
        }

        //previous is -1 as we are starting from starting nodeIndex
        new DFS().dfs(bob, -1, 0);// we are just interested in the timing and the path to reach the root nodeIndex


        record AliceNodes(int nodeIndex, int time, int previous, int netProfit) {
        }


//        3. Alice Simulation after Bob simulation
        ArrayDeque<AliceNodes> deQueue = new ArrayDeque<>() {{
            add(new AliceNodes(0, 0, -1, amount[0]));// starting Alice from root nodeIndex at
            // time 0 with previous -1 and netProfit amount[0]
        }};

        int result = Integer.MIN_VALUE;
        while (!deQueue.isEmpty()) {
            AliceNodes current = deQueue.poll();

//            if (current.nodeIndex == bob) {
//                result = Math.min(result, current.netProfit);
//            }

            for (int neighbour : adjacencyMap.get(current.nodeIndex)) {

                if (neighbour == current.previous) {
                    continue;
                }

                int neighbourProfit = amount[neighbour];
                int neighbourTime = current.time() + 1;


                if (bobTimings.containsKey(neighbour)) {
                    if (neighbourTime > bobTimings.get(neighbour)) {
                        neighbourProfit = 0;
                    }
                    if (neighbourTime == bobTimings.get(neighbour)) {
                        neighbourProfit /= 2;
                    }
                }


                deQueue.add(new AliceNodes(neighbour, neighbourTime, current.nodeIndex,
                        current.netProfit + neighbourProfit));

                if (adjacencyMap.get(neighbour).size() == 1) {
                    // If the neighbor is a leaf nodeIndex that has just one adjacency
                    result = Math.max(result, current.netProfit + neighbourProfit);
                }
            }
        }

        return result;
    }
}
