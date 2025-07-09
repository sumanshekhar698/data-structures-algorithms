package com.dsa.leetcode.graph.weighted.mst;

import java.util.*;

class KruskalAlgorithm_type1_1 {
    static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    /*The UnionFind class (also known as Disjoint Set Union (DSU) or Union-Find data structure)
     is a core part of Kruskal's Algorithm.
     It's used to efficiently detect cycles when you're building the Minimum Spanning Tree (MST).*/
    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
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

    public static void main(String[] args) {

        /*           (10)
                 0 ------- 1
                 | \       |
                 |  \      |
                 |   \     |
           (6)   |   (5)   |  (15)
                 |     \   |
                 |      \  |
                 |       \ |
                 2 ------- 3
                     (4)


                      MST
                     (10)
                 0 ------- 1
                   \
                    \
                     \
                     (5)
                       \
                        \
                         \
                 2 ------- 3
                     (4)
*/
        final int V = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));
        int res = kruskalMST(V, edges);
        System.out.println(res);
    }
}
