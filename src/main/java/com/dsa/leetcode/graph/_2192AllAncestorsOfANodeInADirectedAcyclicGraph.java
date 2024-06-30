package com.dsa.leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class _2192AllAncestorsOfANodeInADirectedAcyclicGraph {

    public static void main(String[] args) {
        int n = 5, edgeList[][] = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};
        n = 8;
        int[][] edgeList2 = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        System.out.println(
                getAncestors(n, edgeList2));
    }


    static TreeSet<Integer>[] memoAncestors;

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        memoAncestors = new TreeSet[n];

        TreeSet<Integer>[] immediateParentsArray = new TreeSet[n];
        List<List<Integer>> lists = new ArrayList<>();

        for (int[] edge : edges) {//collecting all the immediate parent of the nodes
            int source = edge[0];
            int target = edge[1];
            if (immediateParentsArray[target] == null) {
                immediateParentsArray[target] = new TreeSet<>() {{
                    add(source);
                }};
            } else {
                immediateParentsArray[target].add(source);
            }
        }

        for (int i = 0; i < n; i++) {
            if (immediateParentsArray[i] != null) {
                TreeSet<Integer> immediateParentOfi = immediateParentsArray[i];
                TreeSet<Integer> ancestors = new TreeSet<>();
                parentFinder(immediateParentsArray, immediateParentOfi, ancestors);


                memoAncestors[i] = ancestors;
                lists.add(ancestors.stream().collect(Collectors.toList()));
            } else {
                lists.add(new ArrayList<>());
            }

        }

        return lists;

    }

    private static void parentFinderBruteRecursive(TreeSet<Integer>[] immediateParent, TreeSet<Integer> parent,
                                                   TreeSet<Integer> ancestors) {
        if (parent == null)
            return;
        for (int i = 0; i < parent.size(); i++) {

            ancestors.addAll(parent);
            parent.forEach(x -> parentFinderBruteRecursive(immediateParent, immediateParent[x], ancestors));
        }
    }

    private static void parentFinder(TreeSet<Integer>[] immediateParent, TreeSet<Integer> parent,
                                     TreeSet<Integer> ancestors) {
        if (parent == null)
            return;



        for (int i = 0; i < parent.size(); i++) {
            ancestors.addAll(parent);

            for (Integer nodes : parent){
                if (memoAncestors[nodes] != null) {
                    ancestors.addAll(memoAncestors[nodes]);
                    continue;
                }
                parentFinder(immediateParent, immediateParent[nodes], ancestors);
            }

        }
    }


}
