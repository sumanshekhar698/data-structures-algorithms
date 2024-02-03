package company.dotdash;

public class CalculateHeightOfABinaryTree {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(66);
        treeNode.left.left = new TreeNode(44);

        int height = calcHeight(treeNode);
        System.out.println(height);

    }

    private static int calcHeight(TreeNode node) {

        //Edge/Base Case
        if (node == null) {
            return 0;
        } else {
            int max = 0;
            int lHeight = 0;
            int rHeight = 0;

            lHeight = calcHeight(node.left);//for left tree
            rHeight = calcHeight(node.right);//for right tree

            max = Integer.max(lHeight, rHeight);
            return max + 1;

        }

    }


    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
