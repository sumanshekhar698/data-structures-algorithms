package company.walmart;

import java.util.LinkedList;
import java.util.Queue;

public class OddEvenTreePattern {


    public static boolean hasOddEvenLevelPattern(TreeNode root) {
        if (root == null) {
            return true; // Empty tree satisfies the pattern
        }

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Check if the number of elements at the current level is odd or even
            if (level % 2 == 0 && levelSize % 2 != 0) {
                return false;
            } else if (level % 2 == 1 && levelSize % 2 != 1) {
                return false;
            }

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        if (hasOddEvenLevelPattern(root)) {
            System.out.println("The tree has odd-even-odd-even... pattern in the number of elements per level.");
        } else {
            System.out.println("The tree does not have odd-even-odd-even... pattern in the number of elements per level.");
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
