package com.dsa.leetcode.graph;
import java.util.*;

public class _1791FindCenterOfStarGraph {
    public static void main(String[] args) {


        int[][] graphEdges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(findCenterUsingHashMapStringEdges(graphEdges));

    }

    static public int findCenter(int[][] edges) {

        int[] edge1 = edges[0];
        int[] edge2 = edges[1];

        return edge1[0] == edge2[0] || edge1[0] == edge2[1] ? edge1[0] : edge1[1];
    }

    static public int findCenterUsingComonPointHasSet(int[][] edges) {
        //evey number in the 1D array is a node

        Set<Integer> nodesTraversed = new HashSet<Integer>();
//        Set<Integer> nodesTraversed = new HashSet<Integer>();

        for (int[] edge : edges) {

            if (nodesTraversed.contains(edge[0])) {
                return edge[0];
            }
            nodesTraversed.add(edge[0]);

            if (nodesTraversed.contains(edge[1])) {
                return edge[1];
            }
            nodesTraversed.add(edge[1]);
        }

        return -1;


    }


    static public int findCenterUsingHashMapStoringDegree(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];

            map.put(first, map.getOrDefault(first, 0) + 1);
            map.put(second, map.getOrDefault(second, 0) + 1);

        }

        int noOfEdgesOnAStarNode = edges.length;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == noOfEdgesOnAStarNode) {
                return entry.getKey();
            }
        }
        return 0;
    }

    static public int findCenterUsingHashMapStringEdges(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.putIfAbsent(edges[i][0], new ArrayList<>());
            map.putIfAbsent(edges[i][1], new ArrayList<>());

            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        int noOfEdgesOnAStarNode = map.keySet().size() - 1;//noOfNodes - 1
        for (int key : map.keySet()) {

            int noOfVertices = map.get(key).size();
            if (noOfVertices == noOfEdgesOnAStarNode) {
                return key;
            }

        }
        return 0;
    }
}