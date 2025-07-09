package com.dsa.leetcode.graph.weighted.mst;

import java.util.*;

class KruskalAlgorithm_type1_2 {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public Edge(int s, int d, int w) {
            src = s; dest = d; weight = w;
        }
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    /*The UnionFind class (also known as Disjoint Set Union (DSU) or Union-Find data structure)
     is a core part of Kruskal's Algorithm.
     It's used to efficiently detect cycles when you're building the Minimum Spanning Tree (MST).*/
    static class UnionFind {
        int[] parent, rank;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int u) {
            if (parent[u] != u)
                parent[u] = find(parent[u]);
            return parent[u];
        }
        void union(int u, int v) {
            int pu = find(u), pv = find(v);
            if (pu == pv) return;
            if (rank[pu] < rank[pv]) parent[pu] = pv;
            else if (rank[pu] > rank[pv]) parent[pv] = pu;
            else { parent[pu] = pv; rank[pv]++; }
        }
    }
    static int kruskalMST(int V, List<Edge> edges) {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(V);
        int mstWeight = 0;
        System.out.println("Edges in MST (Kruskal):");
        for (Edge e : edges) {
            if (uf.find(e.src) != uf.find(e.dest)) {
                uf.union(e.src, e.dest);
                System.out.println(e.src + " - " + e.dest + " = " + e.weight);
                mstWeight += e.weight;
            }
        }
        System.out.println("Total weight of MST: " + mstWeight);
        return mstWeight;
    }

    public static void main(String[] args) {

        int V = 4;
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
