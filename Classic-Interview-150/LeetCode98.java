// 验证二叉搜索树

public class LeetCode98 {
    private Integer now = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (now == null || now < root.val) {
            now = root.val;
        } else {
            return false;
        }
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}
