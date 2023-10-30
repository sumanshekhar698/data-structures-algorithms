package com.dsa.leetcode.trees.bst;

import java.util.Arrays;

public class _1008ConstructBinarySearchTreeFromPreorderTraversal {

    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 7, 10, 12};
        Solution solution = new Solution();
        TreeNode treeNode = solution.bstFromPreorder(arr);
        System.out.println(treeNode);
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

    static class Solution {

        int i = 0;

        public TreeNode bstFromPreorderOptimized(int[] arr) {
            return helper(arr, Integer.MAX_VALUE);
        }

        public TreeNode helper(int[] arr, int bound) {
            if (i == arr.length || arr[i] > bound)
                return null;

            TreeNode root = new TreeNode(arr[i++]);
            root.left = helper(arr, root.val);
            root.right = helper(arr, bound);
            return root;
        }


        public TreeNode bstFromPreorderOptimizedWRONG(int[] preorder) {

//            O(n) ::  n^2 => n is the number of nodes

            if (preorder.length == 0)
                return null;
            else if (preorder.length == 1) {
                return new TreeNode(preorder[0]);
            }


            TreeNode root = new TreeNode(preorder[0]);

            buildBSTOptimized(preorder, preorder.length, 1, root, Integer.MIN_VALUE, Integer.MAX_VALUE);


            return root;

        }

        //TODO
        private int buildBSTOptimized(int[] preorder, int length, int pos, TreeNode node, int leftRange, int rightRange) {

            if (pos == length || preorder[pos] < leftRange || preorder[pos] > rightRange) {
                return pos;
            }

            if (preorder[pos] < node.val) {//left sub tree proceed
                node.left = new TreeNode(preorder[pos]);
                pos += 1;
                pos = buildBSTOptimized(preorder, preorder.length, pos, node.left, leftRange, node.val - 1);


            }

            if (pos == length || preorder[pos] < leftRange || preorder[pos] > rightRange) {
                return pos;
            }

            node.right = new TreeNode(preorder[pos]);
            pos += 1;
            pos = buildBSTOptimized(preorder, preorder.length, pos, node.left, leftRange, node.val - 1);
            return pos;


        }


        public TreeNode bstFromPreorder(int[] preorder) {

//            O(n) ::  n^2 => n is the number of nodes
            int[] inOrder = preorder.clone();
            Arrays.sort(inOrder);//inOrderReady

//            TreeNode root = new TreeNode(preorder[0]);
            TreeNode root = null;
            for (int i = 0; i < preorder.length; i++) {//The basic idea is to find the position of each element in the BSTree
                root = buildBST(root, preorder[i]);//reassigning root everytime
            }

            return root;

        }

        public TreeNode buildBST(TreeNode root, int ele) {
            if (root == null) {
                return new TreeNode(ele); // Create a new node if the current position is empty
            }

            if (ele < root.val) {
//                This will be repetitive
                root.left = buildBST(root.left, ele);// Insert into the left subtree if the element is less than the root value
            } else {
                root.right = buildBST(root.right, ele);// Insert into the right subtree if the element is greater than or equal to the root value
            }
            return root;
        }
    }


}
