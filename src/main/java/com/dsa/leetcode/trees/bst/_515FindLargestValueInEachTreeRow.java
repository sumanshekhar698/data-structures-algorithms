package com.dsa.leetcode.trees.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515FindLargestValueInEachTreeRow {
    //    https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/?envType=list&envId=9fen75ur
    static public class TreeNode {
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


    class Solution {


        public List<Integer> averageOfLevels(TreeNode root) {

            // basically, we will count the number of levels
//            O(n) ::  n => n is the number of nodes


            Queue<TreeNode> queue = new LinkedList();//Generally BFS involves a queue or a dequeue
            ArrayList<Integer> res = new ArrayList<>();
            if (root != null) {
                queue.add(root);
                res.add(root.val);
            }


            while (!queue.isEmpty()) {

                int max = Integer.MIN_VALUE;//To handle corner cases of Integer Overflow
                int size = queue.size();//taking a snapshot of the current queue length
                for (int i = 0; i < size; i++) {//at each for it will keep on adding the nodes of that level

                    TreeNode node = queue.poll();

                    if (node.left != null) {
                        queue.add(node.left);
                        max = Math.max(node.left.val, max);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                        max = Math.max(node.right.val, max);

                    }
                }
                if (queue.size() != 0)
                    res.add(max);
            }

            return res;
        }


    }

}

