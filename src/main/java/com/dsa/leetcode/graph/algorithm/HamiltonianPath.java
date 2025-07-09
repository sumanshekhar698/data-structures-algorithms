package com.dsa.leetcode.graph.algorithm;

import java.util.*;

public class HamiltonianPath {
    static class Graph {
        int V;
        List<List<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++)
                adj.add(new ArrayList<>());
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        void findHamiltonianPaths() {
            for (int i = 0; i < V; i++) {
                boolean[] visited = new boolean[V];
                List<Integer> path = new ArrayList<>();
                dfs(i, visited, path);
            }
        }

        void dfs(int current, boolean[] visited, List<Integer> path) {
            visited[current] = true;
            path.add(current);

            if (path.size() == V) {
                System.out.println("Hamiltonian Path: " + path);
            } else {
                for (int neighbor : adj.get(current)) {
                    if (!visited[neighbor])
                        dfs(neighbor, visited, path);
                }
            }

            visited[current] = false;
            path.remove(path.size() - 1);
        }
    }

    /*
    *       1
           / \
          0---2
          | /
          3
*/
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(0, 2);

        g.findHamiltonianPaths();
    }
}
