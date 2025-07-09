package com.dsa.leetcode.graph.weighted.mst;

import java.util.*;

// Class to represent an edge for Kruskal's
class KruskalEdge {
    int source;
    int destination;
    int weight;

    public KruskalEdge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

// Disjoint Set Union (DSU) / Union-Find data structure
class DisjointSetUnion {
    int[] parent;
    int[] rank; // Used for union by rank optimization

    public DisjointSetUnion(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each element is initially its own parent
            rank[i] = 0;   // Initial rank is 0
        }
    }

    // Find operation with path compression
    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]); // Path compression
    }

    // Union operation with union by rank
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            // Attach smaller rank tree under root of higher rank tree
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootJ] < rank[rootI]) {
                parent[rootJ] = rootI;
            } else {
                // If ranks are same, make one as root and increment its rank
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
        }
    }
}

public class KruskalAlgorithm_type2 {

    public static List<KruskalEdge> kruskalMST(int V, List<KruskalEdge> edges) {
        List<KruskalEdge> mstEdges = new ArrayList<>();

        // 1. Sort all edges by weight in non-decreasing order
        edges.sort(Comparator.comparingInt(e -> e.weight));

        // 2. Initialize DSU
        DisjointSetUnion dsu = new DisjointSetUnion(V);

        // 3. Iterate through sorted edges
        for (KruskalEdge edge : edges) {
            int u = edge.source;
            int v = edge.destination;

            // Check if adding this edge forms a cycle
            // If u and v are not in the same set, add the edge
            if (dsu.find(u) != dsu.find(v)) {
                mstEdges.add(edge);
                dsu.union(u, v); // Union the sets of u and v

                // Optimization: stop when V-1 edges are found
                if (mstEdges.size() == V - 1) {
                    break;
                }
            }
        }

        return mstEdges;
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices (0 to 5)
        List<KruskalEdge> edges = new ArrayList<>();
        edges.add(new KruskalEdge(0, 1, 4)); // A-B
        edges.add(new KruskalEdge(0, 3, 8)); // A-D
        edges.add(new KruskalEdge(0, 4, 7)); // A-E
        edges.add(new KruskalEdge(1, 2, 8)); // B-C
        edges.add(new KruskalEdge(1, 4, 2)); // B-E
        edges.add(new KruskalEdge(2, 5, 9)); // C-F
        edges.add(new KruskalEdge(3, 4, 6)); // D-E
        edges.add(new KruskalEdge(4, 5, 5)); // E-F

        List<KruskalEdge> mst = kruskalMST(V, edges);

        System.out.println("Kruskal's MST Edges:");
        int totalWeight = 0;
        for (KruskalEdge edge : mst) {
            System.out.println("(" + (char)('A' + edge.source) + ", " + (char)('A' + edge.destination) + ") -> " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total MST Weight: " + totalWeight);
    }
}