//根节点到叶节点的数字之和

public class LeetCode129 {

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

    public int sumNumbers(TreeNode root) {
        // 深度优先搜索，也可以用广度优先搜索解
        return dfs(0, root);
    }

    private int dfs(int sum, TreeNode node) {
        if (node == null)
            return 0;
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null)
            return sum;
        return dfs(sum, node.left) + dfs(sum, node.right);
    }
}
