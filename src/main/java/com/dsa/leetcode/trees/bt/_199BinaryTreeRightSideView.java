package com.dsa.leetcode.trees.bt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _199BinaryTreeRightSideView {

    public static void main(String[] args) {

    }

    public List<Integer> rightSideViewRecursive(TreeNode root) {//O(n)
        ArrayList<Integer> list = new ArrayList<>();
        rightSideViewRecursiveHelper(root, list, 0);
        return list;
    }

    /*We are using pre-order traversal [root Left right] with a modification [root right left]*/
    private void rightSideViewRecursiveHelper(TreeNode root, ArrayList<Integer> list, int level) {
        if (root == null) return;
        if (list.size() == level)
            list.add(root.val);//add the first element of the level
//        if (list.size() < level) list.add(root.val);//add the first element of the level if starting from level 1
        rightSideViewRecursiveHelper(root.right, list, level + 1);//incrementing the level as we go down the tree
        rightSideViewRecursiveHelper(root.left, list, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();//O(n) SPACE
        queue.add(root);//

        while (!queue.isEmpty()) {
            int size = queue.size();
            list.add(queue.peekLast().val);//add the last element of the queue to the list


            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

        }
        return list;
    }


    private class TreeNode {
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
