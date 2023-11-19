package com.dsa.leetcode.trees.bt;

public class _129SumRootToLeafNumbers {
    public static void main(String[] args) {


    }

    public static int sumNumbers(TreeNode root) {

        return dfs(root, 0);//passing zero to satisfy the edge case

    }

    private static int dfs(TreeNode node, int num) {//helper fn
        if (node == null)
            return 0;

        num *= 10;
        num += node.val;

        if (node.left == null && node.right == null) {//if leaf node
            return num;
        }

        return dfs(node.left, num) + dfs(node.right, num);

    }


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


    class Solution {//alternate way using instance variables
        int sum = 0;

        public int sumNumbers(TreeNode root) {
            if (root == null) return 0;
            dfs(root, 0);
            return sum;
        }

        public void dfs(TreeNode root, int val) {
            if (root != null) {
                val *= 10;
                if (root.left == null && root.right == null) {
                    sum += root.val + val;
                    return;
                }
                dfs(root.left, val + root.val);
                dfs(root.right, val + root.val);
                val /= 10;
            }
        }
    }
}


