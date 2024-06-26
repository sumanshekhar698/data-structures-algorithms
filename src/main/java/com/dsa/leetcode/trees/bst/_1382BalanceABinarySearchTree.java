package com.dsa.leetcode.trees.bst;

import java.util.ArrayList;

public class _1382BalanceABinarySearchTree {

    ArrayList<Integer> sortedList = new ArrayList();

    public static void main(String[] args) {
        //A BST inorder traversal places the item in ascending order
        // A Balanced BST height will be log n


    }
    ArrayList<TreeNode> sortedListOfNodes = new ArrayList();

    public TreeNode balanceBST(TreeNode root) {
        inOrderTraversal(root);
        TreeNode newRoot = formBalancedBSTFromSortedArray(0, sortedListOfNodes.size() - 1);
        return newRoot;
    }

    private TreeNode formBalancedBSTFromSortedArray(int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode root = sortedListOfNodes.get(mid);
        root.left = formBalancedBSTFromSortedArray(start, mid - 1);
        root.right = formBalancedBSTFromSortedArray(mid + 1, end);
        return root;


    }

    void inOrderTraversal(TreeNode node) {
        //A BST inorder traversal places the item in ascending order
        if (node == null)
            return;
        inOrderTraversal(node.left);
//        System.out.print(node.val + " ");
//        sortedList.add(node.val);
        sortedListOfNodes.add(node);
        inOrderTraversal(node.right);


    }


    public class TreeNode {
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
