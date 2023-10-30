package com.dsa.leetcode.trees.bst;

public class _101SymmetricTree {

    public static void main(String[] args) {

    }

    public static boolean isSymmetricTree(TreeNode root) {//Using DFS
        //Structure and Value of both SIDES should be the same
//        Time O(p) nodes
        return dfs(root.left, root.right);
    }

    static boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {//both are empty trees
            return true;
        } else if (p == null || q == null) {//one of then is null
            return false;//as it shows non-symmetric
        }

        return p.val == q.val && dfs(p.left, q.right) && dfs(p.right, q.left);
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
}
