package com.dsa.leetcode.trees.bst;

public class _543DiameterOfBinaryTree {
    //    https://leetcode.com/problems/diameter-of-binary-tree/description/
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));

        int diameter = new Solution().diameterOfBinaryTree(root);
        System.out.println(diameter);
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
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null)
                return -1;//height of a single node is 1 and a null noded is -1
            int maxDia = 0;

            return 1 + Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));

        }
    }
}
