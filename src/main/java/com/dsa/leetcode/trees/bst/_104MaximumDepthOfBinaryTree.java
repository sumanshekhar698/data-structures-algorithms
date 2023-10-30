package com.dsa.leetcode.trees.bst;

import java.util.*;

public class _104MaximumDepthOfBinaryTree {
    //    https://leetcode.com/problems/maximum-depth-of-binary-tree/
//    https://www.youtube.com/watch?v=hTM3phVI6YQ
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        int maxDepth = new Solution().maxDepthIterativeDFS(root);
        System.out.println(maxDepth);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    static class Solution {
        public int maxDepthRecursiveDFS(TreeNode root) {

//            O(n) ::  n => n is the number of nodes
            if (root == null)//base condition
                return 0;

//            if we have one node with no left and right, so we can say the maxDepth = 1 + max(Left sub tree, Right sub tree)
            return 1 + Math.max(maxDepthRecursiveDFS(root.left), maxDepthRecursiveDFS(root.right));

        }

        public int maxDepthIterativeDFS(TreeNode root) {//Pre order traversal

//            O(n) ::  n => n is the number of nodes

//            if (root == null) //commenting as the if condition will handle this
//                return 0;

            Deque<Map.Entry<TreeNode, Integer>> stackQueue = new ArrayDeque<>();//We will be needing a Stack DS to emulate CallStack
            stackQueue.addLast(new AbstractMap.SimpleEntry<>(root, 1));//K:V :: Node:Depth
//            int depth = 1; // as we commented the above if block
            int depth = 0;

            while (!stackQueue.isEmpty()) {
                Map.Entry<TreeNode, Integer> treeNodeIntegerEntry = stackQueue.removeLast();

                if (treeNodeIntegerEntry.getKey() != null) {
                    depth = Math.max(depth, treeNodeIntegerEntry.getValue());
                    stackQueue.addLast(new AbstractMap.SimpleEntry<>(treeNodeIntegerEntry.getKey().left, depth + 1));
                    stackQueue.addLast(new AbstractMap.SimpleEntry<>(treeNodeIntegerEntry.getKey().right, depth + 1));
                    //Note some null will be added to the stack, but we can ignore it as our if condition will handle this
                }

            }

            return depth;

        }


        public int maxDepthBFS(TreeNode root) {//Iterative Level Order Traversal

//            basically, we will count the number of levels
//            O(n) ::  n => n is the number of nodes
            if (root == null)
                return 0;


            Queue<TreeNode> queue = new LinkedList();//Generally BFS involves a queue or a dequeue
            queue.add(root);

            int depthLevel = 0;
            while (!queue.isEmpty()) {


                int size = queue.size();//taking a snapshot of the current queue length
                for (int i = 0; i < size; i++) {//at each for it will keep on adding the nodes of that level

                    TreeNode node = queue.poll();

                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                depthLevel++;
            }

            return depthLevel;


        }
    }

}
