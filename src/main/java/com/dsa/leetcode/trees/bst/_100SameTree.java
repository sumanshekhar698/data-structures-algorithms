package com.dsa.leetcode.trees.bst;

public class _100SameTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(isSameTree(t1, t2));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {//Using DFS
        //Structure and Value both should be the same
//        Time O(p+q) nodes
        if (p == null && q == null) {//both are empty trees
            return true;
        } else if (p == null || q == null) {//one of then is null
            return false;
        } else if (p.val != q.val) {//both are not null
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);//


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
