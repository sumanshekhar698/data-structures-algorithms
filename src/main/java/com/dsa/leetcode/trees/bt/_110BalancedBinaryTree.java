package com.dsa.leetcode.trees.bt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class _110BalancedBinaryTree {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {


        class BottomUpCheck {
            Map.Entry<Boolean, Integer> dfs(TreeNode root) {
                if (root == null)
                    return Map.entry(true, 0);
                Map.Entry<Boolean, Integer> left = dfs(root.left);
                Map.Entry<Boolean, Integer> right = dfs(root.right);
                boolean isBalanced = isBalanced(left, right);
                return Map.entry(isBalanced, 1 + Integer.max(left.getValue(), right.getValue()));


            }

            boolean isBalanced(Map.Entry<Boolean, Integer> left, Map.Entry<Boolean, Integer> right) {
                return (left.getKey() && right.getKey()) && Math.abs(left.getValue() - right.getValue()) <= 1;
            }
        }

        return new BottomUpCheck().dfs(root).getKey();


    }


    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {//0 ms

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (height(root) == -1) {
                return false;
            }
            return true;

        }

        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = height(root.left);
            int right = height(root.right);

            if (left == -1 || right == -1) {
                return -1;
            }

            if ((Math.abs(left - right)) > 1) {
                return -1;
            }

            return 1 + Math.max(left, right);
        }
    }
}
