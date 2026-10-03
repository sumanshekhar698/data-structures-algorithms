package com.dsa.leetcode.graph;

import java.util.*;

public class _207_M_CourseSchedule {

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            int N = prerequisites.length;
            HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

            for (int[] prerequisitePair : prerequisites) {
                int course = prerequisitePair[0];
                int prerequisite = prerequisitePair[1];

                // EDGE CASES
                // 1. Check for self-dependency
                if (course == prerequisite) {
                    return false; // A course cannot be its own prerequisite
                }

                // 2. Check for duplicate prerequisites
//                if (graph.containsKey(course) && graph.get(course).contains(prerequisite)) {
//                No need to check for duplicates, as the graph is a set and will automatically handle duplicates
//                    continue; // Duplicate prerequisite found
//                }

                // Add the prerequisite to the course's list
                graph.computeIfAbsent(course, k -> new HashSet<>()).add(prerequisite);

            }

            // Now we can check for cycles in the graph
            boolean[] visited = new boolean[numCourses];//Ensures we never re-process a node whose entire downstream path has already been verified safe.
            boolean[] recStack = new boolean[numCourses];

            /*A course schedule graph may consist of multiple isolated components or sub-graphs (e.g., math courses separate from literature courses).*/
            for (int courseNode = 0; courseNode < numCourses; courseNode++) {//Iterate through all courses to ensure we check for cycles in disconnected components of the graph
                if (isCyclic(courseNode, graph, visited, recStack)) {
                    return false; // Cycle detected
                }
            }

            return true; // No cycle detected

        }

        private boolean isCyclic(int course, HashMap<Integer, HashSet<Integer>> graph, boolean[] visited, boolean[] recStack) {
            if (!visited[course]) {
                visited[course] = true;
                recStack[course] = true;

                HashSet<Integer> prerequisites = graph.getOrDefault(course, new HashSet<>());
                for (int prerequisite : prerequisites) {
                    if (!visited[prerequisite] && isCyclic(prerequisite, graph, visited, recStack)) {
                        return true;
                    } else if (recStack[prerequisite]) {
                        return true;
                    }
                }
            }
            recStack[course] = false;
            return false;
        }
    }
}
