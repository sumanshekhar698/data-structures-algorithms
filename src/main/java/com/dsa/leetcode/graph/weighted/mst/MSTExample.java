package com.dsa.leetcode.graph.weighted.mst;

import java.util.*;

public class MSTExample {

    // Edge class for Kruskal and Prim
    static class Edge {
        int u, v, weight;

        // Constructor for Kruskal (u and v used)
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        // Constructor for Prim (only to and weight used)
        Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    // --------------------- PRIM'S ALGORITHM ---------------------
    public static int primMST(List<List<Edge>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(0, 0));  // Start from vertex 0
        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int node = current.v;
            if (visited[node]) continue;

            visited[node] = true;
            totalWeight += current.weight;

            for (Edge neighbor : graph.get(node)) {
                if (!visited[neighbor.v]) {
                    pq.offer(new Edge(neighbor.v, neighbor.weight));
                }
            }
        }

        return totalWeight;
    }

    // --------------------- KRUSKAL'S ALGORITHM ---------------------
    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) return false;
            parent[rootX] = rootY;
            return true;
        }
    }

    public static int kruskalMST(int n, List<Edge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        UnionFind uf = new UnionFind(n);
        int totalWeight = 0;

        for (Edge edge : edges) {
            if (uf.union(edge.u, edge.v)) {
                totalWeight += edge.weight;
            }
        }

        return totalWeight;
    }

    // --------------------- MAIN FUNCTION ---------------------
    public static void main(String[] args) {
        int numNodes = 5;

        // Example graph:
        //     0
        //   / | \
        //  1  2  3
        //   \ | /
        //     4

        // PRIM: Adjacency list
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Edge(1, 2));
        graph.get(1).add(new Edge(0, 2));

        graph.get(0).add(new Edge(2, 3));
        graph.get(2).add(new Edge(0, 3));

        graph.get(0).add(new Edge(3, 6));
        graph.get(3).add(new Edge(0, 6));

        graph.get(1).add(new Edge(4, 5));
        graph.get(4).add(new Edge(1, 5));

        graph.get(2).add(new Edge(4, 7));
        graph.get(4).add(new Edge(2, 7));

        graph.get(3).add(new Edge(4, 4));
        graph.get(4).add(new Edge(3, 4));

        int primResult = primMST(graph);
        System.out.println("Total weight of MST using Prim's Algorithm: " + primResult);

        // KRUSKAL: Edge list
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(0, 1, 2));
        edgeList.add(new Edge(0, 2, 3));
        edgeList.add(new Edge(0, 3, 6));
        edgeList.add(new Edge(1, 4, 5));
        edgeList.add(new Edge(2, 4, 7));
        edgeList.add(new Edge(3, 4, 4));

        int kruskalResult = kruskalMST(numNodes, edgeList);
        System.out.println("Total weight of MST using Kruskal's Algorithm: " + kruskalResult);
    }
}
