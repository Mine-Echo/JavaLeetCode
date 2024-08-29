// 二叉树的最小绝对差

public class LeetCode530 {
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root, -1);
        return min;
    }

    private int inOrder(TreeNode node, int last) {
        if (node == null)
            return -1;
        int left = inOrder(node.left, last);
        if (left != -1) {
            min = Math.min(min, Math.abs(left - node.val));
        } else if (last != -1) {
            min = Math.min(min, Math.abs(last - node.val));
        }
        int right = inOrder(node.right, node.val);
        return right != -1 ? right : node.val;
    }

    class TreeNode {
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
