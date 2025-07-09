package com.dsa.leetcode.graph.weighted.mst;

import java.util.*;

class PrimEdge {
    int source;
    int destination;
    int weight;

    public PrimEdge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PrimEdge{" +
                "source=" + source +
                ", destination=" + destination +
                ", weight=" + weight +
                '}';
    }
}

public class PrimAlgorithm_type2 {

    public static List<PrimEdge> primMST(int V, List<PrimEdge> edges) {
        List<PrimEdge> mstEdges = new ArrayList<>();

        // Adjacency list to represent the graph
        // For each vertex, store a list of edges connected to it
        Map<Integer, List<PrimEdge>> adj = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (PrimEdge edge : edges) {
            adj.get(edge.source).add(edge);
            // For undirected graph, add edge from destination to source as well
            adj.get(edge.destination).add(new PrimEdge(edge.destination, edge.source, edge.weight));
        }

        // PriorityQueue to store edges, ordered by weight (min-heap)
        // We store edges that connect a visited node to an unvisited node
        PriorityQueue<PrimEdge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // Set to keep track of visited vertices (those in the MST)
        Set<Integer> visited = new HashSet<>();

        // Start Prim's from vertex 0 (can be any vertex)
        int startVertex = 0;
        visited.add(startVertex);

        // Add all edges connected to the startVertex to the priority queue
        for (PrimEdge edge : adj.get(startVertex)) {
            pq.add(edge);
        }

        while (!pq.isEmpty() && mstEdges.size() < V - 1) {
            PrimEdge currentEdge = pq.poll();

            int u = currentEdge.source;
            int v = currentEdge.destination;
            int weight = currentEdge.weight;

            // Check if the current edge connects a visited vertex to an unvisited one
            // We ensure that one end is visited and the other is not.
            // If both are visited, it creates a cycle or is redundant.
            // If neither is visited, it's not connected to our growing MST.
            if (visited.contains(u) && visited.contains(v)) {
                continue; // Both ends already in MST, skip (forms a cycle or redundant)
            }

            int newVertex = -1;
            if (visited.contains(u)) { // u is visited, v is not
                newVertex = v;
            } else if (visited.contains(v)) { // v is visited, u is not
                newVertex = u;
            } else {
                // This case should ideally not happen if we add edges correctly
                // from the currently visited vertex's adjacency list.
                continue;
            }

            // Add the edge to the MST
            mstEdges.add(currentEdge);
            visited.add(newVertex); // Add the newly visited vertex to the set

            // Add all edges connected to the newVertex to the priority queue
            // but only if the other end of the edge is not yet visited
            for (PrimEdge edge : adj.get(newVertex)) {
                if (!visited.contains(edge.destination)) {
                    pq.add(edge);
                }
            }
        }

        return mstEdges;
    }

    public static void main(String[] args) {


/*         (4)     (8)
        A ----- B ----- C
        | \     |       |
    (8) |  (7)  |(2)    |(9)
        |    \  |       |
        D ----- E ----- F
           (6)     (5)*/
        final int V = 6; // Number of vertices (0 to 5): (A to F)

//        A = 0
//        B = 1
//        C = 2
//        D = 3
//        E = 4
//        F = 5

        List<PrimEdge> edges = new ArrayList<>();
        edges.add(new PrimEdge(0, 1, 4)); // A-B
        edges.add(new PrimEdge(0, 3, 8)); // A-D
        edges.add(new PrimEdge(0, 4, 7)); // A-E
        edges.add(new PrimEdge(1, 2, 8)); // B-C
        edges.add(new PrimEdge(1, 4, 2)); // B-E
        edges.add(new PrimEdge(2, 5, 9)); // C-F
        edges.add(new PrimEdge(3, 4, 6)); // D-E
        edges.add(new PrimEdge(4, 5, 5)); // E-F

        List<PrimEdge> mst = primMST(V, edges);

        System.out.println("Prim's MST Edges:");
        int totalWeight = 0;
        for (PrimEdge edge : mst) {
            System.out.println("(" + (char) ('A' + edge.source) + ", " + (char) ('A' + edge.destination) + ") -> " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total MST Weight: " + totalWeight);
    }
}