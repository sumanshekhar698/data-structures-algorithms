package com.dsa.leetcode.trees.basics;

import java.util.*;

public class BinaryTreeBFS_DFS {

    /*        1
    *    2        3
    * 4    5    6    7 */
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        BinaryTreeBFS_DFS binaryTreeBFS = new BinaryTreeBFS_DFS();
        List<Integer> bfs = binaryTreeBFS.bfsUsingLevelBreaks(treeNode);
        System.out.println(bfs);
        List<Integer> dfs = binaryTreeBFS.dfs(treeNode);
        System.out.println(dfs);


    }

    private static class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public List<Integer> dfs(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);//

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
//            System.out.println(node.val);
            list.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return list;
    }

    public List<Integer> bfs(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);//

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            list.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return list;
    }


    public List<Integer> bfsUsingLevelBreaks(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);//

        while (!queue.isEmpty()) {
            int size = queue.size();


            for (int i = 0; i < size; i++) {

                list.add(queue.peek().val);
                TreeNode node = queue.poll();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

        }
        return list;
    }

}
