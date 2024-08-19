/**
 * @author
 */
public class LeetCode124 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        post(root);
        return max;
    }

    private int post(TreeNode node) {
        int result = node.val;
        int left = 0;
        max = Math.max(max, node.val);
        if (node.left != null) {
            left = post(node.left);
            max = Math.max(Math.max(max, left), left + node.val);
            result = Math.max(result, node.val + left);
        }
        int right = 0;
        if (node.right != null) {
            right = post(node.right);
            max = Math.max(Math.max(max, right), right + node.val);
            result = Math.max(result, node.val + right);
        }
        if (node.right != null && node.left != null) {
            max = Math.max(max, left + right + node.val);
        }
        return result;

        // 简化一下写法
        // if (node == null)
        //     return 0;
        // int left = post(node.left);
        // int right = post(node.right);
        // max = Math.max(max, left + right + node.val);
        // return Math.max(Math.max(left + node.val, right + node.val), 0);
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