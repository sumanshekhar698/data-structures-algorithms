package com.dsa.leetcode.graph.algorithm;

import java.util.*;

public class EulerianPath {
    static class Graph {
        private final int V;
        private final List<List<Integer>> adj;

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

        boolean isEulerian() {
            int odd = 0;
            for (int i = 0; i < V; i++) {
                if (adj.get(i).size() % 2 != 0)
                    odd++;
            }
            return (odd == 0 || odd == 2);
        }

        void printEulerPath() {
            if (!isEulerian()) {
                System.out.println("No Eulerian Path/Cycle exists");
                return;
            }

            Stack<Integer> stack = new Stack<>();
            List<Integer> path = new ArrayList<>();

            int start = 0;
            for (int i = 0; i < V; i++) {
                if (adj.get(i).size() % 2 == 1) {
                    start = i;
                    break;
                }
            }

            stack.push(start);
            while (!stack.isEmpty()) {
                int u = stack.peek();
                if (adj.get(u).size() == 0) {
                    path.add(u);
                    stack.pop();
                } else {
                    int v = adj.get(u).get(0);
                    removeEdge(u, v);
                    stack.push(v);
                }
            }

            System.out.println("Eulerian Path/Cycle:");
            for (int node : path) System.out.print(node + " ");
        }

        void removeEdge(int u, int v) {
            adj.get(u).remove((Integer) v);
            adj.get(v).remove((Integer) u);
        }
    }

    /*
*       1
       / \
      0---2
      |   |
      3---4
*/
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);

        g.printEulerPath();
    }
}
