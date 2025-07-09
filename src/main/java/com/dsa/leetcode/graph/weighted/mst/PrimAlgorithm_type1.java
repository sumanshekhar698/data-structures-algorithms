package com.dsa.leetcode.graph.weighted.mst;

import java.util.*;

public class PrimAlgorithm_type1 {

    static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static int findMST(List<List<Edge>> adjacencyList) {
        int numberOfVertices = adjacencyList.size();
        boolean[] visited = new boolean[numberOfVertices];
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        minHeap.offer(new Edge(0, 0)); // Start from node 0
        int totalWeight = 0;

        while (!minHeap.isEmpty()) {
            Edge currentEdge = minHeap.poll();
            int currentNode = currentEdge.destination;

            if (visited[currentNode]) continue;

            visited[currentNode] = true;
            totalWeight += currentEdge.weight;

            for (Edge neighbor : adjacencyList.get(currentNode)) {
                if (!visited[neighbor.destination]) {
                    minHeap.offer(neighbor);
                }
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {

        // Example graph:
        //     0
        //   / | \
        //  1  2  3
        //   \ | /
        //     4


        int numberOfVertices = 5;

        // Build graph as an adjacency list
        List<List<Edge>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Undirected edges
        adjacencyList.get(0).add(new Edge(1, 2));
        adjacencyList.get(1).add(new Edge(0, 2));

        adjacencyList.get(0).add(new Edge(2, 3));
        adjacencyList.get(2).add(new Edge(0, 3));

        adjacencyList.get(0).add(new Edge(3, 6));
        adjacencyList.get(3).add(new Edge(0, 6));

        adjacencyList.get(1).add(new Edge(4, 5));
        adjacencyList.get(4).add(new Edge(1, 5));

        adjacencyList.get(2).add(new Edge(4, 7));
        adjacencyList.get(4).add(new Edge(2, 7));

        adjacencyList.get(3).add(new Edge(4, 4));
        adjacencyList.get(4).add(new Edge(3, 4));

        int mstWeight = findMST(adjacencyList);
        System.out.println("Total weight of MST using Prim's Algorithm: " + mstWeight);
    }
}
