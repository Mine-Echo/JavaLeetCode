//完全二叉树的节点个数

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

public class LeetCode222 {
    public int countNodes(TreeNode root) {
        // 位运算+二分查找法，复杂度log_n的平方，很牛的方法
        if (root == null)
            return 0;
        TreeNode node = root;
        int depth = 0;
        while (node != null) {
            node = node.left;
            depth += 1;
        }
        if (depth == 1)
            return depth;
        int left = (int) Math.pow(2, depth - 1), right = (int) Math.pow(2, depth) - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right + 1) / 2;
            if (mid == left)
                break;
            if (isFind(mid, depth, root)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean isFind(int num, int depth, TreeNode root) {
        int bit;
        TreeNode node = root;
        while (depth > 1) {
            bit = (num >> (depth - 2)) & 1;
            if (bit == 1) {
                node = node.right;
            } else {
                node = node.left;
            }
            depth--;
        }
        if (node == null)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        LeetCode222 leetCode222 = new LeetCode222();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null));
        leetCode222.countNodes(root);
    }
}
